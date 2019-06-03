// Define a grammar called Hello
grammar OverwatchCode;


root: rule* EOF ;         // match keyword hello followed by an identifier
rule: 'rule' '(' STRING ')' '{' eventBlock conditionBlock? actionBlock? '}';

//Events
eventBlock: 'event' '{' eventType '}';
eventType
	: ongoingGlobalEventType 
	| ongoingEachPlayerEventType 
	| playerEarnedEliminationEventType
	| playerDealtFinalBlowEventType
	| playerDealtDamageEventType
	| playerTookDamageEventType
	| playerDiedEventType
	;
ongoingGlobalEventType: 'Ongoing - Global;';
ongoingEachPlayerEventType: 'Ongoing - Each Player;' team ';' playerConstant ';';
playerEarnedEliminationEventType: 'Player earned elimination;' team ';' playerConstant ';';
playerDealtFinalBlowEventType: 'Player dealt final blow;' team ';' playerConstant ';';
playerDealtDamageEventType: 'Player dealt damage;' team ';' playerConstant ';';
playerTookDamageEventType: 'Player took damage;' team ';' playerConstant ';';
playerDiedEventType: 'Player Died;' team ';' playerConstant ';';

//Conditions
conditionBlock: 'conditions' '{' condition* '}';
condition: expression binaryCompartorOperator expression ';';

//Actions
actionBlock: 'actions' '{' (action ';')* '}';
action
	: setGlobalVariableAction
	| abortAction
	| abortIfAction
	| abortIfConditionIsFalseAction
	| abortIfConditionIsTrueAction
	| allowButtonAction
	| applyImpulseAction
	| bigMessageAction
	| chaseGlobalVariableAtRateAction
	| chaseGlobalVariableOverTimeAction
	| chasePlayerVariableAtRateAction
	| chasePlayerVariableOverTimeAction
	| clearStatusAction
	| communicateAction
	| createEffectAction
	| createHudTextAction
	| createIconAction
	| createInWorldTextAction
	| damageAction
	| declareMatchDrawAction
	| declarePlayerVictoryAction
	| declareRoundVictoryAction
	| declareTeamVictoryAction
	| destroyAllEffectsAction
	| destroyAllHudTextAction
	| destroyAllIconsAction
	| destroyAllInWorldTextAction
	| destroyEffectAction
	| destroyHudTextAction
	| destroyIconAction
	| destroyInWorldTextAction
	| disableBuiltInGameModeAnnouncerAction
	| disableBuiltInGameModeCompletionAction
	| disableBuiltInGameModeMusicAction
	| disableBuiltInGameModeRespawningAction
	| disableBuiltInGameModeScoringAction
	| disableDeathSpectateAllPlayersAction
	| disableDeathSpectateTargetHudAction
	| disallowButtonAction
	| enableBuiltInGameModeAnnouncerAction
	| enableBuiltInGameModeCompletionAction
	| enableBuiltInGameModeMusicAction
	| enableBuiltInGameModeRespawningAction
	| enableBuiltInGameModeScoringAction
	| enableDeathSpectateAllPlayersAction
	| enableDeathSpectateTargetHudAction
	| goToAssembleHeroesAction
	| healAction
	| killAction
	| loopAction
	| loopIfAction
	| loopIfConditionIsFalseAction
	| loopIfConditionIsTrueAction
	| modifyGlobalVariableAction
	| modifyGlobalVariableAtIndexAction
	| modifyPlayerVariableAction
	| modifyPlayerVariableAtIndexAction
	| modifyTeamScoreAction
	| pauseMatchTimeAction
	| playEffectAction
	| preloadHeroAction
	| pressButtonAction
	| resetPlayerHeroAvailabilityAction
	| respawnAction
	| resurrectAction
	| setAbility1EnabledAction
	| setAbility2EnabledAction
	| setDamageDealtAction
	| setDamageReceivedAction
	| setFacingAction
	| setGlobalVariableAtIndexAction
	| setGravityAction
	| setHealingDealtAction
	| setHealingReceivedAction
	| setMatchTimeAction
	| setMaxHealthAction
	| setMoveSpeedAction
	| setObjectiveDescriptionAction
	| setPlayerAllowedHeroesAction
	| setPlayerScoreAction
	| setPlayerVariableAction
	| setPlayerVariableAtIndexAction
	| setPrimaryFireEnabledAction
	| setProjectileGravityAction
	| setRespawnMaxTimeAction
	| setSecondaryFireEnabledAction
	| setSlowMotionAction
	| setStatusAction
	| setTeamScoreAction
	| setUltimateAbilityEnabledAction
	| setUltimateChargeAction
	;
