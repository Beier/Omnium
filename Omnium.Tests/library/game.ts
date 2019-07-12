import { Native } from "./native"
import { Team } from "./team"
import { Player, Players } from "./player"
import { List } from "./list"
import { Vector } from "./vector"


export class Game {
    public static get isAssemblingHeroes() {
        return Native.callNativeArg0Function<boolean>("Is assembling heroes", true, false);
    }

    public static get isBetweenRounds() {
        return Native.callNativeArg0Function<boolean>("Is between rounds", true, false);
    }

    public static get isInProgress() {
        return Native.callNativeArg0Function<boolean>("Is game in progress", true, false);
    }

    public static get isInSetup() {
        return Native.callNativeArg0Function<boolean>("Is in setup", true, false);
    }

    public static get isComplete() {
        return Native.callNativeArg0Function<boolean>("Is match complete", true, false);
    }

    public static get isWaitingForPlayers() {
        return Native.callNativeArg0Function<boolean>("Is waiting for players", true, false);
    }

    public static get round() {
        return Native.callNativeArg0Function<number>("Match round", true, false);
    }

    public static get totalSecondsElapsed() {
        return Native.callNativeArg0Function<number>("Total time elapsed", true, false);
    }
}

export module Game {
    export function setGravityPercentFor(player: Player | List<Player>, percent: number) {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set gravity", false, true, player, percent);
    }

    export function setProjectileGravityPercentFor(player: Player | List<Player>, percent: number) {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set projectile gravity", false, true, player, percent);
    }

    export function setProjectileSpeedPercentFor(player: Player | List<Player>, percent: number) {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set projectile speed", false, true, player, percent);
    }

    export function setRespawnMaxTime(player: Player | List<Player>, seconds: number) {
        Native.callNativeArg2Action<Player | List<Player>, number>("Set respawn max time", false, true, player, seconds);
    }

    export function seSlowMotionPercent(percent: number) {
        Native.callNativeArg1Action<number>("Set slow motion", false, true, percent);
    }

    export class MatchTime {
        public static pause() {
            Native.callNativeArg0Action("Pause match time", false, true);
        }

        public static unpause() {
            Native.callNativeArg0Action("Unpause match time", false, true);
        }

        public static get seconds() {
            return Native.callNativeArg0Function<number>("Match time", true, false);
        }

        public static set seconds(value: number) {
            Native.callNativeArg1Action<number>("Set match time", false, true, value);
        }
    }

    export module Mode {
        export function setDefaultAnnouncerEnabled(isEnabled: boolean) {
            if (isEnabled)
                Native.callNativeArg0Action("Enable built-in game mode announcer", false, false);
            else
                Native.callNativeArg0Action("Disable built-in game mode announcer", false, false);
        }

        export function setDefaultCompletionRulesEnabled(isEnabled: boolean) {
            if (isEnabled)
                Native.callNativeArg0Action("Enable built-in game mode completion", false, false);
            else
                Native.callNativeArg0Action("Disable built-in game mode completion", false, false);
        }

        export function seDefaultMusicEnabled(isEnabled: boolean) {
            if (isEnabled)
                Native.callNativeArg0Action("Enable built-in game mode music", false, false);
            else
                Native.callNativeArg0Action("Disable built-in game mode music", false, false);
        }

        export function setDefaultRespawningEnabled(isEnabled: boolean, player: Player | List<Player> = Players.all) {
            if (isEnabled)
                Native.callNativeArg1Action<Player | List<Player>>("Enable built-in game mode respawning", false, false, player);
            else
                Native.callNativeArg1Action<Player | List<Player>>("Disable built-in game mode respawning", false, false, player);
        }

        export function setDefaultScoringEnabled(isEnabled: boolean) {
            if (isEnabled)
                Native.callNativeArg0Action("Enable built-in game mode scoring", false, false);
            else
                Native.callNativeArg0Action("Disable built-in game mode scoring", false, false);
        }

        export function setDeathSpectateEnabled(isEnabled: boolean, player: Player | List<Player> = Players.all) {
            if (isEnabled)
                Native.callNativeArg1Action<Player | List<Player>>("Enable death spectate all players", false, false, player);
            else
                Native.callNativeArg1Action<Player | List<Player>>("Disable death spectate all players", false, false, player);
        }

        export function setSpectateTargetHud(isEnabled: boolean, player: Player | List<Player> = Players.all) {
            if (isEnabled)
                Native.callNativeArg1Action<Player | List<Player>>("Enable death spectate target hud", false, false, player);
            else
                Native.callNativeArg1Action<Player | List<Player>>("Disable death spectate target hud", false, false, player);
        }

