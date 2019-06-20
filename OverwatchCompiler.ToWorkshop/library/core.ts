//This serves as a definition of the methods and properties avalible in Overwatch, and how to map to them.
//For instance, in TypeScript, there is a class called Player, which has a getter "altitude", which defines a mapping to "Altitude Of(this)"


//The native module is special. Every method defined here have a special meaning to the compiler, and will be removed during compilation.
module Native {
    //These methods are used to define a member that can be called in the target language, while providing an implementation to be used when debugging in JS.
    //If a specific number of arguments is missing, just add it. The compiler recognizes methods named /^arg\d+(Function|Action)$/. Function for methods with a return value, action for void return.
    export function callNativeArg0Function<TReturn>(methodName: string, jsAction: () => TReturn = null): TReturn {
        return jsAction();
    }

    export function callNativeArg0Action(methodName: string, jsAction: () => void = null): void {
        jsAction();
    }

    export function callNativeArg1Function<T1, TReturn>(methodName: string, argument1: T1, jsAction: (p1: T1) => TReturn = null): TReturn {
        return jsAction(argument1);
    }

    export function callNativeArg1Action<T1>(methodName: string, argument1: T1, jsAction: (p1: T1) => void = null): void {
        jsAction(argument1);
    }

    //This is used to define methods native to both typescript and overwatch. Ex. Math.abs(x) = Absolute Value(x)
    export function defineTypescriptNativeArg1Function<T1, TReturn>(methodName: string, jsAction: (p1: T1) => TReturn): void {
    }

    //This is used to define new rules
    const rules: Rule[] = [];
    export function rule(ruleName: string, event: Events.Ongoing, conditionOrAction: () => boolean | void, action: () => void = null): void {
        let rule: Rule;
    if(action)
        rule = new Rule(ruleName, event, conditionOrAction as () => boolean, action);
    else
        rule = new Rule(ruleName, event, () => true, conditionOrAction as () => void);
    this.rules.push(rule);
    }

    //Used to execute debug code in JS. This will be discarded by the compiler.
    export function debugExecute(action: () => void): void {
        action();
    }

    export class Rule {
        public readonly name: string;
        public readonly event: Events.Ongoing;
        public readonly condition: () => boolean;
        public readonly action: () => void;

        constructor(name: string, event: Events.Ongoing, condition: () => boolean, action: () => void) {
            this.name = name;
            this.event = event;
            this.condition = condition;
            this.action = action;
        }

        public run(): void {
            if (this.condition())
                this.action();
        }
    }
}
Native.defineTypescriptNativeArg1Function<number, number>("Absolute Value", Math.abs);

class Player {
    private constructor() { }
    
    public get altitude(): number {
        return Native.callNativeArg1Function<Player, number>("Altitude Of", this);
    }
}

class Players {
    private constructor() { }

    public static deadOnTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Dead Players", team);
    }
    
    public static aliveOnTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Living Players", team);
    }

    public static onTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players", team);
    }

    public static notOnObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players Not On Objective", team);
    }

    public static onObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players On Objective", team);
    }


}

class Team {
    private constructor() { }
}

class Teams {
    public static get all(): Team[] {
        return Native.callNativeArg0Function<Team[]>("All Teams");
    }
}

class Hero {
    private constructor() { }

}

class Heroes {
    private constructor() { }

    public static get all(): Hero[] {
        return Native.callNativeArg0Function<Hero[]>("All Heroes");
    }

    public static allowedForPlayer(player: Player): Hero[] {
        return Native.callNativeArg1Function<Player, Hero[]>("Allowed Heroes", player);
    }
}

class Triggering {
    private constructor() { }

    public static get player(): Player {
        return Native.callNativeArg0Function<Player>("Event Player");
    }
}

module Events {
    export enum Ongoing {
        Global = "Ongoing - Global"
    }
}