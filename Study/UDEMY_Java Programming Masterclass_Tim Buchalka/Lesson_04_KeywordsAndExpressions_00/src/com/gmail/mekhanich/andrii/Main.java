package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        finalScoreBonuses(gameOver, score,levelCompleted, bonus);

//        if (gameOver) {
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score " + finalScore);
//        }

//        score = 10000;
//        levelCompleted = 8;
//        bonus = 200;

        finalScoreBonuses(false, 1000,8, 200);
//        if (gameOver) {
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score " + finalScore);
//        }
    }

    public static int finalScoreBonuses( boolean go, int score, int levelCompleted, int bonus){
        int finalScore;
        if (go) {
            finalScore = score + (levelCompleted * bonus);
        } else{
            finalScore = -1;
        }
        System.out.println("Your final score " + finalScore);
        return finalScore;
    }
}