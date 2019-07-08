"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
function wait(seconds) {
    native_1.Native.assert(seconds >= 0.3, "You can not wait for less than 0.3 seconds");
    native_1.Native.callNativeArg1Action("Wait", false, false, seconds);
}
exports.wait = wait;
//# sourceMappingURL=other.js.map