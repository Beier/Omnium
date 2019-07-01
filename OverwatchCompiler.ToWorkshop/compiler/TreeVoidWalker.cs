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
    public abstract class TreeVoidWalker
    {
        protected bool skipChildren = false;
        public readonly List<CompilationError> Errors = new List<CompilationError>();

        public virtual void Visit(INode node)
        {
            if (node == null)
                return;
            if (node is INode)
                EnterINode((INode)node);
            if (node is Node)
                EnterNode((Node)node);
            if (node is ITypeNode)
                EnterITypeNode((ITypeNode)node);
            if (node is IStatement)
                EnterIStatement((IStatement)node);
            if (node is IExpression)
                EnterIExpression((IExpression)node);
            if (node is IHasVariables)
                EnterIHasVariables((IHasVariables)node);
            if (node is INamedDeclaration)
                EnterINamedDeclaration((INamedDeclaration)node);
            if (node is Token)
                EnterToken((Token)node);
            if (node is ArrayType)
                EnterArrayType((ArrayType)node);
            if (node is FunctionType)
                EnterFunctionType((FunctionType)node);
            if (node is ReferenceType)
                EnterReferenceType((ReferenceType)node);
            if (node is TypeList)
                EnterTypeList((TypeList)node);
            if (node is TypeNodeWrapper)
                EnterTypeNodeWrapper((TypeNodeWrapper)node);
            if (node is Assertion)
                EnterAssertion((Assertion)node);
            if (node is GotoStatement)
                EnterGotoStatement((GotoStatement)node);
            if (node is GotoTargetStatement)
                EnterGotoTargetStatement((GotoTargetStatement)node);
            if (node is BlockStatement)
                EnterBlockStatement((BlockStatement)node);
            if (node is BreakStatement)
                EnterBreakStatement((BreakStatement)node);
            if (node is ContinueStatement)
                EnterContinueStatement((ContinueStatement)node);
            if (node is ExpressionStatement)
                EnterExpressionStatement((ExpressionStatement)node);
            if (node is ForeachStatement)
                EnterForeachStatement((ForeachStatement)node);
            if (node is ForStatement)
                EnterForStatement((ForStatement)node);
            if (node is IfStatement)
                EnterIfStatement((IfStatement)node);
            if (node is ReturnStatement)
                EnterReturnStatement((ReturnStatement)node);
            if (node is SwitchStatement)
                EnterSwitchStatement((SwitchStatement)node);
            if (node is SwitchGroup)
                EnterSwitchGroup((SwitchGroup)node);
            if (node is SwitchLabel)
                EnterSwitchLabel((SwitchLabel)node);
            if (node is VariableDeclarationStatement)
                EnterVariableDeclarationStatement((VariableDeclarationStatement)node);
            if (node is WhileStatement)
                EnterWhileStatement((WhileStatement)node);
            if (node is Expression)
                EnterExpression((Expression)node);
            if (node is NativeMethodInvocationExpression)
                EnterNativeMethodInvocationExpression((NativeMethodInvocationExpression)node);
            if (node is ILiteral)
                EnterILiteral((ILiteral)node);
            if (node is ConstructorDeclaration)
                EnterConstructorDeclaration((ConstructorDeclaration)node);
            if (node is EnumDeclaration)
                EnterEnumDeclaration((EnumDeclaration)node);
            if (node is EnumValue)
                EnterEnumValue((EnumValue)node);
            if (node is GenericTypeDeclaration)
                EnterGenericTypeDeclaration((GenericTypeDeclaration)node);
            if (node is GetterDeclaration)
                EnterGetterDeclaration((GetterDeclaration)node);
            if (node is GetterSetterDeclaration)
                EnterGetterSetterDeclaration((GetterSetterDeclaration)node);
            if (node is MethodDeclaration)
                EnterMethodDeclaration((MethodDeclaration)node);
            if (node is Root)
                EnterRoot((Root)node);
            if (node is RuleDeclaration)
                EnterRuleDeclaration((RuleDeclaration)node);
            if (node is SetterDeclaration)
                EnterSetterDeclaration((SetterDeclaration)node);
            if (node is ClassDeclaration)
                EnterClassDeclaration((ClassDeclaration)node);
            if (node is AbstractTopLevelNode)
                EnterAbstractTopLevelNode((AbstractTopLevelNode)node);
            if (node is VariableDeclaration)
                EnterVariableDeclaration((VariableDeclaration)node);
            if (node is BoolType)
                EnterBoolType((BoolType)node);
            if (node is NumberType)
                EnterNumberType((NumberType)node);
            if (node is StringType)
                EnterStringType((StringType)node);
            if (node is VoidType)
                EnterVoidType((VoidType)node);
            if (node is ArrayCreationExpression)
                EnterArrayCreationExpression((ArrayCreationExpression)node);
            if (node is ArrayIndexExpression)
                EnterArrayIndexExpression((ArrayIndexExpression)node);
            if (node is AssignmentExpression)
                EnterAssignmentExpression((AssignmentExpression)node);
            if (node is AssignmentOperator)
                EnterAssignmentOperator((AssignmentOperator)node);
            if (node is BinaryExpression)
                EnterBinaryExpression((BinaryExpression)node);
            if (node is CastExpression)
                EnterCastExpression((CastExpression)node);
            if (node is MemberExpression)
                EnterMemberExpression((MemberExpression)node);
            if (node is LambdaExpression)
                EnterLambdaExpression((LambdaExpression)node);
            if (node is MethodInvocationExpression)
                EnterMethodInvocationExpression((MethodInvocationExpression)node);
            if (node is NativeTrigger)
                EnterNativeTrigger((NativeTrigger)node);
            if (node is ObjectCreationExpression)
                EnterObjectCreationExpression((ObjectCreationExpression)node);
            if (node is PosfixOperationExpression)
                EnterPosfixOperationExpression((PosfixOperationExpression)node);
            if (node is SimpleNameExpression)
                EnterSimpleNameExpression((SimpleNameExpression)node);
            if (node is ThisExpression)
                EnterThisExpression((ThisExpression)node);
            if (node is UnaryExpression)
                EnterUnaryExpression((UnaryExpression)node);
            if (node is BooleanLiteral)
                EnterBooleanLiteral((BooleanLiteral)node);
            if (node is NullLiteral)
                EnterNullLiteral((NullLiteral)node);
            if (node is NumberLiteral)
                EnterNumberLiteral((NumberLiteral)node);
            if (node is StringLiteral)
                EnterStringLiteral((StringLiteral)node);
            if (node is ModuleDeclaration)
                EnterModuleDeclaration((ModuleDeclaration)node);
            if (node is SourceFile)
                EnterSourceFile((SourceFile)node);
            if (skipChildren)
                skipChildren = false;
            else
                foreach (var child in node.Children.ToList())
                    Visit(child);
            if (node is INode)
                ExitINode((INode)node);
            if (node is Node)
                ExitNode((Node)node);
            if (node is ITypeNode)
                ExitITypeNode((ITypeNode)node);
            if (node is IStatement)
                ExitIStatement((IStatement)node);
            if (node is IExpression)
                ExitIExpression((IExpression)node);
            if (node is IHasVariables)
                ExitIHasVariables((IHasVariables)node);
            if (node is INamedDeclaration)
                ExitINamedDeclaration((INamedDeclaration)node);
            if (node is Token)
                ExitToken((Token)node);
            if (node is ArrayType)
                ExitArrayType((ArrayType)node);
            if (node is FunctionType)
                ExitFunctionType((FunctionType)node);
            if (node is ReferenceType)
                ExitReferenceType((ReferenceType)node);
            if (node is TypeList)
                ExitTypeList((TypeList)node);
            if (node is TypeNodeWrapper)
                ExitTypeNodeWrapper((TypeNodeWrapper)node);
            if (node is Assertion)
                ExitAssertion((Assertion)node);
            if (node is GotoStatement)
                ExitGotoStatement((GotoStatement)node);
            if (node is GotoTargetStatement)
                ExitGotoTargetStatement((GotoTargetStatement)node);
            if (node is BlockStatement)
                ExitBlockStatement((BlockStatement)node);
            if (node is BreakStatement)
                ExitBreakStatement((BreakStatement)node);
            if (node is ContinueStatement)
                ExitContinueStatement((ContinueStatement)node);
            if (node is ExpressionStatement)
                ExitExpressionStatement((ExpressionStatement)node);
            if (node is ForeachStatement)
                ExitForeachStatement((ForeachStatement)node);
            if (node is ForStatement)
                ExitForStatement((ForStatement)node);
            if (node is IfStatement)
                ExitIfStatement((IfStatement)node);
            if (node is ReturnStatement)
                ExitReturnStatement((ReturnStatement)node);
            if (node is SwitchStatement)
                ExitSwitchStatement((SwitchStatement)node);
            if (node is SwitchGroup)
                ExitSwitchGroup((SwitchGroup)node);
            if (node is SwitchLabel)
                ExitSwitchLabel((SwitchLabel)node);
            if (node is VariableDeclarationStatement)
                ExitVariableDeclarationStatement((VariableDeclarationStatement)node);
            if (node is WhileStatement)
                ExitWhileStatement((WhileStatement)node);
            if (node is Expression)
                ExitExpression((Expression)node);
            if (node is NativeMethodInvocationExpression)
                ExitNativeMethodInvocationExpression((NativeMethodInvocationExpression)node);
            if (node is ILiteral)
                ExitILiteral((ILiteral)node);
            if (node is ConstructorDeclaration)
                ExitConstructorDeclaration((ConstructorDeclaration)node);
            if (node is EnumDeclaration)
                ExitEnumDeclaration((EnumDeclaration)node);
            if (node is EnumValue)
                ExitEnumValue((EnumValue)node);
            if (node is GenericTypeDeclaration)
                ExitGenericTypeDeclaration((GenericTypeDeclaration)node);
            if (node is GetterDeclaration)
                ExitGetterDeclaration((GetterDeclaration)node);
            if (node is GetterSetterDeclaration)
                ExitGetterSetterDeclaration((GetterSetterDeclaration)node);
            if (node is MethodDeclaration)
                ExitMethodDeclaration((MethodDeclaration)node);
            if (node is Root)
                ExitRoot((Root)node);
            if (node is RuleDeclaration)
                ExitRuleDeclaration((RuleDeclaration)node);
            if (node is SetterDeclaration)
                ExitSetterDeclaration((SetterDeclaration)node);
            if (node is ClassDeclaration)
                ExitClassDeclaration((ClassDeclaration)node);
            if (node is AbstractTopLevelNode)
                ExitAbstractTopLevelNode((AbstractTopLevelNode)node);
            if (node is VariableDeclaration)
                ExitVariableDeclaration((VariableDeclaration)node);
            if (node is BoolType)
                ExitBoolType((BoolType)node);
            if (node is NumberType)
                ExitNumberType((NumberType)node);
            if (node is StringType)
                ExitStringType((StringType)node);
            if (node is VoidType)
                ExitVoidType((VoidType)node);
            if (node is ArrayCreationExpression)
                ExitArrayCreationExpression((ArrayCreationExpression)node);
            if (node is ArrayIndexExpression)
                ExitArrayIndexExpression((ArrayIndexExpression)node);
            if (node is AssignmentExpression)
                ExitAssignmentExpression((AssignmentExpression)node);
            if (node is AssignmentOperator)
                ExitAssignmentOperator((AssignmentOperator)node);
            if (node is BinaryExpression)
                ExitBinaryExpression((BinaryExpression)node);
            if (node is CastExpression)
                ExitCastExpression((CastExpression)node);
            if (node is MemberExpression)
                ExitMemberExpression((MemberExpression)node);
            if (node is LambdaExpression)
                ExitLambdaExpression((LambdaExpression)node);
            if (node is MethodInvocationExpression)
                ExitMethodInvocationExpression((MethodInvocationExpression)node);
            if (node is NativeTrigger)
                ExitNativeTrigger((NativeTrigger)node);
            if (node is ObjectCreationExpression)
                ExitObjectCreationExpression((ObjectCreationExpression)node);
            if (node is PosfixOperationExpression)
                ExitPosfixOperationExpression((PosfixOperationExpression)node);
            if (node is SimpleNameExpression)
                ExitSimpleNameExpression((SimpleNameExpression)node);
            if (node is ThisExpression)
                ExitThisExpression((ThisExpression)node);
            if (node is UnaryExpression)
                ExitUnaryExpression((UnaryExpression)node);
            if (node is BooleanLiteral)
                ExitBooleanLiteral((BooleanLiteral)node);
            if (node is NullLiteral)
                ExitNullLiteral((NullLiteral)node);
            if (node is NumberLiteral)
                ExitNumberLiteral((NumberLiteral)node);
            if (node is StringLiteral)
                ExitStringLiteral((StringLiteral)node);
            if (node is ModuleDeclaration)
                ExitModuleDeclaration((ModuleDeclaration)node);
            if (node is SourceFile)
                ExitSourceFile((SourceFile)node);
        }

        public virtual void EnterINode(INode iNode) { }
        public virtual void ExitINode(INode iNode) { }
        public virtual void EnterNode(Node node) { }
        public virtual void ExitNode(Node node) { }
        public virtual void EnterITypeNode(ITypeNode iTypeNode) { }
        public virtual void ExitITypeNode(ITypeNode iTypeNode) { }
        public virtual void EnterIStatement(IStatement iStatement) { }
        public virtual void ExitIStatement(IStatement iStatement) { }
        public virtual void EnterIExpression(IExpression iExpression) { }
        public virtual void ExitIExpression(IExpression iExpression) { }
        public virtual void EnterIHasVariables(IHasVariables iHasVariables) { }
        public virtual void ExitIHasVariables(IHasVariables iHasVariables) { }
        public virtual void EnterINamedDeclaration(INamedDeclaration iNamedDeclaration) { }
        public virtual void ExitINamedDeclaration(INamedDeclaration iNamedDeclaration) { }
        public virtual void EnterToken(Token token) { }
        public virtual void ExitToken(Token token) { }
        public virtual void EnterArrayType(ArrayType arrayType) { }
        public virtual void ExitArrayType(ArrayType arrayType) { }
        public virtual void EnterFunctionType(FunctionType functionType) { }
        public virtual void ExitFunctionType(FunctionType functionType) { }
        public virtual void EnterReferenceType(ReferenceType referenceType) { }
        public virtual void ExitReferenceType(ReferenceType referenceType) { }
        public virtual void EnterTypeList(TypeList typeList) { }
        public virtual void ExitTypeList(TypeList typeList) { }
        public virtual void EnterTypeNodeWrapper(TypeNodeWrapper typeNodeWrapper) { }
        public virtual void ExitTypeNodeWrapper(TypeNodeWrapper typeNodeWrapper) { }
        public virtual void EnterAssertion(Assertion assertion) { }
        public virtual void ExitAssertion(Assertion assertion) { }
        public virtual void EnterGotoStatement(GotoStatement gotoStatement) { }
        public virtual void ExitGotoStatement(GotoStatement gotoStatement) { }
        public virtual void EnterGotoTargetStatement(GotoTargetStatement gotoTargetStatement) { }
        public virtual void ExitGotoTargetStatement(GotoTargetStatement gotoTargetStatement) { }
        public virtual void EnterBlockStatement(BlockStatement blockStatement) { }
        public virtual void ExitBlockStatement(BlockStatement blockStatement) { }
        public virtual void EnterBreakStatement(BreakStatement breakStatement) { }
        public virtual void ExitBreakStatement(BreakStatement breakStatement) { }
        public virtual void EnterContinueStatement(ContinueStatement continueStatement) { }
        public virtual void ExitContinueStatement(ContinueStatement continueStatement) { }
        public virtual void EnterExpressionStatement(ExpressionStatement expressionStatement) { }
        public virtual void ExitExpressionStatement(ExpressionStatement expressionStatement) { }
        public virtual void EnterForeachStatement(ForeachStatement foreachStatement) { }
        public virtual void ExitForeachStatement(ForeachStatement foreachStatement) { }
        public virtual void EnterForStatement(ForStatement forStatement) { }
        public virtual void ExitForStatement(ForStatement forStatement) { }
        public virtual void EnterIfStatement(IfStatement ifStatement) { }
        public virtual void ExitIfStatement(IfStatement ifStatement) { }
        public virtual void EnterReturnStatement(ReturnStatement returnStatement) { }
        public virtual void ExitReturnStatement(ReturnStatement returnStatement) { }
        public virtual void EnterSwitchStatement(SwitchStatement switchStatement) { }
        public virtual void ExitSwitchStatement(SwitchStatement switchStatement) { }
        public virtual void EnterSwitchGroup(SwitchGroup switchGroup) { }
        public virtual void ExitSwitchGroup(SwitchGroup switchGroup) { }
        public virtual void EnterSwitchLabel(SwitchLabel switchLabel) { }
        public virtual void ExitSwitchLabel(SwitchLabel switchLabel) { }
        public virtual void EnterVariableDeclarationStatement(VariableDeclarationStatement variableDeclarationStatement) { }
        public virtual void ExitVariableDeclarationStatement(VariableDeclarationStatement variableDeclarationStatement) { }
        public virtual void EnterWhileStatement(WhileStatement whileStatement) { }
        public virtual void ExitWhileStatement(WhileStatement whileStatement) { }
        public virtual void EnterExpression(Expression expression) { }
        public virtual void ExitExpression(Expression expression) { }
        public virtual void EnterNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression) { }
        public virtual void ExitNativeMethodInvocationExpression(NativeMethodInvocationExpression nativeMethodInvocationExpression) { }
        public virtual void EnterILiteral(ILiteral iLiteral) { }
        public virtual void ExitILiteral(ILiteral iLiteral) { }
        public virtual void EnterConstructorDeclaration(ConstructorDeclaration constructorDeclaration) { }
        public virtual void ExitConstructorDeclaration(ConstructorDeclaration constructorDeclaration) { }
        public virtual void EnterEnumDeclaration(EnumDeclaration enumDeclaration) { }
        public virtual void ExitEnumDeclaration(EnumDeclaration enumDeclaration) { }
        public virtual void EnterEnumValue(EnumValue enumValue) { }
        public virtual void ExitEnumValue(EnumValue enumValue) { }
        public virtual void EnterGenericTypeDeclaration(GenericTypeDeclaration genericTypeDeclaration) { }
        public virtual void ExitGenericTypeDeclaration(GenericTypeDeclaration genericTypeDeclaration) { }
        public virtual void EnterGetterDeclaration(GetterDeclaration getterDeclaration) { }
        public virtual void ExitGetterDeclaration(GetterDeclaration getterDeclaration) { }
        public virtual void EnterGetterSetterDeclaration(GetterSetterDeclaration getterSetterDeclaration) { }
        public virtual void ExitGetterSetterDeclaration(GetterSetterDeclaration getterSetterDeclaration) { }
        public virtual void EnterMethodDeclaration(MethodDeclaration methodDeclaration) { }
        public virtual void ExitMethodDeclaration(MethodDeclaration methodDeclaration) { }
        public virtual void EnterRoot(Root root) { }
        public virtual void ExitRoot(Root root) { }
        public virtual void EnterRuleDeclaration(RuleDeclaration ruleDeclaration) { }
        public virtual void ExitRuleDeclaration(RuleDeclaration ruleDeclaration) { }
        public virtual void EnterSetterDeclaration(SetterDeclaration setterDeclaration) { }
        public virtual void ExitSetterDeclaration(SetterDeclaration setterDeclaration) { }
        public virtual void EnterClassDeclaration(ClassDeclaration classDeclaration) { }
        public virtual void ExitClassDeclaration(ClassDeclaration classDeclaration) { }
        public virtual void EnterAbstractTopLevelNode(AbstractTopLevelNode abstractTopLevelNode) { }
        public virtual void ExitAbstractTopLevelNode(AbstractTopLevelNode abstractTopLevelNode) { }
        public virtual void EnterVariableDeclaration(VariableDeclaration variableDeclaration) { }
        public virtual void ExitVariableDeclaration(VariableDeclaration variableDeclaration) { }
        public virtual void EnterBoolType(BoolType boolType) { }
        public virtual void ExitBoolType(BoolType boolType) { }
        public virtual void EnterNumberType(NumberType numberType) { }
        public virtual void ExitNumberType(NumberType numberType) { }
        public virtual void EnterStringType(StringType stringType) { }
        public virtual void ExitStringType(StringType stringType) { }
        public virtual void EnterVoidType(VoidType voidType) { }
        public virtual void ExitVoidType(VoidType voidType) { }
        public virtual void EnterArrayCreationExpression(ArrayCreationExpression arrayCreationExpression) { }
        public virtual void ExitArrayCreationExpression(ArrayCreationExpression arrayCreationExpression) { }
        public virtual void EnterArrayIndexExpression(ArrayIndexExpression arrayIndexExpression) { }
        public virtual void ExitArrayIndexExpression(ArrayIndexExpression arrayIndexExpression) { }
        public virtual void EnterAssignmentExpression(AssignmentExpression assignmentExpression) { }
        public virtual void ExitAssignmentExpression(AssignmentExpression assignmentExpression) { }
        public virtual void EnterAssignmentOperator(AssignmentOperator assignmentOperator) { }
        public virtual void ExitAssignmentOperator(AssignmentOperator assignmentOperator) { }
        public virtual void EnterBinaryExpression(BinaryExpression binaryExpression) { }
        public virtual void ExitBinaryExpression(BinaryExpression binaryExpression) { }
        public virtual void EnterCastExpression(CastExpression castExpression) { }
        public virtual void ExitCastExpression(CastExpression castExpression) { }
        public virtual void EnterMemberExpression(MemberExpression memberExpression) { }
        public virtual void ExitMemberExpression(MemberExpression memberExpression) { }
        public virtual void EnterLambdaExpression(LambdaExpression lambdaExpression) { }
        public virtual void ExitLambdaExpression(LambdaExpression lambdaExpression) { }
        public virtual void EnterMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression) { }
        public virtual void ExitMethodInvocationExpression(MethodInvocationExpression methodInvocationExpression) { }
        public virtual void EnterNativeTrigger(NativeTrigger nativeTrigger) { }
        public virtual void ExitNativeTrigger(NativeTrigger nativeTrigger) { }
        public virtual void EnterObjectCreationExpression(ObjectCreationExpression objectCreationExpression) { }
        public virtual void ExitObjectCreationExpression(ObjectCreationExpression objectCreationExpression) { }
        public virtual void EnterPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression) { }
        public virtual void ExitPosfixOperationExpression(PosfixOperationExpression posfixOperationExpression) { }
        public virtual void EnterSimpleNameExpression(SimpleNameExpression simpleNameExpression) { }
        public virtual void ExitSimpleNameExpression(SimpleNameExpression simpleNameExpression) { }
        public virtual void EnterThisExpression(ThisExpression thisExpression) { }
        public virtual void ExitThisExpression(ThisExpression thisExpression) { }
        public virtual void EnterUnaryExpression(UnaryExpression unaryExpression) { }
        public virtual void ExitUnaryExpression(UnaryExpression unaryExpression) { }
        public virtual void EnterBooleanLiteral(BooleanLiteral booleanLiteral) { }
        public virtual void ExitBooleanLiteral(BooleanLiteral booleanLiteral) { }
        public virtual void EnterNullLiteral(NullLiteral nullLiteral) { }
        public virtual void ExitNullLiteral(NullLiteral nullLiteral) { }
        public virtual void EnterNumberLiteral(NumberLiteral numberLiteral) { }
        public virtual void ExitNumberLiteral(NumberLiteral numberLiteral) { }
        public virtual void EnterStringLiteral(StringLiteral stringLiteral) { }
        public virtual void ExitStringLiteral(StringLiteral stringLiteral) { }
        public virtual void EnterModuleDeclaration(ModuleDeclaration moduleDeclaration) { }
        public virtual void ExitModuleDeclaration(ModuleDeclaration moduleDeclaration) { }
        public virtual void EnterSourceFile(SourceFile sourceFile) { }
        public virtual void ExitSourceFile(SourceFile sourceFile) { }
    }
}
