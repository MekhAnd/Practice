package com.gmail.mekhanich.andrii;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
//        deck.printCurrenDeck();

        Game test = new Game("Deberc", deck,
                                    new Player("A"), new Player("B"),
                                    new Player("C"), new Player("D"));

        test.newDeal();
//        test.sortPlayersDial();
        System.out.println();
        System.out.println("Final players card sets");
        test.getGame().forEach(s-> System.out.println(s.getDial()));
        test.getGame().forEach(s-> System.out.println(s.getName() + " has " + s.getScore() + " points"));
    }
}