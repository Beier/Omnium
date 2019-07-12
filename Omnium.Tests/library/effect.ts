import { Native } from "./native"
import { Player, Players } from "./player"
import { List } from "./list"
import { Vector } from "./vector"

export module Effect {
    export module Static {
        export class Effect {
            public destroy() {
                Native.callNativeArg1Action<Effect>("Destroy effect", false, true, this);
            }

            public get exists() {
                return Native.callNativeArg1Function<Effect, boolean>("Entity exists", false, false, this);
            }
        }

        export function create(visibleTo: Player | List<Player>, type: Type, color: Color, position: Vector, radius: number, reevaluation: Reevaluation = Reevaluation.None) {
            Native.callNativeArg6Action
                <Player | List<Player>, Type, Color, Vector, number, Reevaluation>(
                    "Create effect", false, true, visibleTo, type, color, position, radius, reevaluation);
            return getLastCreatedEffect();
        }

        export function createSound(visibleTo: Player | List<Player>, sound: Sound, position: Vector, radius: number, reevaluation: Reevaluation = Reevaluation.None) {
            Native.callNativeArg6Action
                <Player | List<Player>, Sound, Color, Vector, number, Reevaluation>(
                    "Create effect", false, true, visibleTo, sound, Color.White, position, radius, reevaluation);
            return getLastCreatedEffect();
        }

        export function getLastCreatedEffect() {
            return Native.callNativeArg0Function<Effect>("Last created entity", true, false);
        }

        export function destroyAll() {
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
        export function create(type: Type, color: Color, position: Vector, radius: number = 1, visibleTo: Player | List<Player> = Players.all) {
            Native.callNativeArg5Action
                <Player | List<Player>, Type, Color, Vector, number>(
                    "Play effect", false, false, visibleTo, type, color, position, radius);
        }

        export function createSound(sound: Sound, position: Vector, radius: number = 1, visibleTo: Player | List<Player> = Players.all) {
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

//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable