package com.gmail.mekhanich.andrii;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText,cText,dText,eText);
        hellos.forEach(s-> System.out.println(s +":" + s.hashCode()));
        Set<String>  newHellos = new HashSet<>(hellos);
        System.out.println(newHellos);

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard>  cards = Arrays.asList(aceHearts,kingClubs,queenSpades);

        cards.forEach(s-> System.out.println(s +":" + s.hashCode()));

        Set<PlayingCard> deck =  new HashSet<>();

        for(PlayingCard c:cards){
            if(!deck.add(c)){
                System.out.println("found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}