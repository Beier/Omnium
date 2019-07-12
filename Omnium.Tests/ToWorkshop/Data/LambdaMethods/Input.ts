import { Native, wait } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { Player, Players } from "../../../library/Player";
import { List } from "../../../library/List";
import { Message } from "../../../library/Message";

Native.rule("No fly zone",
    Rule.Events.Ongoing.global,
    Players.all.any(player => player.isInAir),
    () => {
        var flyingPlayers = Players.all.filter(player => player.isInAir);
        Players.killAll(flyingPlayers);
    }
);

Native.rule("Sort",
    Rule.Events.Ongoing.eachPlayer(),
    Rule.Event.player.isFiringPrimary,
    () => {
        var list : List<number> = List.empty<number>();
        for (var i = 0; i < 10; i++) {
            list = list.append(i);
        }
        print(list);
        wait(3);
        list = list.shuffled;
        print(list);
        wait(3);
        list = list.sortedBy<number>(x => ((x % 2) * 2 - 1) * x);
        print(list);
        wait(3);
        list = list.sorted;
        print(list);
    }
);

function print(list: List<number>): void {
    var s = list[0].toString();
    for (var i = 1; i < 10; i++) {
        s = s + ", " + list[i];
    }
    Message.send(Players.all, s);
}