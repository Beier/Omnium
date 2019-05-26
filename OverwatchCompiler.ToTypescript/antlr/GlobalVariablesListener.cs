using System.Collections.Generic;
using System.Linq;

namespace OverwatchCompiler.ToTypescript.antlr
{
    public class GlobalVariablesListener : OverwatchCodeBaseListener
    {
        public HashSet<string> GlobalVariables { get; } = new HashSet<string>();

        public override void ExitGlobalVariable(OverwatchCodeParser.GlobalVariableContext context)
        {
            base.ExitGlobalVariable(context);
            GlobalVariables.Add(context.LETTER().Symbol.Text);
        }
    }
}