using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class NumberLiteral : Token, ILiteral
    {
        private string overridenText;
        public override string Text => overridenText ?? base.Text;
        public IType Type { get; set; }

        public NumberLiteral(IParseTree context, string text) : base(context)
        {
            overridenText = text;
        }

        public NumberLiteral(IParseTree context) : base(context)
        {
        }
    }
}