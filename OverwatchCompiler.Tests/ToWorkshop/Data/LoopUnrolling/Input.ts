/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";


Native.rule("Hello World",
    Events.Ongoing.eachPlayer(Events.Team.All, Events.Player.All),
    Triggering.player.isHoldingButton(Button.PrimaryFire),
    () => {
        for (var i = 0; i < 2; i++) {
            if (i % 2 == 0)
                Game.sendMessageTo(Triggering.player, "Hello " + i + "!");
            else
                Game.sendMessageTo(Triggering.player, "Buy!!?!", MessageSize.Small);
        }
    }
);