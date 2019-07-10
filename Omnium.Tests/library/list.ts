
import { Native } from "Native"

export class List<T> extends Array<T> {
    public static empty<T>() : List<T> {
        return Native.callNativeArg0Function<List<T>>("Empty Array", false, false);
    }

    public append(item: T) : List<T> {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Append To Array", false, false, this, item);
    }

    public remove(item: T): List<T> {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Remove from array", false, false, this, item);
    }

    public contains(item: T): boolean {
        return Native.callNativeArg2Function<List<T>, T, boolean>("Array contains", false, false, this, item);
    }

    public slice(start: number, count: number): List<T> {
        return Native.callNativeArg3Function<List<T>, number, number, List<T>>("Array slice", false, false, this, start, count);
    }

    public get first(): T {
        return Native.callNativeArg1Function<List<T>, T>("First of", false, false, this);
    }

    public get last(): T {
        return Native.callNativeArg1Function<List<T>, T>("Last of", false, false, this);
    }

    public get randomItem(): T {
        return Native.callNativeArg1Function<List<T>, T>("Random value in array", false, false, this);
    }

    public get shuffled(): List<T> {
        return Native.callNativeArg1Function<List<T>, List<T>>("Randomized array", false, false, this);
    }

    public get sorted(): List<T> {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Sorted array", false, false, this, Native.callNativeArg0Function<T>("Current array element", false, false));
    }

    public indexOf(element: T): number {
        return Native.callNativeArg2Function<List<T>, T, number>("Index of array value", false, false, this, element);
    }

    //Todo: Filtered array
    //Todo: Is true for all
    //Todo: Is true for any
    //Todo: Sort by
}