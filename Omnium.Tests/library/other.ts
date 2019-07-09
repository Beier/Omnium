import { Native } from "./native"
import { Team } from "./team"
import { Player, Players } from "./player"
import { List } from "./list"
import { Vector } from "./vector"

export function wait(seconds: number): void {
    Native.assert(seconds >= 0.3, "You can not wait for less than 0.3 seconds");
    Native.callNativeArg1Action<number>("Wait", false, false, seconds);
}


export module Motion {
    export function applyImpulse(player: Player | List<Player>,
        direction: Vector,
        speed: number,
        relative: Relative = Relative.ToWorld,
        contraryMotion: ContraryMotion = ContraryMotion.Cancel): void {

        Native.callNativeArg5Action
            <Player | List<Player>, Vector, number, Relative, ContraryMotion>(
                "Apply impulse", false, true, player, direction, speed, relative, contraryMotion);
    }

    export function startAccelerating(
        player: Player | List<Player>,
        direction: Vector,
        rate: number,
        maxSpeed: number,
        relative: Relative = Relative.ToWorld,
        reevaluation: Reevaluation = Reevaluation.None): void {

        Native.callNativeArg6Action
            <Player | List<Player>, Vector, number, number, Relative, Reevaluation>(
                "Start accelerating", false, true, player, direction, rate, maxSpeed, relative, reevaluation);
    }

    export function stopAccelerating(player: Player | List<Player>): void {
        Native.callNativeArg1Action<Player | List<Player>>("Stop accelerating", false, true, player);
    }

    export enum Relative {
        ToWorld = "To world",
        ToPlayer = "To player"
    }

    export enum ContraryMotion {
        Cancel = "Cancel contrary motion",
        Incorporate = "Incorporate contrary motion"
    }

    export enum Reevaluation {
        DirectionRateAndMaxSpeed = "Direction, rate, and max speed",
        None = "None"
    }
}

export module Effect {
    export module Static {


        export class Effect {
            public destroy(): void {
                Native.callNativeArg1Action<Effect>("Destroy effect", false, true, this);
            }
        }

        export function create(visibleTo: Player | List<Player>, type: Type, color: Color, position: Vector, radius: number, reevaluation: Reevaluation = Reevaluation.None): void {
            Native.callNativeArg6Action
                <Player | List<Player>, Type, Color, Vector, number, Reevaluation>(
                    "Create effect", false, true, visibleTo, type, color, position, radius, reevaluation);
        }

        export function createSound(visibleTo: Player | List<Player>, sound: Sound, position: Vector, radius: number, reevaluation: Reevaluation = Reevaluation.None): void {
            Native.callNativeArg6Action
                <Player | List<Player>, Sound, Color, Vector, number, Reevaluation>(
                    "Create effect", false, true, visibleTo, sound, Color.White, position, radius, reevaluation);
        }

        export function destroyAll(): void {
            Native.callNativeArg0Action("Destroy all effects", false, true);
        }


        export enum Type {
            Sphere = "Sphere",
            LightShaft = "Light shaft",
            Orb = "Orb",
            Ring = "Ring",
            Cloud = "Cloud",
            Sparkles = "Sparkles",
            GoodAura = "Good aura",
            BadAura = "Bad aura"
        }

        export enum Sound {
            Energy = "Energy sound",
            PickUp = "Pick-up sound",
            GoodAura = "Good aura sound",
            BadAura = "Bad aura sound",
            Sparkles = "Sparkles sound",
            Smoke = "Smoke sound",
            Decal = "Decal sound",
            Beacon = "Beacon sound"
        }

        export enum Reevaluation {
            VisibleToPositionAndRadius = "Visible to, position, and radius",
            PositionAndRadius = "Position and radius",
            VisibleTo = "Visible to",
            None = "None",
        }
    }

