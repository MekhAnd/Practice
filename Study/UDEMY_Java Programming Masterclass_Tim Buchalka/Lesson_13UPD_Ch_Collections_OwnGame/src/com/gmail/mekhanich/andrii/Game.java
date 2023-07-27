package com.gmail.mekhanich.andrii;

import java.util.*;
import java.util.function.Function;

public class Game {

    private final String name;
    private final List<Player> game;
    private final Deck deck;
    private Card ruff;
    private int dial = 0;

    public Game(String name, Deck deck, Player player01, Player player02, Player player03, Player player04) {
        this.name = name;
        this.deck = deck;
        this.game = new ArrayList<>(List.of(player01, player02, player03, player04));
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getGame() {
        return game;
    }

    public void newDeal() {
        game.forEach(s->{
            s.setDuty(false);
            s.setGameOwner(false);
        });

        game.get(dial % 4).setDuty(true);
        firstDeal();
    }

    public void firstDeal() {
        dial++;
        Collections.shuffle(deck.getDeck());
        List<List<Card>> firstDial = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));

        int decklength = 25;
        int curdNumber = 0;

        for (int i = decklength; i >= 0; i -= 4) {
            if (decklength == 1) {
                ruff = (deck.getDeck()).get(decklength);
                deck.getDeck().remove(deck.get(decklength));
                deck.getDeck().add(ruff);
                Collections.reverse(deck.getDeck());
                deck.getDeck().forEach(System.out::print);
                setGameDial(firstDial);
                decklength = 0;
            } else {
                curdNumber++;
                int endIndex = 0;
                for (Player pl : game) {
                    if (pl.isDuty()) {
                        break;
                    } else {
                        endIndex++;
                    }
                }

                Player duty = game.get(endIndex);
                game.remove(endIndex);
                game.add(duty);

                for (int k = 0; k < firstDial.size(); k++) {
                    firstDial.get(k).add(deck.get(i - k));
                    deck.getDeck().remove(deck.get(i - k));
                }
                decklength -= 4;
            }
        }

        System.out.println("***************************");
        game.forEach(s -> System.out.println(s.getDial()));
        System.out.println(ruff);

        secondDeal();
    }

    public void setGameDial(List<List<Card>> dial) {
        for (int k = 0; k < dial.size(); k++) {
            game.get(k).setDial(dial.get(k));
            game.get(k).sortDial();
        }
    }

    public void sortPlayersDial() {
        for (int i = 0; i < game.size(); i++) {
            List<Card> playerDial = game.get(i).getDial();
            int[] suits = new int[4];

            for (int k = 0; k < playerDial.size(); k++) {
                if (playerDial.get(k).getSuit() == Suit.CLUB) {
                    suits[0]++;
                } else if (playerDial.get(k).getSuit() == Suit.DIAMOND) {
                    suits[1]++;
                } else if (playerDial.get(k).getSuit() == Suit.HEART) {
                    suits[2]++;
                } else if (playerDial.get(k).getSuit() == Suit.SPADE) {
                    suits[3]++;
                }
            }

            boolean check = false;
            for (int quant : suits) {
                if (quant >= 3) {
                    check = true;
                    break;
                }
            }

            if (check) {
                checkRows(suits, game.get(i));
            }

        }
    }

    public void checkRows(int[] array, Player player) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]>2) {
                Suit[] suits = Suit.values();
                Suit s = suits[i];
                List cards = new ArrayList<Integer>(array[i]);
                for (int k = 0; k < player.getDial().size(); k++) {
                    if (player.getDial().get(k).getSuit() == s) {
                        cards.add(player.getDial().get(k).getRank());
                    }
                }
                int row = 0;
                int [] result =new int [cards.size()-1];
                for (int index = 0; index< cards.size(); index ++){
                    if((index+1)< cards.size()){
                        result[index] = (Integer)cards.get(index+1)-(Integer)cards.get(index) == 1 ?
                                (Integer)cards.get(index+1)-(Integer)cards.get(index) : 0;

                    }
                }

                for (int num: result) {
                    if(num == 1){
                        row += num;
                    }
                }

                if (deck.getDeck().size() > 0) {
                    decisionLogic(player, row, cards, s);
                } else {
                    if ( row == cards.size()-1 && row == 2) {
                        System.out.println(player.getName() + " has "+ (row+1) +" in row " + s.getImage());
                        player.setScore(30);
                    } else if (row == cards.size()-1 && row >= 3) {
                        System.out.println(player.getName() + " has " + (row+1) + " in row " + s.getImage());
                        player.setScore(50);
                    }
                    for (Player pl : game) {
                        pl.sortDial();
                    }
                }

            }
        }

    }

    public void secondDeal() {

        List<List<Card>> secondDial = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));

        int decklength = 7;
        while (decklength >= 0) {
            for (int k = 0; k < secondDial.size(); k++) {
                secondDial.get(k).add(deck.get(decklength));
                deck.getDeck().remove(deck.get(decklength));
                decklength--;
            }
        }

        for (int i = 0; i < game.size(); i++) {
            List fullCardSet = game.get(i).getDial();
            fullCardSet.addAll(secondDial.get(i));
        }

        System.out.println("****UNSORTED FULL DIAL****");
        game.forEach(System.out::println);
        System.out.println("****UNSORTED FULL DIAL****");
        System.out.println();
        sortPlayersDial();
    }

    public void decisionLogic(Player player, int row, List cards, Suit s) {
        if (player.isDuty()) {
            if (row == cards.size() - 1) {
                if (row == 2) {
                    if (checkHigherCards(player, s) && s == ruff.getSuit()) {
                        System.out.println(player.getName() + " is make decision play in " + ruff.getSuit());
                        player.setGameOwner(true);
                        secondDeal();
                    } else if (checkHigherCards() && s == ruff.getSuit()) {
                        System.out.println(player.getName() + " is make decision play in " + ruff.getSuit());
                        player.setGameOwner(true);
                        secondDeal();
                    }
                } else if (row >= 3) {
                    if ((checkHigherCards(player, s) && s == ruff.getSuit()) ||
                            (checkHigherCards() && s == ruff.getSuit())) {
                        System.out.println(player.getName() + " is make decision play in " + ruff.getSuit());
                        player.setGameOwner(true);
                        secondDeal();
                    }
                } else {
                    System.out.println(player.getName() + " pass");
                }
            } else {
                System.out.println(player.getName() + " pass");
            }
        } else {
            if (s == ruff.getSuit()) {
                if (row > 3 && checkHigherCards(player, s) && !checkHigherCards()) {
                    System.out.println(player.getName() + " is make decision play in " + ruff.getSuit());
                    player.setGameOwner(true);
                    secondDeal();
                } else {
                    System.out.println(player.getName() + " pass");
                }
            } else {
                if (row > 3 && checkHigherCards(player, s)) {
                    System.out.println(player.getName() + " is make decision play in " + ruff.getSuit());
                    player.setGameOwner(true);
                    secondDeal();
                } else {
                    System.out.println(player.getName() + " pass");
                }
            }
        }
    }

    public boolean checkHigherCards(Player player, Suit s) {
        var comparator = Comparator.comparing(Card::s).thenComparing(Card::rank);
        int index9 = Collections.binarySearch(player.getDial(), new Card(s, "9", 2), comparator);
        int indexJ = Collections.binarySearch(player.getDial(), new Card(s, "J", 4), comparator);

        return index9 > 0 && indexJ > 0;
    }

    public boolean checkHigherCards() {
        return ruff.getRank() == 2 || ruff.getRank() == 4;
    }

    public void prelimScore(){

    }
}