setGlobalVariableAction: 'Set Global Variable' '(' globalVariable ',' expression ')';
abortAction: 'Abort';
abortIfAction: 'Abort If' '(' expression ')';
abortIfConditionIsFalseAction: 'Abort If Condition Is False';
abortIfConditionIsTrueAction: 'Abort If Condition Is True';
allowButtonAction: 'Allow Button' '(' expression ',' button ')';
applyImpulseAction: 'Apply Impulse' '(' expression ',' expression ',' expression ',' relativeTo ',' motionType ')';
bigMessageAction: 'Big Message' '(' expression ',' expression ')';
chaseGlobalVariableAtRateAction: 'Chase Global Variable At Rate' '(' globalVariable ',' expression ',' expression ',' rateReevaluation ')';
chaseGlobalVariableOverTimeAction: 'Chase Global Variable Over Time' '(' globalVariable ',' expression ',' expression ',' timeReevaluation ')';
chasePlayerVariableAtRateAction: 'Chase Player Variable At Rate' '(' expression ',' playerVariable ',' expression ',' expression ',' rateReevaluation ')';
chasePlayerVariableOverTimeAction: 'Chase Player Variable Over Time' '(' expression ',' playerVariable ',' expression ',' expression ',' timeReevaluation ')';
clearStatusAction: 'Clear Status' '(' expression ',' status ')';
communicateAction: 'Communicate' '(' expression ',' communicationType ')';
createEffectAction: 'Create Effect' '(' expression ',' effectShape ',' color ',' expression ',' expression ',' createEffectReevaluation ')';
createHudTextAction: 'Create HUD Text' '(' expression ',' expression ',' expression ',' expression ',' hudTextLocation ',' expression ',' color ',' color ',' color ',' hudTextReevaluation ')';
createIconAction: 'Create Icon' '(' expression ',' expression ',' icon ',' iconReevaluation ',' color ',' expression ')';
createInWorldTextAction: 'Create In-World Text' '(' expression ',' expression ',' expression ',' expression ',' inWorldTextClipping ',' inWorldTextReevaluation ')';
damageAction: 'Damage' '(' expression ',' expression ',' expression ')';
declareMatchDrawAction: 'Declare Match Draw';
declarePlayerVictoryAction: 'Declare Player Victory' '(' expression ')';
declareRoundVictoryAction: 'Declare Round Victory' '(' expression ')';
declareTeamVictoryAction: 'Declare Team Victory' '(' expression ')';
destroyAllEffectsAction: 'Destroy All Effects';
destroyAllHudTextAction: 'Destroy All HUD Text';
destroyAllIconsAction: 'Destroy All Icons';
destroyAllInWorldTextAction: 'Destroy All In-World Text';
destroyEffectAction: 'Destroy Effect' '(' expression ')';
destroyHudTextAction: 'Destroy HUD Text' '(' expression ')';
destroyIconAction: 'Destroy Icon' '(' expression ')';
destroyInWorldTextAction: 'Destroy In-World Text' '(' expression ')';
disableBuiltInGameModeAnnouncerAction: 'Disable Built-In Game Mode Announcer';
disableBuiltInGameModeCompletionAction: 'Disable Built-In Game Mode Completion';
disableBuiltInGameModeMusicAction: 'Disable Built-In Game Mode Music';
disableBuiltInGameModeRespawningAction: 'Disable Built-In Game Mode Respawning' '(' expression ')';
disableBuiltInGameModeScoringAction: 'Disable Built-In Game Mode Scoring';
disableDeathSpectateAllPlayersAction: 'Disable Death Spectate All Players' '(' expression ')';
disableDeathSpectateTargetHudAction: 'Disable Death Spectate Target HUD' '(' expression ')';
disallowButtonAction: 'Disallow Button' '(' expression ',' button ')';
enableBuiltInGameModeAnnouncerAction: 'Enable Built-In Game Mode Announcer';
enableBuiltInGameModeCompletionAction: 'Enable Built-In Game Mode Completion';
enableBuiltInGameModeMusicAction: 'Enable Built-In Game Mode Music';
enableBuiltInGameModeRespawningAction: 'Enable Built-In Game Mode Respawning' '(' expression ')';
enableBuiltInGameModeScoringAction: 'Enable Built-In Game Mode Scoring';
enableDeathSpectateAllPlayersAction: 'Enable Death Spectate All Players' '(' expression ')';
enableDeathSpectateTargetHudAction: 'Enable Death Spectate Target HUD' '(' expression ')';
goToAssembleHeroesAction: 'Go To Assemble Heroes';
healAction: 'Heal' '(' expression ',' expression ',' expression ')';
killAction: 'Kill' '(' expression ',' expression ')';
loopAction: 'Loop';
loopIfAction: 'Loop If' '(' expression ')';
loopIfConditionIsFalseAction: 'Loop If Condition Is False';
loopIfConditionIsTrueAction: 'Loop If Condition Is True';
modifyGlobalVariableAction: 'Modify Global Variable' '(' globalVariable ',' modification ',' expression ')';
modifyGlobalVariableAtIndexAction: 'Modify Global Variable At Index' '(' globalVariable ',' expression ',' modification ',' expression ')';
modifyPlayerVariableAction: 'Modify Player Variable' '(' expression ',' playerVariable ',' modification ',' expression ')';
modifyPlayerVariableAtIndexAction: 'Modify Player Variable At Index' '(' expression ',' playerVariable ',' expression ',' modification ',' expression ')';
modifyTeamScoreAction: 'Modify Team Score' '(' expression ',' expression ')';
pauseMatchTimeAction: 'Pause Match Time';
playEffectAction: 'Play Effect' '(' expression ',' animatedEffect ',' color ',' expression ',' expression ')';
preloadHeroAction: 'Preload Hero' '(' expression ',' expression ')';
pressButtonAction: 'Press Button' '(' expression ',' button ')';
resetPlayerHeroAvailabilityAction: 'Reset Player Hero Availability' '(' expression ')';
respawnAction: 'Respawn' '(' expression ')';
resurrectAction: 'Resurrect' '(' expression ')';
setAbility1EnabledAction: 'Set Ability 1 Enabled' '(' expression ',' expression ')';
setAbility2EnabledAction: 'Set Ability 2 Enabled' '(' expression ',' expression ')';
setDamageDealtAction: 'Set Damage Dealt' '(' expression ',' expression ')';
setDamageReceivedAction: 'Set Damage Received' '(' expression ',' expression ')';
setFacingAction: 'Set Facing' '(' expression ',' expression ',' relativeTo ')';
setGlobalVariableAtIndexAction: 'Set Global Variable At Index' '(' globalVariable ',' expression ',' expression ')';
setGravityAction: 'Set Gravity' '(' expression ',' expression ')';
setHealingDealtAction: 'Set Healing Dealt' '(' expression ',' expression ')';
setHealingReceivedAction: 'Set Healing Received' '(' expression ',' expression ')';
setMatchTimeAction: 'Set Match Time' '(' expression ')';
setMaxHealthAction: 'Set Max Health' '(' expression ',' expression ')';
setMoveSpeedAction: 'Set Move Speed' '(' expression ',' expression ')';
setObjectiveDescriptionAction: 'Set Objective Description' '(' expression ',' expression ',' hudTextReevaluation ')';
setPlayerAllowedHeroesAction: 'Set Player Allowed Heroes' '(' expression ',' expression ')';
setPlayerScoreAction: 'Set Player Score' '(' expression ',' expression ')';
setPlayerVariableAction: 'Set Player Variable' '(' expression ',' playerVariable ',' expression ')';
setPlayerVariableAtIndexAction: 'Set Player Variable At Index' '(' expression ',' playerVariable ',' expression ',' expression ')';
setPrimaryFireEnabledAction: 'Set Primary Fire Enabled' '(' expression ',' expression ')';
setProjectileGravityAction: 'Set Projectile Gravity' '(' expression ',' expression ')';
setRespawnMaxTimeAction: 'Set Respawn Max Time' '(' expression ',' expression ')';
setSecondaryFireEnabledAction: 'Set Secondary Fire Enabled' '(' expression ',' expression ')';
setSlowMotionAction: 'Set Slow Motion' '(' expression ')';
setStatusAction: 'Set Status' '(' expression ',' expression ',' status ',' expression ')';
setTeamScoreAction: 'Set Team Score' '(' expression ',' expression ')';
setUltimateAbilityEnabledAction: 'Set Ultimate Ability Enabled' '(' expression ',' expression ')';
setUltimateChargeAction: 'Set Ultimate Charge' '(' expression ',' expression ')';

