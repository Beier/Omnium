/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";


Array.prototype["add"] = function() {

}

Native.rule("Hello World",
    Events.Ongoing.global,
    () => {
        var array: number[] = [];
        while (true) {
            for (var i = 0; i < 10; i++) {
                array = array.add(array.length);
            }
            array.removeAt(42)
            Game.sendMessageTo(Players.all, array.length.toString());
            wait(0.3);
        }
    }
);