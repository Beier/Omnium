using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class TypeList : Node, ITypeNode
    {
        public readonly ChildList<ITypeNode> SubTypes;

        public TypeList(IParseTree context, IEnumerable<ITypeNode> subTypes) : base(context)
        {
            SubTypes = new ChildList<ITypeNode>(this);
            SubTypes.AddRange(subTypes);
        }

        public override string ToString()
        {
            return SubTypes.MkString(" | ");
        }
    }
}