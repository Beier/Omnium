import { Native } from "native"
import { Player } from "player"
import { HeroType } from "hero"

export module Rule {
    export class Event {
        public static get player(): Player {
            return Native.callNativeArg0Function<Player>("Event Player", false, false);
        }

        public static get attacker(): Player {
            return Native.callNativeArg0Function<Player>("Attacker", false, false);
        }

        public static get damage(): number {
            return Native.callNativeArg0Function<number>("Event damage", false, false);
        }

        public static get wasCriticalHit(): boolean {
            return Native.callNativeArg0Function<boolean>("Event was critical hit", false, false);
        }

        public static get victim(): Player {
            return Native.callNativeArg0Function<Player>("Victim", false, false);
        }
    }

    export module Events {
        export class Ongoing {
            public static get global(): Event {
                return Native.trigger("Ongoing - Global");
            }

            public static eachPlayer(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Ongoing - Each Player", team, players);
            }
        }

        export class Player {
            public static earnedElimination(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Player earned elimination", team, players);
            }

            public static dealtFinalBlow(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Player dealt final blow", team, players);
            }

            public static dealtDamage(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Player dealt damage", team, players);
            }

            public static tookDamage(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Player took damage", team, players);
            }

            public static died(team: Team = Team.All, players: Players | Slot | HeroType = Players.All): Event {
                return Native.playerTrigger("Player died", team, players);
            }
        }

        export enum Team {
            All = "All",
            Team1 = "Team 1",
            Team2 = "Team 2"
        }

        export enum Players {
            All = "All"
        }

        export enum Slot {
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
            Slot11 = "Slot 11"
        }
    }
}