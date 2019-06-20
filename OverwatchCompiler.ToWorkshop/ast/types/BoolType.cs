using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class BoolType : Token, ITypeNode
    {
        public BoolType(IParseTree context) : base(context)
        {
        }

        public override string ToString()
        {
            return "boolean";
        }
    }
}