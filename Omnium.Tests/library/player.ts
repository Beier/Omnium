import { Native } from "./Native"
import { Vector } from "./Vector"
import { List } from "./List"
import { Team, Teams } from "./Team"
import { Hero } from "./Hero"
import { Motion } from "./motion"

export class Player {
    private constructor() { }

    public vars<T extends Native.PlayerVars>(): T {
        return Native.playerVars<T>(this);
    }

    public get altitude() {
        return Native.callNativeArg1Function<Player, number>("Altitude Of", true, false, this);
    }

    public get isAlive() {
        return Native.callNativeArg1Function<Player, boolean>("Is alive", true, false, this);
    }

    public get isDead() {
        return Native.callNativeArg1Function<Player, boolean>("Is dead", true, false, this);
    }

    public get isInAir() {
        return Native.callNativeArg1Function<Player, boolean>("Is in air", true, false, this);
    }

    public get isOnGround() {
        return Native.callNativeArg1Function<Player, boolean>("Is on ground", true, false, this);
    }

    public get isOnWall() {
        return Native.callNativeArg1Function<Player, boolean>("Is on wall", true, false, this);
    }

    public get isOnObjective() {
        return Native.callNativeArg1Function<Player, boolean>("Is on objective", true, false, this);
    }

    public get isMoving() {
        return Native.callNativeArg1Function<Player, boolean>("Is moving", true, false, this);
    }

    public get isPortraitOnFire() {
        return Native.callNativeArg1Function<Player, boolean>("Is portrait on fire", true, false, this);
    }

    public get isInSpawnRoom() {
        return Native.callNativeArg1Function<Player, boolean>("Is in spawn room", true, false, this);
    }

    public get isFiringPrimary() {
        return Native.callNativeArg1Function<Player, boolean>("Is firing primary", true, false, this);
    }

    public get isFiringSecondary() {
        return Native.callNativeArg1Function<Player, boolean>("Is firing secondary", true, false, this);
    }

    public get isCrouching() {
        return Native.callNativeArg1Function<Player, boolean>("Is crouching", true, false, this);
    }

    public get isStanding() {
        return Native.callNativeArg1Function<Player, boolean>("Is standing", true, false, this);
    }

    public get isUsingAbility1() {
        return Native.callNativeArg1Function<Player, boolean>("Is using ability 1", true, false, this);
    }

    public get isUsingAbility2() {
        return Native.callNativeArg1Function<Player, boolean>("Is using ability 2", true, false, this);
    }

    public get isUsingUltimate() {
        return Native.callNativeArg1Function<Player, boolean>("Is using ultimate", true, false, this);
    }

    public get health() {
        return Native.callNativeArg1Function<Player, number>("Health", true, false, this);
    }

    public get healthFraction() {
        return Native.callNativeArg1Function<Player, number>("Normalized health", true, false, this);
    }

    public get maxHealth() {
        return Native.callNativeArg1Function<Player, number>("Max health", true, false, this);
    }

    public isHoldingButton(button: Button) {
        return Native.callNativeArg2Function<Player, Button, boolean>("Is Button Held", true, false, this, button);
    }

    public get position() {
        return Native.callNativeArg1Function<Player, Vector>("Position of", true, false, this);
    }

    public get horizontalSpeed() {
        return Native.callNativeArg1Function<Player, number>("Horizontal speed of", true, false, this);
    }

    public get verticalSpeed() {
        return Native.callNativeArg1Function<Player, number>("Vertical speed of", true, false, this);
    }

    public get speed() {
        return Native.callNativeArg1Function<Player, number>("Speed of", true, false, this);
    }

    public getSpeedInDirection(direction: Vector) {
        return Native.callNativeArg2Function<Player, Vector, number>("Speed of in direction", true, false, this, direction);
    }

    public get eyePosition() {
        return Native.callNativeArg1Function<Player, Vector>("Eye position", true, false, this);
    }

    public get horizontalFacingAngle() {
        return Native.callNativeArg1Function<Player, number>("Horizontal facing angle of", true, false, this);
    }

    public get verticalFacingAngle() {
        return Native.callNativeArg1Function<Player, number>("Vertical facing angle of", true, false, this);
    }

