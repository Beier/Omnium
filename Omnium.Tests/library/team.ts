import { Native } from "Native"
import { List } from "List"
import { Player, Players } from "Player"

export class Team {
    private constructor() { }

    public static get team1() {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team1);
    }

    public static get team2() {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team2);
    }

    public get score() {
        return Native.callNativeArg1Function<Team, number>("Team score", true, false, this);
    }

    public set score(value: number) {
        Native.callNativeArg2Action<Team, number>("Set team score", false, true, this, value);
    }

    public set spawnRoom(number: number) {
        if (number == null)
            Native.callNativeArg1Action<Team>("Stop forcing spawn room", false, true, this);
        else
            Native.callNativeArg2Action<Team, number>("Start forcing spawn room", false, true, this, number);
    }

    public get isOnDefense() {
        return Native.callNativeArg1Function<Team, boolean>("Is team on defense", false, true, this);
    }

    public get isOnOffense() {
        return Native.callNativeArg1Function<Team, boolean>("Is team on offense", false, true, this);
    }

    public get numberOfDeadPlayers() {
        return Native.callNativeArg1Function<Team, number>("Number of dead players", true, false, this);
    }

    public get deadPlayers() {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All Dead Players", true, false, this);
    }

    public get numberOfLivingPlayers() {
        return Native.callNativeArg1Function<Team, number>("Number of living players", true, false, this);
    }

    public get livingPlayers() {
        return Native.callNativeArg1Function<Team | List<Team>, List<Player>>("All living Players", true, false, this);
    }

    public get numberOfPlayers() {
        return Native.callNativeArg1Function<Team, number>("Number of players", true, false, this);
    }

    public get numberOfPlayersOnObjective() {
        return Native.callNativeArg1Function<Team, number>("Number of players on objective", true, false, this);
    }

    public get oppositeTeam() {
        return Native.callNativeArg1Function<Team, Team>("Opposite team of", true, false, this);
    }

    public playerInSlot(slot: number) {
        //Todo: Can this return multiple players?
        return Native.callNativeArg2Function<number, Team, Player>("Players in slot", true, false, slot, this);
    }

    public get players() {
        return Players.onTeam(this);
    }
}

export class Teams {
    public static get all() {
        return Native.callNativeArg1Function<TeamConst, List<Team>>("Team", true, false, TeamConst.All);
    }
}

enum TeamConst {
    All = "All",
    Team1 = "Team 1",
    Team2 = "Team 2"
}
