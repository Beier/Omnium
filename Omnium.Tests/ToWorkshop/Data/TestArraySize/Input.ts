import { Native, wait } from "../../../library/native";
import { Rule } from "../../../library/rule";
import { List } from "../../../library/list";
import { Message } from "../../../library/Message";
import { Players } from "../../../library/Player";

//Max size is 1000
Native.rule("Hello World",
    Rule.Events.Ongoing.global,
    () => {
        wait(5);
        var list = List.empty<number>();
        list = list.append(1).append(2);
        Message.send(Players.all, list[1].toString());
        wait(5);


        while (true) {
            for (var i = 0; i < 10; i++) {
                list = list.append(list.length);
            }
            Message.send(Players.all, list.length.toString());
            wait(0.3);
        }
    }
);