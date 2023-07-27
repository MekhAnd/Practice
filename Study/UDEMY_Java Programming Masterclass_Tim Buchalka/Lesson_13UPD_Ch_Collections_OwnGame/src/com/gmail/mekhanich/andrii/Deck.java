package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

record Card(Suit s, String face, int rank){
    public static String setFace(int rank){
        String[] cards = {"7", "8", "9", "10", "J", "Q", "K", "A"};
        return cards[rank];
    }


    public int getRank(){
        return rank;
    }

    public String getFace(){
        return face;
    }

    public Suit getSuit(){
        return s;
    }

    @Override
    public String toString() {
        return s.getImage() + " " +face + ", ";
    }
}

public class Deck {
    public List<Card> deck = new ArrayList<>();

    public Deck(){
        System.out.println("Prepare deck");
        for(Suit s:Suit.values()){
            for(int i = 0; i<8; i++){
                String face = Card.setFace(i);
                deck.add(new Card(s, face, i));
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void deckShuffle(){
        Collections.shuffle(deck);
    }

    public void printCurrenDeck(){
        System.out.println();
        this.deck.forEach(System.out::print);
    }

    public Card get(int i) {
        return deck.get(i);
    }
}
