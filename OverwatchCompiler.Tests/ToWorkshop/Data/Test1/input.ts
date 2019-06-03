/// <reference path="../../../../OverwatchCompiler.ToWorkshop/library/core.ts" />
import "../../../library/core.ts";

rule("Rule 1",
    Events.Ongoing.Global,
    () => {
        let number = Math.abs(0);
        number = 1 + 2*3 - 4/(5 + 6);
        let players = Players.deadOnTeam(Teams.all);
        let heroes = Heroes.all;
        players = Players.aliveOnTeam(Teams.all);
        players = Players.onTeam(Teams.all);
        players = Players.notOnObjectiveFromTeam(Teams.all);
        players = Players.onObjectiveFromTeam(Teams.all);
        heroes = Heroes.allowedForPlayer(Rule.Event.player);
        number = Rule.Event.player.altitude;
    }
);