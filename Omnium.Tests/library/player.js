"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Native_1 = require("./Native");
var Team_1 = require("./Team");
var motion_1 = require("./motion");
var Player = /** @class */ (function () {
    function Player() {
    }
    Object.defineProperty(Player.prototype, "altitude", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Altitude Of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isAlive", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is alive", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isDead", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is dead", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isInAir", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is in air", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isOnGround", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is on ground", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isOnWall", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is on wall", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isOnObjective", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is on objective", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isMoving", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is moving", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isPortraitOnFire", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is portrait on fire", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isInSpawnRoom", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is in spawn room", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isFiringPrimary", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is firing primary", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isFiringSecondary", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is firing secondary", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isCrouching", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is crouching", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isStanding", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is standing", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isUsingAbility1", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is using ability 1", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isUsingAbility2", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is using ability 2", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isUsingUltimate", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Is using ultimate", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "health", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Health", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "healthFraction", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Normalized health", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "maxHealth", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Max health", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.isHoldingButton = function (button) {
        return Native_1.Native.callNativeArg2Function("Is Button Held", true, false, this, button);
    };
    Object.defineProperty(Player.prototype, "position", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Position of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "horizontalSpeed", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Horizontal speed of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "verticalSpeed", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Vertical speed of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "speed", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Speed of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.getSpeedInDirection = function (direction) {
        return Native_1.Native.callNativeArg2Function("Speed of in direction", true, false, this, direction);
    };
    Object.defineProperty(Player.prototype, "eyePosition", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Eye position", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "horizontalFacingAngle", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Horizontal facing angle of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "verticalFacingAngle", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Vertical facing angle of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "facingDirection", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Facing direction of", true, false, this);
        },
        set: function (direction) {
            Facing.set(this, direction);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.setFacingDirectionAtRate = function (direction, turnRate) {
        Facing.setAtRate(this, direction, turnRate);
    };
    Player.prototype.stopEnforcingFacingDirection = function () {
        Facing.stop(this);
    };
    Player.prototype.setButtonEnabled = function (button, isEnabled) {
        if (isEnabled)
            this.allowButton(button);
        else
            this.disallowButton(button);
    };
    Player.prototype.holdButton = function (button) {
        Native_1.Native.callNativeArg2Action("Start holding button", false, true, this, button);
    };
    Player.prototype.stopHoldingButton = function (button) {
        Native_1.Native.callNativeArg2Action("Stop holding button", false, true, this, button);
    };
    Player.prototype.setPrimaryFireEnabled = function (isEnabled) {
        Native_1.Native.callNativeArg2Action("Set primary fire enabled", false, true, this, isEnabled);
    };
    Player.prototype.setSecondaryFireEnabled = function (isEnabled) {
        Native_1.Native.callNativeArg2Action("Set secondary fire enabled", false, true, this, isEnabled);
    };
    Player.prototype.setAbility1Enabled = function (isEnabled) {
        Native_1.Native.callNativeArg2Action("Set ability 1 enabled", false, true, this, isEnabled);
    };
    Player.prototype.setAbility2Enabled = function (isEnabled) {
        Native_1.Native.callNativeArg2Action("Set ability 2 enabled", false, true, this, isEnabled);
    };
    Player.prototype.setUltimateEnabled = function (isEnabled) {
        Native_1.Native.callNativeArg2Action("Set ultimate ability enabled", false, true, this, isEnabled);
    };
    Player.prototype.allowButton = function (button) {
        Native_1.Native.callNativeArg2Action("Allow button", false, true, this, button);
    };
    Player.prototype.disallowButton = function (button) {
        Native_1.Native.callNativeArg2Action("Disallow button", false, true, this, button);
    };
    Player.prototype.pressButton = function (button) {
        Native_1.Native.callNativeArg2Action("Press button", false, true, this, button);
    };
    Player.prototype.setStatus = function (statusEffect, seconds, assister) {
        if (assister === void 0) { assister = null; }
        Native_1.Native.callNativeArg4Action("Set status", false, true, this, assister, statusEffect, seconds);
    };
    Player.prototype.clearStatus = function (statusEffect) {
        Native_1.Native.callNativeArg2Action("Clear status", false, true, this, statusEffect);
    };
    Object.defineProperty(Player.prototype, "isHacked", {
        get: function () {
            return this.hasStatus(StatusEffect.Hacked);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isBurning", {
        get: function () {
            return this.hasStatus(StatusEffect.Burning);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isKnockedDown", {
        get: function () {
            return this.hasStatus(StatusEffect.KnockedDown);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isAsleep", {
        get: function () {
            return this.hasStatus(StatusEffect.ASleep);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isFrozen", {
        get: function () {
            return this.hasStatus(StatusEffect.Frozen);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isUnkillable", {
        get: function () {
            return this.hasStatus(StatusEffect.Unkillable);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isInvincible", {
        get: function () {
            return this.hasStatus(StatusEffect.Invincible);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isPhasedOut", {
        get: function () {
            return this.hasStatus(StatusEffect.PhasedOut);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isRooted", {
        get: function () {
            return this.hasStatus(StatusEffect.Rooted);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "isStunned", {
        get: function () {
            return this.hasStatus(StatusEffect.Stunned);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.hasStatus = function (statusEffect) {
        return Native_1.Native.callNativeArg2Function("Has status", true, false, this, statusEffect);
    };
    Player.prototype.isUsingEmoteOrVoiceLine = function () {
        return Native_1.Native.callNativeArg1Function("Is communicating any", false, true, this);
    };
    Player.prototype.isUsingVoiceLine = function (voiceLine) {
        if (voiceLine === void 0) { voiceLine = null; }
        if (voiceLine == null)
            return Native_1.Native.callNativeArg1Function("Is communicating any voice line", false, true, this);
        else
            return Native_1.Native.callNativeArg2Function("Is communicating", false, true, this, voiceLine);
    };
    Player.prototype.useVoiceLine = function (voiceLine) {
        Native_1.Native.callNativeArg2Action("Communicate", false, true, this, voiceLine);
    };
    Player.prototype.isUsingEmote = function (emote) {
        if (emote === void 0) { emote = null; }
        if (emote == null)
            return Native_1.Native.callNativeArg1Function("Is communicating any emote", false, true, this);
        else
            return Native_1.Native.callNativeArg2Function("Is communicating", false, true, this, emote);
    };
    Player.prototype.useEmote = function (emote) {
        Native_1.Native.callNativeArg2Action("Communicate", false, true, this, emote);
    };
    Player.prototype.damage = function (amount, damager) {
        if (damager === void 0) { damager = null; }
        Native_1.Native.callNativeArg3Action("Damage", false, true, this, damager, amount);
    };
    Player.prototype.heal = function (amount, healer) {
        if (healer === void 0) { healer = null; }
        Native_1.Native.callNativeArg3Action("Heal", false, true, this, healer, amount);
    };
    Player.prototype.kill = function (killer) {
        if (killer === void 0) { killer = null; }
        Native_1.Native.callNativeArg2Action("Kill", false, true, this, killer);
    };
    Player.prototype.respawn = function () {
        Native_1.Native.callNativeArg1Action("Respawn", false, true, this);
    };
    Player.prototype.resurrect = function () {
        Native_1.Native.callNativeArg1Action("Resurrect", false, true, this);
    };
    Object.defineProperty(Player.prototype, "aimSpeedPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set aim speed", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "damageDealtPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set damage dealt", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "damageReceivedPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set damage received", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "healingDealtPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set healing dealt", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "healingReceivedPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set healing received", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "maxHealthPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set max health", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "movementSpeedPercentage", {
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set move speed", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "score", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Score of", true, false, this);
        },
        set: function (value) {
            Native_1.Native.callNativeArg2Action("Set player score", false, true, this, value);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "makeInvisibleTo", {
        set: function (invisibleTo) {
            Native_1.Native.callNativeArg2Action("Set invisible", false, true, this, invisibleTo);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "allowedHeroes", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Allowed Heroes", true, false, this);
        },
        set: function (heroes) {
            Native_1.Native.callNativeArg2Action("Set player allowed heroes", false, true, this, heroes);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "hero", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Hero of", true, false, this);
        },
        set: function (hero) {
            if (hero == null)
                Native_1.Native.callNativeArg1Action("Stop forcing player to be hero", false, true, this);
            else
                Native_1.Native.callNativeArg2Action("Start forcing player to be hero", false, true, this, hero);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "ultimateCharge", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Ultimate charge percent", true, false, this);
        },
        set: function (percentage) {
            Native_1.Native.callNativeArg2Action("Set ultimate charge", false, true, this, percentage);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.startCamera = function (eyePosition, lookAtPosition, blendSpeed) {
        Native_1.Native.callNativeArg4Action("Start camera", false, true, this, eyePosition, lookAtPosition, blendSpeed);
    };
    Player.prototype.stopCamera = function () {
        Native_1.Native.callNativeArg1Action("Stop camera", false, true, this);
    };
    Player.prototype.damageOverTime = function (damagePerSecond, seconds, damagers) {
        if (damagers === void 0) { damagers = null; }
        return DamageOverTime.start(damagePerSecond, seconds, this, damagers);
    };
    Player.prototype.healOverTime = function (healingPerSecond, seconds, damagers) {
        if (damagers === void 0) { damagers = null; }
        return HealOverTime.start(healingPerSecond, seconds, this, damagers);
    };
    Object.defineProperty(Player.prototype, "throttle", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Throttle of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.forceThrottle = function (minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways) {
        Native_1.Native.callNativeArg7Action("Start forcing throttle", false, true, this, minForward, maxForward, minBackward, maxBackward, minSideways, maxSideways);
    };
    Player.prototype.stopForcingThrottle = function () {
        Native_1.Native.callNativeArg1Action("Stop forcing throttle", false, true, this);
    };
    Player.prototype.startAccelerating = function (direction, rate, maxSpeed) {
        motion_1.Motion.startAccelerating(this, direction, rate, maxSpeed);
    };
    Player.prototype.stopAccelerating = function () {
        motion_1.Motion.stopAccelerating(this);
    };
    Player.prototype.teleportTo = function (position) {
        Native_1.Native.callNativeArg2Action("Teleport", false, true, this, position);
    };
    Player.closestTo = function (position, team) {
        if (team === void 0) { team = Team_1.Teams.all; }
        return Native_1.Native.callNativeArg2Function("Closest player to", true, false, position, team);
    };
    Player.farthestFrom = function (position, team) {
        if (team === void 0) { team = Team_1.Teams.all; }
        return Native_1.Native.callNativeArg2Function("Farthest player from", true, false, position, team);
    };
    Object.defineProperty(Player.prototype, "exists", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Entity exists", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "hasSpawned", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Has spawned", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Player.prototype.horizontalAngleTowards = function (position) {
        return Native_1.Native.callNativeArg2Function("Horizontal angle towards", false, false, this, position);
    };
    Player.prototype.verticalAngleTowards = function (position) {
        return Native_1.Native.callNativeArg2Function("Vertical angle towards", false, false, this, position);
    };
    Player.prototype.isLookingAt = function (position, viewConeAngle) {
        return Native_1.Native.callNativeArg3Function("Is in view angle", false, false, this, position, viewConeAngle);
    };
    Object.defineProperty(Player.prototype, "deaths", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Number of deaths", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "kills", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Number of eliminations", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "finalBlows", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Number of final blows", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "slot", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Slot of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Player.closestToReticle = function (player, team) {
        if (team === void 0) { team = Team_1.Teams.all; }
        return Native_1.Native.callNativeArg2Function("Player closest to reticle", true, false, player, team);
    };
    Object.defineProperty(Player.prototype, "team", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Team of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Player.prototype, "velocity", {
        get: function () {
            return Native_1.Native.callNativeArg1Function("Velocity of", true, false, this);
        },
        enumerable: true,
        configurable: true
    });
    return Player;
}());
exports.Player = Player;
var InvisibleTo;
(function (InvisibleTo) {
    InvisibleTo["Everyone"] = "All";
    InvisibleTo["Enemies"] = "Enemies";
    InvisibleTo["NoOne"] = "None";
})(InvisibleTo = exports.InvisibleTo || (exports.InvisibleTo = {}));
var Players = /** @class */ (function () {
    function Players() {
    }
    Players.count = function () {
        return Native_1.Native.callNativeArg1Function("Number of players", true, false, Team_1.Teams.all);
    };
    Players.countOnObjective = function () {
        return Native_1.Native.callNativeArg1Function("Number of players on objective", true, false, Team_1.Teams.all);
    };
    Players.dead = function () {
        return Native_1.Native.callNativeArg1Function("All Dead Players", true, false, Team_1.Teams.all);
    };
    Players.countDead = function () {
        return Native_1.Native.callNativeArg1Function("Number of dead players", true, false, Team_1.Teams.all);
    };
    Players.living = function () {
        return Native_1.Native.callNativeArg1Function("All Living Players", true, false, Team_1.Teams.all);
    };
    Players.countLiving = function () {
        return Native_1.Native.callNativeArg1Function("Number of Living Players", true, false, Team_1.Teams.all);
    };
    Players.onTeam = function (team) {
        return Native_1.Native.callNativeArg1Function("All Players", true, false, team);
    };
    Object.defineProperty(Players, "all", {
        get: function () {
            return Players.onTeam(Team_1.Teams.all);
        },
        enumerable: true,
        configurable: true
    });
    Players.notOnObjectiveFromTeam = function (team) {
        return Native_1.Native.callNativeArg1Function("All Players Not On Objective", true, false, team);
    };
    Players.onObjectiveFromTeam = function (team) {
        return Native_1.Native.callNativeArg1Function("All Players On Objective", true, false, team);
    };
    Players.beingLookedAtBy = function (player, team, viewConeAngle) {
        return Native_1.Native.callNativeArg3Function("Players in view angle", true, false, player, team, viewConeAngle);
    };
    Players.playingHero = function (hero, team) {
        if (team === void 0) { team = Team_1.Teams.all; }
        return Native_1.Native.callNativeArg2Function("Players on hero", true, false, hero, team);
    };
    Players.withinRadius = function (position, radius, team, lineOfSightCheck) {
        if (team === void 0) { team = Team_1.Teams.all; }
        if (lineOfSightCheck === void 0) { lineOfSightCheck = LineOfSightCheck.Off; }
        return Native_1.Native.callNativeArg4Function("Players within radius", true, false, position, radius, team, lineOfSightCheck);
    };
    return Players;
}());
exports.Players = Players;
var Button;
(function (Button) {
    Button["PrimaryFire"] = "Primary Fire";
    Button["SecondaryFire"] = "Secondary Fire";
    Button["Ability1"] = "Ability 1";
    Button["Ability2"] = "Ability 2";
    Button["Ultimate"] = "Ultimate";
    Button["Interact"] = "Interact";
    Button["Jump"] = "Jump";
    Button["Crouch"] = "Crouch";
})(Button = exports.Button || (exports.Button = {}));
var StatusEffect;
(function (StatusEffect) {
    StatusEffect["Hacked"] = "Hacked";
    StatusEffect["Burning"] = "Burning";
    StatusEffect["KnockedDown"] = "Knocked Down";
    StatusEffect["ASleep"] = "ASleep";
    StatusEffect["Frozen"] = "Frozen";
    StatusEffect["Unkillable"] = "Unkillable";
    StatusEffect["Invincible"] = "Invincible";
    StatusEffect["PhasedOut"] = "Phased Out";
    StatusEffect["Rooted"] = "Rooted";
    StatusEffect["Stunned"] = "Stunned";
})(StatusEffect = exports.StatusEffect || (exports.StatusEffect = {}));
var VoiceLine;
(function (VoiceLine) {
    VoiceLine["Up"] = "Voice Line up";
    VoiceLine["Down"] = "Voice Line down";
    VoiceLine["Left"] = "Voice Line left";
    VoiceLine["Right"] = "Voice Line right";
    VoiceLine["UltimateStatus"] = "Ultimate status";
    VoiceLine["Hello"] = "Hello";
    VoiceLine["NeedHealing"] = "Need healing";
    VoiceLine["GroupUp"] = "Group up";
    VoiceLine["Thanks"] = "Thanks";
    VoiceLine["Acknowledge"] = "Acknowledge";
})(VoiceLine = exports.VoiceLine || (exports.VoiceLine = {}));
var Emote;
(function (Emote) {
    Emote["Up"] = "Emote up";
    Emote["Down"] = "Emote down";
    Emote["Left"] = "Emote left";
    Emote["Right"] = "Emote right";
})(Emote = exports.Emote || (exports.Emote = {}));
var LineOfSightCheck;
(function (LineOfSightCheck) {
    LineOfSightCheck["Off"] = "Off";
    LineOfSightCheck["Surfaces"] = "Surfaces";
    LineOfSightCheck["SurfacesAndEnemyBarriers"] = "Surfaces and enemy barriers";
    LineOfSightCheck["SurfacesAndBarriers"] = "Surfaces and all barriers";
})(LineOfSightCheck = exports.LineOfSightCheck || (exports.LineOfSightCheck = {}));
var DamageModification;
(function (DamageModification_1) {
    var DamageModification = /** @class */ (function () {
        function DamageModification() {
        }
        DamageModification.prototype.stop = function () {
            Native_1.Native.callNativeArg1Action("Stop damage modification", false, true, this);
        };
        return DamageModification;
    }());
    DamageModification_1.DamageModification = DamageModification;
    function start(receivers, damagers, percentage, reevaluation) {
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        Native_1.Native.callNativeArg4Action("Start damage modification", false, true, receivers, damagers, percentage, reevaluation);
        return getLastCreated();
    }
    DamageModification_1.start = start;
    function getLastCreated() {
        return Native_1.Native.callNativeArg0Function("Last damage modification", true, false);
    }
    DamageModification_1.getLastCreated = getLastCreated;
    function stopAll() {
        Native_1.Native.callNativeArg0Action("Stop all damage modifications", false, true);
    }
    DamageModification_1.stopAll = stopAll;
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["All"] = "Receivers, damagers, and damage percent";
        Reevaluation["Players"] = "Receivers and damagers";
        Reevaluation["None"] = "None";
    })(Reevaluation = DamageModification_1.Reevaluation || (DamageModification_1.Reevaluation = {}));
})(DamageModification = exports.DamageModification || (exports.DamageModification = {}));
var DamageOverTime;
(function (DamageOverTime_1) {
    var DamageOverTime = /** @class */ (function () {
        function DamageOverTime() {
        }
        DamageOverTime.prototype.stop = function () {
            Native_1.Native.callNativeArg1Action("Stop damage over time", false, true, this);
        };
        return DamageOverTime;
    }());
    DamageOverTime_1.DamageOverTime = DamageOverTime;
    function start(damagePerSecond, seconds, receivers, damagers) {
        if (damagers === void 0) { damagers = null; }
        Native_1.Native.callNativeArg4Action("Start damage over time", false, true, receivers, damagers, seconds, damagePerSecond);
        return getLastCreated();
    }
    DamageOverTime_1.start = start;
    function getLastCreated() {
        return Native_1.Native.callNativeArg0Function("Last damage over time ID", true, false);
    }
    DamageOverTime_1.getLastCreated = getLastCreated;
    function stopAll() {
        Native_1.Native.callNativeArg0Action("Stop all damage over time", false, true);
    }
    DamageOverTime_1.stopAll = stopAll;
})(DamageOverTime = exports.DamageOverTime || (exports.DamageOverTime = {}));
var HealOverTime;
(function (HealOverTime_1) {
    var HealOverTime = /** @class */ (function () {
        function HealOverTime() {
        }
        HealOverTime.prototype.stop = function () {
            Native_1.Native.callNativeArg1Action("Stop heal over time", false, true, this);
        };
        return HealOverTime;
    }());
    HealOverTime_1.HealOverTime = HealOverTime;
    function start(healingPerSecond, seconds, receivers, damagers) {
        if (damagers === void 0) { damagers = null; }
        Native_1.Native.callNativeArg4Action("Start heal over time", false, true, receivers, damagers, seconds, healingPerSecond);
        return getLastCreated();
    }
    HealOverTime_1.start = start;
    function getLastCreated() {
        return Native_1.Native.callNativeArg0Function("Last heal over time ID", true, false);
    }
    HealOverTime_1.getLastCreated = getLastCreated;
    function stopAll() {
        Native_1.Native.callNativeArg0Action("Stop all heal over time", false, true);
    }
    HealOverTime_1.stopAll = stopAll;
})(HealOverTime = exports.HealOverTime || (exports.HealOverTime = {}));
var Facing;
(function (Facing) {
    function set(player, value, relative) {
        if (relative === void 0) { relative = Relative.ToWorld; }
        Native_1.Native.callNativeArg3Action("Set facing", false, true, player, value, relative);
    }
    Facing.set = set;
    function setAtRate(player, value, turnRate, relativeTo, reevaluation) {
        if (relativeTo === void 0) { relativeTo = Relative.ToWorld; }
        if (reevaluation === void 0) { reevaluation = Reevaluation.None; }
        Native_1.Native.callNativeArg5Action("Start facing", false, true, player, value, turnRate, relativeTo, reevaluation);
    }
    Facing.setAtRate = setAtRate;
    function stop(player) {
        Native_1.Native.callNativeArg1Action("Stop facing", false, true, player);
    }
    Facing.stop = stop;
    //Todo: duplicated
    var Relative;
    (function (Relative) {
        Relative["ToWorld"] = "To world";
        Relative["ToPlayer"] = "To player";
    })(Relative = Facing.Relative || (Facing.Relative = {}));
    var Reevaluation;
    (function (Reevaluation) {
        Reevaluation["DirectionAndTurnRate"] = "Direction and turn rate";
        Reevaluation["None"] = "None";
    })(Reevaluation = Facing.Reevaluation || (Facing.Reevaluation = {}));
})(Facing = exports.Facing || (exports.Facing = {}));
//# sourceMappingURL=player.js.map