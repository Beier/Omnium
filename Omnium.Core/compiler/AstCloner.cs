using System;
using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.expressions.literals;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;

namespace Omnium.Core.compiler
{
    public class AstCloner : TreeValueWalker<INode>
    {
        private readonly Dictionary<INode, INode> replacedNodes = new Dictionary<INode, INode>();

        private AstCloner()
        {

        }

        public static T Clone<T>(T node) where T : INode
        {
            var cloner = new AstCloner();
            var clone = cloner.Visit(node);
            cloner.UpdateReferences(clone);
            return (T) clone;
        }

        private void UpdateReferences(INode node)
        {
            if (node is IExpression expression)
            {
                switch (expression.Type)
                {
                    case ReferenceType referenceType:
                        referenceType.Declaration = GetClone(referenceType.Declaration);
                        break;
                    case MethodReferenceType methodReferenceType:
                        methodReferenceType.Declaration = GetClone(methodReferenceType.Declaration);
                        break;
                    case StaticReference staticReference:
                        staticReference.Declaration = GetClone(staticReference.Declaration);
                        break;
                }
            }

            switch (node)
            {
                case SimpleNameExpression simpleNameExpression:
                    simpleNameExpression.Declaration = GetClone(simpleNameExpression.Declaration);
                    break;
                case MemberExpression memberExpression:
                    memberExpression.Declaration = GetClone(memberExpression.Declaration);
                    break;
                case ReferenceType referenceType:
                    referenceType.Declaration = GetClone(referenceType.Declaration);
                    break;
                case ImportDeclaration importDeclaration:
                    importDeclaration.TargetSourceFile = GetClone(importDeclaration.TargetSourceFile);
                    break;
                case BlockStatement blockStatement:
                    var oldVariables = blockStatement.VariableDeclarations.ToList();
                    blockStatement.VariableDeclarations.Clear();
                    blockStatement.VariableDeclarations.AddRange(oldVariables.Select(GetClone));
                    break;
                case GotoStatement gotoStatement:
                    gotoStatement.TargetStatement = GetClone(gotoStatement.TargetStatement);
                    break;
            }

            foreach (var child in node.Children)
            {
                UpdateReferences(child);
            }
        }

        public override INode VisitGotoStatement(GotoStatement gotoStatement)
        {
            if (gotoStatement.Condition == null)
                return new GotoStatement(gotoStatement.Context, gotoStatement.TargetStatement);
            return new GotoStatement(gotoStatement.Context, gotoStatement.Condition, gotoStatement.TargetStatement);
        }

        public override INode VisitGotoTargetStatement(GotoTargetStatement gotoTargetStatement)
        {
            return new GotoTargetStatement(gotoTargetStatement.Context);
        }

        private T GetClone<T>(T node) where T : class, INode
        {
            if (node == null)
                return null;
            if (replacedNodes.TryGetValue(node, out var clone))
                return (T) clone;
            return node;
        }

        public override INode VisitGenericType(GenericType genericType)
        {
            return new GenericType(genericType.Context, genericType.Children.Select(Visit));
        }


        public override INode GetDefault(INode node)
        {
            throw new Exception("AstCloner is missing implementation for " + node.GetType().Name);
        }

        public override INode Combine(INode v1, INode v2)
        {
            throw new System.NotImplementedException();
        }

        public override INode Visit(INode node)
        {
            if (node == null)
                return null;
            var clone = base.Visit(node);
            replacedNodes.Add(node, clone);
            return clone;
        }

        public override INode VisitRoot(Root root)
        {
            return new Root(root.Children.Select(Visit));
        }

        public override INode VisitClassDeclaration(ClassDeclaration classDeclaration)
        {
            return new ClassDeclaration(classDeclaration.Context, classDeclaration.Name, classDeclaration.Children.Select(Visit));
        }

