using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.declarations;
using OverwatchCompiler.ToWorkshop.extensions;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class FunctionType : Node, ITypeNode
    {
        public IEnumerable<VariableDeclaration> Parameters => Children.OfType<VariableDeclaration>();
        public ITypeNode ReturnType => Children.OfType<ITypeNode>().SingleOrDefault();

        public FunctionType(IParseTree context, IEnumerable<INode> children) : base(context, children)
        {
        }

        public override string ToString()
        {
            return "(" + Parameters.Select(x => x.Type).MkString(", ") + ") => " + ReturnType;
        }
    }
}