import { Rule } from "rule"
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



    export function trigger(name: string): Rule.Events.Event {
        return new Rule.Events.Event();
    }

    export function playerTrigger(name: string, team: Rule.Events.Team, player: Rule.Events.Player): Rule.Events.Event {
        return new Rule.Events.Event();
    }

    //This is used to define new rules
    export function rule(ruleName: string, event: Rule.Events.Event, conditionOrAction: boolean | (() => void), action: () => void = null): void {

    }

    //Used to execute debug code in JS. This will be discarded by the compiler.
    export function debugExecute(action: () => void): void {
        action();
    }

    export function assert(condition: boolean, message: string = null): void {

    }
}

Native.defineTypescriptNativeArg1Function<number, number>("Absolute Value", false, false, Math.abs);