    public get facingDirection() {
        return Native.callNativeArg1Function<Player, Vector>("Facing direction of", true, false, this);
    }

    public set facingDirection(direction: Vector) {
        Facing.set(this, direction);
    }

    public setFacingDirectionAtRate(direction: Vector, turnRate: number) {
        Facing.setAtRate(this, direction, turnRate);
    }

    public stopEnforcingFacingDirection() {
        Facing.stop(this);
    }

    public setButtonEnabled(button: Button, isEnabled: boolean) {
        if (isEnabled)
            this.allowButton(button);
        else
            this.disallowButton(button);
    }

    public holdButton(button: Button) {
        Native.callNativeArg2Action<Player, Button>("Start holding button", false, true, this, button);
    }

    public stopHoldingButton(button: Button) {
        Native.callNativeArg2Action<Player, Button>("Stop holding button", false, true, this, button);
    }

    public setPrimaryFireEnabled(isEnabled: boolean) {
        Native.callNativeArg2Action<Player, boolean>("Set primary fire enabled", false, true, this, isEnabled);
    }

    public setSecondaryFireEnabled(isEnabled: boolean) {
        Native.callNativeArg2Action<Player, boolean>("Set secondary fire enabled", false, true, this, isEnabled);
    }

    public setAbility1Enabled(isEnabled: boolean) {
        Native.callNativeArg2Action<Player, boolean>("Set ability 1 enabled", false, true, this, isEnabled);
    }

    public setAbility2Enabled(isEnabled: boolean) {
        Native.callNativeArg2Action<Player, boolean>("Set ability 2 enabled", false, true, this, isEnabled);
    }

    public setUltimateEnabled(isEnabled: boolean) {
        Native.callNativeArg2Action<Player, boolean>("Set ultimate ability enabled", false, true, this, isEnabled);
    }

    public allowButton(button: Button) {
        Native.callNativeArg2Action<Player, Button>("Allow button", false, true, this, button);
    }

    public disallowButton(button: Button) {
        Native.callNativeArg2Action<Player, Button>("Disallow button", false, true, this, button);
    }

    public pressButton(button: Button) {
        Native.callNativeArg2Action<Player, Button>("Press button", false, true, this, button);
    }

    public setStatus(statusEffect: StatusEffect, seconds: number, assister: Player = null) {
        Native.callNativeArg4Action<Player, Player, StatusEffect, number>("Set status", false, true, this, assister, statusEffect, seconds);
    }

    public clearStatus(statusEffect: StatusEffect) {
        Native.callNativeArg2Action<Player, StatusEffect>("Clear status", false, true, this, statusEffect);
    }

    public get isHacked() {
        return this.hasStatus(StatusEffect.Hacked);
    }

    public get isBurning() {
        return this.hasStatus(StatusEffect.Burning);
    }

    public get isKnockedDown() {
        return this.hasStatus(StatusEffect.KnockedDown);
    }

    public get isAsleep() {
        return this.hasStatus(StatusEffect.ASleep);
    }

    public get isFrozen() {
        return this.hasStatus(StatusEffect.Frozen);
    }

    public get isUnkillable() {
        return this.hasStatus(StatusEffect.Unkillable);
    }

    public get isInvincible() {
        return this.hasStatus(StatusEffect.Invincible);
    }

    public get isPhasedOut() {
        return this.hasStatus(StatusEffect.PhasedOut);
    }

    public get isRooted() {
        return this.hasStatus(StatusEffect.Rooted);
    }

    public get isStunned() {
        return this.hasStatus(StatusEffect.Stunned);
    }

    public hasStatus(statusEffect: StatusEffect) {
        return Native.callNativeArg2Function<Player, StatusEffect, boolean>("Has status", true, false, this, statusEffect);
    }

    public isUsingEmoteOrVoiceLine() {
        return Native.callNativeArg1Function<Player, boolean>("Is communicating any", false, true, this);
    }

    public isUsingVoiceLine(voiceLine: VoiceLine = null) {
        if (voiceLine == null)
            return Native.callNativeArg1Function<Player, boolean>("Is communicating any voice line", false, true, this);
        else
            return Native.callNativeArg2Function<Player, VoiceLine, boolean>("Is communicating", false, true, this, voiceLine);
    }

