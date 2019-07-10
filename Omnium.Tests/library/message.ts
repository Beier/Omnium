import { Native } from "Native"
import { List } from "List"
import { Vector } from "Vector"
import { Player, Players } from "Player"

export module Message {

    export function send(players: Player | List<Player>, message: string, size: Size = Size.Big): void {
        if (size == Size.Big) {
            Native.callNativeArg2Action<Player | List<Player>, string>("Big Message", false, false, players, message);
        } else {
            Native.callNativeArg2Action<Player | List<Player>, string>("Small Message", false, false, players, message);
        }
    }


    export enum Size {
        Big,
        Small
    }

    export module Hud {
        export module Objective {

            export function setDescription(description: string, players : Player | List<Player> = Players.all, reevaluation : Reevaluation = Reevaluation.String): void {
                Native.callNativeArg3Action
                    <Player | List<Player>, string, Reevaluation>(
                        "Set Objective description", false, true, players, description, reevaluation);
            }

            export enum Reevaluation {
                VisibleToAndString = "Visible to and string",
                String = "String"
            }
        }

        export module Text {
            export class HudText {
                public destroy(): void {
                    Native.callNativeArg1Action<HudText>("Destroy hud text", false, true, this);
                }
            }

            export function create(
                players: Player | List<Player>,
                header: string = null,
                subHeader: string = null,
                text: string = null,
                location: Location = Location.Left,
                sortOrder: number = 0,
                headerColor: TextColor = TextColor.White,
                subHeaderColor: TextColor = TextColor.White,
                textColor: TextColor = TextColor.White,
                reevaluation: Reevaluation = Reevaluation.VisibleToAndString): HudText {
                Native.callNativeArg10Action<
                    Player | List<Player>,
                    string,
                    string,
                    string,
                    Location,
                    number,
                    TextColor,
                    TextColor,
                    TextColor,
                    Reevaluation>(
                    "Create HUD Text",
                    false,
                    true,
                    players,
                    header,
                    subHeader,
                    text,
                    location,
                    sortOrder,
                    headerColor,
                    subHeaderColor,
                    textColor,
                    reevaluation);

                return getLastCreated();
            }
            
            export function getLastCreated(): HudText {
                return Native.callNativeArg0Function<HudText>("Last text id", true, false);
            }

            export function destroyAll(): void {
                Native.callNativeArg0Action("Destroy all hud text", false, true);
            }

            enum Location {
                Left = "Left",
                Top = "Top",
                Right = "Right"
            }

            enum Reevaluation {
                String = "String",
                VisibleToAndString = "Visible To and String"
            }
        }
    }

    export module InWorld {
        export class InWorldText {
            public destroy(): void {
                Native.callNativeArg1Action<InWorldText>("Destroy in-world text", false, true, this);
            }
        }

        export function createText(
            visibleTo: Player | List<Player>,
            header: string,
            position: Vector,
            scale: number = 1,
            clipping: Clipping = Clipping.BlockedByWalls,
            reevaluation: Reevaluation = Reevaluation.VisibleToPositionAndString): InWorldText {
            Native.callNativeArg6Action
                <Player | List<Player>, string, Vector, number, Clipping, Reevaluation>(
                "Create in-world text", false, true, visibleTo, header, position, scale, clipping, reevaluation);

            return getLastCreated();
        }

        export function getLastCreated(): InWorldText {
            return Native.callNativeArg0Function<InWorldText>("Last text id", true, false);
        }

        export function destroyAll(): void {
            Native.callNativeArg0Action("Destroy all in-world text", false, true);
        }
        
        export enum Clipping {
            BlockedByWalls = "Clip against surfaces",
            AlwaysVisible = "Do not clip"
        }

        export enum Reevaluation {
            VisibleToPositionAndString = "Visible to position and string",
            VisibleToAndString = "Visible to and string",
            String = "String"
        }
    }
}



enum TextColor {
    White = "White",
    Yellow = "Yellow",
    Green = "Green",
    Purple = "Purple",
    Red = "Red",
    Blue = "Blue",
    Team1 = "Team 1",
    Team2 = "Team 2"
}