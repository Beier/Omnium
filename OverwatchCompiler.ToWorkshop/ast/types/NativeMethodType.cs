using System.Collections.Generic;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class NativeMethodType : IType
    {
        public readonly NativeMethodDeclaration MatchingDeclaration;

        public NativeMethodType(NativeMethodDeclaration matchingDeclaration)
        {
            MatchingDeclaration = matchingDeclaration;
        }

        public override string ToString()
        {
            return MatchingDeclaration.TypescriptNames.MkString(".");
        }
    }
}