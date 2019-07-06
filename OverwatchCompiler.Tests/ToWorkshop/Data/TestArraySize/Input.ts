/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";

Native.rule("Hello World",
    Events.Ongoing.global,
    () => {
        wait(5);
        var list: List<number> = List.empty<number>();
        list = list.append(1).append(2);
        Game.sendMessageTo(Players.all, list[1].toString());
        wait(5);


        while (true) {
            for (var i = 0; i < 10; i++) {
                list = list.append(list.length);
            }
            Game.sendMessageTo(Players.all, list.length.toString());
            wait(0.3);
        }
    }
);