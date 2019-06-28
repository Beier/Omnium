﻿/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";
import "../../../library/strings.ts";


Native.rule("Hello World",
    Events.Ongoing.eachPlayer(Events.Team.All, Events.Player.All),
    Triggering.player.isHoldingButton(Button.PrimaryFire),
    () => {
        Game.sendMessageTo(Triggering.player, "Hello " + Triggering.player + "!");
    }
);