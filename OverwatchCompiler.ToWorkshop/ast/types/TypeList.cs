using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class TypeList : Node, ITypeNode
    {
        public IEnumerable<ITypeNode> SubTypes => Children.OfType<ITypeNode>();

        public TypeList(IParseTree context, IEnumerable<ITypeNode> subTypes) : base(context, subTypes)
        {
        }

        public override string ToString()
        {
            return SubTypes.MkString(" | ");
        }
    }
}