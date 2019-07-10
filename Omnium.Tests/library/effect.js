"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
var player_1 = require("./player");
var Effect;
(function (Effect_1) {
    var Static;
    (function (Static) {
        var Effect = /** @class */ (function () {
            function Effect() {
            }
            Effect.prototype.destroy = function () {
                native_1.Native.callNativeArg1Action("Destroy effect", false, true, this);
            };
            Object.defineProperty(Effect.prototype, "exists", {
                get: function () {
                    return native_1.Native.callNativeArg1Function("Entity exists", false, false, this);
                },
                enumerable: true,
                configurable: true
            });
            return Effect;
        }());
        Static.Effect = Effect;
        function create(visibleTo, type, color, position, radius, reevaluation) {
            if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
            native_1.Native.callNativeArg6Action("Create effect", false, true, visibleTo, type, color, position, radius, reevaluation);
            return getLastCreatedEffect();
        }
        Static.create = create;
        function createSound(visibleTo, sound, position, radius, reevaluation) {
            if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
            native_1.Native.callNativeArg6Action("Create effect", false, true, visibleTo, sound, Color.White, position, radius, reevaluation);
            return getLastCreatedEffect();
        }
        Static.createSound = createSound;
        function getLastCreatedEffect() {
            return native_1.Native.callNativeArg0Function("Last created entity", true, false);
        }
        Static.getLastCreatedEffect = getLastCreatedEffect;
        function destroyAll() {
            native_1.Native.callNativeArg0Action("Destroy all effects", false, true);
        }
        Static.destroyAll = destroyAll;
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
        })(Type = Static.Type || (Static.Type = {}));
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
        })(Sound = Static.Sound || (Static.Sound = {}));
        var Reevaluation;
        (function (Reevaluation) {
            Reevaluation["VisibleToPositionAndRadius"] = "Visible to, position, and radius";
            Reevaluation["PositionAndRadius"] = "Position and radius";
            Reevaluation["VisibleTo"] = "Visible to";
            Reevaluation["None"] = "None";
        })(Reevaluation = Static.Reevaluation || (Static.Reevaluation = {}));
    })(Static = Effect_1.Static || (Effect_1.Static = {}));
    var Animated;
    (function (Animated) {
        function create(type, color, position, radius, visibleTo) {
            if (radius === void 0) { radius = 1; }
            if (visibleTo === void 0) { visibleTo = player_1.Players.all; }
            native_1.Native.callNativeArg5Action("Play effect", false, false, visibleTo, type, color, position, radius);
        }
        Animated.create = create;
        function createSound(sound, position, radius, visibleTo) {
            if (radius === void 0) { radius = 1; }
            if (visibleTo === void 0) { visibleTo = player_1.Players.all; }
            native_1.Native.callNativeArg5Action("Play effect", false, false, visibleTo, sound, Color.White, position, radius);
        }
        Animated.createSound = createSound;
        var Type;
        (function (Type) {
            Type["GoodExplosion"] = "Good explosion";
            Type["BadExplosion"] = "Bad explosion";
            Type["RingExplosion"] = "Ring explosion";
            Type["GoodPickup"] = "Good pickup";
            Type["BadPickup"] = "Bad pickup";
        })(Type = Animated.Type || (Animated.Type = {}));
        var Sound;
        (function (Sound) {
            Sound["DebuffImpact"] = "Debuff impact sound";
            Sound["BuffImpact"] = "Buff impact sound";
            Sound["RingExplosion"] = "Ring explosion sound";
            Sound["BuffExplosion"] = "Buff explosion sound";
            Sound["Explosion"] = "Explosion sound";
        })(Sound = Animated.Sound || (Animated.Sound = {}));
    })(Animated = Effect_1.Animated || (Effect_1.Animated = {}));
})(Effect = exports.Effect || (exports.Effect = {}));
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
//# sourceMappingURL=effect.js.map