import { Native } from "./native"
import { Player } from "./player"
import { List } from "./list"
import { Vector } from "./vector"


export module Icon {
    export class Icon {
        public destroy(): void {
            Native.callNativeArg1Action<Icon>("Destroy icon", false, true, this);
        }

        public get exists(): boolean {
            return Native.callNativeArg1Function<Icon, boolean>("Entity exists", false, false, this);
        }
    }

    export function create(type: Type, color: Color, visibleTo: Player | List<Player>, position: Vector, reevaluation: Reevaluation = Reevaluation.None, showWhenOffscreen: boolean = true): Icon {
        Native.callNativeArg6Action
            <Player | List<Player>, Vector, Type, Reevaluation, Color, boolean>(
            "Create icon", false, true, visibleTo, position, type, reevaluation, color, showWhenOffscreen);
        return getLastCreatedIcon();
    }

    export function getLastCreatedIcon(): Icon {
        return Native.callNativeArg0Function<Icon>("Last created entity", true, false);
    }

    export function destroyAll(): void {
        Native.callNativeArg0Action("Destroy all icons", false, true);
    }

    export enum Type {
        ArrowUp = "Arrow: Up",
        ArrowDown = "Arrow: Down",
        ArrowLeft = "Arrow: Left",
        ArrowRight = "Arrow: Right",
        Asterisk = "Asterisk",
        Bolt = "Bolt",
        Circle = "Circle",
        Club = "Club",
        Diamond = "Diamond",
        Dizzy = "Dizzy",
        ExclamationMark = "Exclamation Mark",
        Eye = "Eye",
        Fire = "Fire",
        Flag = "Flag",
        Halo = "Halo",
        Happy = "Happy",
        Heart = "Heart",
        Moon = "Moon",
        No = "No",
        Plus = "Plus",
        Poison = "Poison",
        Poison2 = "Poison 2",
        QuestionMark = "Question Mark",
        Radioactive = "Radioactive",
        Recycle = "Recycle",
        RingThick = "Ring Thick",
        RingThin = "Ring Thin",
        Sad = "Sad",
        Skull = "Skull",
        Spade = "Spade",
        Spiral = "Spiral",
        Stop = "Stop",
        Trashcan = "Trashcan",
        Warning = "Warning",
        X = "X"
    }

    export enum Reevaluation {
        VisibleToAndPosition = "Visible to and position",
        Position = "Position",
        VisibleTo = "Visible to",
        None = "None",
    }
}

export enum Color {
    White = "White",
    Yellow = "Yellow",
    Green = "Green",
    Purple = "Purple",
    Red = "Red",
    Blue = "Blue",
    OfTeam1 = "Team 1",
    OfTeam2 = "Team 2",
}

//Todo: Chase
//Todo: Methods with re-evaluation continues to read variable
//Todo: Current array element