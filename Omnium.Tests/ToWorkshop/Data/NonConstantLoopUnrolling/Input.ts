import { Native, wait } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/Message";
import { Players } from "../../../library/Player";

Native.registerString("Tick");
Native.registerString("Tock");
Native.registerString("Starting");

Native.rule("Hello World",
    Rule.Events.Ongoing.global,
    () => {
        Message.send(Players.all, "Starting", Message.Size.Big);
        for (var player of Players.all) {
            Message.send(player, "Hello " + player, Message.Size.Small);
            wait(0.3);
        }
        var isTick: boolean = true;
        while (true) {
            wait(1);
            if (isTick)
                Message.send(Players.all, "Tick", Message.Size.Small);
            else
                Message.send(Players.all, "Tock", Message.Size.Small);
            isTick = !isTick;
        }
    }
);