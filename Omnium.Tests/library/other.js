"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
function wait(seconds) {
    native_1.Native.assert(seconds >= 0.3, "You can not wait for less than 0.3 seconds");
    native_1.Native.callNativeArg1Action("Wait", false, false, seconds);
}
exports.wait = wait;
var Impulse;
(function (Impulse) {
    function apply(player, direction, speed, relative, contraryMotion) {
        if (relative === void 0) { relative = Relative.ToWorld; }
        if (contraryMotion === void 0) { contraryMotion = ContraryMotion.Cancel; }
        native_1.Native.callNativeArg5Action("Apply impulse", false, true, player, direction, speed, relative, contraryMotion);
    }
    Impulse.apply = apply;
    var Relative;
    (function (Relative) {
        Relative["ToWorld"] = "To world";
        Relative["ToPlayer"] = "To player";
    })(Relative = Impulse.Relative || (Impulse.Relative = {}));
    var ContraryMotion;
    (function (ContraryMotion) {
        ContraryMotion["Cancel"] = "Cancel contrary motion";
        ContraryMotion["Incorporate"] = "Incorporate contrary motion";
    })(ContraryMotion = Impulse.ContraryMotion || (Impulse.ContraryMotion = {}));
})(Impulse = exports.Impulse || (exports.Impulse = {}));
var Effect;
(function (Effect_1) {
    var Effect = /** @class */ (function () {
        function Effect() {
        }
        Effect.prototype.destroy = function () {
            native_1.Native.callNativeArg1Action("Destroy effect", false, true, this);
        };
        return Effect;
    }());
    Effect_1.Effect = Effect;
    function create(visibleTo, type, color, position, radius, reevaluation) {
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        native_1.Native.callNativeArg6Action("Create effect", false, true, visibleTo, type, color, position, radius, reevaluation);
    }
    Effect_1.create = create;
    function createSound(visibleTo, sound, position, radius, reevaluation) {
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        native_1.Native.callNativeArg6Action("Create effect", false, true, visibleTo, sound, Color.White, position, radius, reevaluation);
    }
    Effect_1.createSound = createSound;
    function destroyAll() {
        native_1.Native.callNativeArg0Action("Destroy all effects", false, true);
    }
    Effect_1.destroyAll = destroyAll;
    var Type;
    (function (Type) {
        Type["Sphere"] = "Sphere";
        Type["LightShaft"] = "Light shaft";
        Type["Orb"] = "Orb";
        Type["Ring"] = "Ring";
        Type["Cloud"] = "Cloud";
        Type["Sparkles"] = "Sparkles";
        Type["GoodAura"] = "Good aura";
        Type["BadAura"] = "Bad aura";
    })(Type = Effect_1.Type || (Effect_1.Type = {}));
    var Sound;
    (function (Sound) {
        Sound["Energy"] = "Energy sound";
        Sound["PickUp"] = "Pick-up sound";
        Sound["GoodAura"] = "Good aura sound";
        Sound["BadAura"] = "Bad aura sound";
        Sound["Sparkles"] = "Sparkles sound";
        Sound["Smoke"] = "Smoke sound";
        Sound["Decal"] = "Decal sound";
        Sound["Beacon"] = "Beacon sound";
    })(Sound = Effect_1.Sound || (Effect_1.Sound = {}));
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["VisibleToPositionAndRadius"] = "Visible to, position, and radius";
        Reevaluation["PositionAndRadius"] = "Position and radius";
        Reevaluation["VisibleTo"] = "Visible to";
        Reevaluation["None"] = "None";
    })(Reevaluation = Effect_1.Reevaluation || (Effect_1.Reevaluation = {}));
})(Effect = exports.Effect || (exports.Effect = {}));
var Icons;
(function (Icons) {
    var IconInstance = /** @class */ (function () {
        function IconInstance() {
        }
        return IconInstance;
    }());
    Icons.IconInstance = IconInstance;
    function create(icon, color, visibleTo, position, reevaluation, showWhenOffscreen) {
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        if (showWhenOffscreen === void 0) { showWhenOffscreen = true; }
        native_1.Native.callNativeArg6Action("Create icon", false, true, visibleTo, position, icon, reevaluation, color, showWhenOffscreen);
    }
    Icons.create = create;
    function destroyAll() {
        native_1.Native.callNativeArg0Action("Destroy all icons", false, true);
    }
    Icons.destroyAll = destroyAll;
    var Icon;
    (function (Icon) {
        Icon["ArrowUp"] = "Arrow: Up";
        Icon["ArrowDown"] = "Arrow: Down";
        Icon["ArrowLeft"] = "Arrow: Left";
        Icon["ArrowRight"] = "Arrow: Right";
        Icon["Asterisk"] = "Asterisk";
        Icon["Bolt"] = "Bolt";
        Icon["Circle"] = "Circle";
        Icon["Club"] = "Club";
        Icon["Diamond"] = "Diamond";
        Icon["Dizzy"] = "Dizzy";
        Icon["ExclamationMark"] = "Exclamation Mark";
        Icon["Eye"] = "Eye";
        Icon["Fire"] = "Fire";
        Icon["Flag"] = "Flag";
        Icon["Halo"] = "Halo";
        Icon["Happy"] = "Happy";
        Icon["Heart"] = "Heart";
        Icon["Moon"] = "Moon";
        Icon["No"] = "No";
        Icon["Plus"] = "Plus";
        Icon["Poison"] = "Poison";
        Icon["Poison2"] = "Poison 2";
        Icon["QuestionMark"] = "Question Mark";
        Icon["Radioactive"] = "Radioactive";
        Icon["Recycle"] = "Recycle";
        Icon["RingThick"] = "Ring Thick";
        Icon["RingThin"] = "Ring Thin";
        Icon["Sad"] = "Sad";
        Icon["Skull"] = "Skull";
        Icon["Spade"] = "Spade";
        Icon["Spiral"] = "Spiral";
        Icon["Stop"] = "Stop";
        Icon["Trashcan"] = "Trashcan";
        Icon["Warning"] = "Warning";
        Icon["X"] = "X";
    })(Icon = Icons.Icon || (Icons.Icon = {}));
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["VisibleToAndPosition"] = "Visible to and position";
        Reevaluation["Position"] = "Position";
        Reevaluation["VisibleTo"] = "Visible to";
        Reevaluation["None"] = "None";
    })(Reevaluation = Icons.Reevaluation || (Icons.Reevaluation = {}));
})(Icons = exports.Icons || (exports.Icons = {}));
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
var GameMode;
(function (GameMode) {
    var Deathmatch;
    (function (Deathmatch) {
        function declareVictory(player) {
            native_1.Native.callNativeArg1Action("Declare player victory", false, true, player);
        }
        Deathmatch.declareVictory = declareVictory;
    })(Deathmatch = GameMode.Deathmatch || (GameMode.Deathmatch = {}));
    var Control;
    (function (Control) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare round victory", false, true, team);
        }
        Control.declareVictory = declareVictory;
    })(Control = GameMode.Control || (GameMode.Control = {}));
    var Elimination;
    (function (Elimination) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare round victory", false, true, team);
        }
        Elimination.declareVictory = declareVictory;
    })(Elimination = GameMode.Elimination || (GameMode.Elimination = {}));
    var Assault;
    (function (Assault) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
        }
        Assault.declareVictory = declareVictory;
        function declareDraw() {
            native_1.Native.callNativeArg0Action("Declare match draw", false, true);
        }
        Assault.declareDraw = declareDraw;
    })(Assault = GameMode.Assault || (GameMode.Assault = {}));
    var Escort;
    (function (Escort) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
        }
        Escort.declareVictory = declareVictory;
        function declareDraw() {
            native_1.Native.callNativeArg0Action("Declare match draw", false, true);
        }
        Escort.declareDraw = declareDraw;
    })(Escort = GameMode.Escort || (GameMode.Escort = {}));
    var AssaultEscort;
    (function (AssaultEscort) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
        }
        AssaultEscort.declareVictory = declareVictory;
        function declareDraw() {
            native_1.Native.callNativeArg0Action("Declare match draw", false, true);
        }
        AssaultEscort.declareDraw = declareDraw;
    })(AssaultEscort = GameMode.AssaultEscort || (GameMode.AssaultEscort = {}));
    var CaptureTheFlag;
    (function (CaptureTheFlag) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
        }
        CaptureTheFlag.declareVictory = declareVictory;
        function declareDraw() {
            native_1.Native.callNativeArg0Action("Declare match draw", false, true);
        }
        CaptureTheFlag.declareDraw = declareDraw;
    })(CaptureTheFlag = GameMode.CaptureTheFlag || (GameMode.CaptureTheFlag = {}));
    var TeamDeathmatch;
    (function (TeamDeathmatch) {
        function declareVictory(team) {
            native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
        }
        TeamDeathmatch.declareVictory = declareVictory;
        function declareDraw() {
            native_1.Native.callNativeArg0Action("Declare match draw", false, true);
        }
        TeamDeathmatch.declareDraw = declareDraw;
    })(TeamDeathmatch = GameMode.TeamDeathmatch || (GameMode.TeamDeathmatch = {}));
})(GameMode = exports.GameMode || (exports.GameMode = {}));
//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//# sourceMappingURL=other.js.map