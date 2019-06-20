using System.Collections.Generic;
using System.Linq;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class PartialNativeMethodType : IType
    {
        public readonly int MatchingParts;
        public readonly List<NativeMethodDeclaration> MatchingDeclarations = new List<NativeMethodDeclaration>();

        public PartialNativeMethodType(IEnumerable<NativeMethodDeclaration> matchingDeclarations, int matchingParts)
        {
            MatchingDeclarations.AddRange(matchingDeclarations);
            MatchingParts = matchingParts;
        }

        public override string ToString()
        {
            return MatchingDeclarations.First().TypescriptNames.Take(MatchingParts).MkString(".");
        }
    }
}