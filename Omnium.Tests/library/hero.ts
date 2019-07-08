import { Native } from "Native"
import { List } from "List"
import { Player } from "Player"

class Hero {
    private constructor() { }

}

class Heroes {
    private constructor() { }

    public static get all(): List<Hero> {
        return Native.callNativeArg0Function<List<Hero>>("All Heroes", true, false);
    }

    public static allowedForPlayer(player: Player): List<Hero> {
        return Native.callNativeArg1Function<Player, List<Hero>>("Allowed Heroes", true, false, player);
    }
}