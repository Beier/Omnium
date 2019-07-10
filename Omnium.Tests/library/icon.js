"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
var Icon;
(function (Icon_1) {
    var Icon = /** @class */ (function () {
        function Icon() {
        }
        Icon.prototype.destroy = function () {
            native_1.Native.callNativeArg1Action("Destroy icon", false, true, this);
        };
        Object.defineProperty(Icon.prototype, "exists", {
            get: function () {
                return native_1.Native.callNativeArg1Function("Entity exists", false, false, this);
            },
            enumerable: true,
            configurable: true
        });
        return Icon;
    }());
    Icon_1.Icon = Icon;
    function create(type, color, visibleTo, position, reevaluation, showWhenOffscreen) {
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        if (showWhenOffscreen === void 0) { showWhenOffscreen = true; }
        native_1.Native.callNativeArg6Action("Create icon", false, true, visibleTo, position, type, reevaluation, color, showWhenOffscreen);
        return getLastCreatedIcon();
    }
    Icon_1.create = create;
    function getLastCreatedIcon() {
        return native_1.Native.callNativeArg0Function("Last created entity", true, false);
    }
    Icon_1.getLastCreatedIcon = getLastCreatedIcon;
    function destroyAll() {
        native_1.Native.callNativeArg0Action("Destroy all icons", false, true);
    }
    Icon_1.destroyAll = destroyAll;
    var Type;
    (function (Type) {
        Type["ArrowUp"] = "Arrow: Up";
        Type["ArrowDown"] = "Arrow: Down";
        Type["ArrowLeft"] = "Arrow: Left";
        Type["ArrowRight"] = "Arrow: Right";
        Type["Asterisk"] = "Asterisk";
        Type["Bolt"] = "Bolt";
        Type["Circle"] = "Circle";
        Type["Club"] = "Club";
        Type["Diamond"] = "Diamond";
        Type["Dizzy"] = "Dizzy";
        Type["ExclamationMark"] = "Exclamation Mark";
        Type["Eye"] = "Eye";
        Type["Fire"] = "Fire";
        Type["Flag"] = "Flag";
        Type["Halo"] = "Halo";
        Type["Happy"] = "Happy";
        Type["Heart"] = "Heart";
        Type["Moon"] = "Moon";
        Type["No"] = "No";
        Type["Plus"] = "Plus";
        Type["Poison"] = "Poison";
        Type["Poison2"] = "Poison 2";
        Type["QuestionMark"] = "Question Mark";
        Type["Radioactive"] = "Radioactive";
        Type["Recycle"] = "Recycle";
        Type["RingThick"] = "Ring Thick";
        Type["RingThin"] = "Ring Thin";
        Type["Sad"] = "Sad";
        Type["Skull"] = "Skull";
        Type["Spade"] = "Spade";
        Type["Spiral"] = "Spiral";
        Type["Stop"] = "Stop";
        Type["Trashcan"] = "Trashcan";
        Type["Warning"] = "Warning";
        Type["X"] = "X";
    })(Type = Icon_1.Type || (Icon_1.Type = {}));
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["VisibleToAndPosition"] = "Visible to and position";
        Reevaluation["Position"] = "Position";
        Reevaluation["VisibleTo"] = "Visible to";
        Reevaluation["None"] = "None";
    })(Reevaluation = Icon_1.Reevaluation || (Icon_1.Reevaluation = {}));
})(Icon = exports.Icon || (exports.Icon = {}));
var Color;
(function (Color) {
    Color["White"] = "White";
    Color["Yellow"] = "Yellow";
    Color["Green"] = "Green";
    Color["Purple"] = "Purple";
    Color["Red"] = "Red";
    Color["Blue"] = "Blue";
    Color["OfTeam1"] = "Team 1";
    Color["OfTeam2"] = "Team 2";
})(Color = exports.Color || (exports.Color = {}));
//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//Todo: Current array element
//# sourceMappingURL=icon.js.map