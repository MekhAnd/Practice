package com.gmail.mekhanich.andrii;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {
    private String name;
    private List<Card> dial;
    private int score = 0;
    private boolean duty = false;
    private boolean gameOwner = false;

    public Player(String name) {
        this.name = name;
    }

    public void setDuty(boolean duty) {
        this.duty = duty;
    }

    public boolean isDuty() {
        return duty;
    }

    public boolean isGameOwner() {
        return gameOwner;
    }

    public void setGameOwner(boolean gameOwner) {
        this.gameOwner = gameOwner;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDial() {
        return dial;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setDial(List<Card> dial) {
        this.dial = dial;
    }

    public void sortDial(){
       var comporator =Comparator.comparing(Card::s)
                        .thenComparing(Card::rank);
       Collections.sort(dial, comporator);
    }

    @Override
    public String toString() {
        return "Player "+ name +" has " + dial + '}';
    }
}