        export function goToAssembleHeroes() {
            Native.callNativeArg0Action("Go to assemble heroes", false, false);
        }

        export module Deathmatch {
            export function declareVictory(player: Player) {
                Native.callNativeArg1Action<Player>("Declare player victory", false, true, player);
            }
        }

        export class Control {
            public static declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare round victory", false, true, team);
            }

            public static get teamCurrentlyInControl() {
                return Native.callNativeArg0Function<Team>("Control mode scoring team", true, false);
            }

            public static scoringPercentageFor(team: Team) {
                return Native.callNativeArg1Function<Team, number>("Control mode scoring percentage", true, false, team);
            }

            public static get isPointLocked() {
                return Native.callNativeArg0Function<boolean>("Is control mode point locked", true, false);
            }

            public get objectiveIndex() {
                return Native.callNativeArg0Function<number>("Objective index", true, false);
            }

            public getPositionOfObjective(index: number = this.objectiveIndex) {
                return Native.callNativeArg1Function<number, Vector>("Objective position", true, false, index);
            }

            public static get capturePercentage() {
                return Native.callNativeArg0Function<number>("Point capture percentage", true, false);
            }
        }

        export module Elimination {
            export function declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare round victory", false, true, team);
            }
        }
        export class Assault {
            public static declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
            }

            public static declareDraw() {
                Native.callNativeArg0Action("Declare match draw", false, true);
            }

            public static isObjectiveComplete(objectiveNumber: number) {
                return Native.callNativeArg1Function<number, boolean>("Is objective complete", true, false, objectiveNumber);
            }

            public get objectiveIndex() {
                return Native.callNativeArg0Function<number>("Objective index", true, false);
            }

            public getPositionOfObjective(index: number = this.objectiveIndex) {
                return Native.callNativeArg1Function<number, Vector>("Objective position", true, false, index);
            }
        }
        export class Escort {
            public static declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
            }

            public static declareDraw() {
                Native.callNativeArg0Action("Declare match draw", false, true);
            }

            public static isObjectiveComplete(objectiveNumber: number) {
                return Native.callNativeArg1Function<number, boolean>("Is objective complete", true, false, objectiveNumber);
            }

            public get objectiveIndex() {
                return Native.callNativeArg0Function<number>("Objective index", true, false);
            }

            public getPositionOfObjective(index: number = this.objectiveIndex) {
                return Native.callNativeArg1Function<number, Vector>("Objective position", true, false, index);
            }

            public get payloadPosition() {
                return Native.callNativeArg0Function<Vector>("Payload position", true, false);
            }

            public get payloadProgress() {
                return Native.callNativeArg0Function<number>("Payload progress percentage", true, false);
            }
        }
        export class AssaultEscort {
            public static declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
            }

            public static declareDraw() {
                Native.callNativeArg0Action("Declare match draw", false, true);
            }

            public static isObjectiveComplete(objectiveNumber: number) {
                return Native.callNativeArg1Function<number, boolean>("Is objective complete", true, false, objectiveNumber);
            }

            public get objectiveIndex() {
                return Native.callNativeArg0Function<number>("Objective index", true, false);
            }

            public getPositionOfObjective(index: number = this.objectiveIndex) {
                return Native.callNativeArg1Function<number, Vector>("Objective position", true, false, index);
            }

            public get payloadPosition() {
                return Native.callNativeArg0Function<Vector>("Payload position", true, false);
            }

            public get payloadProgress() {
                return Native.callNativeArg0Function<number>("Payload progress percentage", true, false);
            }
        }
        export class CaptureTheFlag {
            public static declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
            }

            public static declareDraw() {
                Native.callNativeArg0Action("Declare match draw", false, true);
            }

            public static positionOfFlag(team: Team) {
                return Native.callNativeArg1Function<Team, Vector>("Flag position", true, false, team);
            }

            public static isFlagAtBase(team: Team) {
                return Native.callNativeArg1Function<Team, boolean>("Is flag at base", true, false, team);
            }

            public static isFlagBeingCarried(team: Team) {
                return Native.callNativeArg1Function<Team, boolean>("Is flag being carried", true, false, team);
            }

            public static playerCarryingFlag(team: Team) {
                return Native.callNativeArg1Function<Team, Player>("Player carrying flag", true, false, team);
            }

            public static get isSuddenDeath() {
                return Native.callNativeArg0Function<boolean>("Is CTF mode in sudden death", true, false);
            }
        }
        export module TeamDeathmatch {
            export function declareVictory(team: Team) {
                Native.callNativeArg1Action<Team>("Declare team victory", false, true, team);
            }

            export function declareDraw() {
                Native.callNativeArg0Action("Declare match draw", false, true);
            }
        }
    }
}