/*
Action: '';
Action: '';
Action: '' '(' expression ')';
Action: '' '(' expression ')';
Action: '' '(' expression ',' expression ')';
Action: '' '(' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ',' expression ',' expression ')';
Action: '' '(' expression ',' expression ',' expression ',' expression ',' expression ',' expression ')';
*/


//Expressions
expression
	: literal 
	| team
	| vectorExpression
	| addExpression
	| absoluteValueExpression
	| allDeadPlayersExpression
	| allHeroesExpression
	| allLivingPlayersExpression
	| allPlayersExpression
	| allPlayersNotOnObjectiveExpression
	| allPlayersOnObjectiveExpression
	| allowedHeroesExpression
	| altitudeOfExpression
	| eventPlayerExpression
	| andExpression
	| angleDifferenceExpression
	| appendToArrayExpression
	| arrayContainsExpression
	| arraySliceExpression
	| attackerExpression
	| backwardExpression
	| closestPlayerToExpression
	| compareExpression
	| controlModeScoringPercentageExpression
	| globalVariableExpression
	| controlModeScoringTeamExpression
	| cosineFromDegreesExpression
	| cosineFromRadiansExpression
	| countOfExpression
	| crossProductExpression
	| currentArrayElementExpression
	| directionFromAnglesExpression
	| directionTowardsExpression
	| distanceBetweenExpression
	| divideExpression
	| dotProductExpression
	| downExpression
	| emptyArrayExpression
	| entityExistsExpression
	| eventDamageExpression
	| eventWasCriticalHitExpression
	| eyePositionExpression
	| facingDirectionOfExpression
	| farthestPlayerFromExpression
	| filteredArrayExpression
	| firstOfExpression
	| flagPositionExpression
	| forwardExpression
	| hasSpawnedExpression
	| hasStatusExpression
	| healthExpression
	| healthPercentExpression
	| heroExpression
	| heroIconStringExpression
	| heroOfExpression
	| horizontalAngleFromDirectionExpression
	| horizontalAngleTowardsExpression
	| horizontalFacingAngleOfExpression
	| horizontalSpeedOfExpression
	| indexOfArrayValueExpression
	| isAliveExpression
	| isAssemblingHeroesExpression
	| isBetweenRoundsExpression
	| isButtonHeldExpression
	| isCommunicatingExpression
	| isCommunicatingAnyExpression
	| isCommunicatingAnyEmoteExpression
	| isCommunicatingAnyVoicelineExpression
	| isControlModePointLockedExpression
	| isCrouchingExpression
	| isCTFModeInSuddenDeathExpression
	| isDeadExpression
	| isFiringPrimaryExpression
	| isFiringSecondaryExpression
	| isFlagAtBaseExpression
	| isFlagBeingCarriedExpression
	| isGameInProgressExpression
	| isHeroBeingPlayedExpression
	| isInAirExpression
	| isInLineofSightExpression
	| isInSetupExpression
	| isInSpawnRoomExpression
	| isInViewAngleExpression
	| isMatchCompleteExpression
	| isMovingExpression
	| isObjectiveCompleteExpression
	| isOnGroundExpression
	| isOnObjectiveExpression
	| isOnWallExpression
	| isPortraitOnFireExpression
	| isStandingExpression
	| isTeamOnDefenseExpression
	| isTeamOnOffenseExpression
	| isTrueForAllExpression
	| isTrueForAnyExpression
	| isUsingAbility1Expression
	| isUsingAbility2Expression
	| isUsingUltimateExpression
	| isWaitingForPlayersExpression
	| lastCreatedEntityExpression
	| lastDamageModificationIDExpression
	| lastDamageOverTimeIDExpression
	| lastHealOverTimeIDExpression
	| lastOfExpression
	| lastTextIDExpression
	| leftExpression
	| localVectorOfExpression
	| matchRoundExpression
	| matchTimeExpression
	| maxExpression
	| maxHealthExpression
	| minExpression
	| moduloExpression
	| multiplyExpression
	| nearestWalkablePositionExpression
	| normalizeExpression
	| notExpression
	| numberOfDeadPlayersExpression
	| numberOfDeathsExpression
	| numberOfEliminationsExpression
	| numberOfFinalBlowsExpression
	| numberOfHeroesExpression
	| numberOfLivingPlayersExpression
	| numberOfPlayersExpression
	| numberOfPlayersOnObjectiveExpression
	| objectiveIndexExpression
	| objectivePositionExpression
	| oppositeTeamOfExpression
	| orExpression
	| payloadPositionExpression
	| payloadProgressPercentageExpression
	| playerCarryingFlagExpression
	| playerClosestToReticleExpression
	| playerVariableExpression
	| playersInSlotExpression
	| playersInViewAngleExpression
	| playersOnHeroExpression
	| playersWithinRadiusExpression
	| pointCapturePercentageExpression
	| positionOfExpression
	| raiseToPowerExpression
	| randomIntegerExpression
	| randomRealExpression
	| randomValueInArrayExpression
	| randomizedArrayExpression
	| rayCastHitNormalExpression
	| rayCastHitPlayerExpression
	| rayCastHitPositionExpression
	| removeFromArrayExpression
	| rightExpression
	| roundToIntegerExpression
	| scoreOfExpression
	| sineFromDegreesExpression
	| sineFromRadiansExpression
	| slotOfExpression
	| sortedArrayExpression
	| speedOfExpression
	| speedOfInDirectionExpression
	| squareRootExpression
	| stringExpression
	| subtractExpression
	| teamOfExpression
	| teamScoreExpression
	| throttleOfExpression
	| totalTimeElapsedExpression
	| ultimateChargePercentExpression
	| upExpression
	| valueInArrayExpression
	| vectorTowardsExpression
	| verticalFacingAngleOfExpression
	| verticalSpeedOfExpression
	| victimExpression
	| worldVectorOfExpression
	| xComponentOfExpression
	| yComponentOfExpression
	| zComponentOfExpression
	;

