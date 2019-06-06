//This serves as a definition of the methods and properties avalible in Overwatch, and how to map to them.
//For instance, in TypeScript, there is a class called Player, which has a getter "altitude", which defines a mapping to "Altitude Of(this)"


//The native class is special. Every method defined here have a special meaning to the compiler. 
//You can not extend or change the native class without changing the compiler
class Native {
    //These methods are used to define a member that can be called in the target language, while providing an implementation to be used when debugging in JS.
    public static arg0<TReturn>(methodName: String, jsAction: () => TReturn = null) {
        return jsAction();
    }

    public static arg1<T1, TReturn>(methodName: String, argument1: T1, jsAction: (p1: T1) => TReturn = null) {
        return jsAction(argument1);
    }

    public static defineNativeArg1<T1, TReturn>(methodName: String, jsAction: (p1: T1) => TReturn) {

    }

    //This is used to define new rules
    public static rules: Rule[] = [];
    public static rule(ruleName: string, event: Events.Ongoing, conditionOrAction: () => boolean | void, action: () => void = null) {
        let rule: Rule;
        if (action)
            rule = new Rule(ruleName, event, conditionOrAction as () => boolean, action);
        else
            rule = new Rule(ruleName, event, () => true, conditionOrAction as () => void);
        this.rules.push(rule);
    }

    //Used to execute debug code in JS. This will be discarded by the compiler.
    public static debugExecute(action: () => void) {
        action();
    }
}

class Rule {
    public readonly name : string;
    public readonly event: Events.Ongoing;
    public readonly condition: () => boolean;
    public readonly action: () => void;

    constructor(name: string, event: Events.Ongoing, condition: () => boolean, action: () => void) {
        this.name = name;
        this.event = event;
        this.condition = condition;
        this.action = action;
    }

    public run() {
        if (this.condition())
            this.action();
    }
}

Native.defineNativeArg1<number, number>("Absolute Value", Math.abs);

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
        Global = "Ongoing - Global"
    }
}