using System;
using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.ast.expressions;
using OverwatchCompiler.ToWorkshop.ast.expressions.literals;
using OverwatchCompiler.ToWorkshop.ast.statements;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public abstract class TreeValueWalker<T>
    {
        public readonly List<CompilationError> Errors = new List<CompilationError>();

        public abstract T GetDefault(INode node);
        public abstract T Combine(T v1, T v2);

        public virtual T VisitChildren(INode node)
        {
            var children = node.Children.ToList();
            if (children.Count == 0)
                return GetDefault(node);
            return children.Select(Visit).Aggregate(Combine);
        }

        public virtual T Visit(INode node)
        {
            if (node is SourceFile)
                return VisitSourceFile((SourceFile)node);
            if (node is ModuleDeclaration)
                return VisitModuleDeclaration((ModuleDeclaration)node);
            if (node is StringLiteral)
                return VisitStringLiteral((StringLiteral)node);
            if (node is NumberLiteral)
                return VisitNumberLiteral((NumberLiteral)node);
            if (node is NullLiteral)
                return VisitNullLiteral((NullLiteral)node);
            if (node is BooleanLiteral)
                return VisitBooleanLiteral((BooleanLiteral)node);
            if (node is UnaryExpression)
                return VisitUnaryExpression((UnaryExpression)node);
            if (node is ThisExpression)
                return VisitThisExpression((ThisExpression)node);
            if (node is SimpleNameExpression)
                return VisitSimpleNameExpression((SimpleNameExpression)node);
            if (node is PosfixOperationExpression)
                return VisitPosfixOperationExpression((PosfixOperationExpression)node);
            if (node is ObjectCreationExpression)
                return VisitObjectCreationExpression((ObjectCreationExpression)node);
            if (node is NativeTrigger)
                return VisitNativeTrigger((NativeTrigger)node);
            if (node is MethodInvocationExpression)
                return VisitMethodInvocationExpression((MethodInvocationExpression)node);
            if (node is LambdaExpression)
                return VisitLambdaExpression((LambdaExpression)node);
            if (node is MemberExpression)
                return VisitMemberExpression((MemberExpression)node);
            if (node is CastExpression)
                return VisitCastExpression((CastExpression)node);
            if (node is BinaryExpression)
                return VisitBinaryExpression((BinaryExpression)node);
            if (node is AssignmentOperator)
                return VisitAssignmentOperator((AssignmentOperator)node);
            if (node is AssignmentExpression)
                return VisitAssignmentExpression((AssignmentExpression)node);
            if (node is ArrayIndexExpression)
                return VisitArrayIndexExpression((ArrayIndexExpression)node);
            if (node is ArrayCreationExpression)
                return VisitArrayCreationExpression((ArrayCreationExpression)node);
            if (node is VoidType)
                return VisitVoidType((VoidType)node);
            if (node is StringType)
                return VisitStringType((StringType)node);
            if (node is NumberType)
                return VisitNumberType((NumberType)node);
            if (node is BoolType)
                return VisitBoolType((BoolType)node);
            if (node is VariableDeclaration)
                return VisitVariableDeclaration((VariableDeclaration)node);
            if (node is ClassDeclaration)
                return VisitClassDeclaration((ClassDeclaration)node);
            if (node is SetterDeclaration)
                return VisitSetterDeclaration((SetterDeclaration)node);
            if (node is RuleDeclaration)
                return VisitRuleDeclaration((RuleDeclaration)node);
            if (node is Root)
                return VisitRoot((Root)node);
            if (node is MethodDeclaration)
                return VisitMethodDeclaration((MethodDeclaration)node);
            if (node is GetterSetterDeclaration)
                return VisitGetterSetterDeclaration((GetterSetterDeclaration)node);
            if (node is GetterDeclaration)
                return VisitGetterDeclaration((GetterDeclaration)node);
            if (node is GenericTypeDeclaration)
                return VisitGenericTypeDeclaration((GenericTypeDeclaration)node);
            if (node is EnumValue)
                return VisitEnumValue((EnumValue)node);
            if (node is EnumDeclaration)
                return VisitEnumDeclaration((EnumDeclaration)node);
            if (node is ConstructorDeclaration)
                return VisitConstructorDeclaration((ConstructorDeclaration)node);
            if (node is NativeMethodInvocationExpression)
                return VisitNativeMethodInvocationExpression((NativeMethodInvocationExpression)node);
            if (node is WhileStatement)
                return VisitWhileStatement((WhileStatement)node);
            if (node is VariableDeclarationStatement)
                return VisitVariableDeclarationStatement((VariableDeclarationStatement)node);
            if (node is SwitchLabel)
                return VisitSwitchLabel((SwitchLabel)node);
            if (node is SwitchGroup)
                return VisitSwitchGroup((SwitchGroup)node);
            if (node is SwitchStatement)
                return VisitSwitchStatement((SwitchStatement)node);
            if (node is ReturnStatement)
                return VisitReturnStatement((ReturnStatement)node);
            if (node is IfStatement)
                return VisitIfStatement((IfStatement)node);
            if (node is ForStatement)
                return VisitForStatement((ForStatement)node);
            if (node is ForeachStatement)
                return VisitForeachStatement((ForeachStatement)node);
            if (node is ExpressionStatement)
                return VisitExpressionStatement((ExpressionStatement)node);
            if (node is ContinueStatement)
                return VisitContinueStatement((ContinueStatement)node);
            if (node is BreakStatement)
                return VisitBreakStatement((BreakStatement)node);
            if (node is BlockStatement)
                return VisitBlockStatement((BlockStatement)node);
            if (node is GotoTargetStatement)
                return VisitGotoTargetStatement((GotoTargetStatement)node);
            if (node is GotoStatement)
                return VisitGotoStatement((GotoStatement)node);
            if (node is TypeNodeWrapper)
                return VisitTypeNodeWrapper((TypeNodeWrapper)node);
            if (node is TypeList)
                return VisitTypeList((TypeList)node);
            if (node is ReferenceType)
                return VisitReferenceType((ReferenceType)node);
            if (node is FunctionType)
                return VisitFunctionType((FunctionType)node);
            if (node is ArrayType)
                return VisitArrayType((ArrayType)node);
            if (node is Token)
                return VisitToken((Token)node);
            throw new Exception("Unexpected node type: " + node?.GetType().FullName);
        }

        public virtual T VisitSourceFile(SourceFile sourceFile)
        {
            return VisitChildren(sourceFile);
        }

        public virtual T VisitModuleDeclaration(ModuleDeclaration moduleDeclaration)
        {
            return VisitChildren(moduleDeclaration);
        }

        public virtual T VisitStringLiteral(StringLiteral stringLiteral)
        {
            return VisitChildren(stringLiteral);
        }

        public virtual T VisitNumberLiteral(NumberLiteral numberLiteral)
        {
            return VisitChildren(numberLiteral);
        }

        public virtual T VisitNullLiteral(NullLiteral nullLiteral)
        {
            return VisitChildren(nullLiteral);
        }

        public virtual T VisitBooleanLiteral(BooleanLiteral booleanLiteral)
        {
            return VisitChildren(booleanLiteral);
        }

        public virtual T VisitUnaryExpression(UnaryExpression unaryExpression)
        {
            return VisitChildren(unaryExpression);
        }

        public virtual T VisitThisExpression(ThisExpression thisExpression)
        {
            return VisitChildren(thisExpression);
        }

        public virtual T VisitSimpleNameExpression(SimpleNameExpression simpleNameExpression)
        {
            return VisitChildren(simpleNameExpression);
        }

        public virtual T VisitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression)
        {
            return VisitChildren(posfixOperationExpression);
        }

        public virtual T VisitObjectCreationExpression(ObjectCreationExpression objectCreationExpression)
        {
            return VisitChildren(objectCreationExpression);
        }

        public virtual T VisitNativeTrigger(NativeTrigger nativeTrigger)
        {
            return VisitChildren(nativeTrigger);
        }

        public virtual T VisitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression)
        {
            return VisitChildren(methodInvocationExpression);
        }

        public virtual T VisitLambdaExpression(LambdaExpression lambdaExpression)
        {
            return VisitChildren(lambdaExpression);
        }

        public virtual T VisitMemberExpression(MemberExpression memberExpression)
        {
            return VisitChildren(memberExpression);
        }

        public virtual T VisitCastExpression(CastExpression castExpression)
        {
            return VisitChildren(castExpression);
        }

        public virtual T VisitBinaryExpression(BinaryExpression binaryExpression)
        {
            return VisitChildren(binaryExpression);
        }

        public virtual T VisitAssignmentOperator(AssignmentOperator assignmentOperator)
        {
            return VisitChildren(assignmentOperator);
        }

        public virtual T VisitAssignmentExpression(AssignmentExpression assignmentExpression)
        {
            return VisitChildren(assignmentExpression);
        }

        public virtual T VisitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression)
        {
            return VisitChildren(arrayIndexExpression);
        }

        public virtual T VisitArrayCreationExpression(ArrayCreationExpression arrayCreationExpression)
        {
            return VisitChildren(arrayCreationExpression);
        }

        public virtual T VisitVoidType(VoidType voidType)
        {
            return VisitChildren(voidType);
        }

        public virtual T VisitStringType(StringType stringType)
        {
            return VisitChildren(stringType);
        }

        public virtual T VisitNumberType(NumberType numberType)
        {
            return VisitChildren(numberType);
        }

        public virtual T VisitBoolType(BoolType boolType)
        {
            return VisitChildren(boolType);
        }

        public virtual T VisitVariableDeclaration(VariableDeclaration variableDeclaration)
        {
            return VisitChildren(variableDeclaration);
        }

        public virtual T VisitClassDeclaration(ClassDeclaration classDeclaration)
        {
            return VisitChildren(classDeclaration);
        }

        public virtual T VisitSetterDeclaration(SetterDeclaration setterDeclaration)
        {
            return VisitChildren(setterDeclaration);
        }

        public virtual T VisitRuleDeclaration(RuleDeclaration ruleDeclaration)
        {
            return VisitChildren(ruleDeclaration);
        }

        public virtual T VisitRoot(Root root)
        {
            return VisitChildren(root);
        }

        public virtual T VisitMethodDeclaration(MethodDeclaration methodDeclaration)
        {
            return VisitChildren(methodDeclaration);
        }

        public virtual T VisitGetterSetterDeclaration(GetterSetterDeclaration getterSetterDeclaration)
        {
            return VisitChildren(getterSetterDeclaration);
        }

        public virtual T VisitGetterDeclaration(GetterDeclaration getterDeclaration)
        {
            return VisitChildren(getterDeclaration);
        }

        public virtual T VisitGenericTypeDeclaration(GenericTypeDeclaration genericTypeDeclaration)
        {
            return VisitChildren(genericTypeDeclaration);
        }

        public virtual T VisitEnumValue(EnumValue enumValue)
        {
            return VisitChildren(enumValue);
        }

        public virtual T VisitEnumDeclaration(EnumDeclaration enumDeclaration)
        {
            return VisitChildren(enumDeclaration);
        }

        public virtual T VisitConstructorDeclaration(ConstructorDeclaration constructorDeclaration)
        {
            return VisitChildren(constructorDeclaration);
        }

        public virtual T VisitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression)
        {
            return VisitChildren(nativeMethodInvocationExpression);
        }

        public virtual T VisitWhileStatement(WhileStatement whileStatement)
        {
            return VisitChildren(whileStatement);
        }

        public virtual T VisitVariableDeclarationStatement(VariableDeclarationStatement variableDeclarationStatement)
        {
            return VisitChildren(variableDeclarationStatement);
        }

        public virtual T VisitSwitchLabel(SwitchLabel switchLabel)
        {
            return VisitChildren(switchLabel);
        }

        public virtual T VisitSwitchGroup(SwitchGroup switchGroup)
        {
            return VisitChildren(switchGroup);
        }

        public virtual T VisitSwitchStatement(SwitchStatement switchStatement)
        {
            return VisitChildren(switchStatement);
        }

        public virtual T VisitReturnStatement(ReturnStatement returnStatement)
        {
            return VisitChildren(returnStatement);
        }

        public virtual T VisitIfStatement(IfStatement ifStatement)
        {
            return VisitChildren(ifStatement);
        }

        public virtual T VisitForStatement(ForStatement forStatement)
        {
            return VisitChildren(forStatement);
        }

        public virtual T VisitForeachStatement(ForeachStatement foreachStatement)
        {
            return VisitChildren(foreachStatement);
        }

        public virtual T VisitExpressionStatement(ExpressionStatement expressionStatement)
        {
            return VisitChildren(expressionStatement);
        }

        public virtual T VisitContinueStatement(ContinueStatement continueStatement)
        {
            return VisitChildren(continueStatement);
        }

        public virtual T VisitBreakStatement(BreakStatement breakStatement)
        {
            return VisitChildren(breakStatement);
        }

        public virtual T VisitBlockStatement(BlockStatement blockStatement)
        {
            return VisitChildren(blockStatement);
        }

        public virtual T VisitGotoTargetStatement(GotoTargetStatement gotoTargetStatement)
        {
            return VisitChildren(gotoTargetStatement);
        }

        public virtual T VisitGotoStatement(GotoStatement gotoStatement)
        {
            return VisitChildren(gotoStatement);
        }

        public virtual T VisitTypeNodeWrapper(TypeNodeWrapper typeNodeWrapper)
        {
            return VisitChildren(typeNodeWrapper);
        }

        public virtual T VisitTypeList(TypeList typeList)
        {
            return VisitChildren(typeList);
        }

        public virtual T VisitReferenceType(ReferenceType referenceType)
        {
            return VisitChildren(referenceType);
        }

        public virtual T VisitFunctionType(FunctionType functionType)
        {
            return VisitChildren(functionType);
        }

        public virtual T VisitArrayType(ArrayType arrayType)
        {
            return VisitChildren(arrayType);
        }

        public virtual T VisitToken(Token token)
        {
            return VisitChildren(token);
        }
    }
}
