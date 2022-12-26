package com.gmsil.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        FootballPlayer joe = new FootballPlayer("Joe");
        BasebalPlayer pat = new BasebalPlayer("Pat");
        SoccerPlayer mack = new SoccerPlayer("Mack");

        Team<FootballPlayer> niva = new Team("Niva");
        Team<BasebalPlayer> nivaB = new Team("Niva BaseBall");
        Team<SoccerPlayer> nivaC = new Team("Niva Soccer");
        nivaC.addPlayer(mack);
        nivaB.addPlayer(pat);
        niva.addPlayer(joe);

        System.out.println(niva.numPlayers());
        System.out.println(nivaB.numPlayers());
        System.out.println(nivaC.numPlayers());

//      If we try to add:

//      Team<String> brokenTeam = new Team("mambojambo");

//      without <T extends Player>
//      and try to call:

//      brokenTeam.addPlayer("no-one");

//      THIS Give Exception in thread "main" java.lang.ClassCastException: class java.lang.String
//      cannot be cast to class com.gmsil.mekhanich.andrii.Player
//      (java.lang.String is in module java.base of loader 'bootstrap'; com.gmsil.mekhanich.andrii.Player
//      is in unnamed module of loader 'app')
//	    at com.gmsil.mekhanich.andrii.Team.addPlayer(Team.java:28)
//  	at com.gmsil.mekhanich.andrii.Main.main(Main.java:23)
//      Because  ((Player)player).getName()

        Team<FootballPlayer> dinamo = new Team<>("Dinamo");

        niva.matchResult(dinamo, 2, 0);

        System.out.println("Rankings");
        System.out.println(niva.getName() + ": " + niva.ranking());
        System.out.println(dinamo.getName() + ": " + dinamo.ranking());
        System.out.println(nivaB.getName() + ": " + nivaB.ranking());
        System.out.println(nivaC.getName() + ": " + nivaC.ranking());

        System.out.println(niva.compareTo(dinamo));


    }
}