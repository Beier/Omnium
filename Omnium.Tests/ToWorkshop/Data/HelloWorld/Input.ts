import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/Message";
import { Button } from "../../../library/Player";


Native.rule("Hello World",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Player.All),
    Rule.Triggering.player.isHoldingButton(Button.PrimaryFire),
    () => {
        Message.send(Rule.Triggering.player, "Hello " + Rule.Triggering.player + "!");
    }
);