    public useVoiceLine(voiceLine: VoiceLine) {
        Native.callNativeArg2Action<Player, VoiceLine>("Communicate", false, true, this, voiceLine);
    }

    public isUsingEmote(emote: Emote = null) {
        if (emote == null)
            return Native.callNativeArg1Function<Player, boolean>("Is communicating any emote", false, true, this);
        else
            return Native.callNativeArg2Function<Player, Emote, boolean>("Is communicating", false, true, this, emote);
    }

    public useEmote(emote: Emote) {
        Native.callNativeArg2Action<Player, Emote>("Communicate", false, true, this, emote);
    }

    public damage(amount: number, damager: Player = null) {
        Native.callNativeArg3Action<Player, Player, number>("Damage", false, true, this, damager, amount);
    }

    public heal(amount: number, healer: Player = null) {
        Native.callNativeArg3Action<Player, Player, number>("Heal", false, true, this, healer, amount);
    }

    public kill(killer: Player = null) {
        Native.callNativeArg2Action<Player, Player>("Kill", false, true, this, killer);
    }

    public respawn() {
        Native.callNativeArg1Action<Player>("Respawn", false, true, this);
    }

    public resurrect() {
        Native.callNativeArg1Action<Player>("Resurrect", false, true, this);
    }

    public set aimSpeedPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set aim speed", false, true, this, value);
    }

    public set damageDealtPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set damage dealt", false, true, this, value);
    }

    public set damageReceivedPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set damage received", false, true, this, value);
    }

    public set healingDealtPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set healing dealt", false, true, this, value);
    }

    public set healingReceivedPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set healing received", false, true, this, value);
    }

    public set maxHealthPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set max health", false, true, this, value);
    }

    public set movementSpeedPercentage(value: number) {
        Native.callNativeArg2Action<Player, number>("Set move speed", false, true, this, value);
    }

    public get score() {
        return Native.callNativeArg1Function<Player, number>("Score of", true, false, this);
    }

    public set score(value: number) {
        Native.callNativeArg2Action<Player, number>("Set player score", false, true, this, value);
    }

    public makeInvisibleTo(invisibleTo: InvisibleTo) {
        Native.callNativeArg2Action<Player, InvisibleTo>("Set invisible", false, true, this, invisibleTo);
    }

    public get allowedHeroes() {
        return Native.callNativeArg1Function<Player, List<Hero>>("Allowed Heroes", true, false, this);
    }

    public set allowedHeroes(heroes: List<Hero>) {
        Native.callNativeArg2Action<Player, List<Hero>>("Set player allowed heroes", false, true, this, heroes);
    }

    public get hero() {
        return Native.callNativeArg1Function<Player, Hero>("Hero of", true, false, this);
    }

    public set hero(hero: Hero) {
        if (hero == null)
            Native.callNativeArg1Action<Player>("Stop forcing player to be hero", false, true, this);
        else
            Native.callNativeArg2Action<Player, Hero>("Start forcing player to be hero", false, true, this, hero);
    }

    public set ultimateCharge(percentage: number) {
        Native.callNativeArg2Action<Player, number>("Set ultimate charge", false, true, this, percentage);
    }

    public startCamera(eyePosition: Vector, lookAtPosition: Vector, blendSpeed: number) {
        Native.callNativeArg4Action<Player, Vector, Vector, number>("Start camera", false, true, this, eyePosition, lookAtPosition, blendSpeed);
    }


    public stopCamera() {
        Native.callNativeArg1Action<Player>("Stop camera", false, true, this);
    }

    public damageOverTime(damagePerSecond: number, seconds: number, damagers: Player | List<Player> = null) {
        return DamageOverTime.start(damagePerSecond, seconds, this, damagers);
    }

    public healOverTime(healingPerSecond: number, seconds: number, damagers: Player | List<Player> = null) {
        return HealOverTime.start(healingPerSecond, seconds, this, damagers);
    }

    public get throttle() {
        return Native.callNativeArg1Function<Player, Vector>("Throttle of", true, false, this);
    }

    public forceThrottle(minForward: number,
        maxForward: number,
        minBackward: number,
        maxBackward: number,
        minSideways: number,
        maxSideways: number) {
        Native.callNativeArg7Action
            <Player, number, number, number, number, number, number>(
                "Start forcing throttle", false, true, this, minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways);
    }

    public stopForcingThrottle() {
        Native.callNativeArg1Action<Player>("Stop forcing throttle", false, true, this);
    }

    public startAccelerating(direction: Vector, rate: number, maxSpeed: number) {
        Motion.startAccelerating(this, direction, rate, maxSpeed);
    }

    public stopAccelerating() {
        Motion.stopAccelerating(this);
    }

    public teleportTo(position: Vector) {
        Native.callNativeArg2Action<Player, Vector>("Teleport", false, true, this, position);
    }

    public static closestTo(position: Vector, team: Team | List<Team> = Teams.all) {
        return Native.callNativeArg2Function<Vector, Team | List<Team>, Player>("Closest player to", true, false, position, team);
    }

    public static farthestFrom(position: Vector, team: Team | List<Team> = Teams.all) {
        return Native.callNativeArg2Function<Vector, Team | List<Team>, Player>("Farthest player from", true, false, position, team);
    }

    public get exists() {
        return Native.callNativeArg1Function<Player, boolean>("Entity exists", true, false, this);
    }

    public get hasSpawned() {
        return Native.callNativeArg1Function<Player, boolean>("Has spawned", true, false, this);
    }

    public horizontalAngleTowards(position: Vector) {
        return Native.callNativeArg2Function<Player, Vector, number>("Horizontal angle towards", false, false, this, position);
    }

    public verticalAngleTowards(position: Vector) {
        return Native.callNativeArg2Function<Player, Vector, number>("Vertical angle towards", false, false, this, position);
    }

    public isLookingAt(position: Vector, viewConeAngle: number) {
        return Native.callNativeArg3Function<Player, Vector, number, boolean>("Is in view angle", false, false, this, position, viewConeAngle);
    }

    public get deaths() {
        return Native.callNativeArg1Function<Player, number>("Number of deaths", true, false, this);
    }

    public get kills() {
        return Native.callNativeArg1Function<Player, number>("Number of eliminations", true, false, this);
    }

    public get finalBlows() {
        return Native.callNativeArg1Function<Player, number>("Number of final blows", true, false, this);
    }

    public get slot() {
        return Native.callNativeArg1Function<Player, number>("Slot of", true, false, this);
    }

    public static closestToReticle(player: Player, team: Team | List<Team> = Teams.all) {
        return Native.callNativeArg2Function<Player, Team | List<Team>, Player>("Player closest to reticle", true, false, player, team);
    }

    public get team() {
        return Native.callNativeArg1Function<Player, Team>("Team of", true, false, this);
    }

    public get ultimateCharge() {
        return Native.callNativeArg1Function<Player, number>("Ultimate charge percent", true, false, this);
    }

    public get velocity() {
        return Native.callNativeArg1Function<Player, number>("Velocity of", true, false, this);
    }
}

