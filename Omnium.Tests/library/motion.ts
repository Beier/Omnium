import { Native } from "./native"
import { Player } from "./player"
import { List } from "./list"
import { Vector } from "./vector"

export module Motion {
    export function applyImpulse(player: Player | List<Player>,
        direction: Vector,
        speed: number,
        relative: Relative = Relative.ToWorld,
        contraryMotion: ContraryMotion = ContraryMotion.Cancel) {

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
        reevaluation: Reevaluation = Reevaluation.None) {

        Native.callNativeArg6Action
            <Player | List<Player>, Vector, number, number, Relative, Reevaluation>(
                "Start accelerating", false, true, player, direction, rate, maxSpeed, relative, reevaluation);
    }

    export function stopAccelerating(player: Player | List<Player>) {
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