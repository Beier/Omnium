
using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {
        private StringBuilder BuildEventWithTeamAndPlayerParameters(string eventName, OverwatchCodeParser.TeamContext team, OverwatchCodeParser.PlayerConstantContext player)
        {
            var builder = new StringBuilder();
            builder.Append(eventName);
            builder.Append("(");
            builder.Append(VisitTeam(team));
            builder.Append(", ");
            builder.Append(VisitPlayerConstant(player));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitEventType(OverwatchCodeParser.EventTypeContext context)
        {
            return context.children.Select(Visit).Single();
        }

        public override StringBuilder VisitOngoingGlobalEventType(OverwatchCodeParser.OngoingGlobalEventTypeContext context)
        {
            return new StringBuilder("Events.Ongoing.global");
        }

        public override StringBuilder VisitOngoingEachPlayerEventType(OverwatchCodeParser.OngoingEachPlayerEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Ongoing.eachPlayer", context.team(), context.playerConstant());
        }

        public override StringBuilder VisitPlayerEarnedEliminationEventType(OverwatchCodeParser.PlayerEarnedEliminationEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Player.earnedElimination", context.team(), context.playerConstant());
        }

        public override StringBuilder VisitPlayerDealtFinalBlowEventType(OverwatchCodeParser.PlayerDealtFinalBlowEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Player.dealtFinalBlow", context.team(), context.playerConstant());
        }

        public override StringBuilder VisitPlayerDealtDamageEventType(OverwatchCodeParser.PlayerDealtDamageEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Player.dealtDamage", context.team(), context.playerConstant());
        }

        public override StringBuilder VisitPlayerTookDamageEventType(OverwatchCodeParser.PlayerTookDamageEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Player.tookDamage", context.team(), context.playerConstant());
        }

        public override StringBuilder VisitPlayerDiedEventType(OverwatchCodeParser.PlayerDiedEventTypeContext context)
        {
            return BuildEventWithTeamAndPlayerParameters("Events.Player.died", context.team(), context.playerConstant());
        }
    }
}