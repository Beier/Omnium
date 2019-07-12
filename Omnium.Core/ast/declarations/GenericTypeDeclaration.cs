using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.declarations
{
    public class GenericTypeDeclaration : Node
    {
        public string Name { get; set; }
        public ITypeNode BaseType => Children.OfType<ITypeNode>().SingleOrDefault();

        public GenericTypeDeclaration(IParseTree context, string name, IEnumerable<INode> children) : base(context, children)
        {
            Name = name;
        }
    }
}