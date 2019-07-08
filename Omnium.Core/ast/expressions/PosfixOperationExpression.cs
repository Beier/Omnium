using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.expressions
{
    public class PosfixOperationExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();
        public Token Operation => Children.OfType<Token>().Last();

        public PosfixOperationExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}