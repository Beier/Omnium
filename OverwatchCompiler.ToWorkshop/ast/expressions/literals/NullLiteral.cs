using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions.literals
{
    public class NullLiteral : Token, ILiteral
    {
        public IType Type { get; set; }

        public NullLiteral(IParseTree context) : base(context)
        {
        }
    }
}