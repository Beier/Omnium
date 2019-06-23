/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";

var textPosition: Vector;
var totalShots: number = 0;

Native.rule("Initialize text",
    Events.Ongoing.global,
    true,
    () => {
        textPosition = Vector.zero;
        Game.createInWorldText(Players.all, totalShots.toString(), textPosition, 3, InWorldTextClipping.AlwaysVisible);
    }
);

Native.rule("Move text to shot target",
    Events.Ongoing.eachPlayer(Events.Team.All, Events.Player.All),
    Triggering.player.isHoldingButton(Button.PrimaryFire),
    () => {
        totalShots++;
        textPosition = Vector.getFirstIntersectionBetween(
            Triggering.player.position + Vector.up,
            Triggering.player.position + 100 * Triggering.player.facingDirection + Vector.up
        );
    }
);
