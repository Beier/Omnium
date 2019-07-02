/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";


Array.prototype["add"] = function() {

}

Native.rule("Hello World",
    Events.Ongoing.global,
    () => {
        var list : List<number> = List.empty<number>();
        while (true) {
            for (var i = 0; i < 10; i++) {
                list = list.append(list.length);
            }
            Game.sendMessageTo(Players.all, list.length.toString());
            wait(0.3);
        }
    }
);