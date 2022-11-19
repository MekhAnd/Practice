package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {

        double one = 20.00;
        double two = 80.00;
        double three = (one + two) * 100;

        double remainder = three % 40;
        System.out.println(remainder);
        boolean isNoRemainder = (remainder == 0)? true:false;
        System.out.println(isNoRemainder);
        if(!isNoRemainder){
            System.out.println("Got some reminder");
        }

    }
}