using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class GenericType : Node, ITypeNode
    {
        public ReferenceType Base => (ReferenceType)Children.First();
        public IEnumerable<ITypeNode> GenericTypes => Children.Skip(1).Cast<ITypeNode>();
        public GenericType(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return $"{Base}<{GenericTypes.MkString(", ")}>";
        }
    }
}