

//This serves as a definition of the methods and properties avalible in Overwatch, and how to map to them.
//For instance, in TypeScript, there is a class called Player, which has a getter "altitude", which defines a mapping to "Altitude Of(this)"


//The native module is special. Every method defined here have a special meaning to the compiler, and will be removed during compilation.
module Native {
    //These methods are used to define a member that can be called in the target language, while providing an implementation to be used when debugging in JS.
    //If a specific number of arguments is missing, just add it. The compiler recognizes methods named /^arg\d+(Function|Action)$/. Function for methods with a return value, action for void return.
    export function callNativeArg0Function<TReturn>(methodName: string, readsState: boolean, changesState: boolean, jsAction: () => TReturn = null): TReturn {
        return jsAction();
    }

    export function callNativeArg0Action(methodName: string, readsState: boolean, changesState: boolean, jsAction: () => void = null): void {
        jsAction();
    }

    export function callNativeArg1Function<T1, TReturn>(methodName: string, readsState: boolean, changesState: boolean, argument1: T1, jsAction: (p1: T1) => TReturn = null): TReturn {
        return jsAction(argument1);
    }

    export function callNativeArg1Action<T1>(methodName: string, readsState: boolean, changesState: boolean, argument1: T1, jsAction: (p1: T1) => void = null): void {
        jsAction(argument1);
    }

    export function callNativeArg2Action<T1, T2>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2,
        jsAction: (p1: T1, p2: T2) => void = null): void {
        jsAction(argument1, argument2);
    }

    export function callNativeArg2Function<T1, T2, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2,
        jsAction: (p1: T1, p2: T2) => TReturn = null): TReturn {
        return jsAction(argument1, argument2);
    }

    export function callNativeArg3Function<T1, T2, T3, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, 
        jsAction: (p1: T1, p2: T2, p3: T3) => TReturn = null): TReturn {
        return jsAction(argument1, argument2, argument3);
    }

    export function callNativeArg4Function<T1, T2, T3, T4, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, 
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4) => TReturn = null): TReturn {
        return jsAction(argument1, argument2, argument3, argument4);
    }

    export function callNativeArg5Function<T1, T2, T3, T4, T5, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, argument5: T5, 
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5) => TReturn = null): TReturn {
        return jsAction(argument1, argument2, argument3, argument4, argument5);
    }

    export function callNativeArg6Action<T1, T2, T3, T4, T5, T6>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, argument5: T5, argument6: T6,
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5, p6: T6) => void = null): void {
        jsAction(argument1, argument2, argument3, argument4, argument5, argument6);
    }

    export function callNativeArg10Action<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, argument5: T5, argument6: T6, argument7: T7, argument8: T8, argument9: T9, argument10: T10,
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5, p6: T6, p7: T7, p8: T8, p9: T9, p10: T10) => void = null): void {
        jsAction(argument1, argument2, argument3, argument4, argument5, argument6, argument7, argument8, argument9, argument10);
    }

    //This is used to define methods native to both typescript and overwatch. Ex. Math.abs(x) = Absolute Value(x)
    export function defineTypescriptNativeArg1Function<T1, TReturn>(methodName: string, readsState: boolean, changesState: boolean, jsAction: (p1: T1) => TReturn): void {
    }

    //Used to list the strings available in overwatch
    export function registerString(s: string): void {

    }

    export function defineBinaryOperation<TLeft, TRight, TResult>(operator: string): void {

    }



    export function trigger(name: string): Events.Event {
        return new Events.Event();
    }

    export function playerTrigger(name: string, team: Events.Team, player: Events.Player): Events.Event {
        return new Events.Event();
    }

    //This is used to define new rules
    export function rule(ruleName: string, event: Events.Event, conditionOrAction: boolean | (() => void), action: () => void = null): void {

    }

    //Used to execute debug code in JS. This will be discarded by the compiler.
    export function debugExecute(action: () => void): void {
        action();
    }

    export function assert(condition: boolean, message: string = null): void {

    }
}

module Events {
    export class Event {

    }

    export class Ongoing {
        public static get global(): Event {
            return Native.trigger("Ongoing - Global");
        }

        public static eachPlayer(team: Team = Team.All, player: Player = Player.All): Event {
            return Native.playerTrigger("Ongoing - Each Player", team, player);
        }
    }

    export enum Team {
        All = "All",
        Team1 = "Team 1",
        Team2 = "Team 2"
    }

    export enum Player {
        All = "All",
        Slot0 = "Slot 0",
        Slot1 = "Slot 1",
        Slot2 = "Slot 2",
        Slot3 = "Slot 3",
        Slot4 = "Slot 4",
        Slot5 = "Slot 5",
        Slot6 = "Slot 6",
        Slot7 = "Slot 7",
        Slot8 = "Slot 8",
        Slot9 = "Slot 9",
        Slot10 = "Slot 10",
        Slot11 = "Slot 11"//Todo: Heroes
    }
}

Native.defineTypescriptNativeArg1Function<number, number>("Absolute Value", false, false, Math.abs);


class Player {
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

class Players {
    private constructor() { }

    public static deadOnTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Dead Players", true, false, team);
    }

    public static aliveOnTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Living Players", true, false, team);
    }

    public static onTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players", true, false, team);
    }

    public static get all(): Player[] {
        return Players.onTeam(Teams.all);
    }

    public static notOnObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players Not On Objective", true, false, team);
    }

    public static onObjectiveFromTeam(team: Team | Team[]): Player[] {
        return Native.callNativeArg1Function<Team | Team[], Player[]>("All Players On Objective", true, false, team);
    }
}

