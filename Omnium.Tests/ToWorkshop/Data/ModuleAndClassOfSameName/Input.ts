import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/Message";
import { Players } from "../../../library/Player";
import { Game } from "../../../library/Game";


//Max size is 1000
Native.rule("Hello World",
    Rule.Events.Ongoing.global,
    Game.isInProgress,
    () => {
        Message.send(Players.all, Game.MatchTime.seconds.toString());
    }
);