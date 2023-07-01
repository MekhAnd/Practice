package com.gmail.mekhanich.andrii;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 100;
        int y = 0;
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));

//        int newX = getInt();
//        System.out.println("This X = " + newX);

//        int newX0 = getIntLBYL();
//        System.out.println("This X = " + newX0);

        int newX1= getIntEAFP();
        System.out.println("This X = " + newX1);
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int getIntLBYL() {
        Scanner sc = new Scanner(System.in);

        boolean isValid = true;
        String input = sc.next();
        for(int i = 0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }

    private static int getIntEAFP(){
        Scanner sc = new Scanner(System.in);
        try{
            return sc.nextInt();
        } catch (InputMismatchException ime){
            ime.printStackTrace();
            return 0;
        }
    }

    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            return 0;
        }
    }
}