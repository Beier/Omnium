using OverwatchCompiler.ToWorkshop.ast;
using OverwatchCompiler.ToWorkshop.ast.statements;

namespace OverwatchCompiler.ToWorkshop.compiler
{
    public class IfDeleter : TreeVoidWalker
    {
        public override void ExitIfStatement(IfStatement ifStatement)
        {
            var block = (BlockStatement) ifStatement.Parent;
            var trueBranchGotoTarget = new GotoTargetStatement(ifStatement.Context);
            var endGotoTarget = new GotoTargetStatement(ifStatement.Context);
            var trueBranch = ifStatement.TrueBranch;
            var falseBranch = ifStatement.FalseBranch ?? new BlockStatement(ifStatement.Context, new IStatement[0]);

            block.AddChildBefore(ifStatement, new GotoStatement(ifStatement.Context, ifStatement.Condition, trueBranchGotoTarget));
            block.AddChildBefore(ifStatement, falseBranch);
            block.AddChildBefore(ifStatement, new GotoStatement(ifStatement.Context, endGotoTarget));
            block.AddChildBefore(ifStatement, trueBranchGotoTarget);
            block.AddChildBefore(ifStatement, trueBranch);
            block.AddChildBefore(ifStatement, endGotoTarget);
            ifStatement.Remove();

            BlockFlattener.FlattenAllSubBlocks(block);
        }
    }
}