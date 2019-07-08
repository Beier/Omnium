import { Native } from "./native"

export function wait(seconds: number): void {
    Native.assert(seconds >= 0.3, "You can not wait for less than 0.3 seconds");
    Native.callNativeArg1Action<number>("Wait", false, false, seconds);
}