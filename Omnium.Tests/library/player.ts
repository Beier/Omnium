import { Native } from "./Native"
import { Vector } from "./Vector"
import { List } from "./List"
import { Team, Teams } from "./Team"
import { Hero } from "./Hero"
import { Motion } from "./motion"

export class Player {
    private constructor() { }

    public get altitude(): number {
        return Native.callNativeArg1Function<Player, number>("Altitude Of", true, false, this);
    }

    public get isAlive(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is alive", true, false, this);
    }

    public get isDead(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is dead", true, false, this);
    }

    public get isInAir(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is in air", true, false, this);
    }

    public get isOnGround(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is on ground", true, false, this);
    }

    public get isOnWall(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is on wall", true, false, this);
    }

    public get isOnObjective(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is on objective", true, false, this);
    }

    public get isMoving(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is moving", true, false, this);
    }

    public get isPortraitOnFire(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is portrait on fire", true, false, this);
    }

    public get isInSpawnRoom(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is in spawn room", true, false, this);
    }

    public get isFiringPrimary(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is firing primary", true, false, this);
    }

    public get isFiringSecondary(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is firing secondary", true, false, this);
    }

    public get isCrouching(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is crouching", true, false, this);
    }

    public get isStanding(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is standing", true, false, this);
    }

    public get isUsingAbility1(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is using ability 1", true, false, this);
    }

    public get isUsingAbility2(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is using ability 2", true, false, this);
    }

    public get isUsingUltimate(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is using ultimate", true, false, this);
    }

    public get health(): number {
        return Native.callNativeArg1Function<Player, number>("Health", true, false, this);
    }

    public get healthFraction(): number {
        return Native.callNativeArg1Function<Player, number>("Normalized health", true, false, this);
    }

    public get maxHealth(): number {
        return Native.callNativeArg1Function<Player, number>("Max health", true, false, this);
    }

    public isHoldingButton(button: Button): boolean {
        return Native.callNativeArg2Function<Player, Button, boolean>("Is Button Held", true, false, this, button);
    }

    public get position(): Vector {
        return Native.callNativeArg1Function<Player, Vector>("Position of", true, false, this);
    }

    public get horizontalSpeed(): number {
        return Native.callNativeArg1Function<Player, number>("Horizontal speed of", true, false, this);
    }

    public get verticalSpeed(): number {
        return Native.callNativeArg1Function<Player, number>("Vertical speed of", true, false, this);
    }

    public get speed(): number {
        return Native.callNativeArg1Function<Player, number>("Speed of", true, false, this);
    }

    public getSpeedInDirection(direction: Vector): number {
        return Native.callNativeArg2Function<Player, Vector, number>("Speed of in direction", true, false, this, direction);
    }

    public get eyePosition(): Vector {
        return Native.callNativeArg1Function<Player, Vector>("Eye position", true, false, this);
    }

    public get horizontalFacingAngle(): number {
        return Native.callNativeArg1Function<Player, number>("Horizontal facing angle of", true, false, this);
    }

    public get verticalFacingAngle(): number {
        return Native.callNativeArg1Function<Player, number>("Vertical facing angle of", true, false, this);
    }

    public get facingDirection(): Vector {
        return Native.callNativeArg1Function<Player, Vector>("Facing direction of", true, false, this);
    }

    public set facingDirection(direction: Vector) {
        Facing.set(this, direction);
    }

    public setFacingDirectionAtRate(direction: Vector, turnRate: number): void {
        Facing.setAtRate(this, direction, turnRate);
    }

    public stopEnforcingFacingDirection(): void {
        Facing.stop(this);
    }

    public setButtonEnabled(button: Button, isEnabled: boolean): void {
        if (isEnabled)
            this.allowButton(button);
        else
            this.disallowButton(button);
    }

    public holdButton(button: Button): void {
        Native.callNativeArg2Action<Player, Button>("Start holding button", false, true, this, button);
    }

    public stopHoldingButton(button: Button): void {
        Native.callNativeArg2Action<Player, Button>("Stop holding button", false, true, this, button);
    }

    public setPrimaryFireEnabled(isEnabled: boolean): void {
        Native.callNativeArg2Action<Player, boolean>("Set primary fire enabled", false, true, this, isEnabled);
    }

    public setSecondaryFireEnabled(isEnabled: boolean): void {
        Native.callNativeArg2Action<Player, boolean>("Set secondary fire enabled", false, true, this, isEnabled);
    }

