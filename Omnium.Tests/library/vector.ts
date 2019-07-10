import { Native } from "Native"
import { List } from "List"
import { Rule } from "Rule"
import { Player, Players } from "Player"

export function vector(x: number, y: number, z: number): Vector {
    return Native.callNativeArg3Function<number, number, number, Vector>("Vector", false, false, x, y, z);
}

export class Vector {
    public get x(): number {
        return Native.callNativeArg1Function<Vector, number>("X component of", false, false, this);
    }

    public get y(): number {
        return Native.callNativeArg1Function<Vector, number>("Y component of", false, false, this);
    }

    public get z(): number {
        return Native.callNativeArg1Function<Vector, number>("Z component of", false, false, this);
    }

    public get horizontalAngle(): number {
        return Native.callNativeArg1Function<Vector, number>("Horizontal angle from direction", false, false, this);
    }

    public get verticalAngle(): number {
        return Native.callNativeArg1Function<Vector, number>("Vertical angle from direction", false, false, this);
    }

    public static get zero(): Vector {
        return vector(0, 0, 0);
    }

    public static get up(): Vector {
        return Native.callNativeArg0Function<Vector>("Up", false, false);
    }

    public static get down(): Vector {
        return Native.callNativeArg0Function<Vector>("Down", false, false);
    }

    public static get forward(): Vector {
        return Native.callNativeArg0Function<Vector>("Forward", false, false);
    }

    public static get backward(): Vector {
        return Native.callNativeArg0Function<Vector>("Backward", false, false);
    }

    public static get left(): Vector {
        return Native.callNativeArg0Function<Vector>("Left", false, false);
    }

    public static get right(): Vector {
        return Native.callNativeArg0Function<Vector>("Right", false, false);
    }

    public static getFirstIntersectionBetween(start: Vector,
        end: Vector,
        playersToInclude: Player | List<Player> = Players.all,
        playersToExclude: Player | List<Player> = Rule.Event.player,
        includePlayerOwnedObjects: boolean = true): Vector {
        return Native.callNativeArg5Function<Vector, Vector, Player | List<Player>, Player | List<Player>, boolean, Vector>(
            "Ray cast hit position",
            true,
            false,
            start,
            end,
            playersToInclude,
            playersToExclude,
            includePlayerOwnedObjects);
    }

    public cross(vector2: Vector): Vector {
        return Vector.crossProduct(this, vector2);
    }

    public static crossProduct(vector1: Vector, vector2: Vector): Vector {
        return Native.callNativeArg2Function<Vector, Vector, Vector>("Cross product", false, false, vector1, vector2);
    }

    public dot(vector2: Vector): number {
        return Vector.doProduct(this, vector2);
    }

    public static doProduct(vector1: Vector, vector2: Vector): number {
        return Native.callNativeArg2Function<Vector, Vector, number>("Dot product", false, false, vector1, vector2);
    }

    public static fromAngles(horizontalAngle: number, verticalAngle: number): Vector {
        return Native.callNativeArg2Function<number, number, Vector>("Direction from angles", false, false, horizontalAngle, verticalAngle);
    }

    public static towards(startPosition: Vector, endPosition: Vector): Vector {
        return Native.callNativeArg2Function<Vector, Vector, Vector>("Direction towards", false, false, startPosition, endPosition);
    }

    public distanceTo(other: Vector): number {
        return Native.callNativeArg2Function<Vector, Vector, number>("Distance between", false, false, this, other);
    }

    public hasClearLineOfSightTo(target: Vector, barriers: LineOfSight.Barriers = LineOfSight.Barriers.DoesNotBlockLineOfSight): boolean {
        return LineOfSight.isClearBetween(this, target, barriers);
    }

    public toLocalVectorRelativeTo(player: Player, transformation: VectorTransformation = VectorTransformation.RotationAndTranslation): Vector {
        return Native.callNativeArg3Function<Vector, Player, VectorTransformation, Vector>("Local vector of", false, false, this, player, transformation);
    }

    public static fromLocalVectorRelativeTo(vector: Vector, player: Player, transformation: VectorTransformation = VectorTransformation.RotationAndTranslation): Vector {
        return Native.callNativeArg3Function<Vector, Player, VectorTransformation, Vector>("World vector of", false, false, vector, player, transformation);
    }

    public get nearestWalkablePosition(): Vector {
        return Native.callNativeArg1Function<Vector, Vector>("Nearest walkable position", false, false, this);
    }

