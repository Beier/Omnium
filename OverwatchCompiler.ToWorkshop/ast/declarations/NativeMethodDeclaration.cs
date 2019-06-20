using System.Collections.Generic;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.declarations
{
    public class NativeMethodDeclaration : Node
    {
        public readonly string NativeName;
        public readonly List<string> TypescriptNames = new List<string>();
        public readonly List<IType> ParameterTypes = new List<IType>();
        public readonly IType ReturnType;

        public NativeMethodDeclaration(IParseTree context, string nativeName, IEnumerable<string> names, IEnumerable<IType> parameterTypes, IType returnType) : base(context)
        {
            NativeName = nativeName;
            TypescriptNames.AddRange(names);
            ParameterTypes.AddRange(parameterTypes);
            ReturnType = returnType;
        }
    }
}