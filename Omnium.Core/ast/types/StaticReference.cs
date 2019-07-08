using System.Linq;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class StaticReference : IType
    {
        public INode Declaration { get; set; }

        public StaticReference(INode declaration)
        {
            Declaration = declaration;
        }

        public override string ToString()
        {
            return "static " + Declaration.AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}