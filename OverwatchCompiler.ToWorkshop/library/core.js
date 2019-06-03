var Native = /** @class */ (function () {
    function Native() {
    }
    Native.arg0 = function (methodName, jsAction) {
        if (jsAction === void 0) { jsAction = null; }
        return jsAction();
    };
    Native.arg1 = function (methodName, argument1, jsAction) {
        if (jsAction === void 0) { jsAction = null; }
        return jsAction(argument1);
    };
    return Native;
}());
function rule(ruleName, event, conditionOrAction, action) {
    if (action === void 0) { action = null; }
    throw "Not implemented";
}
var Player = /** @class */ (function () {
    function Player() {
    }
    Object.defineProperty(Player.prototype, "altitude", {
        get: function () {
            return Native.arg1("Altitude Of", this);
        },
        enumerable: true,
        configurable: true
    });
    return Player;
}());
var Players = /** @class */ (function () {
    function Players() {
    }
    Players.deadOnTeam = function (team) {
        return Native.arg1("All Dead Players", team);
    };
    Players.aliveOnTeam = function (team) {
        return Native.arg1("All Living Players", team);
    };
    Players.onTeam = function (team) {
        return Native.arg1("All Players", team);
    };
    Players.notOnObjectiveFromTeam = function (team) {
        return Native.arg1("All Players Not On Objective", team);
    };
    Players.onObjectiveFromTeam = function (team) {
        return Native.arg1("All Players On Objective", team);
    };
    return Players;
}());
var Team = /** @class */ (function () {
    function Team() {
    }
    return Team;
}());
var Teams = /** @class */ (function () {
    function Teams() {
    }
    Object.defineProperty(Teams, "all", {
        get: function () {
            return Native.arg0("All Teams");
        },
        enumerable: true,
        configurable: true
    });
    return Teams;
}());
var Hero = /** @class */ (function () {
    function Hero() {
    }
    return Hero;
}());
var Heroes = /** @class */ (function () {
    function Heroes() {
    }
    Object.defineProperty(Heroes, "all", {
        get: function () {
            return Native.arg0("All Heroes");
        },
        enumerable: true,
        configurable: true
    });
    Heroes.allowedForPlayer = function (player) {
        return Native.arg1("Allowed Heroes", player);
    };
    return Heroes;
}());
var Rule;
(function (Rule) {
    var Event = /** @class */ (function () {
        function Event() {
        }
        Object.defineProperty(Event, "player", {
            get: function () {
                return Native.arg0("Event Player");
            },
            enumerable: true,
            configurable: true
        });
        return Event;
    }());
    Rule.Event = Event;
})(Rule || (Rule = {}));
var Events;
(function (Events) {
    var Ongoing;
    (function (Ongoing) {
        Ongoing[Ongoing["Global"] = 0] = "Global";
    })(Ongoing = Events.Ongoing || (Events.Ongoing = {}));
})(Events || (Events = {}));
//# sourceMappingURL=core.js.map