package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
//    private Suit suit;
//    private String face;
//    private int rank;

    public Card(Suit suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }
//
//    public void setSuit(Suit suit) {
//        this.suit = suit;
//    }
//
//    public String getFace() {
//        return face;
//    }
//
//    public void setFace(String face) {
//        this.face = face;
//    }
//
    public int getRank() {
        return rank;
    }
//
//    public void setRank(int rank) {
//        this.rank = rank;
//    }

    public static Card getNumericCard(Suit s, int rank){
        if(rank > 1 && rank < 11){
            return new Card(s, String.valueOf(rank), rank -2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
//
//        String face = (
//        switch(rank){
//            case 0 -> "2";
//            case 1 -> "3";
//            case 2 -> "4";
//            case 3 -> "5";
//            case 4 -> "6";
//            case 5 -> "7";
//            case 6 -> "8";
//            case 7 -> "9";
//            case 8 -> "10";
//            case 9 -> "J";
//            case 10 -> "Q";
//            case 11 -> "K";
//            case 12 -> "A";
//            default -> "0";
//        });
//        Card card = new Card(s, face, rank);
//        return card;
    }

    public static Card getFaceCard(Suit s, char abbrev){
        int charIdex = "JQKA".indexOf(abbrev);

        if(charIdex > -1){
            return new Card(s, ""+abbrev, charIdex+9 );
        }
        System.out.println("Invalid Face card selected");
        return null;
//
//        int rank = (
//                switch(face){
//                    case "2" -> 0;
//                    case "3" -> 1;
//                    case "4" -> 2;
//                    case "5" -> 3;
//                    case "6" -> 4;
//                    case "7" -> 5;
//                    case "8" -> 6;
//                    case "9" -> 7;
//                    case "10" -> 8;
//                    case "J" -> 9;
//                    case "Q" -> 10;
//                    case "K" -> 11;
//                    case "A" -> 12;
//                    default -> -1;
//                });
//        Card card = new Card(s, face, rank);
//        return card;
    }

    public static List<Card> getStandardDeck(){

        List<Card> deck = new ArrayList<>(52);
        for(Suit suit: Suit.values()){
            for (int i=2; i<=10; i++){
                deck.add(getNumericCard(suit, i));
            }
            for (char c: new char[] {'J', 'Q', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }

        return deck;
    }

    public static  void printDeck(List<Card> deck, String description, int rows){
        System.out.println("-----------------------");
        if(description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size()/ rows;
        for(int i = 0; i< rows; i++){
            int startIndex = i*cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck. subList(startIndex, endIndex).forEach(c-> System.out.print(c + " "));
            System.out.println();
        }
    }

    public static  void printDeck(List<Card> deck){
        printDeck(deck,"Current deck", 4);
    }

    @Override
    public String toString() {
        int index = face.equals("10")? 2:1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }
}