        public override INode VisitConstructorDeclaration(ConstructorDeclaration constructorDeclaration)
        {
            var clone = new ConstructorDeclaration(constructorDeclaration.Context, constructorDeclaration.Children.Select(Visit));
            clone.Modifiers.AddRange(constructorDeclaration.Modifiers);
            return clone;
        }

        public override INode VisitAssertion(Assertion assertion)
        {
            return new Assertion(assertion.Context, assertion.Children.Select(Visit));
        }

        public override INode VisitEnumDeclaration(EnumDeclaration enumDeclaration)
        {
            return new ConstructorDeclaration(enumDeclaration.Context, enumDeclaration.Children.Select(Visit));
        }

        public override INode VisitEnumValue(EnumValue enumValue)
        {
            return new ConstructorDeclaration(enumValue.Context, enumValue.Children.Select(Visit));
        }

        public override INode VisitGenericTypeDeclaration(GenericTypeDeclaration genericTypeDeclaration)
        {
            return new GenericTypeDeclaration(genericTypeDeclaration.Context, genericTypeDeclaration.Name);
        }

        public override INode VisitGetterDeclaration(GetterDeclaration getterDeclaration)
        {
            var clone = new GetterDeclaration(getterDeclaration.Context, getterDeclaration.Name, getterDeclaration.Children.Select(Visit));
            clone.Modifiers.AddRange(getterDeclaration.Modifiers);
            return clone;
        }

        public override INode VisitMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            var clone = new MethodDeclaration(methodDeclaration.Context, methodDeclaration.Name, methodDeclaration.Children.Select(Visit));
            clone.Modifiers.AddRange(methodDeclaration.Modifiers);
            return clone;
        }

