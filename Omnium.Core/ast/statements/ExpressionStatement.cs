using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.expressions;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.statements
{
    public class ExpressionStatement : Node, IStatement
    {
        public IExpression Expression => Children.OfType<IExpression>().SingleOrDefault();

        public ExpressionStatement(IParseTree context, IExpression expression) : base(context, expression.Yield())
        {
        }

        public override string ToString()
        {
            return Expression + ";";
        }
    }
}