vectorExpression: 'Vector' '(' expression ',' expression ',' expression ')';
addExpression: 'Add' '(' expression ',' expression ')';
absoluteValueExpression: 'Absolute Value' '(' expression ')';
allDeadPlayersExpression: 'All Dead Players' '(' expression ')';
allHeroesExpression: 'All Heroes';
allLivingPlayersExpression: 'All Living Players' '(' expression ')';
allPlayersExpression: 'All Players' '(' expression ')';
allPlayersNotOnObjectiveExpression: 'All Players Not On Objective' '(' expression ')';
allPlayersOnObjectiveExpression: 'All Players On Objective' '(' expression ')';
allowedHeroesExpression: 'Allowed Heroes' '(' expression ')';
altitudeOfExpression: 'Altitude Of' '(' expression ')';
eventPlayerExpression: 'Event Player';
andExpression: 'And' '(' expression ',' expression ')';
angleDifferenceExpression: 'Angle Difference' '(' expression ',' expression ')';
appendToArrayExpression: 'Append To Array' '(' expression ',' expression ')';
arrayContainsExpression: 'Array Contains' '(' expression ',' expression ')';
arraySliceExpression: 'Array Slice' '(' expression ',' expression ',' expression ')';
attackerExpression: 'Attacker';
backwardExpression: 'Backward';
closestPlayerToExpression: 'Closest Player To' '(' expression ',' expression ')';
compareExpression: 'Compare' '(' expression ',' binaryCompartorOperator ',' expression ')';
controlModeScoringPercentageExpression: 'Control Mode Scoring Percentage' '(' expression  ')';
globalVariableExpression: 'Global Variable' '(' globalVariable  ')';
controlModeScoringTeamExpression: 'Control Mode Scoring Team';
cosineFromDegreesExpression: 'Cosine From Degrees' '(' expression  ')';
cosineFromRadiansExpression: 'Cosine From Radians' '(' expression  ')';
countOfExpression: 'Count Of' '(' expression  ')';
crossProductExpression: 'Cross Product' '(' expression ',' expression ')';
currentArrayElementExpression: 'Current Array Element';
directionFromAnglesExpression: 'Direction From Angles' '(' expression ',' expression ')';
directionTowardsExpression: 'Direction Towards' '(' expression ',' expression ')';
distanceBetweenExpression: 'Distance Between' '(' expression ',' expression ')';
divideExpression: 'Divide' '(' expression ',' expression ')';
dotProductExpression: 'Dot Product' '(' expression ',' expression ')';
downExpression: 'Down';
emptyArrayExpression: 'Empty Array';
entityExistsExpression: 'Entity Exists' '(' expression ')';
eventDamageExpression: 'Event Damage';
eventWasCriticalHitExpression: 'Event Was Critical Hit';
eyePositionExpression: 'Eye Position' '(' expression ')';
facingDirectionOfExpression: 'Facing Direction Of' '(' expression ')';
farthestPlayerFromExpression: 'Farthest Player From' '(' expression  ',' expression ')';
filteredArrayExpression: 'Filtered Array' '(' expression  ',' expression ')';
firstOfExpression: 'First Of' '(' expression ')';
flagPositionExpression: 'Flag Position' '(' expression ')';
forwardExpression: 'Forward';
hasSpawnedExpression: 'Has Spawned' '(' expression ')';
hasStatusExpression: 'Has Status' '(' expression  ',' status ')';
healthExpression: 'Health' '(' expression ')';
healthPercentExpression: 'Health Percent' '(' expression ')';
heroExpression: 'Hero' '(' heroType ')';
heroIconStringExpression: 'Hero Icon String' '(' expression ')';
heroOfExpression: 'Hero Of' '(' expression ')';
horizontalAngleFromDirectionExpression: 'Horizontal Angle From Direction' '(' expression ')';
horizontalAngleTowardsExpression: 'Horizontal Angle Towards' '(' expression ',' expression ')';
horizontalFacingAngleOfExpression: 'Horizontal Facing Angle Of' '(' expression ')';
horizontalSpeedOfExpression: 'Horizontal Speed Of' '(' expression ')';
indexOfArrayValueExpression: 'Index Of Array Value' '(' expression ',' expression ')';
isAliveExpression: 'Is Alive' '(' expression ')';
isAssemblingHeroesExpression: 'Is Assembling Heroes';
isBetweenRoundsExpression: 'Is Between Rounds';
isButtonHeldExpression: 'Is Button Held' '(' expression ',' button  ')';
isCommunicatingExpression: 'Is Communicating' '(' expression ',' communicationType  ')';
isCommunicatingAnyExpression: 'Is Communicating Any' '(' expression ')';
isCommunicatingAnyEmoteExpression: 'Is Communicating Any Emote' '(' expression ')';
isCommunicatingAnyVoicelineExpression: 'Is Communicating Any Voice line' '(' expression ')';
isControlModePointLockedExpression: 'Is Control Mode Point Locked';
isCrouchingExpression: 'Is Crouching' '(' expression ')';
isCTFModeInSuddenDeathExpression: 'Is CTF Mode In Sudden Death';
isDeadExpression: 'Is Dead' '(' expression ')';
isFiringPrimaryExpression: 'Is Firing Primary' '(' expression ')';
isFiringSecondaryExpression: 'Is Firing Secondary' '(' expression ')';
isFlagAtBaseExpression: 'Is Flag At Base' '(' expression ')';
isFlagBeingCarriedExpression: 'Is Flag Being Carried' '(' expression ')';
isGameInProgressExpression: 'Is Game In Progress';
isHeroBeingPlayedExpression: 'Is Hero Being Played' '(' expression ',' expression ')';
isInAirExpression: 'Is In Air' '(' expression ')';
isInLineofSightExpression: 'Is In Line of Sight' '(' expression ',' expression ',' barrierBlockType ')';
isInSetupExpression: 'Is In Setup';
isInSpawnRoomExpression: 'Is In Spawn Room' '(' expression ')';
isInViewAngleExpression: 'Is In View Angle' '(' expression ',' expression  ',' expression ')';
isMatchCompleteExpression: 'Is Match Complete';
isMovingExpression: 'Is Moving' '(' expression ')';
isObjectiveCompleteExpression: 'Is Objective Complete' '(' expression ')';
isOnGroundExpression: 'Is On Ground' '(' expression ')';
isOnObjectiveExpression: 'Is On Objective' '(' expression ')';
isOnWallExpression: 'Is On Wall' '(' expression ')';
isPortraitOnFireExpression: 'Is Portrait On Fire' '(' expression ')';
isStandingExpression: 'Is Standing' '(' expression ')';
isTeamOnDefenseExpression: 'Is Team On Defense' '(' expression ')';
isTeamOnOffenseExpression: 'Is Team On Offense' '(' expression ')';
isTrueForAllExpression: 'Is True For All' '(' expression ',' expression ')';
isTrueForAnyExpression: 'Is True For Any' '(' expression ',' expression ')';
isUsingAbility1Expression: 'Is Using Ability 1' '(' expression ')';
isUsingAbility2Expression: 'Is Using Ability 2' '(' expression ')';
isUsingUltimateExpression: 'Is Using Ultimate' '(' expression ')';
isWaitingForPlayersExpression: 'Is Waiting For Players';
lastCreatedEntityExpression: 'Last Created Entity';
lastDamageModificationIDExpression: 'Last Damage Modification ID';
lastDamageOverTimeIDExpression: 'Last Damage Over Time ID';
lastHealOverTimeIDExpression: 'Last Heal Over Time ID';
lastOfExpression: 'Last Of' '(' expression ')';
lastTextIDExpression: 'Last Text ID';
leftExpression: 'Left';
localVectorOfExpression: 'Local Vector Of' '(' expression ',' expression ',' vectorTransformationType ')';
matchRoundExpression: 'Match Round';
matchTimeExpression: 'Match Time';
maxExpression: 'Max' '(' expression ',' expression ')';
maxHealthExpression: 'Max Health' '(' expression ')';
minExpression: 'Min' '(' expression ',' expression ')';
moduloExpression: 'Modulo' '(' expression ',' expression ')';
multiplyExpression: 'Multiply' '(' expression ',' expression ')';
nearestWalkablePositionExpression: 'Nearest Walkable Position' '(' expression ')';
normalizeExpression: 'Normalize' '(' expression ')';
notExpression: 'Not' '(' expression ')';
numberOfDeadPlayersExpression: 'Number of Dead Players' '(' expression ')';
numberOfDeathsExpression: 'Number of Deaths' '(' expression ')';
numberOfEliminationsExpression: 'Number of Eliminations' '(' expression ')';
numberOfFinalBlowsExpression: 'Number of Final Blows' '(' expression ')';
numberOfHeroesExpression: 'Number of Heroes' '(' expression ',' expression ')';
numberOfLivingPlayersExpression: 'Number of Living Players' '(' expression ')';
numberOfPlayersExpression: 'Number of Players' '(' expression ')';
numberOfPlayersOnObjectiveExpression: 'Number of Players On Objective' '(' expression ')';
objectiveIndexExpression: 'Objective Index';
objectivePositionExpression: 'Objective Position' '(' expression ')';
oppositeTeamOfExpression: 'Opposite Team Of' '(' expression ')';
orExpression: 'Or' '(' expression ',' expression ')';
payloadPositionExpression: 'Payload Position';
payloadProgressPercentageExpression: 'Payload Progress Percentage';
playerCarryingFlagExpression: 'Player Carrying Flag' '(' expression ')';
playerClosestToReticleExpression: 'Player Closest To Reticle' '(' expression ',' expression ')';
playerVariableExpression: 'Player Variable' '(' expression ',' playerVariable ')';
playersInSlotExpression: 'Players In Slot' '(' expression ',' expression ')';
playersInViewAngleExpression: 'Players in View Angle' '(' expression ',' expression ',' expression ')';
playersOnHeroExpression: 'Players On Hero' '(' expression ',' expression ')';
playersWithinRadiusExpression: 'Players Within Radius' '(' expression ',' expression ',' expression ',' lineOfSightCheckType ')';
pointCapturePercentageExpression: 'Point Capture Percentage';
positionOfExpression: 'Position Of' '(' expression ')';
raiseToPowerExpression: 'Raise To Power' '(' expression ',' expression ')';
randomIntegerExpression: 'Random Integer' '(' expression ',' expression ')';
randomRealExpression: 'Random Real' '(' expression ',' expression ')';
randomValueInArrayExpression: 'Random Value In Array' '(' expression ')';
randomizedArrayExpression: 'Randomized Array' '(' expression ')';
rayCastHitNormalExpression: 'Ray Cast Hit Normal' '(' expression ',' expression ',' expression ',' expression ',' expression ')';
rayCastHitPlayerExpression: 'Ray Cast Hit Player' '(' expression ',' expression ',' expression ',' expression ',' expression ')';
rayCastHitPositionExpression: 'Ray Cast Hit Position' '(' expression ',' expression ',' expression ',' expression ',' expression ')';
removeFromArrayExpression: 'Remove From Array' '(' expression ',' expression ')';
rightExpression: 'Right';
roundToIntegerExpression: 'Round To Integer' '(' expression ',' roundingDirection ')';
scoreOfExpression: 'Score Of' '(' expression ')';
sineFromDegreesExpression: 'Sine From Degrees' '(' expression ')';
sineFromRadiansExpression: 'Sine From Radians' '(' expression ')';
slotOfExpression: 'Slot Of' '(' expression ')';
sortedArrayExpression: 'Sorted Array' '(' expression ',' expression ')';
speedOfExpression: 'Speed Of' '(' expression ')';
speedOfInDirectionExpression: 'Speed Of In Direction' '(' expression ',' expression ')';
squareRootExpression: 'Square Root' '(' expression ')';
stringExpression: 'String' '(' expression ',' expression ',' expression ',' expression ')';
subtractExpression: 'Subtract' '(' expression ',' expression ')';
teamOfExpression: 'Team Of' '(' expression ')';
teamScoreExpression: 'Team Score' '(' expression ')';
throttleOfExpression: 'Throttle Of' '(' expression ')';
totalTimeElapsedExpression: 'Total Time Elapsed';
ultimateChargePercentExpression: 'Ultimate Charge Percent' '(' expression ')';
upExpression: 'Up';
valueInArrayExpression: 'Value In Array' '(' expression ',' expression ')';
vectorTowardsExpression: 'Vector Towards' '(' expression ',' expression ')';
verticalFacingAngleOfExpression: 'Vertical Facing Angle Of' '(' expression ')';
verticalSpeedOfExpression: 'Vertical Speed Of' '(' expression ')';
victimExpression: 'Victim';
worldVectorOfExpression: 'World Vector Of' '(' expression ',' expression ',' vectorTransformationType ')';
xComponentOfExpression: 'X Component Of' '(' expression ')';
yComponentOfExpression: 'Y Component Of' '(' expression ')';
zComponentOfExpression: 'Z Component Of' '(' expression ')';
/*
Expression: '';
Expression: '';
Expression: '' '(' expression ')';
Expression: '' '(' expression ')';
Expression: '' '(' expression ',' expression ')';
Expression: '' '(' expression ',' expression ')';
Expression: '' '(' expression ',' expression ',' expression ')';
Expression: '' '(' expression ',' expression ',' expression ')';
Expression: '' '(' expression ',' expression ',' expression ',' expression ')';
Expression: '' '(' expression ',' expression ',' expression ',' expression ')';
*/


