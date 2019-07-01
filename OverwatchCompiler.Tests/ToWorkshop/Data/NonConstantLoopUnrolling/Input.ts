/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";

Native.registerString("Tick");
Native.registerString("Tock");
Native.registerString("Starting");

Native.rule("Hello World",
    Events.Ongoing.global,
    () => {
        Game.sendMessageTo(Players.all, "Starting", MessageSize.Big);
        for (var player of Players.all) {
            Game.sendMessageTo(player, "Hello " + player, MessageSize.Small);
            wait(0.3);
        }
        var isTick: boolean = true;
        while (true) {
            wait(1);
            if (isTick)
                Game.sendMessageTo(Players.all, "Tick", MessageSize.Small);
            else
                Game.sendMessageTo(Players.all, "Tock", MessageSize.Small);
            isTick = !isTick;
        }
    }
);