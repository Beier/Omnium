
import { Native } from "Native"

export class List<T> extends Array<T> {
    public static empty<T>() {
        return Native.callNativeArg0Function<List<T>>("Empty Array", false, false);
    }

    public append(item: T) {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Append To Array", false, false, this, item);
    }

    public remove(item: T) {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Remove from array", false, false, this, item);
    }

    public contains(item: T) {
        return Native.callNativeArg2Function<List<T>, T, boolean>("Array contains", false, false, this, item);
    }

    public slice(start: number, count: number) {
        return Native.callNativeArg3Function<List<T>, number, number, List<T>>("Array slice", false, false, this, start, count);
    }

    public get first() {
        return Native.callNativeArg1Function<List<T>, T>("First of", false, false, this);
    }

    public get last() {
        return Native.callNativeArg1Function<List<T>, T>("Last of", false, false, this);
    }

    public get randomItem() {
        return Native.callNativeArg1Function<List<T>, T>("Random value in array", false, false, this);
    }

    public get shuffled() {
        return Native.callNativeArg1Function<List<T>, List<T>>("Randomized array", false, false, this);
    }

    public get sorted() {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Sorted array", false, false, this, Native.callNativeArg0Function<T>("Current array element", false, false));
    }

    public get length() {
        return Native.callNativeArg1Function<List<T>, number>("Count Of", false, false, this);
    }

    public indexOf(element: T) {
        return Native.callNativeArg2Function<List<T>, T, number>("Index of array value", false, false, this, element);
    }

    public filter(condition: (item: T) => boolean) {
        return Native.listLambda<T, boolean, List<T>>("Filtered array", this, condition);
    }

    public where(condition: (item: T) => boolean) {
        return Native.listLambda<T, boolean, List<T>>("Filtered array", this, condition);
    }

    public any(condition: (item: T) => boolean = null) {
        if (condition == null)
            return this.length > 0;
        else
            return Native.listLambda<T, boolean, boolean>("Is true for any", this, condition);
    }

    public all(condition: (item: T) => boolean = null) {
        return Native.listLambda<T, boolean, boolean>("Is true for all", this, condition);
    }

    public sortedBy<TKey>(sortKey: (item: T) => TKey) {
        return Native.listLambda<T, TKey, List<T>>("Sorted array", this, sortKey);
    }

    public isEmpty() {
        return this.length == 0;
    }
}