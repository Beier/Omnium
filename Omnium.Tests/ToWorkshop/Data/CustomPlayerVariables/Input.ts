import { Native } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Vector, RayCast } from "../../../library/vector";
import { Message } from "../../../library/message";
import { Players } from "../../../library/player";
import { Icon, Color } from "../../../library/icon";

//Could potentially be multiple different classes implementing player vars
class PlayerVars extends Native.PlayerVars {
    public firstShotPosition: Vector = null;
    public shots = 0;
    public totalDistance = 0;
    public icon : Icon.Icon = null; 

    public get averageDistance() {
        return this.totalDistance / this.shots;
    }

    public reset() {
        if (this.firstShotPosition != null) {
            Icon.create(Icon.Type.X, Color.White, this.player, this.firstShotPosition);
        }
        this.firstShotPosition = null;
        this.shots = 0;
        this.totalDistance = 0;
        if (this.icon != null) {
            this.icon.destroy();
            this.icon = null;
        }
    }
}

Native.rule("On player took a shot",
    Rule.Events.Ongoing.eachPlayer(),
    Rule.Event.player.isFiringPrimary,
    () => {
        var player = Rule.Event.player;
        var start = player.eyePosition;
        var direction = player.facingDirection;
        var hitPosition = RayCast.position(start, start + 1000 * direction, null, Players.all, false);
        let playerVars = player.vars<PlayerVars>();
        if (playerVars.firstShotPosition == null) {
            playerVars.firstShotPosition = hitPosition;
            playerVars.icon = Icon.create(Icon.Type.Circle, Color.Red, player, hitPosition);
            return;
        }

        var distance = hitPosition.distanceTo(playerVars.firstShotPosition);
        playerVars.shots++;
        playerVars.totalDistance += distance;
        Message.send(player, "Distance: " + distance + ", average distance: " + playerVars.averageDistance);
    }
);

Native.rule("Reset",
    Rule.Events.Ongoing.eachPlayer(),
    Rule.Event.player.isUsingAbility1,
    () => {
        Rule.Event.player.vars<PlayerVars>().reset();
    }
);