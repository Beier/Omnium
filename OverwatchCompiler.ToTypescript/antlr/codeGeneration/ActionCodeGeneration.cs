using System;
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

        public override StringBuilder VisitAbortAction(OverwatchCodeParser.AbortActionContext context)
        {
            return new StringBuilder("return");
        }

        public override StringBuilder VisitAbortIfAction(OverwatchCodeParser.AbortIfActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("if (");
            builder.Append(VisitExpression(context.expression()));
            builder.AppendLine(")");
            builder.Append("\t\t\treturn");
            return builder;
        }

        public override StringBuilder VisitAbortIfConditionIsFalseAction(OverwatchCodeParser.AbortIfConditionIsFalseActionContext context)
        {
            var builder = new StringBuilder();
            builder.AppendLine("if (this.reevaluateCondition() == false)");
            builder.Append("\t\t\treturn");
            return builder;
        }

        public override StringBuilder VisitAbortIfConditionIsTrueAction(OverwatchCodeParser.AbortIfConditionIsTrueActionContext context)
        {
            var builder = new StringBuilder();
            builder.AppendLine("if (this.reevaluateCondition())");
            builder.Append("\t\t\treturn");
            return builder;
        }

        public override StringBuilder VisitAllowButtonAction(OverwatchCodeParser.AllowButtonActionContext context)
        {
            return MemberMethodOrProperty("allowButton", VisitExpression(context.expression()), VisitButton(context.button()));
        }

        public override StringBuilder VisitApplyImpulseAction(OverwatchCodeParser.ApplyImpulseActionContext context)
        {
            return MemberMethodOrProperty("applyImpulse",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitRelativeTo(context.relativeTo()),
                VisitMotionType(context.motionType())
                );
        }

        public override StringBuilder VisitBigMessageAction(OverwatchCodeParser.BigMessageActionContext context)
        {
            return BasicMethodOrProperty("showBigMessage", context.expression());
        }

        public override StringBuilder VisitChaseGlobalVariableAtRateAction(OverwatchCodeParser.ChaseGlobalVariableAtRateActionContext context)
        {
            return BasicMethodOrProperty("chaseVariableAtRate",
                VisitGlobalVariable(context.globalVariable()),
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitRateReevaluation(context.rateReevaluation())
            );
        }

        public override StringBuilder VisitChaseGlobalVariableOverTimeAction(OverwatchCodeParser.ChaseGlobalVariableOverTimeActionContext context)
        {
            return BasicMethodOrProperty("chaseVariableOverTime",
                VisitGlobalVariable(context.globalVariable()),
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitTimeReevaluation(context.timeReevaluation())
            );
        }

        public override StringBuilder VisitChasePlayerVariableAtRateAction(OverwatchCodeParser.ChasePlayerVariableAtRateActionContext context)
        {
            var playerVariableArgument = new StringBuilder();
            playerVariableArgument.Append(VisitExpression(context.expression(0)));
            playerVariableArgument.Append(".");
            playerVariableArgument.Append(VisitPlayerVariable(context.playerVariable()));

            return BasicMethodOrProperty("chaseVariableAtRate",
                playerVariableArgument,
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitRateReevaluation(context.rateReevaluation())
            );
        }

        public override StringBuilder VisitChasePlayerVariableOverTimeAction(OverwatchCodeParser.ChasePlayerVariableOverTimeActionContext context)
        {
            var playerVariableArgument = new StringBuilder();
            playerVariableArgument.Append(VisitExpression(context.expression(0)));
            playerVariableArgument.Append(".");
            playerVariableArgument.Append(VisitPlayerVariable(context.playerVariable()));

            return BasicMethodOrProperty("chaseVariableAtRate",
                playerVariableArgument,
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitTimeReevaluation(context.timeReevaluation())
            );
        }

        public override StringBuilder VisitClearStatusAction(OverwatchCodeParser.ClearStatusActionContext context)
        {
            return MemberMethodOrProperty("clearStatus", VisitExpression(context.expression()), VisitStatus(context.status()));
        }

        public override StringBuilder VisitCommunicateAction(OverwatchCodeParser.CommunicateActionContext context)
        {
            return MemberMethodOrProperty("communicate", VisitExpression(context.expression()), VisitCommunicationType(context.communicationType()));
        }

        public override StringBuilder VisitCreateEffectAction(OverwatchCodeParser.CreateEffectActionContext context)
        {
            return BasicMethodOrProperty("createEffect",
                VisitExpression(context.expression(0)),
                VisitEffectShape(context.effectShape()),
                VisitColor(context.color()),
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitCreateEffectReevaluation(context.createEffectReevaluation())
            );
        }

        public override StringBuilder VisitCreateHudTextAction(OverwatchCodeParser.CreateHudTextActionContext context)
        {
            return BasicMethodOrProperty("createHudEffect",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitExpression(context.expression(3)),
                VisitHudTextLocation(context.hudTextLocation()),
                VisitExpression(context.expression(4)),
                VisitColor(context.color(0)),
                VisitColor(context.color(1)),
                VisitColor(context.color(2)),
                VisitHudTextReevaluation(context.hudTextReevaluation())
            );
        }

        public override StringBuilder VisitCreateIconAction(OverwatchCodeParser.CreateIconActionContext context)
        {
            return BasicMethodOrProperty("createIcon",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitIcon(context.icon()),
                VisitIconReevaluation(context.iconReevaluation()),
                VisitColor(context.color()),
                VisitExpression(context.expression(2))
            );
        }

        public override StringBuilder VisitCreateInWorldTextAction(OverwatchCodeParser.CreateInWorldTextActionContext context)
        {
            return BasicMethodOrProperty("createInWorldText",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2)),
                VisitExpression(context.expression(3)),
                VisitInWorldTextClipping(context.inWorldTextClipping()),
                VisitInWorldTextReevaluation(context.inWorldTextReevaluation())
            );
        }

        public override StringBuilder VisitDamageAction(OverwatchCodeParser.DamageActionContext context)
        {
            return MemberMethodOrProperty("damage", context.expression());
        }

        public override StringBuilder VisitDeclareMatchDrawAction(OverwatchCodeParser.DeclareMatchDrawActionContext context)
        {
            return BasicMethodOrProperty("Game.declareMatchDraw()");
        }

        public override StringBuilder VisitDeclarePlayerVictoryAction(OverwatchCodeParser.DeclarePlayerVictoryActionContext context)
        {
            return MemberMethodOrProperty("declareVictory()", context.expression());
        }

        public override StringBuilder VisitDeclareRoundVictoryAction(OverwatchCodeParser.DeclareRoundVictoryActionContext context)
        {
            return BasicMethodOrProperty("Game.declareRoundVictory", context.expression());
        }

        public override StringBuilder VisitDeclareTeamVictoryAction(OverwatchCodeParser.DeclareTeamVictoryActionContext context)
        {
            return MemberMethodOrProperty("declareVictory()", context.expression());
        }

        public override StringBuilder VisitDestroyAllEffectsAction(OverwatchCodeParser.DestroyAllEffectsActionContext context)
        {
            return BasicMethodOrProperty("destroyAllEffects()");
        }

        public override StringBuilder VisitDestroyAllHudTextAction(OverwatchCodeParser.DestroyAllHudTextActionContext context)
        {
            return BasicMethodOrProperty("destroyAllHudTexts()");
        }

        public override StringBuilder VisitDestroyAllIconsAction(OverwatchCodeParser.DestroyAllIconsActionContext context)
        {
            return BasicMethodOrProperty("destroyAllIcons()");
        }

        public override StringBuilder VisitDestroyAllInWorldTextAction(OverwatchCodeParser.DestroyAllInWorldTextActionContext context)
        {
            return BasicMethodOrProperty("destroyAllInWorldTexts()");
        }

        public override StringBuilder VisitDestroyEffectAction(OverwatchCodeParser.DestroyEffectActionContext context)
        {
            return MemberMethodOrProperty("destroy()", context.expression());
        }

        public override StringBuilder VisitDestroyHudTextAction(OverwatchCodeParser.DestroyHudTextActionContext context)
        {
            return MemberMethodOrProperty("destroy()", context.expression());
        }

        public override StringBuilder VisitDestroyIconAction(OverwatchCodeParser.DestroyIconActionContext context)
        {
            return MemberMethodOrProperty("destroy()", context.expression());
        }

        public override StringBuilder VisitDestroyInWorldTextAction(OverwatchCodeParser.DestroyInWorldTextActionContext context)
        {
            return MemberMethodOrProperty("destroy()", context.expression());
        }

        public override StringBuilder VisitDisableBuiltInGameModeAnnouncerAction(OverwatchCodeParser.DisableBuiltInGameModeAnnouncerActionContext context)
        {
            return BasicMethodOrProperty("Game.disableBuiltInGameModeAnnouncer()");
        }

        public override StringBuilder VisitDisableBuiltInGameModeCompletionAction(OverwatchCodeParser.DisableBuiltInGameModeCompletionActionContext context)
        {
            return BasicMethodOrProperty("Game.disableBuiltInGameModeCompletion()");
        }

        public override StringBuilder VisitDisableBuiltInGameModeMusicAction(OverwatchCodeParser.DisableBuiltInGameModeMusicActionContext context)
        {
            return BasicMethodOrProperty("Game.disableBuiltInGameModeMusic()");
        }

        public override StringBuilder VisitDisableBuiltInGameModeRespawningAction(OverwatchCodeParser.DisableBuiltInGameModeRespawningActionContext context)
        {
            return MemberMethodOrProperty("disableRespawning()", context.expression());
        }

        public override StringBuilder VisitDisableBuiltInGameModeScoringAction(OverwatchCodeParser.DisableBuiltInGameModeScoringActionContext context)
        {
            return BasicMethodOrProperty("Game.disableBuiltInGameModeScoring()");
        }

        public override StringBuilder VisitDisableDeathSpectateAllPlayersAction(OverwatchCodeParser.DisableDeathSpectateAllPlayersActionContext context)
        {
            return MemberMethodOrProperty("disableDeathSpectate()", context.expression());
        }

        public override StringBuilder VisitDisableDeathSpectateTargetHudAction(OverwatchCodeParser.DisableDeathSpectateTargetHudActionContext context)
        {
            return MemberMethodOrProperty("disableDeathSpectateTargetHud()", context.expression());
        }

        public override StringBuilder VisitDisallowButtonAction(OverwatchCodeParser.DisallowButtonActionContext context)
        {
            return MemberMethodOrProperty("disallowButton",
                VisitExpression(context.expression()),
                VisitButton(context.button())
            );
        }

        public override StringBuilder VisitEnableBuiltInGameModeAnnouncerAction(OverwatchCodeParser.EnableBuiltInGameModeAnnouncerActionContext context)
        {
            return BasicMethodOrProperty("Game.enableBuiltInGameModeAnnouncer()");
        }

        public override StringBuilder VisitEnableBuiltInGameModeCompletionAction(OverwatchCodeParser.EnableBuiltInGameModeCompletionActionContext context)
        {
            return BasicMethodOrProperty("Game.enableBuiltInGameModeCompletion()");
        }

        public override StringBuilder VisitEnableBuiltInGameModeMusicAction(OverwatchCodeParser.EnableBuiltInGameModeMusicActionContext context)
        {
            return BasicMethodOrProperty("Game.enableBuiltInGameModeMusic()");
        }

        public override StringBuilder VisitEnableBuiltInGameModeRespawningAction(OverwatchCodeParser.EnableBuiltInGameModeRespawningActionContext context)
        {
            return MemberMethodOrProperty("enableRespawning()", context.expression());
        }

        public override StringBuilder VisitEnableBuiltInGameModeScoringAction(OverwatchCodeParser.EnableBuiltInGameModeScoringActionContext context)
        {
            return BasicMethodOrProperty("Game.enableBuiltInGameModeScoring()");
        }

        public override StringBuilder VisitEnableDeathSpectateAllPlayersAction(OverwatchCodeParser.EnableDeathSpectateAllPlayersActionContext context)
        {
            return MemberMethodOrProperty("enableDeathSpectate()", context.expression());
        }

        public override StringBuilder VisitEnableDeathSpectateTargetHudAction(OverwatchCodeParser.EnableDeathSpectateTargetHudActionContext context)
        {
            return MemberMethodOrProperty("enableDeathSpectateTargetHud()", context.expression());
        }

        public override StringBuilder VisitGoToAssembleHeroesAction(OverwatchCodeParser.GoToAssembleHeroesActionContext context)
        {
            return BasicMethodOrProperty("Game.goToAssembleHeroes()");
        }

        public override StringBuilder VisitHealAction(OverwatchCodeParser.HealActionContext context)
        {
            return MemberMethodOrProperty("heal", context.expression());
        }

        public override StringBuilder VisitKillAction(OverwatchCodeParser.KillActionContext context)
        {
            return MemberMethodOrProperty("kill", context.expression());
        }

        public override StringBuilder VisitLoopAction(OverwatchCodeParser.LoopActionContext context)
        {
            return BasicMethodOrProperty("loop()");
        }

        public override StringBuilder VisitLoopIfAction(OverwatchCodeParser.LoopIfActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("if (");
            builder.Append(VisitExpression(context.expression()));
            builder.AppendLine(")");
            builder.Append("\t\t\tloop()");
            return builder;
        }

        public override StringBuilder VisitLoopIfConditionIsFalseAction(OverwatchCodeParser.LoopIfConditionIsFalseActionContext context)
        {
            var builder = new StringBuilder();
            builder.AppendLine("if (this.reevaluateCondition() == false)");
            builder.Append("\t\t\tloop()");
            return builder;
        }

        public override StringBuilder VisitLoopIfConditionIsTrueAction(OverwatchCodeParser.LoopIfConditionIsTrueActionContext context)
        {
            var builder = new StringBuilder();
            builder.AppendLine("if (this.reevaluateCondition())");
            builder.Append("\t\t\tloop()");
            return builder;
        }

        public override StringBuilder VisitModifyGlobalVariableAction(OverwatchCodeParser.ModifyGlobalVariableActionContext context)
        {
            var modification = VisitModification(context.modification()).ToString();

            var builder = new StringBuilder();
            builder.Append(VisitGlobalVariable(context.globalVariable()));
            builder.Append(modification);
            builder.Append(VisitExpression(context.expression()));
            if (modification.EndsWith("("))
                builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitModifyGlobalVariableAtIndexAction(OverwatchCodeParser.ModifyGlobalVariableAtIndexActionContext context)
        {
            var modification = VisitModification(context.modification()).ToString();

            var builder = new StringBuilder();
            builder.Append(VisitGlobalVariable(context.globalVariable()));
            builder.Append("[");
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append("]");
            builder.Append(modification);
            builder.Append(VisitExpression(context.expression(1)));
            if (modification.EndsWith("("))
                builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitModifyPlayerVariableAction(OverwatchCodeParser.ModifyPlayerVariableActionContext context)
        {
            var modification = VisitModification(context.modification()).ToString();

            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".");
            builder.Append(VisitPlayerVariable(context.playerVariable()));
            builder.Append(modification);
            builder.Append(VisitExpression(context.expression(1)));
            if (modification.EndsWith("("))
                builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitModifyPlayerVariableAtIndexAction(OverwatchCodeParser.ModifyPlayerVariableAtIndexActionContext context)
        {
            var modification = VisitModification(context.modification()).ToString();

            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".");
            builder.Append(VisitPlayerVariable(context.playerVariable()));
            builder.Append("[");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append("]");
            builder.Append(modification);
            builder.Append(VisitExpression(context.expression(2)));
            if (modification.EndsWith("("))
                builder.Append(")");
            return builder;
        }

        public override StringBuilder VisitModification(OverwatchCodeParser.ModificationContext context)
        {
            if (context.add() != null)
                return new StringBuilder(" += ");
            if (context.subtract() != null)
                return new StringBuilder(" -= ");
            if (context.multiply() != null)
                return new StringBuilder(" *= ");
            if (context.divide() != null)
                return new StringBuilder(" /= ");
            if (context.modulo() != null)
                return new StringBuilder(" %= ");
            if (context.raiseToPower() != null)
                return new StringBuilder(".raiseTo(");
            if (context.min() != null)
                return new StringBuilder(".min(");
            if (context.max() != null)
                return new StringBuilder(".max(");
            if (context.appendToArray() != null)
                return new StringBuilder(".push(");
            if (context.removeFromArrayByValue() != null)
                return new StringBuilder(".remove(");
            if (context.removeFromArrayByIndex() != null)
                return new StringBuilder(".removeAt(");
            throw new Exception("Unknown modification");
        }

        public override StringBuilder VisitModifyTeamScoreAction(OverwatchCodeParser.ModifyTeamScoreActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".score += ");
            builder.Append(VisitExpression(context.expression(1)));
            return builder;
        }

        public override StringBuilder VisitPauseMatchTimeAction(OverwatchCodeParser.PauseMatchTimeActionContext context)
        {
            return BasicMethodOrProperty("Game.pauseMatchTime()");
        }

        public override StringBuilder VisitPlayEffectAction(OverwatchCodeParser.PlayEffectActionContext context)
        {
            return BasicMethodOrProperty("Game.playEffect",
                VisitExpression(context.expression(0)),
                VisitAnimatedEffect(context.animatedEffect()),
                VisitColor(context.color()),
                VisitExpression(context.expression(1)),
                VisitExpression(context.expression(2))
            );
        }

        public override StringBuilder VisitPreloadHeroAction(OverwatchCodeParser.PreloadHeroActionContext context)
        {
            return MemberMethodOrProperty("preload", context.expression());
        }

        public override StringBuilder VisitPressButtonAction(OverwatchCodeParser.PressButtonActionContext context)
        {
            return MemberMethodOrProperty("pressButton",
                VisitExpression(context.expression()),
                VisitButton(context.button())
            );
        }

        public override StringBuilder VisitResetPlayerHeroAvailabilityAction(OverwatchCodeParser.ResetPlayerHeroAvailabilityActionContext context)
        {
            return MemberMethodOrProperty("resetHeroAvalibility()", context.expression());
        }

        public override StringBuilder VisitRespawnAction(OverwatchCodeParser.RespawnActionContext context)
        {
            return MemberMethodOrProperty("respawn()", context.expression());
        }

        public override StringBuilder VisitResurrectAction(OverwatchCodeParser.ResurrectActionContext context)
        {
            return MemberMethodOrProperty("resurrect()", context.expression());
        }

        public override StringBuilder VisitSetAbility1EnabledAction(OverwatchCodeParser.SetAbility1EnabledActionContext context)
        {
            return MemberMethodOrProperty("setAbility1Enabled", context.expression());
        }

        public override StringBuilder VisitSetAbility2EnabledAction(OverwatchCodeParser.SetAbility2EnabledActionContext context)
        {
            return MemberMethodOrProperty("setAbility2Enabled", context.expression());
        }

        public override StringBuilder VisitSetDamageDealtAction(OverwatchCodeParser.SetDamageDealtActionContext context)
        {
            return MemberMethodOrProperty("setDamageMultiplierPercent", context.expression());
        }

        public override StringBuilder VisitSetDamageReceivedAction(OverwatchCodeParser.SetDamageReceivedActionContext context)
        {
            return MemberMethodOrProperty("setDamageReceivedPercent", context.expression());
        }

        public override StringBuilder VisitSetFacingAction(OverwatchCodeParser.SetFacingActionContext context)
        {
            return MemberMethodOrProperty("setFacing",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitRelativeTo(context.relativeTo())
            );
        }

        public override StringBuilder VisitSetGlobalVariableAtIndexAction(OverwatchCodeParser.SetGlobalVariableAtIndexActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitGlobalVariable(context.globalVariable()));
            builder.Append("[");
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append("] = ");
            builder.Append(VisitExpression(context.expression(1)));
            return builder;
        }

        public override StringBuilder VisitSetGravityAction(OverwatchCodeParser.SetGravityActionContext context)
        {
            return MemberMethodOrProperty("setGravity", context.expression());
        }

        public override StringBuilder VisitSetHealingDealtAction(OverwatchCodeParser.SetHealingDealtActionContext context)
        {
            return MemberMethodOrProperty("setHealingDealtPercent", context.expression());
        }

        public override StringBuilder VisitSetHealingReceivedAction(OverwatchCodeParser.SetHealingReceivedActionContext context)
        {
            return MemberMethodOrProperty("setHealingReceivedPercent", context.expression());
        }

        public override StringBuilder VisitSetMatchTimeAction(OverwatchCodeParser.SetMatchTimeActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append("Game.matchTime = ");
            builder.Append(VisitExpression(context.expression()));
            return builder;
        }

        public override StringBuilder VisitSetMaxHealthAction(OverwatchCodeParser.SetMaxHealthActionContext context)
        {
            return MemberMethodOrProperty("setMaxHealthPercent", context.expression());
        }

        public override StringBuilder VisitSetMoveSpeedAction(OverwatchCodeParser.SetMoveSpeedActionContext context)
        {
            return MemberMethodOrProperty("setMovementSpeedPercent", context.expression());
        }

        public override StringBuilder VisitSetObjectiveDescriptionAction(OverwatchCodeParser.SetObjectiveDescriptionActionContext context)
        {
            return BasicMethodOrProperty("Game.setObjectiveDescription",
                VisitExpression(context.expression(0)),
                VisitExpression(context.expression(1)),
                VisitHudTextReevaluation(context.hudTextReevaluation())
            );
        }

        public override StringBuilder VisitSetPlayerAllowedHeroesAction(OverwatchCodeParser.SetPlayerAllowedHeroesActionContext context)
        {
            return MemberMethodOrProperty("setAllowedHeroes", context.expression());
        }

        public override StringBuilder VisitSetPlayerScoreAction(OverwatchCodeParser.SetPlayerScoreActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".score = ");
            builder.Append(VisitExpression(context.expression(1)));
            return builder;
        }

        public override StringBuilder VisitSetPlayerVariableAction(OverwatchCodeParser.SetPlayerVariableActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".");
            builder.Append(VisitPlayerVariable(context.playerVariable()));
            builder.Append(" = ");
            builder.Append(VisitExpression(context.expression(1)));
            return builder;
        }

        public override StringBuilder VisitSetPlayerVariableAtIndexAction(OverwatchCodeParser.SetPlayerVariableAtIndexActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".");
            builder.Append(VisitPlayerVariable(context.playerVariable()));
            builder.Append("[");
            builder.Append(VisitExpression(context.expression(1)));
            builder.Append("]");
            builder.Append(" = ");
            builder.Append(VisitExpression(context.expression(2)));
            return builder;
        }

        public override StringBuilder VisitSetPrimaryFireEnabledAction(OverwatchCodeParser.SetPrimaryFireEnabledActionContext context)
        {
            return MemberMethodOrProperty("setPrimaryFireEnabled", context.expression());
        }

        public override StringBuilder VisitSetProjectileGravityAction(OverwatchCodeParser.SetProjectileGravityActionContext context)
        {
            return MemberMethodOrProperty("setProjectileGravityPercentage", context.expression());
        }

        public override StringBuilder VisitSetRespawnMaxTimeAction(OverwatchCodeParser.SetRespawnMaxTimeActionContext context)
        {
            return MemberMethodOrProperty("setRespawnMaxTime", context.expression());
        }

        public override StringBuilder VisitSetSecondaryFireEnabledAction(OverwatchCodeParser.SetSecondaryFireEnabledActionContext context)
        {
            return MemberMethodOrProperty("setSecondaryFireEnabled", context.expression());
        }

        public override StringBuilder VisitSetSlowMotionAction(OverwatchCodeParser.SetSlowMotionActionContext context)
        {
            return BasicMethodOrProperty("Game.setGameSpeedPercent", context.expression());
        }

        public override StringBuilder VisitSetStatusAction(OverwatchCodeParser.SetStatusActionContext context)
        {
            return MemberMethodOrProperty("setStatus", context.expression());
        }

        public override StringBuilder VisitSetTeamScoreAction(OverwatchCodeParser.SetTeamScoreActionContext context)
        {
            var builder = new StringBuilder();
            builder.Append(VisitExpression(context.expression(0)));
            builder.Append(".score = ");
            builder.Append(VisitExpression(context.expression(1)));
            return builder;
        }

        public override StringBuilder VisitSetUltimateAbilityEnabledAction(OverwatchCodeParser.SetUltimateAbilityEnabledActionContext context)
        {
            return MemberMethodOrProperty("setUltimateAbilityEnabled", context.expression());
        }

        public override StringBuilder VisitSetUltimateChargeAction(OverwatchCodeParser.SetUltimateChargeActionContext context)
        {
            return MemberMethodOrProperty("setUltimateChargeEnabled", context.expression());
        }
    }
}