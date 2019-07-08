using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.types
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