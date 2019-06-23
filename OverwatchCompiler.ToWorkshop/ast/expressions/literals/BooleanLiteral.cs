using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class BooleanLiteral : Token, ILiteral
    {
        public IType Type { get; set; }
        public bool Value => Text == "true";

        public BooleanLiteral(IParseTree context) : base(context)
        {
        }

        public BooleanLiteral(IParseTree context, string overrideText) : base(context, overrideText)
        {
            Type = new BoolType(context);
        }

        public BooleanLiteral(IParseTree context, bool value) : this(context, value.ToString().ToLower())
        {
        }
    }
}