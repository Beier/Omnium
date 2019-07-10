using System.Collections.Generic;
using System.Linq;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class StaticReference : IType
    {
        public List<INode> Declarations { get; set; }

        public StaticReference(INode declaration) : this(new List<INode> { declaration})
        {
        }

        public StaticReference(List<INode> declarations)
        {
            Declarations = declarations;
        }

        public override string ToString()
        {
            return "static " + Declarations.First().AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}