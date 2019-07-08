using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.statements
{
    public class ContinueStatement : Node, IStatement
    {
        public ContinueStatement(IParseTree context) : base(context)
        {
        }
    }
}