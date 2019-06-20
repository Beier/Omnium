using Antlr4.Runtime.Tree;
using OverwatchCompiler.ToWorkshop.ast.types;

namespace OverwatchCompiler.ToWorkshop.ast.expressions
{
    public class ThisExpression : Token, IExpression
    {
        public IType Type { get; set; }

        public ThisExpression(IParseTree context) : base(context)
        {
        }
    }
}