team: (ALL | ALL_TEAMS | Team1 | Team2);
ALL_TEAMS: 'All Teams';
Team1: 'Team 1';
Team2: 'Team 2';
playerConstant: (ALL | SLOT INTEGER | heroType);


literal: (INTEGER | FLOAT | STRING | NULL | BOOLEAN);
globalVariable: LETTER;
playerVariable: LETTER;


//Heroes
heroType: (reaper | tracer | mercy | hanzo | torbjorn | reinhardt | pharah | winston | widowmaker | bastion | symmetra | zenyatta | genji | roadhog | mcCree | junkrat | zarya | soldier76 | lucio | dva | mei | sombra | doomfist | ana | orisa | brigitte | moira | wreckingBall | ashe | baptiste);
reaper: 'Reaper';
tracer: 'Tracer';
mercy: 'Mercy';
hanzo: 'Hanzo';
torbjorn: 'Torbj\u00F6rn';
reinhardt: 'Reinhardt';
pharah: 'Pharah';
winston: 'Winston';
widowmaker: 'Widowmaker';
bastion: 'Bastion';
symmetra: 'Symmetra';
zenyatta: 'Zenyatta';
genji: 'Genji';
roadhog: 'Roadhog';
mcCree: 'McCree';
junkrat: 'Junkrat';
zarya: 'Zarya';
soldier76: 'Soldier: 76';
lucio: 'L\u00FAcio';
dva: 'D.Va';
mei: 'Mei';
sombra: 'Sombra';
doomfist: 'Doomfist';
ana: 'Ana';
orisa: 'Orisa';
brigitte: 'Brigitte';
moira: 'Moira';
wreckingBall: 'Wrecking Ball';
ashe: 'Ashe';
baptiste: 'Baptiste';

