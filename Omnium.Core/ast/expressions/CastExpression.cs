using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public class CastExpression : Expression
    {
        public IExpression Base => Children.OfType<IExpression>().SingleOrDefault();
        public ITypeNode TargetType => Children.OfType<ITypeNode>().SingleOrDefault();

        public CastExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}