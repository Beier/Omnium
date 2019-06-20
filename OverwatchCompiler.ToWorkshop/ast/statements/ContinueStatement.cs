using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToWorkshop.ast.statements
{
    public class ContinueStatement : Node, IStatement
    {
        public ContinueStatement(IParseTree context) : base(context)
        {
        }
    }
}