status: hacked | burning | knockedDown | asleep | frozen | unkillable | invincible | phasedOut | rooted | stunned;
hacked: 'Hacked';
burning: 'Burning';
knockedDown: 'Knocked Down';
asleep: 'Asleep';
frozen: 'Frozen';
unkillable: 'Unkillable';
invincible: 'Invincible';
phasedOut: 'Phased Out';
rooted: 'Rooted';
stunned: 'Stunned';

button: primaryFire | secondaryFire | ability1 | ability2 | ultimate | interact | jump | crouch;
primaryFire: 'Primary Fire';
secondaryFire: 'Secondary Fire';
ability1: 'Ability 1';
ability2: 'Ability 2';
ultimate: 'Ultimate';
interact: 'Interact';
jump: 'Jump';
crouch: 'Crouch';

communicationType
	: voiceLineUp
	| voiceLineLeft
	| voiceLineRight
	| voiceLineDown
	| emoteUp
	| emoteLeft
	| emoteRight
	| emoteDown
	| ultimateStatus
	| hello
	| needHealing
	| groupUp
	| thanks
	| acknowledge
	;
voiceLineUp: 'Voice Line Up';
voiceLineLeft: 'Voice Line Left';
voiceLineRight: 'Voice Line Right';
voiceLineDown: 'Voice Line Down';
emoteUp: 'Emote Up';
emoteLeft: 'Emote Left';
emoteRight: 'Emote Right';
emoteDown: 'Emote Down';
ultimateStatus: 'Ultimate Status';
hello: 'Hello';
needHealing: 'Need Healing';
groupUp: 'Group Up';
thanks: 'Thanks';
acknowledge: 'Acknowledge';

