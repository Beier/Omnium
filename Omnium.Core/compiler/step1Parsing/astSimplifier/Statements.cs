using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast;
using Omnium.Core.ast.declarations;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.statements;
using Omnium.Core.ast.types;
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step1Parsing.astSimplifier
{
    public partial class AstSimplifier
    {
        public override IEnumerable<INode> VisitNativeMethodInvocationStatement(TypescriptParser.NativeMethodInvocationStatementContext context)
        {
            yield return new MethodInvocationExpression(
                context,
                new MemberExpression(
                    context.memberAccess(),
                    context.memberAccess().identifier().GetText(),
                    new SimpleNameExpression(context, context.identifier().GetText()).Yield()
                ).Yield()
                    .Concat<INode>(Visit(context.memberAccess().typeArgumentList()).Cast<ITypeNode>())
                    .Concat(Visit(context.methodInvocation()).Cast<IExpression>())
            );
        }

        public override IEnumerable<INode> VisitBlock(TypescriptParser.BlockContext context)
        {
            yield return new BlockStatement(
                context,
                Visit(context.statementList()).Cast<IStatement>());
        }

        public override IEnumerable<INode> VisitDeclarationStatement(TypescriptParser.DeclarationStatementContext context)
        {
            return Visit(context.variableDeclaration())
                .Cast<VariableDeclaration>()
                .Select(variableDeclaration => new VariableDeclarationStatement(context, variableDeclaration));
        }

        public override IEnumerable<INode> VisitExpressionStatement(TypescriptParser.ExpressionStatementContext context)
        {
            yield return new ExpressionStatement(
                context,
                (IExpression)Visit(context.expression()).SingleOrDefault());
        }

        public override IEnumerable<INode> VisitIfStatement(TypescriptParser.IfStatementContext context)
        {
            yield return new IfStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchStatement(TypescriptParser.SwitchStatementContext context)
        {
            yield return new SwitchStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchSection(TypescriptParser.SwitchSectionContext context)
        {
            yield return new SwitchGroup(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitSwitchLabel(TypescriptParser.SwitchLabelContext context)
        {
            yield return new SwitchLabel(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitWhileStatement(TypescriptParser.WhileStatementContext context)
        {
            yield return new WhileStatement(
                context,
                VisitChildren(context));
        }

        public override IEnumerable<INode> VisitForStatement(TypescriptParser.ForStatementContext context)
        {
            var inits = Visit(context.forInitializer()).ToList();
            var condition = (IExpression)Visit(context.expression()).SingleOrDefault();
            var nextExpressions = Visit(context.forIterator()).Cast<IExpression>();
            var body = (IStatement)Visit(context.embeddedStatement()).SingleOrDefault();

            yield return new ForStatement(
                context,
                inits.OfType<VariableDeclaration>(),
                inits.OfType<IExpression>(),
                condition,
                nextExpressions,
                body);
        }

        public override IEnumerable<INode> VisitForeachStatement(TypescriptParser.ForeachStatementContext context)
        {
            var variableDeclaration = new VariableDeclaration(context, context.identifier().GetText(), new INode[0])
            {
                VariableType = GetVariableType(context.variableType())
            };
            var arrayExpression = Visit(context.expression()).Single();
            var body = Visit(context.embeddedStatement()).Single();


            yield return new ForeachStatement(context, new []{variableDeclaration, arrayExpression, body});
        }

        public override IEnumerable<INode> VisitBreakStatement(TypescriptParser.BreakStatementContext context)
        {
            yield return new BreakStatement(context);
        }

        public override IEnumerable<INode> VisitContinueStatement(TypescriptParser.ContinueStatementContext context)
        {
            yield return new ContinueStatement(context);
        }

        public override IEnumerable<INode> VisitReturnStatement(TypescriptParser.ReturnStatementContext context)
        {
            yield return new ReturnStatement(context, VisitChildren(context));
        }
    }
}