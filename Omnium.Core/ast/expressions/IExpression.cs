using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public interface IExpression : INode
    {
        IType Type { get; set; }
    }

    public abstract class Expression : Node, IExpression
    {
        public IType Type { get; set; }

        protected Expression(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        protected Expression(IParseTree context) : base(context)
        {
        }
    }
}