export enum InvisibleTo {
    Everyone = "All",
    Enemies = "Enemies",
    NoOne = "None",
}

export class Players {
    private constructor() { }

    public static count() {
        return Native.callNativeArg1Function<List<Team>, number>("Number of players", true, false, Teams.all);
    }

    public static countOnObjective() {
        return Native.callNativeArg1Function<List<Team>, number>("Number of players on objective", true, false, Teams.all);
    }

    public static dead() {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("All Dead Players", true, false, Teams.all);
    }

    public static countDead() {
        return Native.callNativeArg1Function<List<Team>, number>("Number of dead players", true, false, Teams.all);
    }

    public static living() {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("All Living Players", true, false, Teams.all);
    }

    public static countLiving() {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("Number of Living Players", true, false, Teams.all);
    }

    public static onTeam(team: Team | List<Team>) {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players", true, false, team);
    }

    public static get all() {
        return Players.onTeam(Teams.all);
    }

    public static notOnObjectiveFromTeam(team: Team | List<Team>) {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players Not On Objective", true, false, team);
    }

    public static onObjectiveFromTeam(team: Team | List<Team>) {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players On Objective", true, false, team);
    }

    public static beingLookedAtBy(player: Player, team: Team | List<Team>, viewConeAngle: number) {
        return Native.callNativeArg3Function<Player, Team | List<Team>, number, List<Player>>("Players in view angle", true, false, player, team, viewConeAngle);
    }

