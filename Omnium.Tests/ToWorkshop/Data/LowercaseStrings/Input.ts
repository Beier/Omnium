import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/Message";
import { Button } from "../../../library/Player";


Native.rule("Hello World",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Players.All),
    Rule.Event.player.isHoldingButton(Button.PrimaryFire),
    () => {
        Message.send(Rule.Event.player, "Wow, you win current round!");
    }
);