    export module Animated {
        export function create(type: Type, color: Color, position: Vector, radius: number = 1, visibleTo: Player | List<Player> = Players.all): void {
            Native.callNativeArg5Action
                <Player | List<Player>, Type, Color, Vector, number>(
                    "Play effect", false, false, visibleTo, type, color, position, radius);
        }

        export function createSound(sound: Sound, position: Vector, radius: number = 1, visibleTo: Player | List<Player> = Players.all): void {
            Native.callNativeArg5Action
                <Player | List<Player>, Sound, Color, Vector, number>(
                    "Play effect", false, false, visibleTo, sound, Color.White, position, radius);
        }

        export enum Type {
            GoodExplosion = "Good explosion",
            BadExplosion = "Bad explosion",
            RingExplosion = "Ring explosion",
            GoodPickup = "Good pickup",
            BadPickup = "Bad pickup"
        }

        export enum Sound {
            DebuffImpact = "Debuff impact sound",
            BuffImpact = "Buff impact sound",
            RingExplosion = "Ring explosion sound",
            BuffExplosion = "Buff explosion sound",
            Explosion = "Explosion sound"
        }
    }
}

export module Icon {
    export class Icon {
        public destroy(): void {
            Native.callNativeArg1Action<Icon>("Destroy icon", false, true, this);
        }
    }

    export function create(type: Type, color: Color, visibleTo: Player | List<Player>, position: Vector, reevaluation: Reevaluation = Reevaluation.None, showWhenOffscreen: boolean = true): void {
        Native.callNativeArg6Action
            <Player | List<Player>, Vector, Type, Reevaluation, Color, boolean>(
                "Create icon", false, true, visibleTo, position, type, reevaluation, color, showWhenOffscreen);
    }

    export function destroyAll(): void {
        Native.callNativeArg0Action("Destroy all icons", false, true);
    }

    export enum Type {
        ArrowUp = "Arrow: Up",
        ArrowDown = "Arrow: Down",
        ArrowLeft = "Arrow: Left",
        ArrowRight = "Arrow: Right",
        Asterisk = "Asterisk",
        Bolt = "Bolt",
        Circle = "Circle",
        Club = "Club",
        Diamond = "Diamond",
        Dizzy = "Dizzy",
        ExclamationMark = "Exclamation Mark",
        Eye = "Eye",
        Fire = "Fire",
        Flag = "Flag",
        Halo = "Halo",
        Happy = "Happy",
        Heart = "Heart",
        Moon = "Moon",
        No = "No",
        Plus = "Plus",
        Poison = "Poison",
        Poison2 = "Poison 2",
        QuestionMark = "Question Mark",
        Radioactive = "Radioactive",
        Recycle = "Recycle",
        RingThick = "Ring Thick",
        RingThin = "Ring Thin",
        Sad = "Sad",
        Skull = "Skull",
        Spade = "Spade",
        Spiral = "Spiral",
        Stop = "Stop",
        Trashcan = "Trashcan",
        Warning = "Warning",
        X = "X"
    }

    export enum Reevaluation {
        VisibleToAndPosition = "Visible to and position",
        Position = "Position",
        VisibleTo = "Visible to",
        None = "None",
    }
}

export enum Color {
    White = "White",
    Yellow = "Yellow",
    Green = "Green",
    Purple = "Purple",
    Red = "Red",
    Blue = "Blue",
    OfTeam1 = "Team 1",
    OfTeam2 = "Team 2",
}

export module GameMode {
    export function setDefaultAnnouncerEnabled(isEnabled: boolean): void {
        if (isEnabled)
            Native.callNativeArg0Action("Enable built-in game mode announcer", false, false);
        else
            Native.callNativeArg0Action("Disable built-in game mode announcer", false, false);
    }

    export function setDefaultCompletionRulesEnabled(isEnabled: boolean): void {
        if (isEnabled)
            Native.callNativeArg0Action("Enable built-in game mode completion", false, false);
        else
            Native.callNativeArg0Action("Disable built-in game mode completion", false, false);
    }