    public static playingHero(hero: Hero, team: Team | List<Team> = Teams.all) {
        return Native.callNativeArg2Function<Hero, Team | List<Team>, List<Player>>("Players on hero", true, false, hero, team);
    }

    public static withinRadius(position: Vector, radius: number, team: Team | List<Team> = Teams.all, lineOfSightCheck: LineOfSightCheck = LineOfSightCheck.Off) {
        return Native.callNativeArg4Function<Vector, number, Team | List<Team>, LineOfSightCheck, List<Player>>("Players within radius", true, false, position, radius, team, lineOfSightCheck);
    }






    public static setFacingDirectionForAll(players: List<Player>, direction: Vector) {
        Facing.set(players, direction);
    }

    public static setFacingDirectionForAllAtRate(players: List<Player>, direction: Vector, turnRate: number) {
        Facing.setAtRate(players, direction, turnRate);
    }

    public static stopEnforcingFacingDirectionForAll(players: List<Player>) {
        Facing.stop(players);
    }

    public static setButtonEnabledForAll(players: List<Player>, button: Button, isEnabled: boolean) {
        if (isEnabled)
            Players.allowButtonForAll(players, button);
        else
            Players.disallowButtonForAll(players, button);
    }

    public static holdButtonForAll(players: List<Player>, button: Button) {
        Native.callNativeArg2Action<List<Player>, Button>("Start holding button", false, true, players, button);
    }

    public static stopHoldingButtonForAll(players: List<Player>, button: Button) {
        Native.callNativeArg2Action<List<Player>, Button>("Stop holding button", false, true, players, button);
    }

    public static setPrimaryFireEnabledForAll(players: List<Player>, isEnabled: boolean) {
        Native.callNativeArg2Action<List<Player>, boolean>("Set primary fire enabled", false, true, players, isEnabled);
    }

    public static setSecondaryFireEnabledForAll(players: List<Player>, isEnabled: boolean) {
        Native.callNativeArg2Action<List<Player>, boolean>("Set secondary fire enabled", false, true, players, isEnabled);
    }

    public static setAbility1EnabledForAll(players: List<Player>, isEnabled: boolean) {
        Native.callNativeArg2Action<List<Player>, boolean>("Set ability 1 enabled", false, true, players, isEnabled);
    }

    public static setAbility2EnabledForAll(players: List<Player>, isEnabled: boolean) {
        Native.callNativeArg2Action<List<Player>, boolean>("Set ability 2 enabled", false, true, players, isEnabled);
    }

    public static setUltimateEnabledForAll(players: List<Player>, isEnabled: boolean) {
        Native.callNativeArg2Action<List<Player>, boolean>("Set ultimate ability enabled", false, true, players, isEnabled);
    }

    public static allowButtonForAll(players: List<Player>, button: Button) {
        Native.callNativeArg2Action<List<Player>, Button>("Allow button", false, true, players, button);
    }

    public static disallowButtonForAll(players: List<Player>, button: Button) {
        Native.callNativeArg2Action<List<Player>, Button>("Disallow button", false, true, players, button);
    }

    public static pressButtonForAll(players: List<Player>, button: Button) {
        Native.callNativeArg2Action<List<Player>, Button>("Press button", false, true, players, button);
    }

    public static setStatusForAll(players: List<Player>, statusEffect: StatusEffect, seconds: number, assister: Player = null) {
        Native.callNativeArg4Action<List<Player>, Player, StatusEffect, number>("Set status", false, true, players, assister, statusEffect, seconds);
    }

    public static clearStatusForAll(players: List<Player>, statusEffect: StatusEffect) {
        Native.callNativeArg2Action<List<Player>, StatusEffect>("Clear status", false, true, players, statusEffect);
    }
   
    public static useEmoteForAll(players: List<Player>, emote: Emote) {
        Native.callNativeArg2Action<List<Player>, Emote>("Communicate", false, true, players, emote);
    }

    public static damageAll(players: List<Player>, amount: number, damager: Player = null) {
        Native.callNativeArg3Action<List<Player>, Player, number>("Damage", false, true, players, damager, amount);
    }

    public static healAll(players: List<Player>, amount: number, healer: Player = null) {
        Native.callNativeArg3Action<List<Player>, Player, number>("Heal", false, true, players, healer, amount);
    }

