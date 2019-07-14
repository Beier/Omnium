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
Todo

## Examples

Have a look at the examples in my test cases. 
https://github.com/Beier/Omnium/tree/master/Omnium.Tests/ToWorkshop/Data












