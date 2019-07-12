using Omnium.Core.ast.expressions;

namespace Omnium.Core.compiler
{
    public class ReplacePlayerVars : TreeVoidWalker
    {
        public override void ExitPlayerVarsExpression(PlayerVarsExpression playerVarsExpression)
        {
            playerVarsExpression.ReplaceWith(playerVarsExpression.Player);
        }

        public override void ExitPlayerVarsPlayerExpression(PlayerVarsPlayerExpression playerVarsPlayerExpression)
        {
            playerVarsPlayerExpression.ReplaceWith(playerVarsPlayerExpression.thisExpression);
        }
    }
}