using Antlr4.Runtime.Tree;

namespace Omnium.Core.ast.statements
{
    public class GotoTargetStatement : Node, IStatement
    {
        private static int instances = 0;
        private readonly int instanceNumber = ++instances;

        public GotoTargetStatement(IParseTree context) : base(context)
        {
        }

        public override string ToString()
        {
            return ":" + instanceNumber;
        }
    }
}