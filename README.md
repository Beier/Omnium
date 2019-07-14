# Omnium

Enables you to create code for Overwatch Workshop in Typescript.

For instance,
```
import { Native } from "./library/native";
import { Rule } from "./library/rule";
import { Vector } from "./library/vector";
import { Message } from "./library/Message";
import { Players, Button } from "./library/Player";

var textPosition: Vector;
var totalShots = 0;

Native.rule("Initialize text",
    Rule.Events.Ongoing.global,
    true,
    () => {
        textPosition = Vector.zero;
        Message.InWorld.createText(Players.all, totalShots.toString(), textPosition, 3, Message.InWorld.Clipping.AlwaysVisible);
    }
);

Native.rule("Move text to shot target",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Players.All),
    Rule.Event.player.isHoldingButton(Button.PrimaryFire),
    () => {
        totalShots++;
        textPosition = Vector.getFirstIntersectionBetween(
            Rule.Event.player.position + Vector.up,
            Rule.Event.player.position + 100 * Rule.Event.player.facingDirection + Vector.up
        );
    }
);
```

Compiles into

```
rule("Initialize global variables")
{
	event
	{
		Ongoing - Global;
	}
	
	actions
	{
		Set Global Variable(B, 0);
	}
}

rule("Initialize text")
{
	event
	{
		Ongoing - Global;
	}
	
	actions
	{
		Set Global Variable(A, Vector(0, 0, 0));
		Create in-world text(All Players(Team(All)), Global Variable(B), Global Variable(A), 3, Do not clip, Visible to position and string);
	}
}

rule("Move text to shot target")
{
	event
	{
		Ongoing - Each Player;
		All;
		All;
	}
	
	conditions
	{
		Is Button Held(Event Player, Primary Fire) == true;
	}
	
	actions
	{
		Set Global Variable(B, Add(Global Variable(B), 1));
		Set Global Variable(A, Ray cast hit position(Add(Position of(Event Player), Up), Add(Add(Position of(Event Player), Multiply(100, Facing direction of(Event Player))), Up), All Players(Team(All)), Event Player, true));
	}
}
```
which can then be copy-pasted into Overwatch.
## Download

https://github.com/Beier/Omnium/releases

## Examples

Have a look at the examples in my test cases. 
https://github.com/Beier/Omnium/tree/master/Omnium.Tests/ToWorkshop/Data

## Documentation

I have created a library of modules, classes and functions that can be used to call all methods in Overwatch workshop. This library is bundled with the release. Most of the library just consist of normal TypeScript classes that you can edit as you see fit, but some of the classes and modules have special meaning to the compiler.

If you are looking for a specific action/function from the Workshop, make a string search for it in the library code.

### Rules

To create a rule, import Native and Rule, and call the method Native.rule

```
import { Native } from "./library/native";
import { Rule } from "./library/rule";

Native.rule(
    "My rule",
    Rule.Events.Ongoing.eachPlayer(),
    Rule.Event.player.isAlive,//Condition can be omitted. Combine multiple conditions with && and ||
    () => {
        //Actions
    }
);
```
All event types are found under `Rule.Events`.
Variables related to the rule, such as Event Player are found under `Rule.Event`.

### Native
All functions in the Native module have special meaning to the compiler.

#### callNative
The native module has functions like `callNativeArg1Function` or `callNativeArg10Action`, which is how an action for function in the native overwatch code is invoked. You should not need to call this directly, as all the actions are already part of the library. 
For instance, the Team class in the library contain the code
```
export class Team {
    public static get team1() {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team1);
    }

    public static get team2() {
        return Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team2);
    }

    public get score() {
        return Native.callNativeArg1Function<Team, number>("Team score", true, false, this);
    }

    public set score(value: number) {
        Native.callNativeArg2Action<Team, number>("Set team score", false, true, this, value);
    }
    
    ...
}
```
Which means you can call `Team.team1.score` instead of `Native.callNativeArg1Function<Team, number>("Team score", true, false, Native.callNativeArg1Function<TeamConst, Team>("Team", true, false, TeamConst.Team1)`.

However, if the Overwatch team adds a new action to the Workshop, it will not be in the library, but you can still call it with theese methods. Also, if you see this, please notify me, or make a pull request on the library code here on GitHub.

### Strings
You can make strings, like you would normally in typescript. 
`Message.send(Players.all, Rule.Event.player + " failed!");`
The compiler will check that the string can be constructed based on the strings registered in library/strings.ts, and convert this into
`String("{0}!", String("{0} {1}", Event Player, String("failed", Null, Null, Null), Null), Null, Null)`
If you try to make a string that can not be constructed, like `Message.send(Players.all, Rule.Event.player + " died!");`, the compilation will fail.

If the compiler is missing a string that exists in overwatch, you can register it with `Native.registerString("...");`. Please also notify me, or make a pull request on the library code here on GitHub.

### Arrays

Normal typescript arrays are not supported, since operations like slice and splice work differently in Overwatch than in normal JavaScript. Instead, use the generic list class
```
import { Native } from "./library/native";
import { List } from "./library/List";

Native.rule("Test list",
    Rule.Events.Ongoing.global,
    () => {
        var list = List.empty<number>();
        list = list.append(3);
	list = list.append(1);
	list = list.append(2);
	list = list.sorted;
    }
);
```
Many library functions such as `Players.all` also return lists.

### Loops

The compiler supports for, for-of and while loops. If you write a for loop with a constant number of iterations, such as
```
var list : List<number> = List.empty<number>();
for (var i = 0; i < 10; i++) {
    list = list.append(i);
}
```
The compiler will unroll it to
```
var list : List<number> = List.empty<number>();
list = list.append(0);
list = list.append(1);
list = list.append(2);
list = list.append(3);
list = list.append(4);
list = list.append(5);
list = list.append(6);
list = list.append(7);
list = list.append(8);
list = list.append(9);
```
If the number of iterations is unknown, the compiler will instead use the `loop` action, but that requires a `wait` somewhere in the loop. For instance
```
import { Native, wait } from "./library/native";
import { Rule } from "./library/rule";
import { Message } from "./library/message";
import { Players } from "./library/player";
import { List } from "./library/list";

Native.rule("Test max array size",
    Rule.Events.Ongoing.global,
    () => {
        var list = List.empty<number>();
        while (true) {
            for (var i = 0; i < 10; i++) {
                list = list.append(list.length);
            }
            Message.send(Players.all, list.length.toString());
            wait(0.3);
        }
    }
);
```
Compiles to
```
rule("Initialize global variables")
{
	event
	{
		Ongoing - Global;
	}
	
	actions
	{
		Set Global Variable(A, 0);
	}
}

rule("Test max array size")
{
	event
	{
		Ongoing - Global;
	}
	
	actions
	{
		Skip If(Compare(Global Variable(A), ==, 1), 2);
		Set Global Variable(B, Empty Array);
		Set Global Variable(A, 1);
		Set Global Variable(C, Append To Array(Global Variable(B), Count Of(Global Variable(B))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(C, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Set Global Variable(B, Append To Array(Global Variable(C), Count Of(Global Variable(C))));
		Big Message(All Players(Team(All)), Count Of(Global Variable(B)));
		Wait(0.3, Ignore condition);
		Loop;
	}
}
```
