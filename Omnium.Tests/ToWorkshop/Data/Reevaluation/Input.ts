import { Native, wait } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message, TextColor } from "../../../library/message";
import { Game } from "../../../library/game";


Native.rule("Show stats",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Players.All),
    () => {
        var player = Rule.Event.player;
        var lastPosition = player.position;
        var distanceTraveled = 0;
        Message.Hud.Text.create(player,
            "Status",
            "Time: " + Game.totalSecondsElapsed + " sec",
            "Distance: " + distanceTraveled + " m",
            Message.Hud.Text.Location.Left,
            0,
            TextColor.White,
            TextColor.White,
            TextColor.White,
            Message.Hud.Text.Reevaluation.String);
        while (true) {
            wait(0.25);
            distanceTraveled += player.position.distanceTo(lastPosition);
            lastPosition = player.position;
        }
    }
);