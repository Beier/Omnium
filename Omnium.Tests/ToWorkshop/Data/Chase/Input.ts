import { Native, wait, ChaseRateReevaluation } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Message } from "../../../library/message";
import { Players } from "../../../library/player";

Native.rule("Hurt all aggressive players",
    Rule.Events.Ongoing.eachPlayer(Rule.Events.Team.All, Rule.Events.Players.All),
    Rule.Event.player.isFiringPrimary,
    () => {
        var shootingDuration = 0;
        Native.chaseAtRate(shootingDuration, shootingDuration + 1, 10, ChaseRateReevaluation.DestinationAndRate);
        while (Rule.Event.player.isFiringPrimary) {
            Rule.Event.player.damage(shootingDuration);
            wait(1);
        }
        Native.stopChasing(shootingDuration);
    }
);