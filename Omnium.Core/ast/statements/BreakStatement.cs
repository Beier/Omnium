using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.statements
{
    public class BreakStatement : Node, IStatement
    {
        public BreakStatement(IParseTree context) : base(context)
        {
        }
    }
}