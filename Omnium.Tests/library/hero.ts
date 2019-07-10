import { Native } from "Native"
import { List } from "List"
import { Player } from "Player"
import { Team, Teams } from "Team"

export class Hero {
    private constructor() { }

    public static ofType(type: HeroType): Hero {
        return Native.callNativeArg1Function<HeroType, Hero>("Hero", false, false, type);
    }

    public preloadFor(player: Player | List<Player>): void {
        Native.callNativeArg2Action<Hero, Player | List<Player>>("Preload hero", false, false, this, player);
    }

    public get iconString(): string {
        return Native.callNativeArg1Function<Hero, string>("Hero icon string", false, false, this);
    }
    
    public isBeingPlayed(team: Team | List<Team> = Teams.all): boolean {
        return Native.callNativeArg2Function<Hero, Team | List<Team>, boolean>("Is hero being played", false, false, this, team);
    }

    public get count() : number {
        return this.countOn(Teams.all);
    }

    public countOn(team: Team | List<Team>): number {
        return Native.callNativeArg2Function<Hero, Team | List<Team>, number>("Number of heroes", true, false, this, team);
    }
}

export class Heroes {
    private constructor() { }

    public static get all(): List<Hero> {
        return Native.callNativeArg0Function<List<Hero>>("All Heroes", true, false);
    }

    public static resetAvalibleHeroesFor(player: Player | List<Player>): void {
        Native.callNativeArg1Action<Player | List<Player>>("Reset player hero availability", false, true, player);
    }
}



export enum HeroType {
    Reaper = "Reaper",
    Tracer = "Tracer",
    Mercy = "Mercy",
    Hanzo = "Hanzo",
    Torbjorn = "Torbjörn",
    Reinhardt = "Reinhardt",
    Pharah = "Pharah",
    Winston = "Winston",
    Widowmaker = "Widowmaker",
    Bastion = "Bastion",
    Symmetra = "Symmetra",
    Zenyatta = "Zenyatta",
    Genji = "Genji",
    Roadhog = "Roadhog",
    McCree = "McCree",
    Junkrat = "Junkrat",
    Zarya = "Zarya",
    Soldier76 = "Soldier: 76",
    Lucio = "Lúcio",
    Dva = "D.Va",
    Mei = "Mei",
    Sombra = "Sombra",
    Doomfist = "Doomfist",
    Ana = "Ana",
    Orisa = "Orisa",
    Brigitte = "Brigitte",
    Moira = "Moira",
    WreckingBall = "Wrecking Ball",
    Ashe = "Ashe",
    Baptiste = "Baptiste"
}