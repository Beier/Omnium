import { Native } from "Native"
import { Vector } from "Vector"
import { List } from "List"
import { Team, Teams } from "Team"

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