barrierBlockType: barriersDoNotBlockLOS | enemyBarriersBlockLOS | allBarriersBlockLOS;
barriersDoNotBlockLOS: 'Barriers Do Not Block LOS';
enemyBarriersBlockLOS: 'Enemy Barriers Block LOS';
allBarriersBlockLOS: 'All Barriers Block LOS';

vectorTransformationType: rotation | rotationAndTranslation;
rotation: 'Rotation';
rotationAndTranslation: 'Rotation And Translation';

lineOfSightCheckType: off | surfaces | surfacesAndEnemyBarriers | surfacesAndAllBarriers;
off: 'Off';
surfaces: 'Surfaces';
surfacesAndEnemyBarriers: 'Surfaces And Enemy Barriers';
surfacesAndAllBarriers: 'Surfaces And All Barriers';

roundingDirection: up | down | toNearest;
up: 'Up';
down: 'Down';
toNearest: 'To Nearest';

motionType: cancelContraryMotion | incorporateContraryMotion;
cancelContraryMotion: 'Cancel Contrary Motion';
incorporateContraryMotion: 'Incorporate Contrary Motion';

relativeTo: toWorld | toPlayer;
toWorld: 'To World';
toPlayer: 'To Player';

rateReevaluation: destinationAndRate | none;
destinationAndRate: 'Destination and Rate';

timeReevaluation: destinationAndDuration | none;
destinationAndDuration: 'Destination and Duration';
none: 'None';

effectShape
	: sphere
	| lightShaft
	| orb
	| ring
	| cloud
	| sparkles
	| goodAura
	| badAura
	| energySound
	| pickUpSound
	| goodAuraSound
	| badAuraSound
	| sparklesSound
	| smokeSound
	| decalSound
	| beaconSound
	;
