using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;

namespace OverwatchCompiler.ToTypescript.antlr.codeGeneration
{
    public partial class CodeGeneration
    {
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
            return BasicMethodOrProperty("Vector", context.expression());
        }

        public override StringBuilder VisitAddExpression(OverwatchCodeParser.AddExpressionContext context)
        {
            return BinaryExpression("+", context.expression());
        }

        public override StringBuilder VisitAbsoluteValueExpression(OverwatchCodeParser.AbsoluteValueExpressionContext context)
        {
            return BasicMethodOrProperty("Math.abs", context.expression());
        }

        public override StringBuilder VisitAllDeadPlayersExpression(OverwatchCodeParser.AllDeadPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Players.deadOnTeam", context.expression());
        }

        public override StringBuilder VisitAllHeroesExpression(OverwatchCodeParser.AllHeroesExpressionContext context)
        {
            return BasicMethodOrProperty("Heroes.all");
        }

        public override StringBuilder VisitAllLivingPlayersExpression(OverwatchCodeParser.AllLivingPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Players.aliveOnTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersExpression(OverwatchCodeParser.AllPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Players.onTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersNotOnObjectiveExpression(OverwatchCodeParser.AllPlayersNotOnObjectiveExpressionContext context)
        {
            return BasicMethodOrProperty("Players.notOnObjectiveFromTeam", context.expression());
        }

        public override StringBuilder VisitAllPlayersOnObjectiveExpression(OverwatchCodeParser.AllPlayersOnObjectiveExpressionContext context)
        {
            return BasicMethodOrProperty("Players.onObjectiveFromTeam", context.expression());
        }

        public override StringBuilder VisitAllowedHeroesExpression(OverwatchCodeParser.AllowedHeroesExpressionContext context)
        {
            return BasicMethodOrProperty("Heroes.allowedForPlayer", context.expression());
        }

        public override StringBuilder VisitAltitudeOfExpression(OverwatchCodeParser.AltitudeOfExpressionContext context)
        {
            return BasicMethodOrProperty("altitudeOf", context.expression());
        }

        public override StringBuilder VisitEventPlayerExpression(OverwatchCodeParser.EventPlayerExpressionContext context)
        {
            return BasicMethodOrProperty("Event.player");
        }

        public override StringBuilder VisitAndExpression(OverwatchCodeParser.AndExpressionContext context)
        {
            return BinaryExpression("&&", context.expression());
        }

        public override StringBuilder VisitAngleDifferenceExpression(OverwatchCodeParser.AngleDifferenceExpressionContext context)
        {
            return BasicMethodOrProperty("angleDifference", context.expression());
        }

        public override StringBuilder VisitAppendToArrayExpression(OverwatchCodeParser.AppendToArrayExpressionContext context)
        {
            return MemberMethodOrProperty("push", context.expression());
        }

        public override StringBuilder VisitArrayContainsExpression(OverwatchCodeParser.ArrayContainsExpressionContext context)
        {
            return MemberMethodOrProperty("includes", context.expression());
        }

        public override StringBuilder VisitArraySliceExpression(OverwatchCodeParser.ArraySliceExpressionContext context)
        {
            return MemberMethodOrProperty("slice", context.expression());
        }

        public override StringBuilder VisitAttackerExpression(OverwatchCodeParser.AttackerExpressionContext context)
        {
            return BasicMethodOrProperty("Player.attacker");
        }

        public override StringBuilder VisitBackwardExpression(OverwatchCodeParser.BackwardExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.backward");
        }

        public override StringBuilder VisitClosestPlayerToExpression(OverwatchCodeParser.ClosestPlayerToExpressionContext context)
        {
            return BasicMethodOrProperty("Player.closestTo", context.expression());
        }

        public override StringBuilder VisitCompareExpression(OverwatchCodeParser.CompareExpressionContext context)
        {
            return BinaryExpression(context.binaryCompartorOperator().GetText(), context.expression());
        }

        public override StringBuilder VisitControlModeScoringPercentageExpression(OverwatchCodeParser.ControlModeScoringPercentageExpressionContext context)
        {
            return BasicMethodOrProperty("controlModeScoringPercentage", context.expression());
        }

        public override StringBuilder VisitGlobalVariableExpression(OverwatchCodeParser.GlobalVariableExpressionContext context)
        {
            return VisitGlobalVariable(context.globalVariable());
        }

        public override StringBuilder VisitControlModeScoringTeamExpression(OverwatchCodeParser.ControlModeScoringTeamExpressionContext context)
        {
            return BasicMethodOrProperty("Team.scoringControlMode");
        }

        public override StringBuilder VisitCosineFromRadiansExpression(OverwatchCodeParser.CosineFromRadiansExpressionContext context)
        {
            return BasicMethodOrProperty("Math.cos", context.expression());
        }

        public override StringBuilder VisitCosineFromDegreesExpression(OverwatchCodeParser.CosineFromDegreesExpressionContext context)
        {
            return BasicMethodOrProperty("Math.cosDeg", context.expression());
        }

        public override StringBuilder VisitCountOfExpression(OverwatchCodeParser.CountOfExpressionContext context)
        {
            return MemberMethodOrProperty("length", context.expression());
        }

        public override StringBuilder VisitCrossProductExpression(OverwatchCodeParser.CrossProductExpressionContext context)
        {
            return MemberMethodOrProperty("cross", context.expression());
        }

        public override StringBuilder VisitCurrentArrayElementExpression(OverwatchCodeParser.CurrentArrayElementExpressionContext context)
        {
            return BasicMethodOrProperty("currentArrayElement");
        }

        public override StringBuilder VisitDirectionFromAnglesExpression(OverwatchCodeParser.DirectionFromAnglesExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.fromAngles", context.expression());
        }

        public override StringBuilder VisitDirectionTowardsExpression(OverwatchCodeParser.DirectionTowardsExpressionContext context)
        {
            return MemberMethodOrProperty("directionTowards", context.expression());
        }

        public override StringBuilder VisitDistanceBetweenExpression(OverwatchCodeParser.DistanceBetweenExpressionContext context)
        {
            return MemberMethodOrProperty("distanceTo", context.expression());
        }

        public override StringBuilder VisitDivideExpression(OverwatchCodeParser.DivideExpressionContext context)
        {
            return BinaryExpression("/", context.expression());
        }

        public override StringBuilder VisitDotProductExpression(OverwatchCodeParser.DotProductExpressionContext context)
        {
            return MemberMethodOrProperty("dot", context.expression());
        }

        public override StringBuilder VisitDownExpression(OverwatchCodeParser.DownExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.down");
        }

        public override StringBuilder VisitEmptyArrayExpression(OverwatchCodeParser.EmptyArrayExpressionContext context)
        {
            return new StringBuilder("[]");
        }

        public override StringBuilder VisitEntityExistsExpression(OverwatchCodeParser.EntityExistsExpressionContext context)
        {
            return BasicMethodOrProperty("exists", context.expression());
        }

        public override StringBuilder VisitEventDamageExpression(OverwatchCodeParser.EventDamageExpressionContext context)
        {
            return BasicMethodOrProperty("Event.damage");
        }

        public override StringBuilder VisitEventWasCriticalHitExpression(OverwatchCodeParser.EventWasCriticalHitExpressionContext context)
        {
            return BasicMethodOrProperty("Event.wasCriticalHit");
        }

        public override StringBuilder VisitEyePositionExpression(OverwatchCodeParser.EyePositionExpressionContext context)
        {
            return MemberMethodOrProperty("eyePosition", context.expression());
        }

        public override StringBuilder VisitFacingDirectionOfExpression(OverwatchCodeParser.FacingDirectionOfExpressionContext context)
        {
            return MemberMethodOrProperty("facingDirection", context.expression());
        }

        public override StringBuilder VisitFarthestPlayerFromExpression(OverwatchCodeParser.FarthestPlayerFromExpressionContext context)
        {
            return BasicMethodOrProperty("Player.farthestFrom", context.expression());
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
            return MemberMethodOrProperty("head", context.expression());
        }

        public override StringBuilder VisitFlagPositionExpression(OverwatchCodeParser.FlagPositionExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Ctf.flagPositionFor", context.expression());
        }

        public override StringBuilder VisitForwardExpression(OverwatchCodeParser.ForwardExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.forward");
        }

        public override StringBuilder VisitHasSpawnedExpression(OverwatchCodeParser.HasSpawnedExpressionContext context)
        {
            return MemberMethodOrProperty("hasSpawned", context.expression());
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
            return MemberMethodOrProperty("health", context.expression());
        }

        public override StringBuilder VisitHealthPercentExpression(OverwatchCodeParser.HealthPercentExpressionContext context)
        {
            return MemberMethodOrProperty("healthPercent", context.expression());
        }

        public override StringBuilder VisitHeroExpression(OverwatchCodeParser.HeroExpressionContext context)
        {
            return VisitHeroType(context.heroType());
        }

        public override StringBuilder VisitHeroIconStringExpression(OverwatchCodeParser.HeroIconStringExpressionContext context)
        {
            return MemberMethodOrProperty("iconString", context.expression());
        }

        public override StringBuilder VisitHeroOfExpression(OverwatchCodeParser.HeroOfExpressionContext context)
        {
            return MemberMethodOrProperty("hero", context.expression());
        }

        public override StringBuilder VisitHorizontalAngleFromDirectionExpression(OverwatchCodeParser.HorizontalAngleFromDirectionExpressionContext context)
        {
            return MemberMethodOrProperty("horizontalAngle", context.expression());
        }

        public override StringBuilder VisitHorizontalAngleTowardsExpression(OverwatchCodeParser.HorizontalAngleTowardsExpressionContext context)
        {
            return MemberMethodOrProperty("horizontalAngleTowards", context.expression());
        }

        public override StringBuilder VisitHorizontalFacingAngleOfExpression(OverwatchCodeParser.HorizontalFacingAngleOfExpressionContext context)
        {
            return MemberMethodOrProperty("horizontalFacingAngle", context.expression());
        }

        public override StringBuilder VisitHorizontalSpeedOfExpression(OverwatchCodeParser.HorizontalSpeedOfExpressionContext context)
        {
            return MemberMethodOrProperty("horizontalSpeed", context.expression());
        }

        public override StringBuilder VisitIndexOfArrayValueExpression(OverwatchCodeParser.IndexOfArrayValueExpressionContext context)
        {
            return MemberMethodOrProperty("indexOf", context.expression());
        }

        public override StringBuilder VisitIsAliveExpression(OverwatchCodeParser.IsAliveExpressionContext context)
        {
            return MemberMethodOrProperty("isAlive", context.expression());
        }

        public override StringBuilder VisitIsAssemblingHeroesExpression(OverwatchCodeParser.IsAssemblingHeroesExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isAssemblingHeroes");
        }

        public override StringBuilder VisitIsBetweenRoundsExpression(OverwatchCodeParser.IsBetweenRoundsExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isBetweenRounds");
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
            return MemberMethodOrProperty("isCommunicating", context.expression());
        }

        public override StringBuilder VisitIsCommunicatingAnyEmoteExpression(OverwatchCodeParser.IsCommunicatingAnyEmoteExpressionContext context)
        {
            return MemberMethodOrProperty("isCommunicatingWithEmote", context.expression());
        }

        public override StringBuilder VisitIsCommunicatingAnyVoicelineExpression(OverwatchCodeParser.IsCommunicatingAnyVoicelineExpressionContext context)
        {
            return MemberMethodOrProperty("isCommunicatingWithVoiceLine", context.expression());
        }

        public override StringBuilder VisitIsControlModePointLockedExpression(OverwatchCodeParser.IsControlModePointLockedExpressionContext context)
        {
            return BasicMethodOrProperty("Game.ControlPoint.isPointLocked");
        }

        public override StringBuilder VisitIsCrouchingExpression(OverwatchCodeParser.IsCrouchingExpressionContext context)
        {
            return MemberMethodOrProperty("isCrouching", context.expression());
        }

        public override StringBuilder VisitIsCTFModeInSuddenDeathExpression(OverwatchCodeParser.IsCTFModeInSuddenDeathExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Ctf.isInSuddenDeath");
        }

        public override StringBuilder VisitIsDeadExpression(OverwatchCodeParser.IsDeadExpressionContext context)
        {
            return MemberMethodOrProperty("isDead", context.expression());
        }

        public override StringBuilder VisitIsFiringPrimaryExpression(OverwatchCodeParser.IsFiringPrimaryExpressionContext context)
        {
            return MemberMethodOrProperty("isFiringPrimary", context.expression());
        }

        public override StringBuilder VisitIsFiringSecondaryExpression(OverwatchCodeParser.IsFiringSecondaryExpressionContext context)
        {
            return MemberMethodOrProperty("isFiringSecondary", context.expression());
        }

        public override StringBuilder VisitIsFlagAtBaseExpression(OverwatchCodeParser.IsFlagAtBaseExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Ctf.isFlagAtBaseFor", context.expression());
        }

        public override StringBuilder VisitIsFlagBeingCarriedExpression(OverwatchCodeParser.IsFlagBeingCarriedExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Ctf.isFlagBeingCarriedFor", context.expression());
        }

        public override StringBuilder VisitIsGameInProgressExpression(OverwatchCodeParser.IsGameInProgressExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isInProgress");
        }

        public override StringBuilder VisitIsHeroBeingPlayedExpression(OverwatchCodeParser.IsHeroBeingPlayedExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isHeroBeingPlayed", context.expression());
        }

        public override StringBuilder VisitIsInAirExpression(OverwatchCodeParser.IsInAirExpressionContext context)
        {
            return MemberMethodOrProperty("isInAir", context.expression());
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
            return BasicMethodOrProperty("Game.isInSetup");
        }

        public override StringBuilder VisitIsInSpawnRoomExpression(OverwatchCodeParser.IsInSpawnRoomExpressionContext context)
        {
            return MemberMethodOrProperty("isInSpawnRoom", context.expression());
        }

        public override StringBuilder VisitIsInViewAngleExpression(OverwatchCodeParser.IsInViewAngleExpressionContext context)
        {
            return MemberMethodOrProperty("isLookingAt", context.expression());
        }

        public override StringBuilder VisitIsMatchCompleteExpression(OverwatchCodeParser.IsMatchCompleteExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isMatchComplete");
        }

        public override StringBuilder VisitIsMovingExpression(OverwatchCodeParser.IsMovingExpressionContext context)
        {
            return MemberMethodOrProperty("isMoving", context.expression());
        }

        public override StringBuilder VisitIsObjectiveCompleteExpression(OverwatchCodeParser.IsObjectiveCompleteExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isObjectiveComplete", context.expression());
        }

        public override StringBuilder VisitIsOnGroundExpression(OverwatchCodeParser.IsOnGroundExpressionContext context)
        {
            return MemberMethodOrProperty("isOnGround", context.expression());
        }

        public override StringBuilder VisitIsOnObjectiveExpression(OverwatchCodeParser.IsOnObjectiveExpressionContext context)
        {
            return MemberMethodOrProperty("isOnObjective", context.expression());
        }

        public override StringBuilder VisitIsOnWallExpression(OverwatchCodeParser.IsOnWallExpressionContext context)
        {
            return MemberMethodOrProperty("isOnWall", context.expression());
        }

        public override StringBuilder VisitIsPortraitOnFireExpression(OverwatchCodeParser.IsPortraitOnFireExpressionContext context)
        {
            return MemberMethodOrProperty("isPortraitOnFire", context.expression());
        }

        public override StringBuilder VisitIsStandingExpression(OverwatchCodeParser.IsStandingExpressionContext context)
        {
            return MemberMethodOrProperty("isStanding", context.expression());
        }

        public override StringBuilder VisitIsTeamOnDefenseExpression(OverwatchCodeParser.IsTeamOnDefenseExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isOnDefense", context.expression());
        }

        public override StringBuilder VisitIsTeamOnOffenseExpression(OverwatchCodeParser.IsTeamOnOffenseExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isOnOffense", context.expression());
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
            return MemberMethodOrProperty("isUsingAbility1", context.expression());
        }

        public override StringBuilder VisitIsUsingAbility2Expression(OverwatchCodeParser.IsUsingAbility2ExpressionContext context)
        {
            return MemberMethodOrProperty("isUsingAbility2", context.expression());
        }

        public override StringBuilder VisitIsUsingUltimateExpression(OverwatchCodeParser.IsUsingUltimateExpressionContext context)
        {
            return MemberMethodOrProperty("isUsingUltimate", context.expression());
        }

        public override StringBuilder VisitIsWaitingForPlayersExpression(OverwatchCodeParser.IsWaitingForPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Game.isWaitingForPlayers");
        }

        public override StringBuilder VisitLastCreatedEntityExpression(OverwatchCodeParser.LastCreatedEntityExpressionContext context)
        {
            return BasicMethodOrProperty("Game.getLastCreatedEntity()");
        }

        public override StringBuilder VisitLastDamageModificationIDExpression(OverwatchCodeParser.LastDamageModificationIDExpressionContext context)
        {
            return BasicMethodOrProperty("Game.getIdOfLastDamageModification()");
        }

        public override StringBuilder VisitLastDamageOverTimeIDExpression(OverwatchCodeParser.LastDamageOverTimeIDExpressionContext context)
        {
            return BasicMethodOrProperty("Game.getIdOfLastDamageOverTime()");
        }

        public override StringBuilder VisitLastHealOverTimeIDExpression(OverwatchCodeParser.LastHealOverTimeIDExpressionContext context)
        {
            return BasicMethodOrProperty("Game.getIdOfLastHealOverTime()");
        }

        public override StringBuilder VisitLastOfExpression(OverwatchCodeParser.LastOfExpressionContext context)
        {
            return MemberMethodOrProperty("last", context.expression());
        }

        public override StringBuilder VisitLastTextIDExpression(OverwatchCodeParser.LastTextIDExpressionContext context)
        {
            return BasicMethodOrProperty("Game.getIdOfLastText()");
        }

        public override StringBuilder VisitLeftExpression(OverwatchCodeParser.LeftExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.left");
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
            return BasicMethodOrProperty("Game.matchRound");
        }

        public override StringBuilder VisitMatchTimeExpression(OverwatchCodeParser.MatchTimeExpressionContext context)
        {
            return BasicMethodOrProperty("Game.matchTime");
        }

        public override StringBuilder VisitMaxExpression(OverwatchCodeParser.MaxExpressionContext context)
        {
            return BasicMethodOrProperty("Math.max", context.expression());
        }

        public override StringBuilder VisitMaxHealthExpression(OverwatchCodeParser.MaxHealthExpressionContext context)
        {
            return MemberMethodOrProperty("maxHealth", context.expression());
        }

        public override StringBuilder VisitMinExpression(OverwatchCodeParser.MinExpressionContext context)
        {
            return BasicMethodOrProperty("Math.min", context.expression());
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
            return BasicMethodOrProperty("Vector.getNearestWalkablePosition", context.expression());
        }

        public override StringBuilder VisitNormalizeExpression(OverwatchCodeParser.NormalizeExpressionContext context)
        {
            return MemberMethodOrProperty("normalize()", context.expression());
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
            return BasicMethodOrProperty("Game.numberOfDeadPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfDeathsExpression(OverwatchCodeParser.NumberOfDeathsExpressionContext context)
        {
            return MemberMethodOrProperty("numberOfDeaths", context.expression());
        }

        public override StringBuilder VisitNumberOfEliminationsExpression(OverwatchCodeParser.NumberOfEliminationsExpressionContext context)
        {
            return MemberMethodOrProperty("numberOfEliminations", context.expression());
        }

        public override StringBuilder VisitNumberOfFinalBlowsExpression(OverwatchCodeParser.NumberOfFinalBlowsExpressionContext context)
        {
            return MemberMethodOrProperty("numberOfFinalBlows", context.expression());
        }

        public override StringBuilder VisitNumberOfHeroesExpression(OverwatchCodeParser.NumberOfHeroesExpressionContext context)
        {
            return BasicMethodOrProperty("Game.numberOfHeroesOfTypeOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfLivingPlayersExpression(OverwatchCodeParser.NumberOfLivingPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Game.numberOfLivingPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfPlayersExpression(OverwatchCodeParser.NumberOfPlayersExpressionContext context)
        {
            return BasicMethodOrProperty("Game.numberOfPlayersOnTeam", context.expression());
        }

        public override StringBuilder VisitNumberOfPlayersOnObjectiveExpression(OverwatchCodeParser.NumberOfPlayersOnObjectiveExpressionContext context)
        {
            return BasicMethodOrProperty("Game.numberOfPlayersFromTeamOnObjective", context.expression());
        }

        public override StringBuilder VisitObjectiveIndexExpression(OverwatchCodeParser.ObjectiveIndexExpressionContext context)
        {
            return BasicMethodOrProperty("Game.indexOfCurrentObjective");
        }

        public override StringBuilder VisitObjectivePositionExpression(OverwatchCodeParser.ObjectivePositionExpressionContext context)
        {
            return BasicMethodOrProperty("Game.positionOfObjective", context.expression());
        }

        public override StringBuilder VisitOppositeTeamOfExpression(OverwatchCodeParser.OppositeTeamOfExpressionContext context)
        {
            return BasicMethodOrProperty("Team.oppositeOf", context.expression());
        }

        public override StringBuilder VisitOrExpression(OverwatchCodeParser.OrExpressionContext context)
        {
            return BinaryExpression("||", context.expression());
        }

        public override StringBuilder VisitPayloadPositionExpression(OverwatchCodeParser.PayloadPositionExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Payload.position");
        }

        public override StringBuilder VisitPayloadProgressPercentageExpression(OverwatchCodeParser.PayloadProgressPercentageExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Payload.progressPercentage");
        }

        public override StringBuilder VisitPlayerCarryingFlagExpression(OverwatchCodeParser.PlayerCarryingFlagExpressionContext context)
        {
            return BasicMethodOrProperty("Game.Ctf.playerCarryingFlagFor", context.expression());
        }

        public override StringBuilder VisitPlayerClosestToReticleExpression(OverwatchCodeParser.PlayerClosestToReticleExpressionContext context)
        {
            return BasicMethodOrProperty("Player.getPlayerClosestToReticleOf", context.expression());
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
            return BasicMethodOrProperty("Player.inSlot", context.expression());
        }

        public override StringBuilder VisitPlayersInViewAngleExpression(OverwatchCodeParser.PlayersInViewAngleExpressionContext context)
        {
            return BasicMethodOrProperty("Players.inLineOfSightOf", context.expression());
        }

        public override StringBuilder VisitPlayersOnHeroExpression(OverwatchCodeParser.PlayersOnHeroExpressionContext context)
        {
            return BasicMethodOrProperty("Players.onHero", context.expression());
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
            return BasicMethodOrProperty("Game.ControlPoint.capturePercentage");
        }

        public override StringBuilder VisitPositionOfExpression(OverwatchCodeParser.PositionOfExpressionContext context)
        {
            return MemberMethodOrProperty("position", context.expression());
        }

        public override StringBuilder VisitRaiseToPowerExpression(OverwatchCodeParser.RaiseToPowerExpressionContext context)
        {
            return BasicMethodOrProperty("Math.pow", context.expression());
        }

        public override StringBuilder VisitRandomIntegerExpression(OverwatchCodeParser.RandomIntegerExpressionContext context)
        {
            return BasicMethodOrProperty("Math.randomInt", context.expression());
        }

        public override StringBuilder VisitRandomRealExpression(OverwatchCodeParser.RandomRealExpressionContext context)
        {
            return BasicMethodOrProperty("Math.randomReal", context.expression());
        }

        public override StringBuilder VisitRandomValueInArrayExpression(OverwatchCodeParser.RandomValueInArrayExpressionContext context)
        {
            return MemberMethodOrProperty("getRandomElement()", context.expression());
        }

        public override StringBuilder VisitRandomizedArrayExpression(OverwatchCodeParser.RandomizedArrayExpressionContext context)
        {
            return MemberMethodOrProperty("shuffle()", context.expression());
        }

        public override StringBuilder VisitRayCastHitNormalExpression(OverwatchCodeParser.RayCastHitNormalExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.normalFromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRayCastHitPlayerExpression(OverwatchCodeParser.RayCastHitPlayerExpressionContext context)
        {
            return BasicMethodOrProperty("Player.fromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRayCastHitPositionExpression(OverwatchCodeParser.RayCastHitPositionExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.positionFromRayCastHit", context.expression());
        }

        public override StringBuilder VisitRemoveFromArrayExpression(OverwatchCodeParser.RemoveFromArrayExpressionContext context)
        {
            return MemberMethodOrProperty("remove", context.expression());
        }

        public override StringBuilder VisitRightExpression(OverwatchCodeParser.RightExpressionContext context)
        {
            return BasicMethodOrProperty("Vector.right");
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
            return MemberMethodOrProperty("score", context.expression());
        }

        public override StringBuilder VisitSineFromDegreesExpression(OverwatchCodeParser.SineFromDegreesExpressionContext context)
        {
            return BasicMethodOrProperty("Math.sinDeg", context.expression());
        }

        public override StringBuilder VisitSineFromRadiansExpression(OverwatchCodeParser.SineFromRadiansExpressionContext context)
        {
            return BasicMethodOrProperty("Math.sin", context.expression());
        }

        public override StringBuilder VisitSlotOfExpression(OverwatchCodeParser.SlotOfExpressionContext context)
        {
            return MemberMethodOrProperty("slot", context.expression());
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
            return MemberMethodOrProperty("speed", context.expression());
        }

        public override StringBuilder VisitSpeedOfInDirectionExpression(OverwatchCodeParser.SpeedOfInDirectionExpressionContext context)
        {
            return MemberMethodOrProperty("getSpeedInDirection", context.expression());
        }

        public override StringBuilder VisitSquareRootExpression(OverwatchCodeParser.SquareRootExpressionContext context)
        {
            return BasicMethodOrProperty("Math.sqrt", context.expression());
        }

        public override StringBuilder VisitStringExpression(OverwatchCodeParser.StringExpressionContext context)
        {
            return MemberMethodOrProperty("format", context.expression());
        }

        public override StringBuilder VisitSubtractExpression(OverwatchCodeParser.SubtractExpressionContext context)
        {
            return BinaryExpression("-", context.expression());
        }

        public override StringBuilder VisitTeamOfExpression(OverwatchCodeParser.TeamOfExpressionContext context)
        {
            return MemberMethodOrProperty("team", context.expression());
        }

        public override StringBuilder VisitTeamScoreExpression(OverwatchCodeParser.TeamScoreExpressionContext context)
        {
            return MemberMethodOrProperty("score", context.expression());
        }

        public override StringBuilder VisitThrottleOfExpression(OverwatchCodeParser.ThrottleOfExpressionContext context)
        {
            return MemberMethodOrProperty("throttle", context.expression());
        }

        public override StringBuilder VisitTotalTimeElapsedExpression(OverwatchCodeParser.TotalTimeElapsedExpressionContext context)
        {
            return BasicMethodOrProperty("Game.totalTimeElapsed");
        }

        public override StringBuilder VisitUltimateChargePercentExpression(OverwatchCodeParser.UltimateChargePercentExpressionContext context)
        {
            return MemberMethodOrProperty("ultimateChargePercent", context.expression());
        }

        public override StringBuilder VisitUp(OverwatchCodeParser.UpContext context)
        {
            return BasicMethodOrProperty("Vector.up");
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
            return BasicMethodOrProperty("Vector.towards", context.expression());
        }

        public override StringBuilder VisitVerticalFacingAngleOfExpression(OverwatchCodeParser.VerticalFacingAngleOfExpressionContext context)
        {
            return MemberMethodOrProperty("verticalFacingAngle", context.expression());
        }

        public override StringBuilder VisitVerticalSpeedOfExpression(OverwatchCodeParser.VerticalSpeedOfExpressionContext context)
        {
            return MemberMethodOrProperty("verticalSpeed", context.expression());
        }

        public override StringBuilder VisitVictimExpression(OverwatchCodeParser.VictimExpressionContext context)
        {
            return BasicMethodOrProperty("Event.victim");
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
            return MemberMethodOrProperty("x", context.expression());
        }

        public override StringBuilder VisitYComponentOfExpression(OverwatchCodeParser.YComponentOfExpressionContext context)
        {
            return MemberMethodOrProperty("y", context.expression());
        }

        public override StringBuilder VisitZComponentOfExpression(OverwatchCodeParser.ZComponentOfExpressionContext context)
        {
            return MemberMethodOrProperty("z", context.expression());
        }
    }
}