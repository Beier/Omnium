using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class VoidType : Token, ITypeNode
    {
        public VoidType(IParseTree context) : base(context)
        {
        }

        public override string ToString()
        {
            return "void";
        }
    }
}