sphere: 'Sphere';
lightShaft: 'Light Shaft';
orb: 'Orb';
ring: 'Ring';
cloud: 'Cloud';
sparkles: 'Sparkles';
goodAura: 'Good Aura';
badAura: 'Bad Aura';
energySound: 'Energy Sound';
pickUpSound: 'Pick-up Sound';
goodAuraSound: 'Good Aura Sound';
badAuraSound: 'Bad Aura Sound';
sparklesSound: 'Sparkles Sound';
smokeSound: 'Smoke Sound';
decalSound: 'Decal Sound';
beaconSound: 'Beacon Sound';

color: white | yellow | green | purple | red | blue | team1 | team2;
white: 'White';
yellow: 'Yellow';
green: 'Green';
purple: 'Purple';
red: 'Red';
blue: 'Blue';
team1: 'Team 1';
team2: 'Team 2';

createEffectReevaluation: visibleToPositionAndRadius | positionAandRadius | visibleTo | none;
visibleToPositionAndRadius: 'Visible To Position and Radius';
positionAandRadius: 'Position and Radius';
visibleTo: 'Visible To';

hudTextLocation: left | top | right;
left: 'Left';
top: 'Top';
right: 'Right';

hudTextReevaluation: visibleToAndString | string;
visibleToAndString: 'Visible To and String';
string: 'String';

icon
	: arrowDown
	| arrowLeft
	| arrowRight
	| arrowUp
	| asterisk
	| bolt
	| checkmark
	| circle
	| club
	| diamond
	| dizzy
	| exclamationMark
	| eye
	| fire
	| flag
	| halo
	| happy
	| heart
	| moon
	| no
	| plus
	| poison
	| poison2
	| questionMark
	| radioactive
	| recycle
	| ringThick
	| ringThin
	| sad
	| skull
	| spade
	| spiral
	| stop
	| trashcan
	| warning
	| x
	;
arrowDown: 'Arrow: Down';
arrowLeft: 'Arrow: Left';
arrowRight: 'Arrow: Right';
arrowUp: 'Arrow: Up';
asterisk: 'Asterisk';
bolt: 'Bolt';
checkmark: 'Checkmark';
circle: 'Circle';
club: 'Club';
diamond: 'Diamond';
dizzy: 'Dizzy';
exclamationMark: 'Exclamation Mark';
eye: 'Eye';
fire: 'Fire';
flag: 'Flag';
halo: 'Halo';
happy: 'Happy';
heart: 'Heart';
moon: 'Moon';
no: 'No';
plus: 'Plus';
poison: 'Poison';
poison2: 'Poison 2';
questionMark: 'Question Mark';
radioactive: 'Radioactive';
recycle: 'Recycle';
ringThick: 'Ring Thick';
ringThin: 'Ring Thin';
sad: 'Sad';
skull: 'Skull';
spade: 'Spade';
spiral: 'Spiral';
stop: 'Stop';
trashcan: 'Trashcan';
warning: 'Warning';
x: 'X';

modification
	: add
	| subtract
	| multiply
	| divide
	| modulo
	| raiseToPower
	| min
	| max
	| appendToArray
	| removeFromArrayByValue
	| removeFromArrayByIndex
	;
add: 'Add';
subtract: 'Subtract';
multiply: 'Multiply';
divide: 'Divide';
modulo: 'Modulo';
raiseToPower: 'Raise To Power';
min: 'Min';
max: 'Max';
appendToArray: 'Append To Array';
removeFromArrayByValue: 'Remove From Array By Value';
removeFromArrayByIndex: 'Remove From Array By Index';

animatedEffect
	: goodExplosion
	| badExplosion
	| ringExplosion
	| goodPickupEffect
	| badPickupEffect
	| debuffImpactSound
	| buffImpactSound
	| ringExplosionSound
	| buffExplosionSound
	| explosionSound
	;
goodExplosion: 'Good Explosion';
badExplosion: 'Bad Explosion';
ringExplosion: 'Ring Explosion';
goodPickupEffect: 'Good Pickup Effect';
badPickupEffect: 'Bad Pickup Effect';
debuffImpactSound: 'Debuff Impact Sound';
buffImpactSound: 'Buff Impact Sound';
ringExplosionSound: 'Ring Explosion Sound';
buffExplosionSound: 'Buff Explosion Sound';
explosionSound: 'Explosion Sound';



iconReevaluation: visibleToAndPosition | position | visibleTo | none ;
visibleToAndPosition: 'Visible To and Position';
position: 'Position';

inWorldTextClipping: clipAgainstSurfaces | doNotClip;
clipAgainstSurfaces: 'Clip Against Surfaces';
doNotClip: 'Do Not Clip';

inWorldTextReevaluation: visibleToPositionAndString | visibleToAndString | string;
visibleToPositionAndString: 'Visible To Position and String';

binaryCompartorOperator: '==' | '!=' | '<' | '<=' | '>' | '>=';

LETTER: [A-Z];
INTEGER: [0-9]+;//Todo: Negative numbers
SLOT: 'Slot';
ALL: 'All';
STRING : '"' ( '\\"' | . )*? '"';
FLOAT: '-'? [0-9]+ ('.' [0-9]+)?;
NULL: 'Null';
BOOLEAN: 'True' | 'False';

WS : ( ' ' | '\t' | '\r' | '\n' ) -> channel(HIDDEN);
ERROR_CHAR : .;