    public setAbility1Enabled(isEnabled: boolean): void {
        Native.callNativeArg2Action<Player, boolean>("Set ability 1 enabled", false, true, this, isEnabled);
    }

    public setAbility2Enabled(isEnabled: boolean): void {
        Native.callNativeArg2Action<Player, boolean>("Set ability 2 enabled", false, true, this, isEnabled);
    }

    public setUltimateEnabled(isEnabled: boolean): void {
        Native.callNativeArg2Action<Player, boolean>("Set ultimate ability enabled", false, true, this, isEnabled);
    }

    public allowButton(button: Button): void {
        Native.callNativeArg2Action<Player, Button>("Allow button", false, true, this, button);
    }

    public disallowButton(button: Button): void {
        Native.callNativeArg2Action<Player, Button>("Disallow button", false, true, this, button);
    }

    public pressButton(button: Button): void {
        Native.callNativeArg2Action<Player, Button>("Press button", false, true, this, button);
    }

    public setStatus(statusEffect: StatusEffect, seconds: number, assister: Player = null): void {
        Native.callNativeArg4Action<Player, Player, StatusEffect, number>("Set status", false, true, this, assister, statusEffect, seconds);
    }

    public clearStatus(statusEffect: StatusEffect): void {
        Native.callNativeArg2Action<Player, StatusEffect>("Clear status", false, true, this, statusEffect);
    }

    public get isHacked(): boolean {
        return this.hasStatus(StatusEffect.Hacked);
    }

    public get isBurning(): boolean {
        return this.hasStatus(StatusEffect.Burning);
    }

    public get isKnockedDown(): boolean {
        return this.hasStatus(StatusEffect.KnockedDown);
    }

    public get isAsleep(): boolean {
        return this.hasStatus(StatusEffect.ASleep);
    }

    public get isFrozen(): boolean {
        return this.hasStatus(StatusEffect.Frozen);
    }

    public get isUnkillable(): boolean {
        return this.hasStatus(StatusEffect.Unkillable);
    }

    public get isInvincible(): boolean {
        return this.hasStatus(StatusEffect.Invincible);
    }

    public get isPhasedOut(): boolean {
        return this.hasStatus(StatusEffect.PhasedOut);
    }

    public get isRooted(): boolean {
        return this.hasStatus(StatusEffect.Rooted);
    }

    public get isStunned(): boolean {
        return this.hasStatus(StatusEffect.Stunned);
    }

    public hasStatus(statusEffect: StatusEffect): boolean {
        return Native.callNativeArg2Function<Player, StatusEffect, boolean>("Has status", true, false, this, statusEffect);
    }

    public isUsingEmoteOrVoiceLine(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Is communicating any", false, true, this);
    }

    public isUsingVoiceLine(voiceLine: VoiceLine = null): boolean {
        if (voiceLine == null)
            return Native.callNativeArg1Function<Player, boolean>("Is communicating any voice line", false, true, this);
        else
            return Native.callNativeArg2Function<Player, VoiceLine, boolean>("Is communicating", false, true, this, voiceLine);
    }

    public useVoiceLine(voiceLine: VoiceLine): void {
        Native.callNativeArg2Action<Player, VoiceLine>("Communicate", false, true, this, voiceLine);
    }

    public isUsingEmote(emote: Emote = null): boolean {
        if (emote == null)
            return Native.callNativeArg1Function<Player, boolean>("Is communicating any emote", false, true, this);
        else
            return Native.callNativeArg2Function<Player, Emote, boolean>("Is communicating", false, true, this, emote);
    }

    public useEmote(emote: Emote): void {
        Native.callNativeArg2Action<Player, Emote>("Communicate", false, true, this, emote);
    }

    public damage(amount: number, damager: Player = null): void {
        Native.callNativeArg3Action<Player, Player, number>("Damage", false, true, this, damager, amount);
    }

    public heal(amount: number, healer: Player = null): void {
        Native.callNativeArg3Action<Player, Player, number>("Heal", false, true, this, healer, amount);
    }

    public kill(killer: Player = null): void {
        Native.callNativeArg2Action<Player, Player>("Kill", false, true, this, killer);
    }

    public respawn(): void {
        Native.callNativeArg1Action<Player>("Respawn", false, true, this);
    }

