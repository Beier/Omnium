using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions.literals
{
    public class NullLiteral : Token, ILiteral
    {
        public IType Type { get; set; }

        public NullLiteral(IParseTree context) : base(context, "null")
        {
        }
    }
}