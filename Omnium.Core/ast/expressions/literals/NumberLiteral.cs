using Antlr4.Runtime.Tree;
using Omnium.Core.ast.types;

namespace Omnium.Core.ast.expressions.literals
{
    public class NumberLiteral : Token, ILiteral
    {
        public IType Type { get; set; }
        public double Value => double.Parse(Text.Replace('.', ','));

        public NumberLiteral(IParseTree context, string text) : base(context, text)
        {
        }

        public NumberLiteral(IParseTree context) : base(context)
        {
        }

        public NumberLiteral(IParseTree context, double value) : this(context, value.ToString())
        {
        }
    }
}