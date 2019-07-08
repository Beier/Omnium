using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions
{
    public class ThisExpression : Token, IExpression
    {
        public IType Type { get; set; }

        public ThisExpression(IParseTree context) : base(context)
        {
        }
    }
}