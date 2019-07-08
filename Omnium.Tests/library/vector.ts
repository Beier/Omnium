import { Native } from "Native"
import { List } from "List"
import { Rule } from "Rule"
import { Player, Players } from "Player"

export function vector(x: number, y: number, z: number): Vector {
    return Native.callNativeArg3Function<number, number, number, Vector>("Vector", false, false, x, y, z);
}

export class Vector {
    public static get zero(): Vector {
        return vector(0, 0, 0);
    }

    public static get up(): Vector {
        return Native.callNativeArg0Function<Vector>("Up", false, false);
    }

    public static getFirstIntersectionBetween(start: Vector,
        end: Vector,
        playersToInclude: Player | List<Player> = Players.all,
        playersToExclude: Player | List<Player> = Rule.Triggering.player,
        includePlayerOwnedObjects: boolean = true): Vector {
        return Native.callNativeArg5Function<Vector, Vector, Player | List<Player>, Player | List<Player>, boolean, Vector>(
            "Ray cast hit position",
            true,
            false,
            start,
            end,
            playersToInclude,
            playersToExclude,
            includePlayerOwnedObjects);
    }
}

