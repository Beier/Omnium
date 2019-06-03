

class Native {
    public static arg0<TReturn>(methodName: String, jsAction: () => TReturn = null) {
        return jsAction();
    }

    public static arg1<T1, TReturn>(methodName: String, argument1: T1, jsAction: (p1: T1) => TReturn = null) {
        return jsAction(argument1);
    }
}

function rule(ruleName: string, event: Events.Ongoing, conditionOrAction: () => boolean | void, action : () => void = null) {
    throw "Not implemented";
}

class Player {
    private constructor() { }
    
    public get altitude(): number {
        return Native.arg1("Altitude Of", this);
    }
}

class Players {
    private constructor() { }

    public static deadOnTeam(team: Team | Team[]): Player[] {
        return Native.arg1("All Dead Players", team);
    }
    
    public static aliveOnTeam(team: Team | Team[]): Player[] {
        return Native.arg1("All Living Players", team);
    }

    public static onTeam(team: Team | Team[]): Player[] {
        return Native.arg1("All Players", team);
    }

    public static notOnObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.arg1("All Players Not On Objective", team);
    }

    public static onObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.arg1("All Players On Objective", team);
    }


}

class Team {
    private constructor() { }

}

class Teams {
    public static get all(): Hero[] {
        return Native.arg0("All Teams");
    }
}

class Hero {
    private constructor() { }

}

class Heroes {
    private constructor() { }

    public static get all(): Hero[] {
        return Native.arg0("All Heroes");
    }

    public static allowedForPlayer(player: Player): Player[] {
        return Native.arg1("Allowed Heroes", player);
    }
}

module Rule {
    export class Event {
        private constructor() { }

        public static get player(): Player {
            return Native.arg0("Event Player");
        }
    }
}

module Events {
    export enum Ongoing {
        Global
    }
}