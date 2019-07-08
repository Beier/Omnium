using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.types
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