enum Button {
    PrimaryFire = "Primary Fire",
    SecondaryFire = "Secondary Fire",
    Ability1 = "Ability 1",
    Ability2 = "Ability 2",
    Ultimate = "Ultimate",
    Interact = "Interact",
    Jump = "Jump",
    Crouch = "Crouch",
}

class Team {
    private constructor() { }

    public static get team1(): Team {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team1);
    }

    public static get team2(): Team {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team2);
    }
}

class Teams {
    public static get all(): Team[] {
        return Native.callNativeArg1Function<TeamConst, Team[]>("Team", true, false, TeamConst.All);
    }
}

enum TeamConst {
    All = "All",
    Team1 = "Team 1",
    Team2 = "Team 2"
}

class Hero {
    private constructor() { }

}

class Heroes {
    private constructor() { }

    public static get all(): Hero[] {
        return Native.callNativeArg0Function<Hero[]>("All Heroes", true, false);
    }

    public static allowedForPlayer(player: Player): Hero[] {
        return Native.callNativeArg1Function<Player, Hero[]>("Allowed Heroes", true, false, player);
    }
}

function vector(x: number, y: number, z: number): Vector {
    return Native.callNativeArg3Function<number, number, number, Vector>("Vector", false, false, x, y, z);
}

class Vector {
    public static get zero(): Vector {
        return vector(0, 0, 0);
    }

    public static get up(): Vector {
        return Native.callNativeArg0Function<Vector>("Up", false, false);
    }

    public static getFirstIntersectionBetween(start: Vector,
        end: Vector,
        playersToInclude: Player | Player[] = Players.all,
        playersToExclude: Player | Player[] = Triggering.player,
        includePlayerOwnedObjects: boolean = true): Vector {
        return Native.callNativeArg5Function<Vector, Vector, Player | Player[], Player | Player[], boolean, Vector>(
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


class Triggering {
    private constructor() { }

    public static get player(): Player {
        return Native.callNativeArg0Function<Player>("Event Player", false, false);
    }
}

class Game {
    public static createHudText(
        players: Player | Player[],
        header: string = null,
        subHeader: string = null,
        text: string = null,
        location: TextLocation = TextLocation.Left,
        sortOrder: number = 0,
        headerColor: TextColor = TextColor.White,
        subHeaderColor: TextColor = TextColor.White,
        textColor: TextColor = TextColor.White,
        reevaluation: HudTextReevaluation = HudTextReevaluation.VisibleToAndString): void {
        Native.callNativeArg10Action<
            Player | Player[],
            string,
            string,
            string,
            TextLocation,
            number,
            TextColor,
            TextColor,
            TextColor,
            HudTextReevaluation>(
                "Create HUD Text",
                false,
                true,
                players,
                header,
                subHeader,
                text,
                location,
                sortOrder,
                headerColor,
                subHeaderColor,
                textColor,
                reevaluation);
    }

    public static sendMessageTo(players: Player | Player[], message: string, size: MessageSize = MessageSize.Big): void {
        if (size == MessageSize.Big) {
            Native.callNativeArg2Action<Player | Player[], string>("Big Message", false, false, players, message);
        } else {
            Native.callNativeArg2Action<Player | Player[], string>("Small Message", false, false, players, message);
        }
    }

    public static createInWorldText(
        visibleTo: Player | Player[],
        header: string,
        position: Vector,
        scale: number = 1,
        clipping: InWorldTextClipping = InWorldTextClipping.BlockedByWalls,
        reevaluation: InWorldTextReevaluation = InWorldTextReevaluation.VisibleToPositionAndString): void {
        Native.callNativeArg6Action
            <Player | Player[], string, Vector, number, InWorldTextClipping, InWorldTextReevaluation>(
                "Create in-world text", false, true, visibleTo, header, position, scale, clipping, reevaluation);
    }
}

/*
 *
 * actions
{
	Big Message(All Players(All Teams), String("Hello", Null, Null, Null));
	Small Message(All Players(All Teams), String("Hello", Null, Null, Null));
}
 */

enum MessageSize {
    Big,
    Small
}

enum TextLocation {
    Left = "Left",
    Top = "Top",
    Right = "Right"
}

enum TextColor {
    White = "White",
    Yellow = "Yellow",
    Green = "Green",
    Purple = "Purple",
    Red = "Red",
    Blue = "Blue",
    Team1 = "Team 1",
    Team2 = "Team 2"
}

enum HudTextReevaluation {
    String = "String",
    VisibleToAndString = "Visible To and String"
}

enum InWorldTextClipping {
    BlockedByWalls = "Clip against surfaces",
    AlwaysVisible = "Do not clip"
}

enum InWorldTextReevaluation {
    VisibleToPositionAndString = "Visible to position and string",
    VisibleToAndString = "Visible to and string",
    String = "String"
}

function wait(seconds: number): void {
    Native.assert(seconds >= 0.3, "You can not wait for less than 0.3 seconds");
    Native.callNativeArg1Action<number>("Wait", false, false, seconds);
}

class List<T> extends Array<T> {
    public static empty<T>() : List<T> {
        return Native.callNativeArg0Function<List<T>>("Empty Array", false, false);
    }

    public append(item: T) : List<T> {
        return Native.callNativeArg1Function<T, List<T>>("Append To Array", false, false, item);
    }
}

function FOo() {
    var arr = List.empty<Player>();

    for (var x of arr) {
        x.
    }
}