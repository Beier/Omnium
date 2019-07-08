using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.expressions
{
    public class NativeTrigger : Expression
    {
        public readonly string Name;
        public IEnumerable<IExpression> Arguments => Children.Cast<IExpression>();

        public NativeTrigger(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }

        public override string ToString()
        {
            if (!Arguments.Any())
                return Name;
            return Name + "(" + Arguments.MkString(", ") + ")";
        }
    }
}