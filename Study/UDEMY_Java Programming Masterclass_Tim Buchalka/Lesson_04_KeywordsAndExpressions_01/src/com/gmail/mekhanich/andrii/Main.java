package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {

        displayHighScorePosition("Andrii 01", 1500);
        displayHighScorePosition("Andrii 02", 900);
        displayHighScorePosition("Andrii 03", 400);
        displayHighScorePosition("Andrii 04", 50);
        displayHighScorePosition("Andrii 05", 500);
    }

    public static void displayHighScorePosition (String name, int highScoreTablePosition){
        System.out.println(name + " managet to get into position " + calculateHighScoreTablePosition(highScoreTablePosition) + " on high score table");
    }

    public static int calculateHighScoreTablePosition (int highScore){
        int position = 1;
        if (highScore<100){
            position = 4;
        } else if(highScore<500){
            position = 3;
        } else if(highScore<1000){
            position = 2;
        }
        return position;
    }
   }
