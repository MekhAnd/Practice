package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CounterStrike cs01 = new CounterStrike("001");
        CounterStrike cs02 = new CounterStrike("GO");
        CounterStrike cs03 = new CounterStrike("WIN");

        Team <CounterStrike> goTeam = new Team<>("GOTEAM");
        goTeam.addNewMember(cs01);
        goTeam.addNewMember(cs02);
        goTeam.addNewMember(cs03);

        CounterStrike cs001 = new CounterStrike("First");
        CounterStrike cs002 = new CounterStrike("SECOND");
        CounterStrike cs003 = new CounterStrike("Third");

        Team <CounterStrike> wnTeam = new Team<>("WnTeam");
        wnTeam.addNewMember(cs001);
        wnTeam.addNewMember(cs002);
        wnTeam.addNewMember(cs003);

        Ligue<CounterStrike> csgo = new Ligue<>("CSGO");

        csgo.addTeam(goTeam);
        csgo.addTeam(wnTeam);

        goTeam.matchResult(wnTeam, 15,25);
        goTeam.matchResult(wnTeam, 12,2);
        goTeam.matchResult(wnTeam, 25,2);
        goTeam.matchResult(wnTeam, 0,0);

        csgo.ligueTeamChart();



    }
}
