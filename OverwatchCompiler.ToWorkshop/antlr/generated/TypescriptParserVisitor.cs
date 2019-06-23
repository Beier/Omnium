//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.7.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from TypescriptParser.g4 by ANTLR 4.7.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="TypescriptParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.7.2")]
[System.CLSCompliant(false)]
public interface ITypescriptParserVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.sourceFiles"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSourceFiles([NotNull] TypescriptParser.SourceFilesContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.sourceFile"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSourceFile([NotNull] TypescriptParser.SourceFileContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.importDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitImportDeclaration([NotNull] TypescriptParser.ImportDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.moduleOrTypeName"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitModuleOrTypeName([NotNull] TypescriptParser.ModuleOrTypeNameContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typeList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeList([NotNull] TypescriptParser.TypeListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.type"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitType([NotNull] TypescriptParser.TypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.baseType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBaseType([NotNull] TypescriptParser.BaseTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.primitiveType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPrimitiveType([NotNull] TypescriptParser.PrimitiveTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassType([NotNull] TypescriptParser.ClassTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typeArgumentList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeArgumentList([NotNull] TypescriptParser.TypeArgumentListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.functionType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionType([NotNull] TypescriptParser.FunctionTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.argumentList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArgumentList([NotNull] TypescriptParser.ArgumentListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.argument"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArgument([NotNull] TypescriptParser.ArgumentContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.expression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExpression([NotNull] TypescriptParser.ExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.nonAssignmentExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNonAssignmentExpression([NotNull] TypescriptParser.NonAssignmentExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.assignment"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignment([NotNull] TypescriptParser.AssignmentContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.assignmentOperator"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignmentOperator([NotNull] TypescriptParser.AssignmentOperatorContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.conditionalOrExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConditionalOrExpression([NotNull] TypescriptParser.ConditionalOrExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.conditionalAndExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConditionalAndExpression([NotNull] TypescriptParser.ConditionalAndExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.equalityExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEqualityExpression([NotNull] TypescriptParser.EqualityExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.castExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCastExpression([NotNull] TypescriptParser.CastExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.relationalExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRelationalExpression([NotNull] TypescriptParser.RelationalExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.additiveExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAdditiveExpression([NotNull] TypescriptParser.AdditiveExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.multiplicativeExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMultiplicativeExpression([NotNull] TypescriptParser.MultiplicativeExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.unaryExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitUnaryExpression([NotNull] TypescriptParser.UnaryExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.primaryExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPrimaryExpression([NotNull] TypescriptParser.PrimaryExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.nativeMethodInvocationStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitNativeMethodInvocationStatement([NotNull] TypescriptParser.NativeMethodInvocationStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>literalExpression</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLiteralExpression([NotNull] TypescriptParser.LiteralExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>simpleNameExpression</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSimpleNameExpression([NotNull] TypescriptParser.SimpleNameExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>parenthesisExpressions</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParenthesisExpressions([NotNull] TypescriptParser.ParenthesisExpressionsContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>thisReferenceExpression</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitThisReferenceExpression([NotNull] TypescriptParser.ThisReferenceExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>objectCreation</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitObjectCreation([NotNull] TypescriptParser.ObjectCreationContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>arrayCreationExpression</c>
	/// labeled alternative in <see cref="TypescriptParser.primaryExpressionStart"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArrayCreationExpression([NotNull] TypescriptParser.ArrayCreationExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.expressionList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExpressionList([NotNull] TypescriptParser.ExpressionListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.memberAccess"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMemberAccess([NotNull] TypescriptParser.MemberAccessContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.bracketExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBracketExpression([NotNull] TypescriptParser.BracketExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.lambdaExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLambdaExpression([NotNull] TypescriptParser.LambdaExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.anonymousFunctionSignature"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAnonymousFunctionSignature([NotNull] TypescriptParser.AnonymousFunctionSignatureContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.explicitAnonymousFunctionParameterList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExplicitAnonymousFunctionParameterList([NotNull] TypescriptParser.ExplicitAnonymousFunctionParameterListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.explicitAnonymousFunctionParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExplicitAnonymousFunctionParameter([NotNull] TypescriptParser.ExplicitAnonymousFunctionParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.implicitAnonymousFunctionParameterList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitImplicitAnonymousFunctionParameterList([NotNull] TypescriptParser.ImplicitAnonymousFunctionParameterListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.anonymousFunctionBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAnonymousFunctionBody([NotNull] TypescriptParser.AnonymousFunctionBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>declarationStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDeclarationStatement([NotNull] TypescriptParser.DeclarationStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>embedded</c>
	/// labeled alternative in <see cref="TypescriptParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEmbedded([NotNull] TypescriptParser.EmbeddedContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.embeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEmbeddedStatement([NotNull] TypescriptParser.EmbeddedStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>emptyStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEmptyStatement([NotNull] TypescriptParser.EmptyStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>expressionStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExpressionStatement([NotNull] TypescriptParser.ExpressionStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>ifStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIfStatement([NotNull] TypescriptParser.IfStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>switchStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSwitchStatement([NotNull] TypescriptParser.SwitchStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>whileStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitWhileStatement([NotNull] TypescriptParser.WhileStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>forStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForStatement([NotNull] TypescriptParser.ForStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>foreachStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForeachStatement([NotNull] TypescriptParser.ForeachStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>breakStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBreakStatement([NotNull] TypescriptParser.BreakStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>continueStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitContinueStatement([NotNull] TypescriptParser.ContinueStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>returnStatement</c>
	/// labeled alternative in <see cref="TypescriptParser.simpleEmbeddedStatement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturnStatement([NotNull] TypescriptParser.ReturnStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBlock([NotNull] TypescriptParser.BlockContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.variableDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVariableDeclaration([NotNull] TypescriptParser.VariableDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.variableType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVariableType([NotNull] TypescriptParser.VariableTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.variableDeclarator"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVariableDeclarator([NotNull] TypescriptParser.VariableDeclaratorContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.switchSection"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSwitchSection([NotNull] TypescriptParser.SwitchSectionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.switchLabel"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSwitchLabel([NotNull] TypescriptParser.SwitchLabelContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.statementList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStatementList([NotNull] TypescriptParser.StatementListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.forInitializer"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForInitializer([NotNull] TypescriptParser.ForInitializerContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.forIterator"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForIterator([NotNull] TypescriptParser.ForIteratorContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.moduleDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitModuleDeclaration([NotNull] TypescriptParser.ModuleDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.moduleBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitModuleBody([NotNull] TypescriptParser.ModuleBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.moduleMemberDeclarations"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitModuleMemberDeclarations([NotNull] TypescriptParser.ModuleMemberDeclarationsContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.moduleMemberDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitModuleMemberDeclaration([NotNull] TypescriptParser.ModuleMemberDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.functionDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctionDeclaration([NotNull] TypescriptParser.FunctionDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typeDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeDeclaration([NotNull] TypescriptParser.TypeDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typeParameterList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeParameterList([NotNull] TypescriptParser.TypeParameterListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typeParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeParameter([NotNull] TypescriptParser.TypeParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassBody([NotNull] TypescriptParser.ClassBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classMemberDeclarations"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassMemberDeclarations([NotNull] TypescriptParser.ClassMemberDeclarationsContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classMemberDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassMemberDeclaration([NotNull] TypescriptParser.ClassMemberDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.allMemberModifiers"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAllMemberModifiers([NotNull] TypescriptParser.AllMemberModifiersContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.allMemberModifier"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAllMemberModifier([NotNull] TypescriptParser.AllMemberModifierContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.commonMemberDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCommonMemberDeclaration([NotNull] TypescriptParser.CommonMemberDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.typedMemberDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypedMemberDeclaration([NotNull] TypescriptParser.TypedMemberDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classField"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassField([NotNull] TypescriptParser.ClassFieldContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.returnTypeList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturnTypeList([NotNull] TypescriptParser.ReturnTypeListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.returnType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturnType([NotNull] TypescriptParser.ReturnTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.methodBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMethodBody([NotNull] TypescriptParser.MethodBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.formalParameterList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFormalParameterList([NotNull] TypescriptParser.FormalParameterListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.fixedParameters"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFixedParameters([NotNull] TypescriptParser.FixedParametersContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.fixedParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFixedParameter([NotNull] TypescriptParser.FixedParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.constructorInitializer"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConstructorInitializer([NotNull] TypescriptParser.ConstructorInitializerContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.body"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBody([NotNull] TypescriptParser.BodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.variantTypeParameterList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVariantTypeParameterList([NotNull] TypescriptParser.VariantTypeParameterListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.variantTypeParameter"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitVariantTypeParameter([NotNull] TypescriptParser.VariantTypeParameterContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.enumBody"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEnumBody([NotNull] TypescriptParser.EnumBodyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.enumMemberDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEnumMemberDeclaration([NotNull] TypescriptParser.EnumMemberDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.rightArrow"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRightArrow([NotNull] TypescriptParser.RightArrowContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.rightShift"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRightShift([NotNull] TypescriptParser.RightShiftContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.rightShiftAssignment"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRightShiftAssignment([NotNull] TypescriptParser.RightShiftAssignmentContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.literal"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLiteral([NotNull] TypescriptParser.LiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.booleanLiteral"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBooleanLiteral([NotNull] TypescriptParser.BooleanLiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.stringLiteral"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStringLiteral([NotNull] TypescriptParser.StringLiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.classDefinition"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitClassDefinition([NotNull] TypescriptParser.ClassDefinitionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.enumDefinition"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEnumDefinition([NotNull] TypescriptParser.EnumDefinitionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.constructorDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConstructorDeclaration([NotNull] TypescriptParser.ConstructorDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.methodDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMethodDeclaration([NotNull] TypescriptParser.MethodDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.getterDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitGetterDeclaration([NotNull] TypescriptParser.GetterDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.setterDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSetterDeclaration([NotNull] TypescriptParser.SetterDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.argDeclaration"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArgDeclaration([NotNull] TypescriptParser.ArgDeclarationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.methodInvocation"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMethodInvocation([NotNull] TypescriptParser.MethodInvocationContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.objectCreationExpression"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitObjectCreationExpression([NotNull] TypescriptParser.ObjectCreationExpressionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="TypescriptParser.identifier"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIdentifier([NotNull] TypescriptParser.IdentifierContext context);
}
