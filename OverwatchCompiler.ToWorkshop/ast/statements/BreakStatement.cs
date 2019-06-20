using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class BreakStatement : Node, IStatement
    {
        public BreakStatement(IParseTree context) : base(context)
        {
        }
    }
}