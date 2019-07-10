import { Rule } from "rule"
import { HeroType } from "hero"
import { } from "strings"

//This serves as a definition of the methods and properties avalible in Overwatch, and how to map to them.
//For instance, in TypeScript, there is a class called Player, which has a getter "altitude", which defines a mapping to "Altitude Of(this)"


//The native module is special. Every method defined here have a special meaning to the compiler, and will be removed during compilation.
export module Native {
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

    export function callNativeArg3Action<T1, T2, T3>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3,
        jsAction: (p1: T1, p2: T2, p3: T3) => void = null): void {
        jsAction(argument1, argument2, argument3);
    }

    export function callNativeArg3Function<T1, T2, T3, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, 
        jsAction: (p1: T1, p2: T2, p3: T3) => TReturn = null): TReturn {
        return jsAction(argument1, argument2, argument3);
    }

    export function callNativeArg4Action<T1, T2, T3, T4>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4,
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4) => void = null): void {
        jsAction(argument1, argument2, argument3, argument4);
    }

    export function callNativeArg4Function<T1, T2, T3, T4, TReturn>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, 
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4) => TReturn = null): TReturn {
        return jsAction(argument1, argument2, argument3, argument4);
    }

    export function callNativeArg5Action<T1, T2, T3, T4, T5>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, argument5: T5,
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5) => void = null): void {
        jsAction(argument1, argument2, argument3, argument4, argument5);
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

    export function callNativeArg7Action<T1, T2, T3, T4, T5, T6, T7>(
        methodName: string, readsState: boolean, changesState: boolean,
        argument1: T1, argument2: T2, argument3: T3, argument4: T4, argument5: T5, argument6: T6, argument7: T7,
        jsAction: (p1: T1, p2: T2, p3: T3, p4: T4, p5: T5, p6: T6, p7: T7) => void = null): void {
        jsAction(argument1, argument2, argument3, argument4, argument5, argument6, argument7);
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

    export function defineTypescriptNativeArg2Function<T1, T2, TReturn>(methodName: string, readsState: boolean, changesState: boolean,
        jsAction: (p1: T1, p2: T2) => TReturn): void {
    }

    //Used to list the strings available in overwatch
    export function registerString(s: string): void {

    }

    export function defineBinaryOperation<TLeft, TRight, TResult>(operator: string): void {

    }



    export function trigger(name: string): Rule.Event {
        return new Rule.Event();
    }

    export function playerTrigger(name: string, team: Rule.Events.Team, player: Rule.Events.Players | Rule.Events.Slot | HeroType): Rule.Event {
        return new Rule.Event();
    }

    //This is used to define new rules
    export function rule(ruleName: string, event: Rule.Event, conditionOrAction: boolean | (() => void), action: () => void = null): void {

    }

    //Used to execute debug code in JS. This will be discarded by the compiler.
    export function debugExecute(action: () => void): void {
        action();
    }

    export function assert(condition: boolean, message: string = null): void {

    }
}


export function wait(seconds: number): void {
    Native.callNativeArg2Action<number, WaitType>("Wait", false, false, seconds, WaitType.IgnoreCondition);
}

enum WaitType {
    //The other wait types modify control flow, and are not currently supported
    IgnoreCondition = "Ignore condition"
}

Native.defineTypescriptNativeArg1Function<number, number>("Absolute Value", false, false, Math.abs);
Native.defineTypescriptNativeArg1Function<number, number>("Arccosine in radians", false, false, Math.acos);
Native.defineTypescriptNativeArg1Function<number, number>("Arcsine in radians", false, false, Math.asin);
Native.defineTypescriptNativeArg2Function<number, number, number>("Arctangent in radians", false, false, Math.atan2);
Native.defineTypescriptNativeArg1Function<number, number>("Cosine from radians", false, false, Math.cos);
Native.defineTypescriptNativeArg1Function<number, number>("Sine from radians", false, false, Math.sin);
Native.defineTypescriptNativeArg2Function<number, number, number>("Max", false, false, Math.max);
Native.defineTypescriptNativeArg2Function<number, number, number>("Min", false, false, Math.min);
Native.defineTypescriptNativeArg2Function<number, number, number>("Raise to power", false, false, Math.pow);
Native.defineTypescriptNativeArg1Function<number, number>("Square root", false, false, Math.sqrt);
Native.defineTypescriptNativeArg1Function<number, number>("Tangent from radians", false, false, Math.tan);

export module Random {
    export function integer(min: number, max: number): number {
        return Native.callNativeArg2Function<number, number, number>("Random integer", false, false, min, max);
    }
    export function real(min: number, max: number): number {
        return Native.callNativeArg2Function<number, number, number>("Random real", false, false, min, max);
    }
}

export function round(number: number, type: RoundType = RoundType.ToNearest): number {
    return Native.callNativeArg2Function<number, RoundType, number>("Round to integer", false, false, number, type);
}

export enum RoundType {
    Up = "Up",
    Down = "Down",
    ToNearest = "To nearest"
}