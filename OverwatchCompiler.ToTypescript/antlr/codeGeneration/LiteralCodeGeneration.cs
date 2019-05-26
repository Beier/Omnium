using System.Linq;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {
        public override StringBuilder VisitTeam(OverwatchCodeParser.TeamContext context)
        {
            if (context.ALL() != null || context.ALL_TEAMS() != null)
                return new StringBuilder("Teams.all");

            var builder = new StringBuilder();
            builder.Append("Team.team");
            builder.Append(context.INTEGER().GetText());
            return builder;
        }

        public override StringBuilder VisitPlayerConstant(OverwatchCodeParser.PlayerConstantContext context)
        {
            if (context.ALL() != null)
                return new StringBuilder("Players.all");
            if (context.SLOT() != null)
            {
                var builder = new StringBuilder();
                builder.Append("Player.inSlot(");
                builder.Append(context.INTEGER().GetText());
                builder.Append(")");
                return builder;
            }
            else
            {
                var builder = new StringBuilder();
                builder.Append("Players.playingHero(");
                builder.Append(VisitHeroType(context.heroType()));
                builder.Append(")");
                return builder;
            }
        }

        private StringBuilder createEnumMember(string enumName, ParserRuleContext context)
        {
            var enumValue = context.children.Single(x => x != null);
            var enumTypeName = enumValue.GetType().Name;
            enumTypeName = enumTypeName.Substring(0, enumTypeName.Length - "Context".Length);
            var builder = new StringBuilder();
            builder.Append(enumName);
            builder.Append(".");
            builder.Append(enumTypeName);
            return builder;
        }

        public override StringBuilder VisitHeroType(OverwatchCodeParser.HeroTypeContext context)
        {
            return createEnumMember("Hero", context);
        }

        public override StringBuilder VisitStatus(OverwatchCodeParser.StatusContext context)
        {
            return createEnumMember("StatusEffect", context);
        }

        public override StringBuilder VisitButton(OverwatchCodeParser.ButtonContext context)
        {
            return createEnumMember("Button", context);
        }

        public override StringBuilder VisitCommunicationType(OverwatchCodeParser.CommunicationTypeContext context)
        {
            return createEnumMember("CommunicationType", context);
        }

        public override StringBuilder VisitBarrierBlockType(OverwatchCodeParser.BarrierBlockTypeContext context)
        {
            return createEnumMember("BarrierBlockType", context);
        }

        public override StringBuilder VisitVectorTransformationType(OverwatchCodeParser.VectorTransformationTypeContext context)
        {
            return createEnumMember("VectorTransformationType", context);
        }

        public override StringBuilder VisitLineOfSightCheckType(OverwatchCodeParser.LineOfSightCheckTypeContext context)
        {
            return createEnumMember("LineOfSightCheck", context);
        }

        public override StringBuilder VisitRoundingDirection(OverwatchCodeParser.RoundingDirectionContext context)
        {
            return createEnumMember("RoundingDirection", context);
        }

        public override StringBuilder VisitLiteral(OverwatchCodeParser.LiteralContext context)
        {
            if (context.STRING() != null)
                return new StringBuilder(context.GetText());
            return new StringBuilder(context.GetText().ToLower());
        }

        public override StringBuilder VisitGlobalVariable(OverwatchCodeParser.GlobalVariableContext context)
        {
            return new StringBuilder(context.GetText().ToLower());
        }

        public override StringBuilder VisitPlayerVariable(OverwatchCodeParser.PlayerVariableContext context)
        {
            return new StringBuilder(context.GetText().ToLower());
        }
    }
}