"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
var Motion;
(function (Motion) {
    function applyImpulse(player, direction, speed, relative, contraryMotion) {
        if (relative === void 0) { relative = Relative.ToWorld; }
        if (contraryMotion === void 0) { contraryMotion = ContraryMotion.Cancel; }
        native_1.Native.callNativeArg5Action("Apply impulse", false, true, player, direction, speed, relative, contraryMotion);
    }
    Motion.applyImpulse = applyImpulse;
    function startAccelerating(player, direction, rate, maxSpeed, relative, reevaluation) {
        if (relative === void 0) { relative = Relative.ToWorld; }
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        native_1.Native.callNativeArg6Action("Start accelerating", false, true, player, direction, rate, maxSpeed, relative, reevaluation);
    }
    Motion.startAccelerating = startAccelerating;
    function stopAccelerating(player) {
        native_1.Native.callNativeArg1Action("Stop accelerating", false, true, player);
    }
    Motion.stopAccelerating = stopAccelerating;
    var Relative;
    (function (Relative) {
        Relative["ToWorld"] = "To world";
        Relative["ToPlayer"] = "To player";
    })(Relative = Motion.Relative || (Motion.Relative = {}));
    var ContraryMotion;
    (function (ContraryMotion) {
        ContraryMotion["Cancel"] = "Cancel contrary motion";
        ContraryMotion["Incorporate"] = "Incorporate contrary motion";
    })(ContraryMotion = Motion.ContraryMotion || (Motion.ContraryMotion = {}));
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["DirectionRateAndMaxSpeed"] = "Direction, rate, and max speed";
        Reevaluation["None"] = "None";
    })(Reevaluation = Motion.Reevaluation || (Motion.Reevaluation = {}));
})(Motion = exports.Motion || (exports.Motion = {}));
//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//Todo: Current array element
//# sourceMappingURL=motion.js.map