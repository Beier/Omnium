using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {
        private StringBuilder BasicExpression(string name, params OverwatchCodeParser.ExpressionContext[] subExpressions)
        {
            var builder = new StringBuilder();
            builder.Append(name);
            if (subExpressions.Length == 0)
                return builder;
            builder.Append("(");
            for (int i = 0; i < subExpressions.Length; i++)
            {
                if (i != 0)
                    builder.Append(", ");
                builder.Append(VisitExpression(subExpressions[i]));
            }
            builder.Append(")");
            return builder;
        }

        private StringBuilder MemberMethodCallExpression(string name, params OverwatchCodeParser.ExpressionContext[] subExpressions)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(subExpressions[0]));
            builder.Append(".");
            builder.Append(name);
            if (subExpressions.Length == 1)
                return builder;
            builder.Append("(");
            for (int i = 1; i < subExpressions.Length; i++)
            {
                if (i != 1)
                    builder.Append(", ");
                builder.Append(VisitExpression(subExpressions[i]));
            }
            builder.Append(")");
            return builder;
        }

        private StringBuilder BinaryExpression(string op, OverwatchCodeParser.ExpressionContext[] subExpressions)
        {
            var builder = new StringBuilder();
            builder.Append("(");
            builder.Append(VisitExpression(subExpressions[0]));
            builder.Append(" ");
            builder.Append(op);
            builder.Append(" ");
            builder.Append(VisitExpression(subExpressions[1]));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitExpression(OverwatchCodeParser.ExpressionContext context)
        {
            return context.children.Select(Visit).Single();
        }

        public override StringBuilder VisitVectorExpression(OverwatchCodeParser.VectorExpressionContext context)
        {
            return BasicExpression("Vector", context.expression());
        }

        public override StringBuilder VisitAddExpression(OverwatchCodeParser.AddExpressionContext context)
        {
            return BinaryExpression("+", context.expression());
        }

        public override StringBuilder VisitAbsoluteValueExpression(OverwatchCodeParser.AbsoluteValueExpressionContext context)
        {
            return BasicExpression("Math.abs", context.expression());
        }

        public override StringBuilder VisitAllDeadPlayersExpression(OverwatchCodeParser.AllDeadPlayersExpressionContext context)
        {
            return BasicExpression("Players.deadOnTeam", context.expression());
        }

        public override StringBuilder VisitAllHeroesExpression(OverwatchCodeParser.AllHeroesExpressionContext context)
        {
            return BasicExpression("Heroes.all");
        }

        public override StringBuilder VisitAllLivingPlayersExpression(OverwatchCodeParser.AllLivingPlayersExpressionContext context)
        {
            return BasicExpression("Players.aliveOnTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersExpression(OverwatchCodeParser.AllPlayersExpressionContext context)
        {
            return BasicExpression("Players.onTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersNotOnObjectiveExpression(OverwatchCodeParser.AllPlayersNotOnObjectiveExpressionContext context)
        {
            return BasicExpression("Players.notOnObjectiveFromTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersOnObjectiveExpression(OverwatchCodeParser.AllPlayersOnObjectiveExpressionContext context)
        {
            return BasicExpression("Players.onObjectiveFromTeam", context.expression());
        }

        public override StringBuilder VisitAllowedHeroesExpression(OverwatchCodeParser.AllowedHeroesExpressionContext context)
        {
            return BasicExpression("Heroes.allowedForPlayer", context.expression());
        }

        public override StringBuilder VisitAltitudeOfExpression(OverwatchCodeParser.AltitudeOfExpressionContext context)
        {
            return BasicExpression("altitudeOf", context.expression());
        }

        public override StringBuilder VisitEventPlayerExpression(OverwatchCodeParser.EventPlayerExpressionContext context)
        {
            return BasicExpression("Event.player");
        }

        public override StringBuilder VisitAndExpression(OverwatchCodeParser.AndExpressionContext context)
        {
            return BinaryExpression("&&", context.expression());
        }

        public override StringBuilder VisitAngleDifferenceExpression(OverwatchCodeParser.AngleDifferenceExpressionContext context)
        {
            return BasicExpression("angleDifference", context.expression());
        }

        public override StringBuilder VisitAppendToArrayExpression(OverwatchCodeParser.AppendToArrayExpressionContext context)
        {
            return MemberMethodCallExpression("push", context.expression());
        }

        public override StringBuilder VisitArrayContainsExpression(OverwatchCodeParser.ArrayContainsExpressionContext context)
        {
            return MemberMethodCallExpression("includes", context.expression());
        }

        public override StringBuilder VisitArraySliceExpression(OverwatchCodeParser.ArraySliceExpressionContext context)
        {
            return MemberMethodCallExpression("slice", context.expression());
        }

        public override StringBuilder VisitAttackerExpression(OverwatchCodeParser.AttackerExpressionContext context)
        {
            return BasicExpression("Player.attacker");
        }

        public override StringBuilder VisitBackwardExpression(OverwatchCodeParser.BackwardExpressionContext context)
        {
            return BasicExpression("Vector.backward");
        }

        public override StringBuilder VisitClosestPlayerToExpression(OverwatchCodeParser.ClosestPlayerToExpressionContext context)
        {
            return BasicExpression("Player.closestTo", context.expression());
        }

        public override StringBuilder VisitCompareExpression(OverwatchCodeParser.CompareExpressionContext context)
        {
            return BinaryExpression(context.binaryCompartorOperator().GetText(), context.expression());
        }

        public override StringBuilder VisitControlModeScoringPercentageExpression(OverwatchCodeParser.ControlModeScoringPercentageExpressionContext context)
        {
            return BasicExpression("controlModeScoringPercentage", context.expression());
        }

        public override StringBuilder VisitGlobalVariableExpression(OverwatchCodeParser.GlobalVariableExpressionContext context)
        {
            return VisitGlobalVariable(context.globalVariable());
        }

        public override StringBuilder VisitControlModeScoringTeamExpression(OverwatchCodeParser.ControlModeScoringTeamExpressionContext context)
        {
            return BasicExpression("Team.scoringControlMode");
        }

        public override StringBuilder VisitCosineFromRadiansExpression(OverwatchCodeParser.CosineFromRadiansExpressionContext context)
        {
            return BasicExpression("Math.cos", context.expression());
        }

        public override StringBuilder VisitCosineFromDegreesExpression(OverwatchCodeParser.CosineFromDegreesExpressionContext context)
        {
            return BasicExpression("Math.cosDeg", context.expression());
        }

        public override StringBuilder VisitCountOfExpression(OverwatchCodeParser.CountOfExpressionContext context)
        {
            return MemberMethodCallExpression("length", context.expression());
        }

        public override StringBuilder VisitCrossProductExpression(OverwatchCodeParser.CrossProductExpressionContext context)
        {
            return MemberMethodCallExpression("cross", context.expression());
        }

        public override StringBuilder VisitCurrentArrayElementExpression(OverwatchCodeParser.CurrentArrayElementExpressionContext context)
        {
            return BasicExpression("currentArrayElement");
        }

        public override StringBuilder VisitDirectionFromAnglesExpression(OverwatchCodeParser.DirectionFromAnglesExpressionContext context)
        {
            return BasicExpression("Vector.fromAngles", context.expression());
        }

        public override StringBuilder VisitDirectionTowardsExpression(OverwatchCodeParser.DirectionTowardsExpressionContext context)
        {
            return MemberMethodCallExpression("directionTowards", context.expression());
        }

        public override StringBuilder VisitDistanceBetweenExpression(OverwatchCodeParser.DistanceBetweenExpressionContext context)
        {
            return MemberMethodCallExpression("distanceTo", context.expression());
        }

        public override StringBuilder VisitDivideExpression(OverwatchCodeParser.DivideExpressionContext context)
        {
            return BinaryExpression("/", context.expression());
        }

        public override StringBuilder VisitDotProductExpression(OverwatchCodeParser.DotProductExpressionContext context)
        {
            return MemberMethodCallExpression("dot", context.expression());
        }

        public override StringBuilder VisitDownExpression(OverwatchCodeParser.DownExpressionContext context)
        {
            return BasicExpression("Vector.down");
        }

        public override StringBuilder VisitEmptyArrayExpression(OverwatchCodeParser.EmptyArrayExpressionContext context)
        {
            return new StringBuilder("[]");
        }

        public override StringBuilder VisitEntityExistsExpression(OverwatchCodeParser.EntityExistsExpressionContext context)
        {
            return BasicExpression("exists", context.expression());
        }

        public override StringBuilder VisitEventDamageExpression(OverwatchCodeParser.EventDamageExpressionContext context)
        {
            return BasicExpression("Event.damage");
        }

        public override StringBuilder VisitEventWasCriticalHitExpression(OverwatchCodeParser.EventWasCriticalHitExpressionContext context)
        {
            return BasicExpression("Event.wasCriticalHit");
        }

        public override StringBuilder VisitEyePositionExpression(OverwatchCodeParser.EyePositionExpressionContext context)
        {
            return MemberMethodCallExpression("eyePosition", context.expression());
        }

        public override StringBuilder VisitFacingDirectionOfExpression(OverwatchCodeParser.FacingDirectionOfExpressionContext context)
        {
            return MemberMethodCallExpression("facingDirection", context.expression());
        }

        public override StringBuilder VisitFarthestPlayerFromExpression(OverwatchCodeParser.FarthestPlayerFromExpressionContext context)
        {
            return BasicExpression("Player.farthestFrom", context.expression());
        }

        public override StringBuilder VisitFilteredArrayExpression(OverwatchCodeParser.FilteredArrayExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".filter(currentArrayElement => ");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitFirstOfExpression(OverwatchCodeParser.FirstOfExpressionContext context)
        {
            return MemberMethodCallExpression("head", context.expression());
        }

        public override StringBuilder VisitFlagPositionExpression(OverwatchCodeParser.FlagPositionExpressionContext context)
        {
            return BasicExpression("Game.Ctf.flagPositionFor", context.expression());
        }

        public override StringBuilder VisitForwardExpression(OverwatchCodeParser.ForwardExpressionContext context)
        {
            return BasicExpression("Vector.forward");
        }

        public override StringBuilder VisitHasSpawnedExpression(OverwatchCodeParser.HasSpawnedExpressionContext context)
        {
            return MemberMethodCallExpression("hasSpawned", context.expression());
        }

        public override StringBuilder VisitHasStatusExpression(OverwatchCodeParser.HasStatusExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression()));
            builder.Append(".hasStatus(");
            builder.Append(VisitStatus(context.status()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitHealthExpression(OverwatchCodeParser.HealthExpressionContext context)
        {
            return MemberMethodCallExpression("health", context.expression());
        }

        public override StringBuilder VisitHealthPercentExpression(OverwatchCodeParser.HealthPercentExpressionContext context)
        {
            return MemberMethodCallExpression("healthPercent", context.expression());
        }

        public override StringBuilder VisitHeroExpression(OverwatchCodeParser.HeroExpressionContext context)
        {
            return VisitHeroType(context.heroType());
        }

        public override StringBuilder VisitHeroIconStringExpression(OverwatchCodeParser.HeroIconStringExpressionContext context)
        {
            return MemberMethodCallExpression("iconString", context.expression());
        }

        public override StringBuilder VisitHeroOfExpression(OverwatchCodeParser.HeroOfExpressionContext context)
        {
            return MemberMethodCallExpression("hero", context.expression());
        }

        public override StringBuilder VisitHorizontalAngleFromDirectionExpression(OverwatchCodeParser.HorizontalAngleFromDirectionExpressionContext context)
        {
            return MemberMethodCallExpression("horizontalAngle", context.expression());
        }

        public override StringBuilder VisitHorizontalAngleTowardsExpression(OverwatchCodeParser.HorizontalAngleTowardsExpressionContext context)
        {
            return MemberMethodCallExpression("horizontalAngleTowards", context.expression());
        }

        public override StringBuilder VisitHorizontalFacingAngleOfExpression(OverwatchCodeParser.HorizontalFacingAngleOfExpressionContext context)
        {
            return MemberMethodCallExpression("horizontalFacingAngle", context.expression());
        }

        public override StringBuilder VisitHorizontalSpeedOfExpression(OverwatchCodeParser.HorizontalSpeedOfExpressionContext context)
        {
            return MemberMethodCallExpression("horizontalSpeed", context.expression());
        }

        public override StringBuilder VisitIndexOfArrayValueExpression(OverwatchCodeParser.IndexOfArrayValueExpressionContext context)
        {
            return MemberMethodCallExpression("indexOf", context.expression());
        }

        public override StringBuilder VisitIsAliveExpression(OverwatchCodeParser.IsAliveExpressionContext context)
        {
            return MemberMethodCallExpression("isAlive", context.expression());
        }

        public override StringBuilder VisitIsAssemblingHeroesExpression(OverwatchCodeParser.IsAssemblingHeroesExpressionContext context)
        {
            return BasicExpression("Game.isAssemblingHeroes");
        }

        public override StringBuilder VisitIsBetweenRoundsExpression(OverwatchCodeParser.IsBetweenRoundsExpressionContext context)
        {
            return BasicExpression("Game.isBetweenRounds");
        }

        public override StringBuilder VisitIsButtonHeldExpression(OverwatchCodeParser.IsButtonHeldExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression()));
            builder.Append(".isHoldingButton(");
            builder.Append(VisitButton(context.button()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitIsCommunicatingExpression(OverwatchCodeParser.IsCommunicatingExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression()));
            builder.Append(".isCommunicating(");
            builder.Append(VisitCommunicationType(context.communicationType()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitIsCommunicatingAnyExpression(OverwatchCodeParser.IsCommunicatingAnyExpressionContext context)
        {
            return MemberMethodCallExpression("isCommunicating", context.expression());
        }

        public override StringBuilder VisitIsCommunicatingAnyEmoteExpression(OverwatchCodeParser.IsCommunicatingAnyEmoteExpressionContext context)
        {
            return MemberMethodCallExpression("isCommunicatingWithEmote", context.expression());
        }

        public override StringBuilder VisitIsCommunicatingAnyVoicelineExpression(OverwatchCodeParser.IsCommunicatingAnyVoicelineExpressionContext context)
        {
            return MemberMethodCallExpression("isCommunicatingWithVoiceLine", context.expression());
        }

        public override StringBuilder VisitIsControlModePointLockedExpression(OverwatchCodeParser.IsControlModePointLockedExpressionContext context)
        {
            return BasicExpression("Game.ControlPoint.isPointLocked");
        }

        public override StringBuilder VisitIsCrouchingExpression(OverwatchCodeParser.IsCrouchingExpressionContext context)
        {
            return MemberMethodCallExpression("isCrouching", context.expression());
        }

        public override StringBuilder VisitIsCTFModeInSuddenDeathExpression(OverwatchCodeParser.IsCTFModeInSuddenDeathExpressionContext context)
        {
            return BasicExpression("Game.Ctf.isInSuddenDeath");
        }

        public override StringBuilder VisitIsDeadExpression(OverwatchCodeParser.IsDeadExpressionContext context)
        {
            return MemberMethodCallExpression("isDead", context.expression());
        }

        public override StringBuilder VisitIsFiringPrimaryExpression(OverwatchCodeParser.IsFiringPrimaryExpressionContext context)
        {
            return MemberMethodCallExpression("isFiringPrimary", context.expression());
        }

        public override StringBuilder VisitIsFiringSecondaryExpression(OverwatchCodeParser.IsFiringSecondaryExpressionContext context)
        {
            return MemberMethodCallExpression("isFiringSecondary", context.expression());
        }

        public override StringBuilder VisitIsFlagAtBaseExpression(OverwatchCodeParser.IsFlagAtBaseExpressionContext context)
        {
            return BasicExpression("Game.Ctf.isFlagAtBaseFor", context.expression());
        }

        public override StringBuilder VisitIsFlagBeingCarriedExpression(OverwatchCodeParser.IsFlagBeingCarriedExpressionContext context)
        {
            return BasicExpression("Game.Ctf.isFlagBeingCarriedFor", context.expression());
        }

        public override StringBuilder VisitIsGameInProgressExpression(OverwatchCodeParser.IsGameInProgressExpressionContext context)
        {
            return BasicExpression("Game.isInProgress");
        }

        public override StringBuilder VisitIsHeroBeingPlayedExpression(OverwatchCodeParser.IsHeroBeingPlayedExpressionContext context)
        {
            return BasicExpression("Game.isHeroBeingPlayed", context.expression());
        }

        public override StringBuilder VisitIsInAirExpression(OverwatchCodeParser.IsInAirExpressionContext context)
        {
            return MemberMethodCallExpression("isInAir", context.expression());
        }

        public override StringBuilder VisitIsInLineofSightExpression(OverwatchCodeParser.IsInLineofSightExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(".isInLineOfSightOf(");
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(", ");
            builder.Append(VisitBarrierBlockType(context.barrierBlockType()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitIsInSetupExpression(OverwatchCodeParser.IsInSetupExpressionContext context)
        {
            return BasicExpression("Game.isInSetup");
        }

        public override StringBuilder VisitIsInSpawnRoomExpression(OverwatchCodeParser.IsInSpawnRoomExpressionContext context)
        {
            return MemberMethodCallExpression("isInSpawnRoom", context.expression());
        }

        public override StringBuilder VisitIsInViewAngleExpression(OverwatchCodeParser.IsInViewAngleExpressionContext context)
        {
            return MemberMethodCallExpression("isLookingAt", context.expression());
        }

        public override StringBuilder VisitIsMatchCompleteExpression(OverwatchCodeParser.IsMatchCompleteExpressionContext context)
        {
            return BasicExpression("Game.isMatchComplete");
        }

        public override StringBuilder VisitIsMovingExpression(OverwatchCodeParser.IsMovingExpressionContext context)
        {
            return MemberMethodCallExpression("isMoving", context.expression());
        }

        public override StringBuilder VisitIsObjectiveCompleteExpression(OverwatchCodeParser.IsObjectiveCompleteExpressionContext context)
        {
            return BasicExpression("Game.isObjectiveComplete", context.expression());
        }

        public override StringBuilder VisitIsOnGroundExpression(OverwatchCodeParser.IsOnGroundExpressionContext context)
        {
            return MemberMethodCallExpression("isOnGround", context.expression());
        }

        public override StringBuilder VisitIsOnObjectiveExpression(OverwatchCodeParser.IsOnObjectiveExpressionContext context)
        {
            return MemberMethodCallExpression("isOnObjective", context.expression());
        }

        public override StringBuilder VisitIsOnWallExpression(OverwatchCodeParser.IsOnWallExpressionContext context)
        {
            return MemberMethodCallExpression("isOnWall", context.expression());
        }

        public override StringBuilder VisitIsPortraitOnFireExpression(OverwatchCodeParser.IsPortraitOnFireExpressionContext context)
        {
            return MemberMethodCallExpression("isPortraitOnFire", context.expression());
        }

        public override StringBuilder VisitIsStandingExpression(OverwatchCodeParser.IsStandingExpressionContext context)
        {
            return MemberMethodCallExpression("isStanding", context.expression());
        }

        public override StringBuilder VisitIsTeamOnDefenseExpression(OverwatchCodeParser.IsTeamOnDefenseExpressionContext context)
        {
            return BasicExpression("Game.isOnDefense", context.expression());
        }

        public override StringBuilder VisitIsTeamOnOffenseExpression(OverwatchCodeParser.IsTeamOnOffenseExpressionContext context)
        {
            return BasicExpression("Game.isOnOffense", context.expression());
        }

        public override StringBuilder VisitIsTrueForAllExpression(OverwatchCodeParser.IsTrueForAllExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".forall(currentArrayElement => ");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitIsTrueForAnyExpression(OverwatchCodeParser.IsTrueForAnyExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".exists(currentArrayElement => ");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitIsUsingAbility1Expression(OverwatchCodeParser.IsUsingAbility1ExpressionContext context)
        {
            return MemberMethodCallExpression("isUsingAbility1", context.expression());
        }

        public override StringBuilder VisitIsUsingAbility2Expression(OverwatchCodeParser.IsUsingAbility2ExpressionContext context)
        {
            return MemberMethodCallExpression("isUsingAbility2", context.expression());
        }

        public override StringBuilder VisitIsUsingUltimateExpression(OverwatchCodeParser.IsUsingUltimateExpressionContext context)
        {
            return MemberMethodCallExpression("isUsingUltimate", context.expression());
        }

        public override StringBuilder VisitIsWaitingForPlayersExpression(OverwatchCodeParser.IsWaitingForPlayersExpressionContext context)
        {
            return BasicExpression("Game.isWaitingForPlayers");
        }

        public override StringBuilder VisitLastCreatedEntityExpression(OverwatchCodeParser.LastCreatedEntityExpressionContext context)
        {
            return BasicExpression("Game.getLastCreatedEntity()");
        }

        public override StringBuilder VisitLastDamageModificationIDExpression(OverwatchCodeParser.LastDamageModificationIDExpressionContext context)
        {
            return BasicExpression("Game.getIdOfLastDamageModification()");
        }

        public override StringBuilder VisitLastDamageOverTimeIDExpression(OverwatchCodeParser.LastDamageOverTimeIDExpressionContext context)
        {
            return BasicExpression("Game.getIdOfLastDamageOverTime()");
        }

        public override StringBuilder VisitLastHealOverTimeIDExpression(OverwatchCodeParser.LastHealOverTimeIDExpressionContext context)
        {
            return BasicExpression("Game.getIdOfLastHealOverTime()");
        }

        public override StringBuilder VisitLastOfExpression(OverwatchCodeParser.LastOfExpressionContext context)
        {
            return MemberMethodCallExpression("last", context.expression());
        }

        public override StringBuilder VisitLastTextIDExpression(OverwatchCodeParser.LastTextIDExpressionContext context)
        {
            return BasicExpression("Game.getIdOfLastText()");
        }

        public override StringBuilder VisitLeftExpression(OverwatchCodeParser.LeftExpressionContext context)
        {
            return BasicExpression("Vector.left");
        }

        public override StringBuilder VisitLocalVectorOfExpression(OverwatchCodeParser.LocalVectorOfExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".toLocalCoordinatesFor(");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(", ");
            builder.Append(VisitVectorTransformationType(context.vectorTransformationType()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitMatchRoundExpression(OverwatchCodeParser.MatchRoundExpressionContext context)
        {
            return BasicExpression("Game.matchRound");
        }

        public override StringBuilder VisitMatchTimeExpression(OverwatchCodeParser.MatchTimeExpressionContext context)
        {
            return BasicExpression("Game.matchTime");
        }

        public override StringBuilder VisitMaxExpression(OverwatchCodeParser.MaxExpressionContext context)
        {
            return BasicExpression("Math.max", context.expression());
        }

        public override StringBuilder VisitMaxHealthExpression(OverwatchCodeParser.MaxHealthExpressionContext context)
        {
            return MemberMethodCallExpression("maxHealth", context.expression());
        }

        public override StringBuilder VisitMinExpression(OverwatchCodeParser.MinExpressionContext context)
        {
            return BasicExpression("Math.min", context.expression());
        }

        public override StringBuilder VisitModuloExpression(OverwatchCodeParser.ModuloExpressionContext context)
        {
            return BinaryExpression("%", context.expression());
        }

        public override StringBuilder VisitMultiplyExpression(OverwatchCodeParser.MultiplyExpressionContext context)
        {
            return BinaryExpression("*", context.expression());
        }

        public override StringBuilder VisitNearestWalkablePositionExpression(OverwatchCodeParser.NearestWalkablePositionExpressionContext context)
        {
            return BasicExpression("Vector.getNearestWalkablePosition", context.expression());
        }

        public override StringBuilder VisitNormalizeExpression(OverwatchCodeParser.NormalizeExpressionContext context)
        {
            return MemberMethodCallExpression("normalize()", context.expression());
        }

        public override StringBuilder VisitNotExpression(OverwatchCodeParser.NotExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("!");
            builder.Append(VisitExpression(context.expression()));
            return builder;
        }

        public override StringBuilder VisitNumberOfDeadPlayersExpression(OverwatchCodeParser.NumberOfDeadPlayersExpressionContext context)
        {
            return BasicExpression("Game.numberOfDeadPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfDeathsExpression(OverwatchCodeParser.NumberOfDeathsExpressionContext context)
        {
            return MemberMethodCallExpression("numberOfDeaths", context.expression());
        }

        public override StringBuilder VisitNumberOfEliminationsExpression(OverwatchCodeParser.NumberOfEliminationsExpressionContext context)
        {
            return MemberMethodCallExpression("numberOfEliminations", context.expression());
        }

        public override StringBuilder VisitNumberOfFinalBlowsExpression(OverwatchCodeParser.NumberOfFinalBlowsExpressionContext context)
        {
            return MemberMethodCallExpression("numberOfFinalBlows", context.expression());
        }

        public override StringBuilder VisitNumberOfHeroesExpression(OverwatchCodeParser.NumberOfHeroesExpressionContext context)
        {
            return BasicExpression("Game.numberOfHeroesOfTypeOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfLivingPlayersExpression(OverwatchCodeParser.NumberOfLivingPlayersExpressionContext context)
        {
            return BasicExpression("Game.numberOfLivingPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfPlayersExpression(OverwatchCodeParser.NumberOfPlayersExpressionContext context)
        {
            return BasicExpression("Game.numberOfPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfPlayersOnObjectiveExpression(OverwatchCodeParser.NumberOfPlayersOnObjectiveExpressionContext context)
        {
            return BasicExpression("Game.numberOfPlayersFromTeamOnObjective", context.expression());
        }

        public override StringBuilder VisitObjectiveIndexExpression(OverwatchCodeParser.ObjectiveIndexExpressionContext context)
        {
            return BasicExpression("Game.indexOfCurrentObjective");
        }

        public override StringBuilder VisitObjectivePositionExpression(OverwatchCodeParser.ObjectivePositionExpressionContext context)
        {
            return BasicExpression("Game.positionOfObjective", context.expression());
        }

        public override StringBuilder VisitOppositeTeamOfExpression(OverwatchCodeParser.OppositeTeamOfExpressionContext context)
        {
            return BasicExpression("Team.oppositeOf", context.expression());
        }

        public override StringBuilder VisitOrExpression(OverwatchCodeParser.OrExpressionContext context)
        {
            return BinaryExpression("||", context.expression());
        }

        public override StringBuilder VisitPayloadPositionExpression(OverwatchCodeParser.PayloadPositionExpressionContext context)
        {
            return BasicExpression("Game.Payload.position");
        }

        public override StringBuilder VisitPayloadProgressPercentageExpression(OverwatchCodeParser.PayloadProgressPercentageExpressionContext context)
        {
            return BasicExpression("Game.Payload.progressPercentage");
        }

        public override StringBuilder VisitPlayerCarryingFlagExpression(OverwatchCodeParser.PlayerCarryingFlagExpressionContext context)
        {
            return BasicExpression("Game.Ctf.playerCarryingFlagFor", context.expression());
        }

        public override StringBuilder VisitPlayerClosestToReticleExpression(OverwatchCodeParser.PlayerClosestToReticleExpressionContext context)
        {
            return BasicExpression("Player.getPlayerClosestToReticleOf", context.expression());
        }

        public override StringBuilder VisitPlayerVariableExpression(OverwatchCodeParser.PlayerVariableExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression()));
            builder.Append(".variables.");
            builder.Append(VisitPlayerVariable(context.playerVariable()));
            return builder;
        }

        public override StringBuilder VisitPlayersInSlotExpression(OverwatchCodeParser.PlayersInSlotExpressionContext context)
        {
            return BasicExpression("Player.inSlot", context.expression());
        }

        public override StringBuilder VisitPlayersInViewAngleExpression(OverwatchCodeParser.PlayersInViewAngleExpressionContext context)
        {
            return BasicExpression("Players.inLineOfSightOf", context.expression());
        }

        public override StringBuilder VisitPlayersOnHeroExpression(OverwatchCodeParser.PlayersOnHeroExpressionContext context)
        {
            return BasicExpression("Players.onHero", context.expression());
        }

        public override StringBuilder VisitPlayersWithinRadiusExpression(OverwatchCodeParser.PlayersWithinRadiusExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("Players.withinRadiusOf(");
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(", ");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(", ");
            builder.Append(VisitExpression(context.expression(2)));
            builder.Append(", ");
            builder.Append(VisitLineOfSightCheckType(context.lineOfSightCheckType()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitPointCapturePercentageExpression(OverwatchCodeParser.PointCapturePercentageExpressionContext context)
        {
            return BasicExpression("Game.ControlPoint.capturePercentage");
        }

        public override StringBuilder VisitPositionOfExpression(OverwatchCodeParser.PositionOfExpressionContext context)
        {
            return MemberMethodCallExpression("position", context.expression());
        }

        public override StringBuilder VisitRaiseToPowerExpression(OverwatchCodeParser.RaiseToPowerExpressionContext context)
        {
            return BasicExpression("Math.pow", context.expression());
        }

        public override StringBuilder VisitRandomIntegerExpression(OverwatchCodeParser.RandomIntegerExpressionContext context)
        {
            return BasicExpression("Math.randomInt", context.expression());
        }

        public override StringBuilder VisitRandomRealExpression(OverwatchCodeParser.RandomRealExpressionContext context)
        {
            return BasicExpression("Math.randomReal", context.expression());
        }

        public override StringBuilder VisitRandomValueInArrayExpression(OverwatchCodeParser.RandomValueInArrayExpressionContext context)
        {
            return MemberMethodCallExpression("getRandomElement()", context.expression());
        }

        public override StringBuilder VisitRandomizedArrayExpression(OverwatchCodeParser.RandomizedArrayExpressionContext context)
        {
            return MemberMethodCallExpression("shuffle()", context.expression());
        }

        public override StringBuilder VisitRayCastHitNormalExpression(OverwatchCodeParser.RayCastHitNormalExpressionContext context)
        {
            return BasicExpression("Vector.normalFromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRayCastHitPlayerExpression(OverwatchCodeParser.RayCastHitPlayerExpressionContext context)
        {
            return BasicExpression("Player.fromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRayCastHitPositionExpression(OverwatchCodeParser.RayCastHitPositionExpressionContext context)
        {
            return BasicExpression("Vector.positionFromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRemoveFromArrayExpression(OverwatchCodeParser.RemoveFromArrayExpressionContext context)
        {
            return MemberMethodCallExpression("remove", context.expression());
        }

        public override StringBuilder VisitRightExpression(OverwatchCodeParser.RightExpressionContext context)
        {
            return BasicExpression("Vector.right");
        }

        public override StringBuilder VisitRoundToIntegerExpression(OverwatchCodeParser.RoundToIntegerExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("Math.round(");
            builder.Append(VisitExpression(context.expression()));
            builder.Append(", ");
            builder.Append(VisitRoundingDirection(context.roundingDirection()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitScoreOfExpression(OverwatchCodeParser.ScoreOfExpressionContext context)
        {
            return MemberMethodCallExpression("score", context.expression());
        }

        public override StringBuilder VisitSineFromDegreesExpression(OverwatchCodeParser.SineFromDegreesExpressionContext context)
        {
            return BasicExpression("Math.sinDeg", context.expression());
        }

        public override StringBuilder VisitSineFromRadiansExpression(OverwatchCodeParser.SineFromRadiansExpressionContext context)
        {
            return BasicExpression("Math.sin", context.expression());
        }

        public override StringBuilder VisitSlotOfExpression(OverwatchCodeParser.SlotOfExpressionContext context)
        {
            return MemberMethodCallExpression("slot", context.expression());
        }

        public override StringBuilder VisitSortedArrayExpression(OverwatchCodeParser.SortedArrayExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".sortBy(currentArrayElement => ");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitSpeedOfExpression(OverwatchCodeParser.SpeedOfExpressionContext context)
        {
            return MemberMethodCallExpression("speed", context.expression());
        }

        public override StringBuilder VisitSpeedOfInDirectionExpression(OverwatchCodeParser.SpeedOfInDirectionExpressionContext context)
        {
            return MemberMethodCallExpression("getSpeedInDirection", context.expression());
        }

        public override StringBuilder VisitSquareRootExpression(OverwatchCodeParser.SquareRootExpressionContext context)
        {
            return BasicExpression("Math.sqrt", context.expression());
        }

        public override StringBuilder VisitStringExpression(OverwatchCodeParser.StringExpressionContext context)
        {
            return MemberMethodCallExpression("format", context.expression());
        }

        public override StringBuilder VisitSubtractExpression(OverwatchCodeParser.SubtractExpressionContext context)
        {
            return BinaryExpression("-", context.expression());
        }

        public override StringBuilder VisitTeamOfExpression(OverwatchCodeParser.TeamOfExpressionContext context)
        {
            return MemberMethodCallExpression("team", context.expression());
        }

        public override StringBuilder VisitTeamScoreExpression(OverwatchCodeParser.TeamScoreExpressionContext context)
        {
            return MemberMethodCallExpression("score", context.expression());
        }

        public override StringBuilder VisitThrottleOfExpression(OverwatchCodeParser.ThrottleOfExpressionContext context)
        {
            return MemberMethodCallExpression("throttle", context.expression());
        }

        public override StringBuilder VisitTotalTimeElapsedExpression(OverwatchCodeParser.TotalTimeElapsedExpressionContext context)
        {
            return BasicExpression("Game.totalTimeElapsed");
        }

        public override StringBuilder VisitUltimateChargePercentExpression(OverwatchCodeParser.UltimateChargePercentExpressionContext context)
        {
            return MemberMethodCallExpression("ultimateChargePercent", context.expression());
        }

        public override StringBuilder VisitUp(OverwatchCodeParser.UpContext context)
        {
            return BasicExpression("Vector.up");
        }

        public override StringBuilder VisitValueInArrayExpression(OverwatchCodeParser.ValueInArrayExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append("[");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append("]");
            return builder;
        }

        public override StringBuilder VisitVectorTowardsExpression(OverwatchCodeParser.VectorTowardsExpressionContext context)
        {
            return BasicExpression("Vector.towards", context.expression());
        }

        public override StringBuilder VisitVerticalFacingAngleOfExpression(OverwatchCodeParser.VerticalFacingAngleOfExpressionContext context)
        {
            return MemberMethodCallExpression("verticalFacingAngle", context.expression());
        }

        public override StringBuilder VisitVerticalSpeedOfExpression(OverwatchCodeParser.VerticalSpeedOfExpressionContext context)
        {
            return MemberMethodCallExpression("verticalSpeed", context.expression());
        }

        public override StringBuilder VisitVictimExpression(OverwatchCodeParser.VictimExpressionContext context)
        {
            return BasicExpression("Event.victim");
        }

        public override StringBuilder VisitWorldVectorOfExpression(OverwatchCodeParser.WorldVectorOfExpressionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".toWorldCoordinatesFor(");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append(", ");
            builder.Append(VisitVectorTransformationType(context.vectorTransformationType()));
            builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitXComponentOfExpression(OverwatchCodeParser.XComponentOfExpressionContext context)
        {
            return MemberMethodCallExpression("x", context.expression());
        }

        public override StringBuilder VisitYComponentOfExpression(OverwatchCodeParser.YComponentOfExpressionContext context)
        {
            return MemberMethodCallExpression("y", context.expression());
        }

        public override StringBuilder VisitZComponentOfExpression(OverwatchCodeParser.ZComponentOfExpressionContext context)
        {
            return MemberMethodCallExpression("z", context.expression());
        }
    }
}