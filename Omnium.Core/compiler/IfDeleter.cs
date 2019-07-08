using Omnium.Core.ast;
using Omnium.Core.ast.expressions;
using Omnium.Core.ast.statements;

namespace Omnium.Core.compiler
{
    public class IfDeleter : TreeVoidWalker
    {
        public override void ExitIfStatement(IfStatement ifStatement)
        {
            var block = (BlockStatement) ifStatement.Parent;
            var trueBranchGotoTarget = new GotoTargetStatement(ifStatement.Context);
            var endGotoTarget = new GotoTargetStatement(ifStatement.Context);
            var trueBranch = ifStatement.TrueBranch;
            var falseBranch = ifStatement.FalseBranch;

            if (falseBranch != null)
            {
                block.AddChildBefore(ifStatement,
                    new GotoStatement(ifStatement.Context, ifStatement.Condition, trueBranchGotoTarget));
                block.AddChildBefore(ifStatement, falseBranch);
                block.AddChildBefore(ifStatement, new GotoStatement(ifStatement.Context, endGotoTarget));
                block.AddChildBefore(ifStatement, trueBranchGotoTarget);
                block.AddChildBefore(ifStatement, trueBranch);
                block.AddChildBefore(ifStatement, endGotoTarget);
            }
            else
            {
                var condition = new UnaryExpression(ifStatement.Context, new INode[]
                {
                    new Token(ifStatement.Context, "!"),
                    ifStatement.Condition
                });
                block.AddChildBefore(ifStatement, new GotoStatement(ifStatement.Context, condition, endGotoTarget));
                block.AddChildBefore(ifStatement, trueBranch);
                block.AddChildBefore(ifStatement, endGotoTarget);
            }
            ifStatement.Remove();
            BlockFlattener.FlattenAllSubBlocks(block);
        }
    }
}