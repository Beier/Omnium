using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class BooleanLiteral : Token, ILiteral
    {
        public IType Type { get; set; }

        public BooleanLiteral(IParseTree context) : base(context)
        {
        }
    }
}