using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {
        public override StringBuilder VisitActionBlock(OverwatchCodeParser.ActionBlockContext context)
        {
            var builder = new StringBuilder();
            builder.Append("\t() => {");
            foreach (var action in context.action().Select(VisitAction))
            {
                builder.AppendLine();
                builder.Append("\t\t");
                builder.Append(action);
                builder.Append(";");
            }
            builder.AppendLine();
            builder.Append("\t}");
            return builder;
        }

        public override StringBuilder VisitAction(OverwatchCodeParser.ActionContext context)
        {
            return context.children.Select(Visit).Single(x => x != null);
        }

        public override StringBuilder VisitSetGlobalVariableAction(OverwatchCodeParser.SetGlobalVariableActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitGlobalVariable(context.globalVariable()));
            builder.Append(" = ");
            builder.Append(VisitExpression(context.expression()));
            return builder;
        }
    }
}