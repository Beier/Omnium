using System.Linq;
using Omnium.Core.ast.declarations;
using Omnium.Core.extensions;

namespace Omnium.Core.ast.types
{
    public class MethodReferenceType : IType
    {
        public MethodDeclaration Declaration { get; set; }

        public MethodReferenceType(MethodDeclaration declaration)
        {
            Declaration = declaration;
        }
        
        public override string ToString()
        {
            return Declaration.AllAncestorsAndSelf().OfType<INamedDeclaration>().Select(x => x.Name).MkString(".");
        }
    }
}