using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class FunctionType : Node, ITypeNode
    {
        public readonly ChildList<VariableDeclaration> Parameters;
        public readonly ChildProperty<ITypeNode> ReturnType;

        public FunctionType(IParseTree context, IEnumerable<VariableDeclaration> parameters, ITypeNode returnType) : base(context)
        {
            Parameters = new ChildList<VariableDeclaration>(this);
            Parameters.AddRange(parameters);
            ReturnType = new ChildProperty<ITypeNode>(this, returnType);
        }

        public override string ToString()
        {
            return "(" + Parameters.Select(x => x.Type.Value).MkString(", ") + ") => " + ReturnType.Value;
        }
    }
}