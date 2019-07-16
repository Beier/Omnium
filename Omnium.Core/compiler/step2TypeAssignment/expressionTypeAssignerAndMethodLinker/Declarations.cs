using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.compiler.utilities;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step2TypeAssignment.expressionTypeAssignerAndMethodLinker
{
    public partial class ExpressionTypeAssignerAndMethodLinker : TreeVoidWalker
    {
        private Stack<INamedDeclaration> currentMethodStack = new Stack<INamedDeclaration>();
        private Dictionary<INamedDeclaration, List<ITypeNode>> inferredMethodTypes = new Dictionary<INamedDeclaration, List<ITypeNode>>();
        private HashSet<INamedDeclaration> visitedMethods = new HashSet<INamedDeclaration>();
        public override void EnterMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            EnterMethodOrGetterOrSetter(methodDeclaration);
        }

        public override void EnterGetterDeclaration(GetterDeclaration getterDeclaration)
        {
            EnterMethodOrGetterOrSetter(getterDeclaration);
        }

        public override void EnterSetterDeclaration(SetterDeclaration setterDeclaration)
        {
            EnterMethodOrGetterOrSetter(setterDeclaration);
        }

        private void EnterMethodOrGetterOrSetter(INamedDeclaration namedDeclaration)
        {
            if (visitedMethods.Contains(namedDeclaration))
            {
                skipChildren = true;
                return;
            }

            if (currentMethodStack.Contains(namedDeclaration))
            {
                var path = currentMethodStack.SkipWhile(x => x != namedDeclaration).Concat(namedDeclaration.Yield())
                    .Select(
                        (MethodDeclaration methodDeclaration) => $"\tmethod {methodDeclaration.Name} ({methodDeclaration.Context.GetPositionString()})",
                        (GetterDeclaration getterDeclaration) => $"\tgetter {getterDeclaration.Name} ({getterDeclaration.Context.GetPositionString()})",
                        (SetterDeclaration setterDeclaration) => $"\tsetter {setterDeclaration.Name} ({setterDeclaration.Context.GetPositionString()})"
                    ).MkString("\n");

                throw new CompilationError(namedDeclaration.Context, "Recursive methods are not allowed\n" + path);
            }
            currentMethodStack.Push(namedDeclaration);
            switch (namedDeclaration)
            {
                case MethodDeclaration methodDeclaration:
                    if (methodDeclaration.ReturnType == null)
                        inferredMethodTypes.Add(methodDeclaration, new List<ITypeNode>());
                    break;
                case GetterDeclaration getterDeclaration:
                    if (getterDeclaration.ReturnType == null)
                        inferredMethodTypes.Add(getterDeclaration, new List<ITypeNode>());
                    break;
            }
        }


        public override void ExitReturnStatement(ReturnStatement returnStatement)
        {
            var ancestor = returnStatement.NearestAncestorOfAnyType(typeof(MethodDeclaration), typeof(LambdaExpression), typeof(GetterDeclaration));
            if (ancestor is INamedDeclaration namedDeclaration)
            {
                ITypeNode returnType = null;
                switch (namedDeclaration)
                {
                    case MethodDeclaration methodDeclaration:
                        returnType = methodDeclaration.ReturnType;
                        break;
                    case GetterDeclaration getterDeclaration:
                        returnType = getterDeclaration.ReturnType;
                        break;
                }
                var returnStatementType = returnStatement?.Value.Type ?? new VoidType(returnStatement.Context);
                if (returnType != null)
                {
                    if (!returnStatementType.IsAssignableTo(returnType))
                        Errors.Add(new CompilationError(returnStatement.Context, $"{returnStatementType} is not assignable to the return type of the method: {returnType}."));
                }
                else if (!(returnStatementType is ITypeNode returnStatementTypeNode))
                {
                    Errors.Add(new CompilationError(returnStatement.Context, $"Invalid return value: {returnStatementType}"));
                }
                else
                {
                    var typeList = inferredMethodTypes[namedDeclaration];
                    if (!typeList.Any(x => x.IsEquivalentTo(returnStatementType)))
                        typeList.Add(returnStatementTypeNode);
                }
            }
        }

        public override void ExitMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            ExitMethodOrGetterOrSetter(methodDeclaration);
        }

        public override void ExitGetterDeclaration(GetterDeclaration getterDeclaration)
        {
            ExitMethodOrGetterOrSetter(getterDeclaration);
        }

        public override void ExitSetterDeclaration(SetterDeclaration setterDeclaration)
        {
            ExitMethodOrGetterOrSetter(setterDeclaration);
        }

        private void ExitMethodOrGetterOrSetter(INamedDeclaration namedDeclaration)
        {
            if (currentMethodStack.Count == 0 || currentMethodStack.Peek() != namedDeclaration)
                return;
            currentMethodStack.Pop();
            visitedMethods.Add(namedDeclaration);
            if (inferredMethodTypes.TryGetValue(namedDeclaration, out var types))
            {
                ITypeNode returnType;
                if (types.All(x => x is VoidType))
                    returnType = new VoidType(namedDeclaration.Context);
                else if (types.Any(x => x is VoidType))
                    throw new CompilationError(namedDeclaration.Context, "Not all return statements return a value");
                else
                    returnType = types.Aggregate((left, right) =>
                    {
                        var aggregateTypes = Unwrap(left).Concat(Unwrap(right))
                            .RemoveDuplicates((x, y) => x.IsEquivalentTo(y)).ToList();
                        if (aggregateTypes.Count == 1)
                            return aggregateTypes[0];
                        return new TypeList(namedDeclaration.Context, aggregateTypes.Select(AstCloner.Clone));

                        IEnumerable<ITypeNode> Unwrap(ITypeNode t)
                        {
                            if (t is TypeList typeList)
                                return typeList.SubTypes;
                            return t.Yield();
                        }
                    });

                namedDeclaration.AddChild(AstCloner.Clone(returnType));
            }
        }
        
        public override void ExitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            if (variableDeclaration.InitExpression == null && variableDeclaration.Type == null)
                Errors.Add(new CompilationError(variableDeclaration.Context, "You must specify a type, or initialize the variable."));
            else if (variableDeclaration.InitExpression != null && variableDeclaration.Type != null && !variableDeclaration.InitExpression.Type.IsAssignableTo(variableDeclaration.Type))
                Errors.Add(new CompilationError(variableDeclaration.Context, $"{variableDeclaration.InitExpression.Type} is not assignable to {variableDeclaration.Type}."));
            else if (variableDeclaration.InitExpression != null && variableDeclaration.Type == null)
                variableDeclaration.AddChild(AstCloner.Clone((ITypeNode)variableDeclaration.InitExpression.Type));
        }

        public override void ExitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            var root = ruleDeclaration.NearestAncestorOfType<Root>();
            var eventDeclaration = root
                .SourceFiles
                .SelectMany(x => x.ModuleDeclarations)
                .Where(x => x.Name == "Rule")
                .SelectMany(x => x.ClassDeclarations)
                .Single(x => x.Name == "Event");

            var triggerType = new ReferenceType(ruleDeclaration.Context, eventDeclaration);
            var conditionType = new BoolType(ruleDeclaration.Context);
            var actionType = new FunctionType(ruleDeclaration.Context, new VoidType(ruleDeclaration.Context).Yield());
            if (!ruleDeclaration.Trigger.Type.IsAssignableTo(triggerType))
                Errors.Add(new CompilationError(ruleDeclaration.Condition.Context, $"Can not assign {ruleDeclaration.Condition.Type} to {conditionType}"));
            if (!ruleDeclaration.Condition.Type.IsAssignableTo(conditionType))
                Errors.Add(new CompilationError(ruleDeclaration.Condition.Context, $"Can not assign {ruleDeclaration.Condition.Type} to {conditionType}"));
            if (!ruleDeclaration.Action.Type.IsAssignableTo(actionType))
                Errors.Add(new CompilationError(ruleDeclaration.Action.Context, $"Can not assign {ruleDeclaration.Action.Type} to {actionType}"));
        }

        public override void ExitClassDeclaration(ClassDeclaration classDeclaration)
        {
            foreach (var getterSetterDeclaration in classDeclaration.GettersAndSetters)
            {
                if (getterSetterDeclaration.Getter != null
                    && getterSetterDeclaration.Setter != null
                    && !getterSetterDeclaration.Getter.ReturnType.IsEquivalentTo(getterSetterDeclaration.Setter.Parameter.Type))
                    Errors.Add(new CompilationError(getterSetterDeclaration.Getter.Context, "Getters and setters of the same name must have the same type."));
            }
        }
    }
}