        public override INode VisitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            return new ModuleDeclaration(moduleDeclaration.Context, moduleDeclaration.Name, moduleDeclaration.Children.Select(Visit));
        }

        public override INode VisitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            return new RuleDeclaration(ruleDeclaration.Context, ruleDeclaration.Name, ruleDeclaration.Children.Select(Visit));
        }

        public override INode VisitSetterDeclaration(SetterDeclaration setterDeclaration)
        {
            var clone = new SetterDeclaration(setterDeclaration.Context, setterDeclaration.Name, setterDeclaration.Children.Select(Visit));
            clone.Modifiers.AddRange(setterDeclaration.Modifiers);
            return clone;
        }

        public override INode VisitSourceFile(SourceFile sourceFile)
        {//Todo
            var clone = new SourceFile(sourceFile.Context, sourceFile.Path, sourceFile.Children.Select(Visit));
            //clone.ImportedSourceFiles.AddRange(sourceFile.ImportedSourceFiles);
            return clone;
        }

        public override INode VisitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            var clone = new VariableDeclaration(variableDeclaration.Context, variableDeclaration.Name, variableDeclaration.Children.Select(Visit));
            clone.Modifiers.AddRange(variableDeclaration.Modifiers);
            clone.VariableType = variableDeclaration.VariableType;
            return clone;
        }

        public override INode VisitBooleanLiteral(BooleanLiteral booleanLiteral)
        {
            return new BooleanLiteral(booleanLiteral.Context, booleanLiteral.overrideText)
            {
                Type = booleanLiteral.Type
            };
        }

        public override INode VisitNullLiteral(NullLiteral nullLiteral)
        {
            return new NullLiteral(nullLiteral.Context)
            {
                Type = nullLiteral.Type
            };
        }

        public override INode VisitNumberLiteral(NumberLiteral numberLiteral)
        {
            return new NumberLiteral(numberLiteral.Context, numberLiteral.overrideText)
            {
                Type = numberLiteral.Type
            };
        }

        public override INode VisitStringLiteral(StringLiteral stringLiteral)
        {
            return new StringLiteral(stringLiteral.Context, stringLiteral.Text)
            {
                Type = stringLiteral.Type
            };
        }

        public override INode VisitArrayCreationExpression(ArrayCreationExpression arrayCreationExpression)
        {
            return new ArrayCreationExpression(arrayCreationExpression.Context, arrayCreationExpression.Children.Select(Visit))
            {
                Type = arrayCreationExpression.Type
            };
        }

        public override INode VisitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            return new ArrayIndexExpression(arrayIndexExpression.Context, arrayIndexExpression.Children.Select(Visit))
            {
                Type = arrayIndexExpression.Type
            };
        }

        public override INode VisitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            return new AssignmentExpression(assignmentExpression.Context, assignmentExpression.Children.Select(Visit))
            {
                Type = assignmentExpression.Type
            };
        }

        public override INode VisitBinaryExpression(BinaryExpression binaryExpression)
        {
            return new BinaryExpression(binaryExpression.Context, binaryExpression.Children.Select(Visit))
            {
                Type = binaryExpression.Type
            };
        }

        public override INode VisitCastExpression(CastExpression castExpression)
        {
            return new CastExpression(castExpression.Context, castExpression.Children.Select(Visit))
            {
                Type = castExpression.Type
            };
        }

        public override INode VisitLambdaExpression(LambdaExpression lambdaExpression)
        {
            return new LambdaExpression(lambdaExpression.Context, lambdaExpression.Children.Select(Visit))
            {
                Type = lambdaExpression.Type
            };
        }

        public override INode VisitMemberExpression(MemberExpression memberExpression)
        {
            return new MemberExpression(memberExpression.Context, memberExpression.Name, memberExpression.Children.Select(Visit))
            {
                Type = memberExpression.Type,
                Declaration = memberExpression.Declaration
            };
        }

        public override INode VisitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            return new MethodInvocationExpression(methodInvocationExpression.Context, methodInvocationExpression.Children.Select(Visit))
            {
                Type = methodInvocationExpression.Type
            };
        }

        public override INode VisitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression)
        {
            return new NativeMethodInvocationExpression(nativeMethodInvocationExpression.Context, nativeMethodInvocationExpression.NativeMethodName, nativeMethodInvocationExpression.Type, nativeMethodInvocationExpression.ReadsState, nativeMethodInvocationExpression.ChangesState, nativeMethodInvocationExpression.ModifiesControlFlow, nativeMethodInvocationExpression.Children.Select(Visit));
        }

        public override INode VisitObjectCreationExpression(ObjectCreationExpression objectCreationExpression)
        {
            return new ObjectCreationExpression(objectCreationExpression.Context, objectCreationExpression.Children.Select(Visit))
            {
                Type = objectCreationExpression.Type
            };
        }

        public override INode VisitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression)
        {
            return new PosfixOperationExpression(posfixOperationExpression.Context, posfixOperationExpression.Children.Select(Visit))
            {
                Type = posfixOperationExpression.Type
            };
        }

        public override INode VisitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            return new SimpleNameExpression(simpleNameExpression.Context, simpleNameExpression.Name)
            {
                Type = simpleNameExpression.Type,
                Declaration = simpleNameExpression.Declaration
            };
        }

        public override INode VisitThisExpression(ThisExpression thisExpression)
        {
            return new ThisExpression(thisExpression.Context)
            {
                Type = thisExpression.Type
            };
        }

        public override INode VisitUnaryExpression(UnaryExpression unaryExpression)
        {
            return new UnaryExpression(unaryExpression.Context, unaryExpression.Children.Select(Visit))
            {
                Type = unaryExpression.Type
            };
        }

        public override INode VisitBlockStatement(BlockStatement blockStatement)
        {
            var visitBlockStatement = new BlockStatement(blockStatement.Context, blockStatement.Children.Select(Visit).Cast<IStatement>());
            visitBlockStatement.VariableDeclarations.AddRange(blockStatement.VariableDeclarations);
            return visitBlockStatement;
        }

        public override INode VisitBreakStatement(BreakStatement breakStatement)
        {
            return new BreakStatement(breakStatement.Context);
        }

        public override INode VisitContinueStatement(ContinueStatement continueStatement)
        {
            return new ContinueStatement(continueStatement.Context);
        }

        public override INode VisitExpressionStatement(ExpressionStatement expressionStatement)
        {
            return new ExpressionStatement(expressionStatement.Context, (IExpression)Visit(expressionStatement.Expression));
        }

        public override INode VisitForeachStatement(ForeachStatement foreachStatement)
        {
            return new ForeachStatement(foreachStatement.Context, foreachStatement.Children.Select(Visit));
        }

        public override INode VisitForStatement(ForStatement forStatement)
        {
            return new ForStatement(
                forStatement.Context, 
                forStatement.Variables.Select(Visit).Cast<VariableDeclaration>(),
                forStatement.InitExpressions.Select(Visit).Cast<IExpression>(),
                (IExpression)Visit(forStatement.Condition),
                forStatement.NextExpressions.Select(Visit).Cast<IExpression>(),
                (IStatement)Visit(forStatement.Body)
                );
        }

        public override INode VisitIfStatement(IfStatement ifStatement)
        {
            return new IfStatement(ifStatement.Context, ifStatement.Children.Select(Visit));
        }

        public override INode VisitReturnStatement(ReturnStatement returnStatement)
        {
            return new ReturnStatement(returnStatement.Context, returnStatement.Children.Select(Visit));
        }

        public override INode VisitSwitchStatement(SwitchStatement switchStatement)
        {
            return new SwitchStatement(switchStatement.Context, switchStatement.Children.Select(Visit));
        }

        public override INode VisitSwitchGroup(SwitchGroup switchGroup)
        {
            return new SwitchGroup(switchGroup.Context, switchGroup.Children.Select(Visit));
        }

        public override INode VisitSwitchLabel(SwitchLabel switchLabel)
        {
            return new SwitchLabel(switchLabel.Context, switchLabel.Children.Select(Visit));
        }

        public override INode VisitVariableDeclarationStatement(VariableDeclarationStatement variableDeclarationStatement)
        {
            return new VariableDeclarationStatement(variableDeclarationStatement.Context, (VariableDeclaration)Visit(variableDeclarationStatement.VariableDeclaration));
        }

        public override INode VisitWhileStatement(WhileStatement whileStatement)
        {
            return new WhileStatement(whileStatement.Context, whileStatement.Children.Select(Visit));
        }

        public override INode VisitBoolType(BoolType boolType)
        {
            return new BoolType(boolType.Context);
        }

        public override INode VisitFunctionType(FunctionType functionType)
        {
            return new FunctionType(functionType.Context, functionType.Children.Select(Visit));
        }

        public override INode VisitNumberType(NumberType numberType)
        {
            return new NumberType(numberType.Context);
        }

        public override INode VisitReferenceType(ReferenceType referenceType)
        {
            return new ReferenceType(referenceType.Context, referenceType.Children.Select(Visit).Cast<Token>())
            {
                Declaration = referenceType.Declaration
            };
        }

        public override INode VisitStringType(StringType stringType)
        {
            return new StringType(stringType.Context);
        }

        public override INode VisitTypeList(TypeList typeList)
        {
            return new TypeList(typeList.Context, typeList.Children.Select(Visit).Cast<ITypeNode>());
        }

        public override INode VisitVoidType(VoidType voidType)
        {
            return new VoidType(voidType.Context);
        }

        public override INode VisitAssignmentOperator(AssignmentOperator assignmentOperator)
        {
            return new AssignmentOperator(assignmentOperator.Context, assignmentOperator.Value);
        }

        public override INode VisitToken(Token token)
        {
            return new Token(token.Context, token.overrideText);
        }

        public override INode VisitNativeTrigger(NativeTrigger nativeTrigger)
        {
            return new NativeTrigger(nativeTrigger.Context, nativeTrigger.Name, nativeTrigger.Arguments);
        }
    }
}