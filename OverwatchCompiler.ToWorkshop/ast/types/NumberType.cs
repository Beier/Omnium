using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class NumberType : Token, ITypeNode
    {
        public NumberType(IParseTree context) : base(context)
        {
        }

        public override string ToString()
        {
            return "number";
        }
    }
}