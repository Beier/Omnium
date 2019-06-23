using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.types
{
    public class StringType : Token, ITypeNode
    {
        public StringType(IParseTree context) : base(context)
        {
        }

        public override string ToString()
        {
            return "string";
        }
    }
}