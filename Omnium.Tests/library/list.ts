
import { Native } from "Native"

export class List<T> extends Array<T> {
    public static empty<T>() : List<T> {
        return Native.callNativeArg0Function<List<T>>("Empty Array", false, false);
    }

    public append(item: T) : List<T> {
        return Native.callNativeArg2Function<List<T>, T, List<T>>("Append To Array", false, false, this, item);
    }
}