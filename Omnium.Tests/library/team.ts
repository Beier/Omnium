import { Native } from "Native"
import { List } from "List"

export class Team {
    private constructor() { }

    public static get team1(): Team {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team1);
    }

    public static get team2(): Team {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team2);
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

    
}

export class Teams {
    public static get all(): List<Team> {
        return Native.callNativeArg1Function<TeamConst, List<Team>>("Team", true, false, TeamConst.All);
    }
}

enum TeamConst {
    All = "All",
    Team1 = "Team 1",
    Team2 = "Team 2"
}
