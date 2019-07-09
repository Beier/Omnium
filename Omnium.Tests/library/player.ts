import { Native } from "Native"
import { Vector } from "Vector"
import { List } from "List"
import { Team, Teams } from "Team"
import { Hero } from "Hero"
import { Motion } from "other"

export class Player {
    private constructor() { }

    public get altitude(): number {
        return Native.callNativeArg1Function<Player, number>("Altitude Of", true, false, this);
    }

    public isHoldingButton(button: Button): boolean {
        return Native.callNativeArg2Function<Player, Button, boolean>("Is Button Held", true, false, this, button);
    }

    public get position(): Vector {
        return Native.callNativeArg1Function<Player, Vector>("Position of", true, false, this);
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

    public useVoiceLine(voiceLine: VoiceLine): void {
        Native.callNativeArg2Action<Player, VoiceLine>("Communicate", false, true, this, voiceLine);
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

    

    public damageOverTime(damagePerSecond: number, seconds: number, damagers: Player | List<Player> = null): void {
        DamageOverTime.start(damagePerSecond, seconds, this, damagers);
    }

    public healOverTime(healingPerSecond: number, seconds: number, damagers: Player | List<Player> = null): void {
        HealOverTime.start(healingPerSecond, seconds, this, damagers);
    }

    public forceThrottle(minForward: number,
        maxForward: number,
        minBackward: number,
        maxBackward: number,
        minSideways: number,
        maxSideways: number): void  {
        Native.callNativeArg7Action
            <Player, number, number, number, number, number, number>(
                "Start forcing throttle", false, true, this, minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways);
    }

    public stopForcingThrottle(): void  {
        Native.callNativeArg1Action<Player>("Stop forcing throttle", false, true, this);
    }

    public startAccelerating(direction: Vector, rate: number, maxSpeed: number): void  {
        Motion.startAccelerating(this, direction, rate, maxSpeed);
    }

    public stopAccelerating(): void  {
        Motion.stopAccelerating(this);
    }

    public teleportTo(position: Vector): void {
        Native.callNativeArg2Action<Player, Vector>("Teleport", false, true, this, position);
    }
}

export enum InvisibleTo {
    Everyone = "All",
    Enemies = "Enemies",
    NoOne = "None",
}

export class Players {
    private constructor() { }

    public static deadOnTeam(team: Team | List<Team>): List<Player> {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Dead Players", true, false, team);
    }

    public static aliveOnTeam(team: Team | List<Team>): List<Player> {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Living Players", true, false, team);
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


export module DamageModification {
    export class DamageModification {
        public stop(): void {
            Native.callNativeArg1Action<DamageModification>("Stop damage modification", false, true, this);
        }
    }

    export function start(receivers: Player | List<Player>, damagers: Player | List<Player>, percentage: number, reevaluation: Reevaluation = Reevaluation.None): void {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, Reevaluation>(
                "Start damage modification", false, true, receivers, damagers, percentage, reevaluation);
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

    export function start(damagePerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null): void {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start damage over time", false, true, receivers, damagers, seconds, damagePerSecond);
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

    export function start(healingPerSecond: number, seconds: number, receivers: Player | List<Player>, damagers: Player | List<Player> = null): void {
        Native.callNativeArg4Action
            <Player | List<Player>, Player | List<Player>, number, number>(
                "Start heal over time", false, true, receivers, damagers, seconds, healingPerSecond);
    }

    export function stopAll(): void {
        Native.callNativeArg0Action("Stop all heal over time", false, true);
    }
}

export module Facing {
    export function set(player : Player | List<Player>, value: Vector, relative: Relative = Relative.ToWorld): void {
        Native.callNativeArg3Action<Player | List<Player>, Vector, Relative>("Set facing", false, true, player, value, relative);
    }

    export function setAtRate(player: Player | List<Player>, value: Vector, turnRate: number, relativeTo: Relative = Relative.ToWorld, reevaluation : Reevaluation = Reevaluation.None): void {
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