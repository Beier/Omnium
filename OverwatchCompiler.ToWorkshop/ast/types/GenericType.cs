using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
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