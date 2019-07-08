using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.types
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