    public static killAll(players: List<Player>, killer: Player = null) {
        Native.callNativeArg2Action<List<Player>, Player>("Kill", false, true, players, killer);
    }

    public static respawnAll(players: List<Player>) {
        Native.callNativeArg1Action<List<Player>>("Respawn", false, true, players);
    }

    public static resurrectAll(players: List<Player>) {
        Native.callNativeArg1Action<List<Player>>("Resurrect", false, true, players);
    }

    public static setAimSpeedPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set aim speed", false, true, players, value);
    }

    public static setDamageDealtPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set damage dealt", false, true, players, value);
    }

    public static setDamageReceivedPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set damage received", false, true, players, value);
    }

    public static setHealingDealtPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set healing dealt", false, true, players, value);
    }

    public static setHealingReceivedPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set healing received", false, true, players, value);
    }

    public static setMaxHealthPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set max health", false, true, players, value);
    }

    public static setMovementSpeedPercentageForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set move speed", false, true, players, value);
    }

    public static setScoreForAll(players: List<Player>, value: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set player score", false, true, players, value);
    }

    public static makeAllInvisibleTo(players: List<Player>, invisibleTo: InvisibleTo) {
        Native.callNativeArg2Action<List<Player>, InvisibleTo>("Set invisible", false, true, players, invisibleTo);
    }

    public static setAllowedHeroesForAll(players: List<Player>, heroes: List<Hero>) {
        Native.callNativeArg2Action<List<Player>, List<Hero>>("Set player allowed heroes", false, true, players, heroes);
    }

    public static setHeroForAll(players: List<Player>, hero: Hero) {
        if (hero == null)
            Native.callNativeArg1Action<List<Player>>("Stop forcing player to be hero", false, true, players);
        else
            Native.callNativeArg2Action<List<Player>, Hero>("Start forcing player to be hero", false, true, players, hero);
    }

    public static setUltimateChargeForAll(players: List<Player>, percentage: number) {
        Native.callNativeArg2Action<List<Player>, number>("Set ultimate charge", false, true, players, percentage);
    }

    public static startCameraForAll(players: List<Player>, eyePosition: Vector, lookAtPosition: Vector, blendSpeed: number) {
        Native.callNativeArg4Action<List<Player>, Vector, Vector, number>("Start camera", false, true, players, eyePosition, lookAtPosition, blendSpeed);
    }

    public static stopCameraForAll(players: List<Player>) {
        Native.callNativeArg1Action<List<Player>>("Stop camera", false, true, players);
    }

    public static damageAllOverTime(players: List<Player>, damagePerSecond: number, seconds: number, damagers: Player | List<Player> = null) {
        return DamageOverTime.start(damagePerSecond, seconds, players, damagers);
    }

    public static healAllOverTime(players: List<Player>, healingPerSecond: number, seconds: number, damagers: Player | List<Player> = null) {
        return HealOverTime.start(healingPerSecond, seconds, players, damagers);
    }
    
    public static forceThrottleForAll(players: List<Player>,
        minForward: number,
        maxForward: number,
        minBackward: number,
        maxBackward: number,
        minSideways: number,
        maxSideways: number) {
        Native.callNativeArg7Action
            <List<Player>, number, number, number, number, number, number>(
                "Start forcing throttle", false, true, players, minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways);
    }

    public static stopForcingThrottleForAll(players: List<Player>) {
        Native.callNativeArg1Action<List<Player>>("Stop forcing throttle", false, true, players);
    }

    public static startAcceleratingForAll(players: List<Player>, direction: Vector, rate: number, maxSpeed: number) {
        Motion.startAccelerating(players, direction, rate, maxSpeed);
    }

    public static stopAcceleratingForAll(players: List<Player>) {
        Motion.stopAccelerating(players);
    }

    public static teleportAll(players: List<Player>, position: Vector) {
        Native.callNativeArg2Action<List<Player>, Vector>("Teleport", false, true, players, position);
    }
}

export enum Button {
    PrimaryFire = "Primary Fire",
    SecondaryFire = "Secondary Fire",
    Ability1 = "Ability 1",
    Ability2 = "Ability 2",
    Ultimate = "Ultimate",
    Interact = "Interact",
    Jump = "Jump",
    Crouch = "Crouch",
}

