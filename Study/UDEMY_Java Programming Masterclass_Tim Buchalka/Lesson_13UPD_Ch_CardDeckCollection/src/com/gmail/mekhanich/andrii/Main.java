package com.gmail.mekhanich.andrii;

import java.util.*;


public class Main {
    public static void main(String[] args) {



        Card[] cardsArray =  new Card[13];
        Card aceOfHearts = Card.getFaceCard(Suit.HEART, 'A');

        Arrays.fill(cardsArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardsArray), "Ace of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1 );

        Card kingOfClubs = Card.getFaceCard(Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1 );

        Collections.addAll(cards, cardsArray);
        Collections.addAll(cards, cardsArray);
        Card.printDeck(cards, "Card colletions with Aces added", 2);
//
        Collections.copy(cards, kingsOfClubs); //kingsOfClubs.length = 13 and cards.length = 0
        Card.printDeck(cards, "Card Collection with King copied", 2); //Source does not fit in dest

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Revresed Deck of Cards", 4);

        var sortingAlgorythm = Comparator.comparing(Card::getRank)
                .thenComparing(Card::getSuit);
        Collections.sort(deck, sortingAlgorythm);
//        deck.sort(sortingAlgorythm);
        Card.printDeck(deck, "Standart Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit revesed:", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens, "Tens in deck", 1);

//        Collections.shuffle(deck);
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);


        boolean disjoint1 = Collections.disjoint(kings, tens);
        System.out.println("disjoint1 = " + disjoint1);

        deck.sort(sortingAlgorythm);
        Card tenOfHearts =Card.getNumericCard(Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorythm);
        System.out.println("found index = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts)); //????
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32,36), "Tens row", 1);

        Collections.replaceAll(deck, tenOfHearts,tenOfClubs );
        Card.printDeck(deck.subList(32,36), "Tens row", 1);

        if(Collections.replaceAll(deck, tenOfHearts,tenOfClubs)){
            System.out.println("tens of * all replaced" );
        } else{
            System.out.println("No tens of * found");
        }

        System.out.println("Ten of Clubs Cards = " +
                Collections.frequency(deck, tenOfClubs));

        System.out.println("Best card = " + Collections.max(deck, sortingAlgorythm));
        System.out.println("Worst card = " + Collections.min(deck, sortingAlgorythm));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotating = " + deck.subList(0,13));
        System.out.println("Rotating = " + 2 +" : "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2);
        System.out.println("UnRotating = " + deck.subList(0,13));
        System.out.println("Rotating = " + -2 +" : "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for(int i = 0; i < copied.size()/2; i++){
            Collections.swap(copied, i, copied.size()-1-i);
        }
        System.out.println("Manual reverse = " + copied);
        System.out.println("Manual reverse2 = ");
        Collections.reverse(copied);
        System.out.println( copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("reverse AGAIN= " + copied);

        String test = "10";
        System.out.println(Integer.parseInt(test));
        String test01 = "A";
        System.out.println(Integer.parseInt(test01));

    }
}