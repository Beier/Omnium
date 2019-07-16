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
using Omnium.Core.extensions;

namespace Omnium.Core.compiler.step1Parsing.astSimplifier
{
    public partial class AstSimplifier
    {
        public override IEnumerable<INode> VisitAssignment(TypescriptParser.AssignmentContext context)
        {
            yield return new AssignmentExpression(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitAssignmentOperator(TypescriptParser.AssignmentOperatorContext context)
        {
            yield return new AssignmentOperator(context, context.GetText());
        }

        public override IEnumerable<INode> VisitConditionalOrExpression(TypescriptParser.ConditionalOrExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.conditionalAndExpression(), context.OP_OR());
        }

        public override IEnumerable<INode> VisitConditionalAndExpression(TypescriptParser.ConditionalAndExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.equalityExpression(), context.OP_AND());
        }

        public override IEnumerable<INode> VisitEqualityExpression(TypescriptParser.EqualityExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.castExpression(), context.OP_EQ().Concat(context.OP_NE()));
        }

        public override IEnumerable<INode> VisitCastExpression(TypescriptParser.CastExpressionContext context)
        {
            if (context.type() == null)
                return VisitChildren(context);
            return new CastExpression(context, VisitChildren(context)).Yield();
        }

        public override IEnumerable<INode> VisitRelationalExpression(TypescriptParser.RelationalExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.additiveExpression(), context.GT().Concat(context.LT()).Concat(context.OP_GE()).Concat(context.OP_LE()));
        }

        public override IEnumerable<INode> VisitAdditiveExpression(TypescriptParser.AdditiveExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.multiplicativeExpression(), context.PLUS().Concat(context.MINUS()));
        }

        public override IEnumerable<INode> VisitMultiplicativeExpression(TypescriptParser.MultiplicativeExpressionContext context)
        {
            yield return CreateBinaryExpression(context, context.unaryExpression(), context.DIV().Concat(context.PERCENT()).Concat(context.STAR()));
        }

        public override IEnumerable<INode> VisitUnaryExpression(TypescriptParser.UnaryExpressionContext context)
        {
            if (context.primaryExpression() != null)
                yield return (IExpression)Visit(context.primaryExpression()).SingleOrDefault();
            else
            {
                var token = CreateToken(context.PLUS() ?? context.MINUS() ?? context.BANG());
                var @base = (IExpression)Visit(context.unaryExpression()).SingleOrDefault();
                yield return new UnaryExpression(context, new INode[] { token, @base });
            }
        }

        public override IEnumerable<INode> VisitPrimaryExpression(TypescriptParser.PrimaryExpressionContext context)
        {
            var @base = (IExpression)Visit(context.primaryExpressionStart()).SingleOrDefault();
            var operations = context.bracketExpression()
                .Concat<IParseTree>(context.memberAccess())
                .Concat(context.methodInvocation())
                .Concat(context.OP_INC())
                .Concat(context.OP_DEC())
                .OrderBy(x => x.GetTokens().First().Line)
                .ThenBy(x => x.GetTokens().First().Column);

            foreach (var operation in operations)
            {
                if (operation is TypescriptParser.BracketExpressionContext bracketExpression)
                    @base = new ArrayIndexExpression(bracketExpression, @base.Yield().Concat(Visit(bracketExpression)));
                else if (operation is TypescriptParser.MemberAccessContext memberAccess)
                    @base = new MemberExpression(memberAccess, memberAccess.identifier().GetText(), @base.Yield());
                else if (operation is TypescriptParser.MethodInvocationContext methodInvocation)
                {
                    var genericTypeArguments = Visit((@base.Context as TypescriptParser.MemberAccessContext)?.typeArgumentList()).Cast<ITypeNode>();
                    var arguments = Visit(methodInvocation.argumentList()).Cast<IExpression>();

                    @base = new MethodInvocationExpression(
                        methodInvocation,
                        @base.Yield().Concat<INode>(genericTypeArguments).Concat(arguments));
                }
                else if (operation is ITerminalNode terminalNode)
                {
                    @base = new PosfixOperationExpression(terminalNode, new INode[] { @base, new Token(terminalNode) });
                }
                else
                    throw new Exception("Unexpected operation: " + operation);
            }

            yield return @base;
        }

        public override IEnumerable<INode> VisitLambdaExpression(TypescriptParser.LambdaExpressionContext context)
        {
            var children = VisitChildren(context).ToList();
            var variables = children.OfType<VariableDeclaration>();
            var expressionBody = children.OfType<IExpression>().SingleOrDefault();
            var blockBody = children.OfType<BlockStatement>().SingleOrDefault()
                            ?? new BlockStatement(context, new ReturnStatement(context, expressionBody.Yield()).Yield());
            yield return new LambdaExpression(context, variables.Concat<INode>(blockBody.Yield()));
        }

        public override IEnumerable<INode> VisitAnonymousFunctionSignature(TypescriptParser.AnonymousFunctionSignatureContext context)
        {
            if (context.identifier() != null)
                return new VariableDeclaration(context.identifier(), context.identifier().GetText(), new INode[0]).Yield();
            return base.VisitAnonymousFunctionSignature(context);
        }

        public override IEnumerable<INode> VisitExplicitAnonymousFunctionParameter(TypescriptParser.ExplicitAnonymousFunctionParameterContext context)
        {
            yield return new VariableDeclaration(context, context.identifier().GetText(), Visit(context.type()));
        }

        public override IEnumerable<INode> VisitImplicitAnonymousFunctionParameterList(TypescriptParser.ImplicitAnonymousFunctionParameterListContext context)
        {
            return context.identifier()
                .Select(identifier => new VariableDeclaration(identifier, identifier.GetText(), new INode[0]));
        }

        public override IEnumerable<INode> VisitSimpleNameExpression(TypescriptParser.SimpleNameExpressionContext context)
        {
            yield return new SimpleNameExpression(context, context.identifier().GetText());
        }

        public override IEnumerable<INode> VisitThisReferenceExpression(TypescriptParser.ThisReferenceExpressionContext context)
        {
            yield return new ThisExpression(context);
        }

        public override IEnumerable<INode> VisitObjectCreation(TypescriptParser.ObjectCreationContext context)
        {
            yield return new ObjectCreationExpression(context, VisitChildren(context));
        }

        public override IEnumerable<INode> VisitArrayCreationExpression(TypescriptParser.ArrayCreationExpressionContext context)
        {
            yield return new ArrayCreationExpression(
                context,
                Visit(context.expressionList()).Cast<IExpression>());
        }

        private IExpression CreateBinaryExpression(IParseTree context, IEnumerable<IParseTree> expressions, IEnumerable<IParseTree> tokens)
        {
            var subExpressions = expressions.SelectMany(Visit).Cast<IExpression>().ToArray();
            var operators = tokens.Select(CreateToken).OrderBy(x => x.Line).ThenBy(x => x.Column).ToArray();

            var previous = subExpressions[0];
            for (int i = 1; i < subExpressions.Length; i++)
            {
                previous = new BinaryExpression(
                    context,
                    new INode[]
                    {
                        previous,
                        operators[i - 1],
                        subExpressions[i]
                    });
            }

            return previous;
        }

        private Token CreateToken(IParseTree node)
        {
            return new Token(node);
        }



        public override IEnumerable<INode> VisitLiteral(TypescriptParser.LiteralContext context)
        {
            if (context.booleanLiteral() != null)
                yield return new BooleanLiteral(context);
            if (context.stringLiteral() != null)
                yield return new StringLiteral(context);
            if (context.INTEGER_LITERAL() != null)
                yield return new NumberLiteral(context);
            if (context.HEX_INTEGER_LITERAL() != null)
            {
                var hex = context.GetText();
                var number = Convert.ToInt32(hex, 16);
                yield return new NumberLiteral(context, number.ToString());
            }
            if (context.REAL_LITERAL() != null)
                yield return new NumberLiteral(context);
            if (context.NULL() != null)
                yield return new NullLiteral(context);
        }
    }
}