    public resurrect(): void {
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

    public get score(): number {
        return Native.callNativeArg1Function<Player, number>("Score of", true, false, this);
    }

    public set score(value: number) {
        Native.callNativeArg2Action<Player, number>("Set player score", false, true, this, value);
    }

    public set makeInvisibleTo(invisibleTo: InvisibleTo) {
        Native.callNativeArg2Action<Player, InvisibleTo>("Set invisible", false, true, this, invisibleTo);
    }

    public get allowedHeroes(): List<Hero> {
        return Native.callNativeArg1Function<Player, List<Hero>>("Allowed Heroes", true, false, this);
    }

    public set allowedHeroes(heroes: List<Hero>) {
        Native.callNativeArg2Action<Player, List<Hero>>("Set player allowed heroes", false, true, this, heroes);
    }

    public get hero(): Hero {
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

    public startCamera(eyePosition: Vector, lookAtPosition: Vector, blendSpeed: number): void {
        Native.callNativeArg4Action<Player, Vector, Vector, number>("Start camera", false, true, this, eyePosition, lookAtPosition, blendSpeed);
    }


    public stopCamera(): void {
        Native.callNativeArg1Action<Player>("Stop camera", false, true, this);
    }

    public damageOverTime(damagePerSecond: number, seconds: number, damagers: Player | List<Player> = null): DamageOverTime.DamageOverTime {
        return DamageOverTime.start(damagePerSecond, seconds, this, damagers);
    }

    public healOverTime(healingPerSecond: number, seconds: number, damagers: Player | List<Player> = null): HealOverTime.HealOverTime {
        return HealOverTime.start(healingPerSecond, seconds, this, damagers);
    }

    public get throttle(): Vector {
        return Native.callNativeArg1Function<Player, Vector>("Throttle of", true, false, this);
    }

    public forceThrottle(minForward: number,
        maxForward: number,
        minBackward: number,
        maxBackward: number,
        minSideways: number,
        maxSideways: number): void {
        Native.callNativeArg7Action
            <Player, number, number, number, number, number, number>(
                "Start forcing throttle", false, true, this, minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways);
    }

    public stopForcingThrottle(): void {
        Native.callNativeArg1Action<Player>("Stop forcing throttle", false, true, this);
    }

    public startAccelerating(direction: Vector, rate: number, maxSpeed: number): void {
        Motion.startAccelerating(this, direction, rate, maxSpeed);
    }

    public stopAccelerating(): void {
        Motion.stopAccelerating(this);
    }

    public teleportTo(position: Vector): void {
        Native.callNativeArg2Action<Player, Vector>("Teleport", false, true, this, position);
    }

    public static closestTo(position: Vector, team: Team | List<Team> = Teams.all): Player {
        return Native.callNativeArg2Function<Vector, Team | List<Team>, Player>("Closest player to", true, false, position, team);
    }

    public static farthestFrom(position: Vector, team: Team | List<Team> = Teams.all): Player {
        return Native.callNativeArg2Function<Vector, Team | List<Team>, Player>("Farthest player from", true, false, position, team);
    }

    public get exists(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Entity exists", true, false, this);
    }

    public get hasSpawned(): boolean {
        return Native.callNativeArg1Function<Player, boolean>("Has spawned", true, false, this);
    }

    public horizontalAngleTowards(position: Vector): number {
        return Native.callNativeArg2Function<Player, Vector, number>("Horizontal angle towards", false, false, this, position);
    }

    public verticalAngleTowards(position: Vector): number {
        return Native.callNativeArg2Function<Player, Vector, number>("Vertical angle towards", false, false, this, position);
    }

    public isLookingAt(position: Vector, viewConeAngle: number): boolean {
        return Native.callNativeArg3Function<Player, Vector, number, boolean>("Is in view angle", false, false, this, position, viewConeAngle);
    }

    public get deaths(): number {
        return Native.callNativeArg1Function<Player, number>("Number of deaths", true, false, this);
    }

    public get kills(): number {
        return Native.callNativeArg1Function<Player, number>("Number of eliminations", true, false, this);
    }

    public get finalBlows(): number {
        return Native.callNativeArg1Function<Player, number>("Number of final blows", true, false, this);
    }

    public get slot(): number {
        return Native.callNativeArg1Function<Player, number>("Slot of", true, false, this);
    }

    public static closestToReticle(player: Player, team: Team | List<Team> = Teams.all): Player {
        return Native.callNativeArg2Function<Player, Team | List<Team>, Player>("Player closest to reticle", true, false, player, team);
    }

    public get team(): Team {
        return Native.callNativeArg1Function<Player, Team>("Team of", true, false, this);
    }

    public get ultimateCharge(): number {
        return Native.callNativeArg1Function<Player, number>("Ultimate charge percent", true, false, this);
    }

    public get velocity(): number {
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

    public static count(): number {
        return Native.callNativeArg1Function<List<Team>, number>("Number of players", true, false, Teams.all);
    }

    public static countOnObjective(): number {
        return Native.callNativeArg1Function<List<Team>, number>("Number of players on objective", true, false, Teams.all);
    }

    public static dead(): List<Player> {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("All Dead Players", true, false, Teams.all);
    }

    public static countDead(): number {
        return Native.callNativeArg1Function<List<Team>, number>("Number of dead players", true, false, Teams.all);
    }

    public static living(): List<Player> {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("All Living Players", true, false, Teams.all);
    }

    public static countLiving(): List<Player> {
        return Native.callNativeArg1Function<List<Team>, List<Player>>("Number of Living Players", true, false, Teams.all);
    }

    public static onTeam(team: Team | List<Team>): List<Player> {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players", true, false, team);
    }

    public static get all(): List<Player> {
        return Players.onTeam(Teams.all);
    }

    public static notOnObjectiveFromTeam(team: Team | List<Team>): List<Player> {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players Not On Objective", true, false, team);
    }

    public static onObjectiveFromTeam(team: Team | List<Team>): List<Player> {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Players On Objective", true, false, team);
    }

    public static beingLookedAtBy(player: Player, team: Team | List<Team>, viewConeAngle: number): List<Player> {
        return Native.callNativeArg3Function<Player, Team | List<Team>, number, List<Player>>("Players in view angle", true, false, player, team, viewConeAngle);
    }

    public static playingHero(hero: Hero, team: Team | List<Team> = Teams.all): List<Player> {
        return Native.callNativeArg2Function<Hero, Team | List<Team>, List<Player>>("Players on hero", true, false, hero, team);
    }

    public static withinRadius(position: Vector, radius: number, team: Team | List<Team> = Teams.all, lineOfSightCheck: LineOfSightCheck = LineOfSightCheck.Off): List<Player> {
        return Native.callNativeArg4Function<Vector, number, Team | List<Team>, LineOfSightCheck, List<Player>>("Players within radius", true, false, position, radius, team, lineOfSightCheck);
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
        public stop(): void {
            Native.callNativeArg1Action<DamageModification>("Stop damage modification", false, true, this);
        }
    }

    export function start(receivers: Player | List<Player>, damagers: Player | List<Player>, percentage: number, reevaluation: Reevaluation = Reevaluation.None): DamageModification {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, Reevaluation>(
                "Start damage modification", false, true, receivers, damagers, percentage, reevaluation);
        return getLastCreated();
    }

    export function getLastCreated(): DamageModification {
        return Native.callNativeArg0Function<DamageModification>("Last damage modification", true, false);
    }

    export function stopAll(): void {
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
        public stop(): void {
            Native.callNativeArg1Action<DamageOverTime>("Stop damage over time", false, true, this);
        }
    }

    export function start(damagePerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null): DamageOverTime {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start damage over time", false, true, receivers, damagers, seconds, damagePerSecond);
        return getLastCreated();
    }

    export function getLastCreated(): DamageOverTime {
        return Native.callNativeArg0Function<DamageOverTime>("Last damage over time ID", true, false);
    }

    export function stopAll(): void {
        Native.callNativeArg0Action("Stop all damage over time", false, true);
    }
}

export module HealOverTime {
    export class HealOverTime {
        public stop(): void {
            Native.callNativeArg1Action<HealOverTime>("Stop heal over time", false, true, this);
        }
    }

    export function start(healingPerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null): HealOverTime {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start heal over time", false, true, receivers, damagers, seconds, healingPerSecond);
        return getLastCreated();
    }

    export function getLastCreated(): HealOverTime {
        return Native.callNativeArg0Function<HealOverTime>("Last heal over time ID", true, false);
    }

    export function stopAll(): void {
        Native.callNativeArg0Action("Stop all heal over time", false, true);
    }
}

export module Facing {
    export function set(player: Player | List<Player>, value: Vector, relative: Relative = Relative.ToWorld): void {
        Native.callNativeArg3Action<Player | List<Player>, Vector, Relative>("Set facing", false, true, player, value, relative);
    }

    export function setAtRate(player: Player | List<Player>, value: Vector, turnRate: number, relativeTo: Relative = Relative.ToWorld, reevaluation: Reevaluation = Reevaluation.None): void {
        Native.callNativeArg5Action
            <Player | List<Player>, Vector, number, Relative, Reevaluation>
            ("Start facing", false, true, player, value, turnRate, relativeTo, reevaluation);
    }

    export function stop(player: Player | List<Player>): void {
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