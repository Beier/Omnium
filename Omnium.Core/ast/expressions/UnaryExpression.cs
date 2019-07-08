using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.expressions
{
    public class UnaryExpression : Expression
    {
        public Token Operator => Children.OfType<Token>().First();
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();

        public UnaryExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return "!" + Base;
        }
    }
}