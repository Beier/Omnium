import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Vector } from "../../../library/vector";
import { Message } from "../../../library/Message";
import { Players, Button } from "../../../library/Player";

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
