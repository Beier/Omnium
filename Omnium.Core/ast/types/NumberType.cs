using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.types
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