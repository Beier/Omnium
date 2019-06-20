using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class StringLiteral : Token, ILiteral
    {
        public IType Type { get; set; }

        public StringLiteral(IParseTree context) : base(context)
        {
        }
    }
}