import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/Message";
import { Button } from "../../../library/Player";

Native.rule("Hello World",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Player.All),
    Rule.Triggering.player.isHoldingButton(Button.PrimaryFire),
    () => {
        for (var i = 0; i < 10; i++) {
            if (i % 2 == 0)
                Message.send(Rule.Triggering.player, "Hello " + i + "!");
            else
                Message.send(Rule.Triggering.player, "Buy!!?!", Message.Size.Small);
        }
    }
);