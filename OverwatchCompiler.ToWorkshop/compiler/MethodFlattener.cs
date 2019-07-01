using System;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class MethodFlattener : TreeVoidWalker
    {
        private readonly List<MethodDeclaration> methodDeclarations = new List<MethodDeclaration>();

        public override void ExitMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            BlockFlattener.FlattenAllSubBlocks(methodDeclaration.Body);
            methodDeclarations.Add(methodDeclaration);
        }

        public override void ExitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            //Convert trigger and condition to lambda expressions
            var trigger = ruleDeclaration.Trigger;
            var condition = ruleDeclaration.Condition;

            trigger.Remove();
            condition.Remove();

            ruleDeclaration.AddChildFirst(
                new LambdaExpression(
                    ruleDeclaration.Context,
                    new BlockStatement(
                        ruleDeclaration.Context,
                        new ReturnStatement(ruleDeclaration.Context, condition.Yield()).Yield()).Yield()
                    )
                );
            ruleDeclaration.AddChildFirst(
                new LambdaExpression(
                    ruleDeclaration.Context,
                    new BlockStatement(
                        ruleDeclaration.Context,
                        new ReturnStatement(ruleDeclaration.Context, trigger.Yield()).Yield()).Yield()
                    )
                );
        }

        public override void ExitArrayCreationExpression(ArrayCreationExpression arrayCreationExpression)
        {
            var replacement = NativeMethods.EmptyArray(arrayCreationExpression.Context);
            foreach (var initialItem in arrayCreationExpression.InitialItems)
            {
                replacement = NativeMethods.AppendToArray(arrayCreationExpression.Context, replacement, initialItem);
            }
            arrayCreationExpression.ReplaceWith(replacement);
        }

        public override void ExitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            if (arrayIndexExpression.Parent is AssignmentExpression assignment && assignment.Left == arrayIndexExpression)
                return;
            arrayIndexExpression.ReplaceWith(
                NativeMethods.ArrayIndex(
                    arrayIndexExpression.Context,
                    arrayIndexExpression.Array,
                    arrayIndexExpression.Index)
                );
        }

        public override void ExitRoot(Root root)
        {
            ValidateNoRecurssiveMethodCalls();

            var methodInvocationsInRules = root.SourceFiles.SelectMany(x => x.RuleDeclarations).SelectMany(x => x.AllDescendantsAndSelf()).OfType<MethodInvocationExpression>().ToList();
            foreach (var methodInvocation in methodInvocationsInRules)
            {
                var target = ((MethodReferenceType)methodInvocation.Base.Type).Declaration;
                UnwrapMethodInvocation(methodInvocation, target);
            }

            foreach (var methodDeclaration in methodDeclarations)
            {
                methodDeclaration.Remove();
            }
        }

        private void ValidateNoRecurssiveMethodCalls()
        {
            foreach (var methodDeclaration in methodDeclarations)
            {
                if (IsRecurssive(new List<MethodDeclaration> {methodDeclaration}))
                {
                    Errors.Add(new CompilationError(methodDeclaration.Context, "Recursive methods are not possible."));
                    return;
                }
            }
        }

        private bool IsRecurssive(List<MethodDeclaration> visitedMethodDeclarations)
        {
            var currentMethod = visitedMethodDeclarations.Last();
            var calledMethods = currentMethod
                .AllDescendantsAndSelf()
                .OfType<MethodInvocationExpression>()
                .Select(x => ((MethodReferenceType)x.Base.Type).Declaration)
                .ToList();
            if (calledMethods.Any(visitedMethodDeclarations.Contains))
                return true;

            foreach (var calledMethod in calledMethods)
            {
                if (IsRecurssive(visitedMethodDeclarations.Concat(calledMethod.Yield()).ToList()))
                    return true;
            }

            return false;
        }

        private void UnwrapMethodInvocation(MethodInvocationExpression invocation, MethodDeclaration declaration)
        {
            if (invocation.Parent == null)
                return;
            var context = invocation.Context;
            var parentStatement = invocation.NearestAncestorOfType<IStatement>();
            var discardReturnValue = invocation.Parent is ExpressionStatement;
            var block = (BlockStatement)parentStatement.Parent;

            var addedStatements = new List<IStatement>();
            VariableDeclaration returnValueVar = null;
            if (!discardReturnValue)
            {
                returnValueVar = new VariableDeclaration(
                    context,
                    declaration.Name + new Random().Next(),
                    new INode[] { AstCloner.Clone(declaration.ReturnType) });
                var variableDeclarationStatement = new VariableDeclarationStatement(context, returnValueVar);
                block.AddChildBefore(parentStatement, variableDeclarationStatement);
                block.VariableDeclarations.Add(returnValueVar);
                invocation.ReplaceWith(new SimpleNameExpression(context, returnValueVar.Name)
                {
                    Type = returnValueVar.Type,
                    Declaration = returnValueVar
                });
                addedStatements.Add(variableDeclarationStatement);
            }
            else
            {
                invocation.Remove();
            }


            var clonedDeclaration = AstCloner.Clone(declaration);
            var parameters = clonedDeclaration.Variables.ToList();
            var arguments = invocation.Arguments.ToList();
            for (int i = 0; i < parameters.Count; i++)
            {
                if (arguments.Count > i)
                {
                    if (parameters[i].InitExpression != null)
                        parameters[i].InitExpression.ReplaceWith(arguments[i]);
                    else
                        parameters[i].AddChild(arguments[i]);
                }
                parameters[i].Remove();
                var variableDeclarationStatement = new VariableDeclarationStatement(parameters[i].Context, parameters[i]);
                block.AddChildBefore(parentStatement, variableDeclarationStatement);
                block.VariableDeclarations.Add(parameters[i]);
                addedStatements.Add(variableDeclarationStatement);
            }

            var body = clonedDeclaration.Body;
            block.AddChildBefore(parentStatement, body);
            addedStatements.Add(body);
            var gotoTarget = new GotoTargetStatement(invocation.Context);
            block.AddChildBefore(parentStatement, gotoTarget);
            addedStatements.Add(gotoTarget);

            ReplaceReturnStatements(clonedDeclaration.Body, gotoTarget, returnValueVar);

            if (discardReturnValue)
                parentStatement.Remove();

            foreach (var subInvocation in addedStatements.SelectMany(x => x.AllDescendantsAndSelf()).OfType<MethodInvocationExpression>().ToList())
            {
                var subTarget = ((MethodReferenceType)subInvocation.Base.Type).Declaration;
                UnwrapMethodInvocation(subInvocation, subTarget);

            }
            BlockFlattener.FlattenAllSubBlocks(block);
        }

        private void ReplaceReturnStatements(INode node, GotoTargetStatement gotoTarget, VariableDeclaration returnValueVar)
        {
            if (!(node is IStatement))
                return;
            switch (node)
            {
                case ReturnStatement returnStatement:
                    var block = (BlockStatement)returnStatement.Parent;
                    if (returnValueVar != null)
                        block.AddChildBefore(returnStatement, new ExpressionStatement(
                            returnStatement.Context,
                            new AssignmentExpression(
                                returnStatement.Context,
                                new INode[]
                                {
                                        new SimpleNameExpression(returnStatement.Context, returnValueVar.Name)
                                        {
                                            Declaration = returnValueVar,
                                            Type = returnValueVar.Type
                                        },
                                        new AssignmentOperator(returnStatement.Context, "="),
                                        returnStatement.Value
                                })
                            ));
                    block.AddChildBefore(returnStatement, new GotoStatement(returnStatement.Context, gotoTarget));
                    returnStatement.Remove();
                    return;
            }
            //Any other statement
            foreach (var child in node.Children.ToList())
            {
                ReplaceReturnStatements(child, gotoTarget, returnValueVar);
            }
        }
    }
}