using System;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
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