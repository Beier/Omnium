using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration : OverwatchCodeBaseVisitor<StringBuilder>
    {

        private readonly List<string> usedGlobalVariables;
        public CodeGeneration(List<string> usedGlobalVariables)
        {
            this.usedGlobalVariables = usedGlobalVariables;
        }

        public override StringBuilder VisitRoot(OverwatchCodeParser.RootContext context)
        {
            var builder = new StringBuilder();
            if (usedGlobalVariables.Any())
            {
                builder.Append("var ");
                for (int i = 0; i < usedGlobalVariables.Count; i++)
                {
                    if (i != 0)
                        builder.Append(", ");
                    builder.Append(usedGlobalVariables[i].ToLower());
                }

                builder.AppendLine(";");
                builder.AppendLine();
            }

            foreach (var rule in context.rule().Select(VisitRule))
            {
                builder.Append(rule);
                builder.AppendLine();
                builder.AppendLine();
            }

            return builder;
        }

        public override StringBuilder VisitRule(OverwatchCodeParser.RuleContext context)
        {
            var builder = new StringBuilder();
            builder.Append("rule(");
            builder.Append(context.STRING().Symbol.Text);
            builder.AppendLine(",");

            builder.Append("\t");
            builder.Append(VisitEventType(context.eventBlock().eventType()));

            if (context.conditionBlock() != null)
            {
                builder.AppendLine(",");
                builder.Append(VisitConditionBlock(context.conditionBlock()));
            }
            if (context.actionBlock() != null)
            {
                builder.AppendLine(",");
                builder.Append(VisitActionBlock(context.actionBlock()));
            }

            builder.AppendLine();
            builder.Append(");");

            return builder;
        }

        public override StringBuilder VisitConditionBlock(OverwatchCodeParser.ConditionBlockContext context)
        {
            var builder = new StringBuilder();
            builder.Append("\t() => ");
            for (int i = 0; i < context.condition().Length; i++)
            {
                if (i != 0)
                {
                    builder.AppendLine(" &&");
                    builder.Append("\t\t");
                }
                builder.Append(VisitCondition(context.condition(i)));

            }
            if (builder.Length == 1)
                builder.Append("true");

            return builder;
        }

        public override StringBuilder VisitCondition(OverwatchCodeParser.ConditionContext context)
        {
            return BinaryExpression(context.binaryCompartorOperator().GetText(), context.expression());
        }
    }
}