export enum StatusEffect {
    Hacked = "Hacked",
    Burning = "Burning",
    KnockedDown = "Knocked Down",
    ASleep = "ASleep",
    Frozen = "Frozen",
    Unkillable = "Unkillable",
    Invincible = "Invincible",
    PhasedOut = "Phased Out",
    Rooted = "Rooted",
    Stunned = "Stunned",
}

export enum VoiceLine {
    Up = "Voice Line up",
    Down = "Voice Line down",
    Left = "Voice Line left",
    Right = "Voice Line right",
    UltimateStatus = "Ultimate status",
    Hello = "Hello",
    NeedHealing = "Need healing",
    GroupUp = "Group up",
    Thanks = "Thanks",
    Acknowledge = "Acknowledge"
}

export enum Emote {
    Up = "Emote up",
    Down = "Emote down",
    Left = "Emote left",
    Right = "Emote right"
}

export enum LineOfSightCheck {
    Off = "Off",
    Surfaces = "Surfaces",
    SurfacesAndEnemyBarriers = "Surfaces and enemy barriers",
    SurfacesAndBarriers = "Surfaces and all barriers"
}

export module DamageModification {
    export class DamageModification {
        public stop() {
            Native.callNativeArg1Action<DamageModification>("Stop damage modification", false, true, this);
        }
    }

    export function start(receivers: Player | List<Player>, damagers: Player | List<Player>, percentage: number, reevaluation: Reevaluation = Reevaluation.None) {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, Reevaluation>(
                "Start damage modification", false, true, receivers, damagers, percentage, reevaluation);
        return getLastCreated();
    }

    export function getLastCreated() {
        return Native.callNativeArg0Function<DamageModification>("Last damage modification", true, false);
    }

    export function stopAll() {
        Native.callNativeArg0Action("Stop all damage modifications", false, true);
    }

    export enum Reevaluation {
        All = "Receivers, damagers, and damage percent",
        Players = "Receivers and damagers",
        None = "None"
    }
}

export module DamageOverTime {
    export class DamageOverTime {
        public stop() {
            Native.callNativeArg1Action<DamageOverTime>("Stop damage over time", false, true, this);
        }
    }

    export function start(damagePerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null) {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start damage over time", false, true, receivers, damagers, seconds, damagePerSecond);
        return getLastCreated();
    }

    export function getLastCreated() {
        return Native.callNativeArg0Function<DamageOverTime>("Last damage over time ID", true, false);
    }

    export function stopAll() {
        Native.callNativeArg0Action("Stop all damage over time", false, true);
    }
}

export module HealOverTime {
    export class HealOverTime {
        public stop() {
            Native.callNativeArg1Action<HealOverTime>("Stop heal over time", false, true, this);
        }
    }

    export function start(healingPerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null) {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start heal over time", false, true, receivers, damagers, seconds, healingPerSecond);
        return getLastCreated();
    }

    export function getLastCreated() {
        return Native.callNativeArg0Function<HealOverTime>("Last heal over time ID", true, false);
    }

    export function stopAll() {
        Native.callNativeArg0Action("Stop all heal over time", false, true);
    }
}

export module Facing {
    export function set(player: Player | List<Player>, value: Vector, relative: Relative = Relative.ToWorld) {
        Native.callNativeArg3Action<Player | List<Player>, Vector, Relative>("Set facing", false, true, player, value, relative);
    }

    export function setAtRate(player: Player | List<Player>, value: Vector, turnRate: number, relativeTo: Relative = Relative.ToWorld, reevaluation: Reevaluation = Reevaluation.None) {
        Native.callNativeArg5Action
            <Player | List<Player>, Vector, number, Relative, Reevaluation>
            ("Start facing", false, true, player, value, turnRate, relativeTo, reevaluation);
    }

    export function stop(player: Player | List<Player>) {
        Native.callNativeArg1Action<Player | List<Player>>("Stop facing", false, true, player);
    }


    //Todo: duplicated
    export enum Relative {
        ToWorld = "To world",
        ToPlayer = "To player"
    }

    export enum Reevaluation {
        DirectionAndTurnRate = "Direction and turn rate",
        None = "None"
    }
}