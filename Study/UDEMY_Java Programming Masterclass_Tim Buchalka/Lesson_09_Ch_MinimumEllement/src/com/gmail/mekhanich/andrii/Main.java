package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int count = sc.nextInt();
        System.out.println(findMin(readIntegers(count)));
        System.out.println("Hello world!");
    }


    public static int [] readIntegers(int count){
       int [] array = new int[count];
       for(int i=0; i<array.length; i++){
           System.out.println("Enter next number: \r");
           int num = sc.nextInt();
           sc.nextLine(); //Tim`s solution!!!
           array[i] = num;
        }
        return array;
    }

    public static int findMin(int [] array){
        int min = array[0]; //Integer.MAX_VALUE!!!
        for(int i=0; i<array.length; i++){
            if(array[i]< min) min = array[i];
        }
        return min;
    }
}
