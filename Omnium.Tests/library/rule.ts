import { Native } from "native"
import { Player } from "player"

export module Rule {
    export module Events {
        export class Event { }

        export class Ongoing {
            public static get global(): Event {
                return Native.trigger("Ongoing - Global");
            }

            public static eachPlayer(team: Team = Team.All, player: Player = Player.All): Event {
                return Native.playerTrigger("Ongoing - Each Player", team, player);
            }
        }

        export enum Team {
            All = "All",
            Team1 = "Team 1",
            Team2 = "Team 2"
        }

        export enum Player {
            All = "All",
            Slot0 = "Slot 0",
            Slot1 = "Slot 1",
            Slot2 = "Slot 2",
            Slot3 = "Slot 3",
            Slot4 = "Slot 4",
            Slot5 = "Slot 5",
            Slot6 = "Slot 6",
            Slot7 = "Slot 7",
            Slot8 = "Slot 8",
            Slot9 = "Slot 9",
            Slot10 = "Slot 10",
            Slot11 = "Slot 11"//Todo: Heroes
        }
    }

    export class Triggering {
        public static get player(): Player {
            return Native.callNativeArg0Function<Player>("Event Player", false, false);
        }
    }
}