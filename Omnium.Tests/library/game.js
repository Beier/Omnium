"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var native_1 = require("./native");
var player_1 = require("./player");
var Game = /** @class */ (function () {
    function Game() {
    }
    Object.defineProperty(Game, "isAssemblingHeroes", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is assembling heroes", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "isBetweenRounds", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is between rounds", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "isInProgress", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is game in progress", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "isInSetup", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is in setup", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "isComplete", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is match complete", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "isWaitingForPlayers", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Is waiting for players", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "round", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Match round", true, false);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Game, "totalSecondsElapsed", {
        get: function () {
            return native_1.Native.callNativeArg0Function("Total time elapsed", true, false);
        },
        enumerable: true,
        configurable: true
    });
    return Game;
}());
exports.Game = Game;
(function (Game) {
    function setGravityPercentFor(player, percent) {
        native_1.Native.callNativeArg2Action("Set gravity", false, true, player, percent);
    }
    Game.setGravityPercentFor = setGravityPercentFor;
    function setProjectileGravityPercentFor(player, percent) {
        native_1.Native.callNativeArg2Action("Set projectile gravity", false, true, player, percent);
    }
    Game.setProjectileGravityPercentFor = setProjectileGravityPercentFor;
    function setProjectileSpeedPercentFor(player, percent) {
        native_1.Native.callNativeArg2Action("Set projectile speed", false, true, player, percent);
    }
    Game.setProjectileSpeedPercentFor = setProjectileSpeedPercentFor;
    function setRespawnMaxTime(player, seconds) {
        native_1.Native.callNativeArg2Action("Set respawn max time", false, true, player, seconds);
    }
    Game.setRespawnMaxTime = setRespawnMaxTime;
    function seSlowMotionPercent(percent) {
        native_1.Native.callNativeArg1Action("Set slow motion", false, true, percent);
    }
    Game.seSlowMotionPercent = seSlowMotionPercent;
    var MatchTime = /** @class */ (function () {
        function MatchTime() {
        }
        MatchTime.pause = function () {
            native_1.Native.callNativeArg0Action("Pause match time", false, true);
        };
        MatchTime.unpause = function () {
            native_1.Native.callNativeArg0Action("Unpause match time", false, true);
        };
        Object.defineProperty(MatchTime.prototype, "seconds", {
            get: function () {
                return native_1.Native.callNativeArg0Function("Match time", true, false);
            },
            set: function (value) {
                native_1.Native.callNativeArg1Action("Set match time", false, true, value);
            },
            enumerable: true,
            configurable: true
        });
        return MatchTime;
    }());
    Game.MatchTime = MatchTime;
    var Mode;
    (function (Mode) {
        function setDefaultAnnouncerEnabled(isEnabled) {
            if (isEnabled)
                native_1.Native.callNativeArg0Action("Enable built-in game mode announcer", false, false);
            else
                native_1.Native.callNativeArg0Action("Disable built-in game mode announcer", false, false);
        }
        Mode.setDefaultAnnouncerEnabled = setDefaultAnnouncerEnabled;
        function setDefaultCompletionRulesEnabled(isEnabled) {
            if (isEnabled)
                native_1.Native.callNativeArg0Action("Enable built-in game mode completion", false, false);
            else
                native_1.Native.callNativeArg0Action("Disable built-in game mode completion", false, false);
        }
        Mode.setDefaultCompletionRulesEnabled = setDefaultCompletionRulesEnabled;
        function seDefaultMusicEnabled(isEnabled) {
            if (isEnabled)
                native_1.Native.callNativeArg0Action("Enable built-in game mode music", false, false);
            else
                native_1.Native.callNativeArg0Action("Disable built-in game mode music", false, false);
        }
        Mode.seDefaultMusicEnabled = seDefaultMusicEnabled;
        function setDefaultRespawningEnabled(isEnabled, player) {
            if (player === void 0) { player = player_1.Players.all; }
            if (isEnabled)
                native_1.Native.callNativeArg1Action("Enable built-in game mode respawning", false, false, player);
            else
                native_1.Native.callNativeArg1Action("Disable built-in game mode respawning", false, false, player);
        }
        Mode.setDefaultRespawningEnabled = setDefaultRespawningEnabled;
        function setDefaultScoringEnabled(isEnabled) {
            if (isEnabled)
                native_1.Native.callNativeArg0Action("Enable built-in game mode scoring", false, false);
            else
                native_1.Native.callNativeArg0Action("Disable built-in game mode scoring", false, false);
        }
        Mode.setDefaultScoringEnabled = setDefaultScoringEnabled;
        function setDeathSpectateEnabled(isEnabled, player) {
            if (player === void 0) { player = player_1.Players.all; }
            if (isEnabled)
                native_1.Native.callNativeArg1Action("Enable death spectate all players", false, false, player);
            else
                native_1.Native.callNativeArg1Action("Disable death spectate all players", false, false, player);
        }
        Mode.setDeathSpectateEnabled = setDeathSpectateEnabled;
        function setSpectateTargetHud(isEnabled, player) {
            if (player === void 0) { player = player_1.Players.all; }
            if (isEnabled)
                native_1.Native.callNativeArg1Action("Enable death spectate target hud", false, false, player);
            else
                native_1.Native.callNativeArg1Action("Disable death spectate target hud", false, false, player);
        }
        Mode.setSpectateTargetHud = setSpectateTargetHud;
        function goToAssembleHeroes() {
            native_1.Native.callNativeArg0Action("Go to assemble heroes", false, false);
        }
        Mode.goToAssembleHeroes = goToAssembleHeroes;
        var Deathmatch;
        (function (Deathmatch) {
            function declareVictory(player) {
                native_1.Native.callNativeArg1Action("Declare player victory", false, true, player);
            }
            Deathmatch.declareVictory = declareVictory;
        })(Deathmatch = Mode.Deathmatch || (Mode.Deathmatch = {}));
        var Control = /** @class */ (function () {
            function Control() {
            }
            Control.declareVictory = function (team) {
                native_1.Native.callNativeArg1Action("Declare round victory", false, true, team);
            };
            Object.defineProperty(Control, "teamCurrentlyInControl", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Control mode scoring team", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Control.scoringPercentageFor = function (team) {
                return native_1.Native.callNativeArg1Function("Control mode scoring percentage", true, false, team);
            };
            Object.defineProperty(Control, "isPointLocked", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Is control mode point locked", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Control.prototype, "objectiveIndex", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Objective index", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Control.prototype.getPositionOfObjective = function (index) {
                if (index === void 0) { index = this.objectiveIndex; }
                return native_1.Native.callNativeArg1Function("Objective position", true, false, index);
            };
            Object.defineProperty(Control, "capturePercentage", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Point capture percentage", true, false);
                },
                enumerable: true,
                configurable: true
            });
            return Control;
        }());
        Mode.Control = Control;
        var Elimination;
        (function (Elimination) {
            function declareVictory(team) {
                native_1.Native.callNativeArg1Action("Declare round victory", false, true, team);
            }
            Elimination.declareVictory = declareVictory;
        })(Elimination = Mode.Elimination || (Mode.Elimination = {}));
        var Assault = /** @class */ (function () {
            function Assault() {
            }
            Assault.declareVictory = function (team) {
                native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
            };
            Assault.declareDraw = function () {
                native_1.Native.callNativeArg0Action("Declare match draw", false, true);
            };
            Assault.isObjectiveComplete = function (objectiveNumber) {
                return native_1.Native.callNativeArg1Function("Is objective complete", true, false, objectiveNumber);
            };
            Object.defineProperty(Assault.prototype, "objectiveIndex", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Objective index", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Assault.prototype.getPositionOfObjective = function (index) {
                if (index === void 0) { index = this.objectiveIndex; }
                return native_1.Native.callNativeArg1Function("Objective position", true, false, index);
            };
            return Assault;
        }());
        Mode.Assault = Assault;
        var Escort = /** @class */ (function () {
            function Escort() {
            }
            Escort.declareVictory = function (team) {
                native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
            };
            Escort.declareDraw = function () {
                native_1.Native.callNativeArg0Action("Declare match draw", false, true);
            };
            Escort.isObjectiveComplete = function (objectiveNumber) {
                return native_1.Native.callNativeArg1Function("Is objective complete", true, false, objectiveNumber);
            };
            Object.defineProperty(Escort.prototype, "objectiveIndex", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Objective index", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Escort.prototype.getPositionOfObjective = function (index) {
                if (index === void 0) { index = this.objectiveIndex; }
                return native_1.Native.callNativeArg1Function("Objective position", true, false, index);
            };
            Object.defineProperty(Escort.prototype, "payloadPosition", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Payload position", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(Escort.prototype, "payloadProgress", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Payload progress percentage", true, false);
                },
                enumerable: true,
                configurable: true
            });
            return Escort;
        }());
        Mode.Escort = Escort;
        var AssaultEscort = /** @class */ (function () {
            function AssaultEscort() {
            }
            AssaultEscort.declareVictory = function (team) {
                native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
            };
            AssaultEscort.declareDraw = function () {
                native_1.Native.callNativeArg0Action("Declare match draw", false, true);
            };
            AssaultEscort.isObjectiveComplete = function (objectiveNumber) {
                return native_1.Native.callNativeArg1Function("Is objective complete", true, false, objectiveNumber);
            };
            Object.defineProperty(AssaultEscort.prototype, "objectiveIndex", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Objective index", true, false);
                },
                enumerable: true,
                configurable: true
            });
            AssaultEscort.prototype.getPositionOfObjective = function (index) {
                if (index === void 0) { index = this.objectiveIndex; }
                return native_1.Native.callNativeArg1Function("Objective position", true, false, index);
            };
            Object.defineProperty(AssaultEscort.prototype, "payloadPosition", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Payload position", true, false);
                },
                enumerable: true,
                configurable: true
            });
            Object.defineProperty(AssaultEscort.prototype, "payloadProgress", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Payload progress percentage", true, false);
                },
                enumerable: true,
                configurable: true
            });
            return AssaultEscort;
        }());
        Mode.AssaultEscort = AssaultEscort;
        var CaptureTheFlag = /** @class */ (function () {
            function CaptureTheFlag() {
            }
            CaptureTheFlag.declareVictory = function (team) {
                native_1.Native.callNativeArg1Action("Declare team victory", false, true, team);
            };
            CaptureTheFlag.declareDraw = function () {
                native_1.Native.callNativeArg0Action("Declare match draw", false, true);
            };
            CaptureTheFlag.positionOfFlag = function (team) {
                return native_1.Native.callNativeArg1Function("Flag position", true, false, team);
            };
            CaptureTheFlag.isFlagAtBase = function (team) {
                return native_1.Native.callNativeArg1Function("Is flag at base", true, false, team);
            };
            CaptureTheFlag.isFlagBeingCarried = function (team) {
                return native_1.Native.callNativeArg1Function("Is flag being carried", true, false, team);
            };
            CaptureTheFlag.playerCarryingFlag = function (team) {
                return native_1.Native.callNativeArg1Function("Player carrying flag", true, false, team);
            };
            Object.defineProperty(CaptureTheFlag, "isSuddenDeath", {
                get: function () {
                    return native_1.Native.callNativeArg0Function("Is CTF mode in sudden death", true, false);
                },
                enumerable: true,
                configurable: true
            });
            return CaptureTheFlag;
        }());
        Mode.CaptureTheFlag = CaptureTheFlag;
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
        })(TeamDeathmatch = Mode.TeamDeathmatch || (Mode.TeamDeathmatch = {}));
    })(Mode = Game.Mode || (Game.Mode = {}));
})(Game = exports.Game || (exports.Game = {}));
exports.Game = Game;
//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//Todo: Current array element
//# sourceMappingURL=game.js.map