    export function seDefaultMusicEnabled(isEnabled: boolean): void {
        if (isEnabled)
            Native.callNativeArg0Action("Enable built-in game mode music", false, false);
        else
            Native.callNativeArg0Action("Disable built-in game mode music", false, false);
    }

    export function setDefaultRespawningEnabled(isEnabled: boolean, player: Player | List<Player> = Players.all): void {
        if (isEnabled)
            Native.callNativeArg1Action<Player | List<Player>>("Enable built-in game mode respawning", false, false, player);
        else
            Native.callNativeArg1Action<Player | List<Player>>("Disable built-in game mode respawning", false, false, player);
    }

    export function setDefaultScoringEnabled(isEnabled: boolean): void {
        if (isEnabled)
            Native.callNativeArg0Action("Enable built-in game mode scoring", false, false);
        else
            Native.callNativeArg0Action("Disable built-in game mode scoring", false, false);
    }

    export function setDeathSpectateEnabled(isEnabled: boolean, player: Player | List<Player> = Players.all): void {
        if (isEnabled)
            Native.callNativeArg1Action<Player | List<Player>>("Enable death spectate all players", false, false, player);
        else
            Native.callNativeArg1Action<Player | List<Player>>("Disable death spectate all players", false, false, player);
    }

    export function setSpectateTargetHud(isEnabled: boolean, player: Player | List<Player> = Players.all): void {
        if (isEnabled)
            Native.callNativeArg1Action<Player | List<Player>>("Enable death spectate target hud", false, false, player);
        else
            Native.callNativeArg1Action<Player | List<Player>>("Disable death spectate target hud", false, false, player);
    }

    export function goToAssembleHeroes(): void {
        Native.callNativeArg0Action("Go to assemble heroes", false, false);
    }

    export module Deathmatch {
        export function declareVictory(player: Player): void {
            Native.callNativeArg1Action<Player>("Declare player victory", false, true, player);
        }
    }

    export module Control {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare round victory", false, true, team);
        }
    }

    export module Elimination {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare round victory", false, true, team);
        }
    }
    export module Assault {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
        }

        export function declareDraw(): void {
            Native.callNativeArg0Action("Declare match draw", false, true);
        }
    }
    export module Escort {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
        }

        export function declareDraw(): void {
            Native.callNativeArg0Action("Declare match draw", false, true);
        }
    }
    export module AssaultEscort {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
        }

        export function declareDraw(): void {
            Native.callNativeArg0Action("Declare match draw", false, true);
        }
    }
    export module CaptureTheFlag {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
        }

        export function declareDraw(): void {
            Native.callNativeArg0Action("Declare match draw", false, true);
        }
    }
    export module TeamDeathmatch {
        export function declareVictory(team: Team): void {
            Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
        }

        export function declareDraw(): void {
            Native.callNativeArg0Action("Declare match draw", false, true);
        }
    }
}

export module Game {
    export function setGravityPercentFor(player: Player | List<Player>, percent: number): void {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set gravity", false, true, player, percent);
    }

    export function setProjectileGravityPercentFor(player: Player | List<Player>, percent: number): void {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set projectile gravity", false, true, player, percent);
    }

    export function setProjectileSpeedPercentFor(player: Player | List<Player>, percent: number): void {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set projectile speed", false, true, player, percent);
    }

    export function setRespawnMaxTime(player: Player | List<Player>, seconds: number): void {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set respawn max time", false, true, player, seconds);
    }

    export function seSlowMotionPercent(percent: number): void {
        Native.callNativeArg1Action<number>("Set slow motion", false, true, percent);
    }


    export class MatchTime {
        public static pause(): void {
            Native.callNativeArg0Action("Pause match time", false, true);
        }

        public static unpause(): void {
            Native.callNativeArg0Action("Unpause match time", false, true);
        }

        public set seconds(value: number) {
            Native.callNativeArg1Action<number>("Set match time", false, true, value);
        }
    }
}
//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//TOdo: Start facing