    public get normalized(): Vector {
        return Native.callNativeArg1Function<Vector, Vector>("Normalize", false, false, this);
    }

    public get unitVector(): Vector {
        return this.normalized;
    }
}

export enum VectorTransformation {
    Rotation = "Rotation",
    RotationAndTranslation = "Rotation and translation"
}

export module LineOfSight {

    export function isClearBetween(v1: Vector, v2: Vector, barriers: Barriers = Barriers.DoesNotBlockLineOfSight): boolean {
        return Native.callNativeArg3Function<Vector, Vector, Barriers, boolean>("Is in line of sight", true, false, v1, v2, barriers);
    }

    export enum Barriers {
        BlockLineOfSight = "All barriers block los",
        FromEnemyBlockLineOfSight = "Enemy barriers block los",
        DoesNotBlockLineOfSight = "Barriers do not block los"
    }
}

export module Angle {
    export function between(vector1: Vector, vector2: Vector): number {
        return Native.callNativeArg2Function<Vector, Vector, number>("Angle between vectors", false, false, vector1, vector2);
    }

    export function difference(angle1: number, angle2: number): number {
        return Native.callNativeArg2Function<number, number, number>("Angle difference", false, false, angle1, angle2);
    }

    export function acosRad(number: number): number {
        return Native.callNativeArg1Function<number, number>("Arccosine in radians", false, false, number);
    }

    export function acosDeg(number: number): number {
        return Native.callNativeArg1Function<number, number>("Arccosine in degrees", false, false, number);
    }

    export function asinRad(number: number): number {
        return Native.callNativeArg1Function<number, number>("Arcsine in radians", false, false, number);
    }

    export function asinDeg(number: number): number {
        return Native.callNativeArg1Function<number, number>("Arcsine in degrees", false, false, number);
    }

    export function atan2Deg(numerator: number, denominator: number): number {
        return Native.callNativeArg2Function<number, number, number>("Arctangent in degrees", false, false, numerator, denominator);
    }

    export function atan2Rad(numerator: number, denominator: number): number {
        return Native.callNativeArg2Function<number, number, number>("Arctangent in radians", false, false, numerator, denominator);
    }

    export function cosDeg(number: number): number {
        return Native.callNativeArg1Function<number, number>("Cosine from degrees", false, false, number);
    }

    export function cosRad(number: number): number {
        return Native.callNativeArg1Function<number, number>("Cosine from radians", false, false, number);
    }

    export function sinDeg(number: number): number {
        return Native.callNativeArg1Function<number, number>("Sine from degrees", false, false, number);
    }

    export function sinRad(number: number): number {
        return Native.callNativeArg1Function<number, number>("Sine from radians", false, false, number);
    }

    export function tanDeg(number: number): number {
        return Native.callNativeArg1Function<number, number>("Tangent from degrees", false, false, number);
    }

    export function tanRad(number: number): number {
        return Native.callNativeArg1Function<number, number>("Tangent from radians", false, false, number);
    }
}

export module RayCast {
    export function position(start: Vector,
        end: Vector,
        includedPlayers: Player | List<Player> = Players.all,
        excludedPlayers: Player | List<Player> = Rule.Event.player,
        includePlayerObjects: boolean = true): Vector {

        return Native.callNativeArg5Function
            <Vector, Vector, Player | List<Player>, Player | List<Player>, boolean, Vector>(
                "Ray cast hit position", true, false, start, end, includedPlayers, excludedPlayers, includePlayerObjects);
    }

    export function normal(start: Vector,
        end: Vector,
        includedPlayers: Player | List<Player> = Players.all,
        excludedPlayers: Player | List<Player> = Rule.Event.player,
        includePlayerObjects: boolean = true): Vector {

        return Native.callNativeArg5Function
            <Vector, Vector, Player | List<Player>, Player | List<Player>, boolean, Vector>(
                "Ray cast hit normal", true, false, start, end, includedPlayers, excludedPlayers, includePlayerObjects);
    }

    export function player(start: Vector,
        end: Vector,
        includedPlayers: Player | List<Player> = Players.all,
        excludedPlayers: Player | List<Player> = Rule.Event.player,
        includePlayerObjects: boolean = true): Player {

        return Native.callNativeArg5Function
            <Vector, Vector, Player | List<Player>, Player | List<Player>, boolean, Player>(
                "Ray cast hit player", true, false, start, end, includedPlayers, excludedPlayers, includePlayerObjects);
    }
}