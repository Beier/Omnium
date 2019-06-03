using System;
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

            if (context.Team1() != null)
                return new StringBuilder("Team.team1");
            if (context.Team2() != null)
                return new StringBuilder("Team.team2");
            throw new Exception("Unexpected team");
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

        public override StringBuilder VisitMotionType(OverwatchCodeParser.MotionTypeContext context)
        {
            return createEnumMember("MotionType", context);
        }

        public override StringBuilder VisitRelativeTo(OverwatchCodeParser.RelativeToContext context)
        {
            return createEnumMember("Relative", context);
        }

        public override StringBuilder VisitRateReevaluation(OverwatchCodeParser.RateReevaluationContext context)
        {
            return createEnumMember("ChaseRateReevaluation", context);
        }

        public override StringBuilder VisitTimeReevaluation(OverwatchCodeParser.TimeReevaluationContext context)
        {
            return createEnumMember("ChaseTimeReevaluation", context);
        }

        public override StringBuilder VisitCreateEffectReevaluation(OverwatchCodeParser.CreateEffectReevaluationContext context)
        {
            return createEnumMember("CreateEffectReevaluation", context);
        }

        public override StringBuilder VisitHudTextLocation(OverwatchCodeParser.HudTextLocationContext context)
        {
            return createEnumMember("HudTextLocation", context);
        }

        public override StringBuilder VisitHudTextReevaluation(OverwatchCodeParser.HudTextReevaluationContext context)
        {
            return createEnumMember("HudTextReevaluation", context);
        }

        public override StringBuilder VisitIcon(OverwatchCodeParser.IconContext context)
        {
            return createEnumMember("Icon", context);
        }

        public override StringBuilder VisitIconReevaluation(OverwatchCodeParser.IconReevaluationContext context)
        {
            return createEnumMember("IconReevaluation", context);
        }

        public override StringBuilder VisitInWorldTextClipping(OverwatchCodeParser.InWorldTextClippingContext context)
        {
            return createEnumMember("TextClipping", context);
        }

        public override StringBuilder VisitInWorldTextReevaluation(OverwatchCodeParser.InWorldTextReevaluationContext context)
        {
            return createEnumMember("InWorldTextReevaluation", context);
        }

        public override StringBuilder VisitEffectShape(OverwatchCodeParser.EffectShapeContext context)
        {
            return createEnumMember("Shape", context);
        }

        public override StringBuilder VisitColor(OverwatchCodeParser.ColorContext context)
        {
            return createEnumMember("Color", context);
        }

        public override StringBuilder VisitAnimatedEffect(OverwatchCodeParser.AnimatedEffectContext context)
        {
            return createEnumMember("AnimatedEffect", context);
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