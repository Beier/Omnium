using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public class ObjectCreationExpression : Expression
    {
        public ITypeNode CreatedType => Children.OfType<ITypeNode>().SingleOrDefault();
        public IEnumerable<IExpression> Arguments => Children.OfType<IExpression>();

        public ObjectCreationExpression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }
    }
}