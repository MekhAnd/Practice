package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] myArray = getIntegers(5);
        printArray (myArray);

    }

    public static void printArray (int[]array){
       for (int i = 0; i<array.length; i++){
            System.out.println("Element " + i + " contents "+ array[i]);
        }

    }

    public static int[] sortIntegers(int[] oldArray){
        int [] array = Arrays.copyOf(oldArray, oldArray.length); //Tim`s solution

        for (int i = 0; i<array.length-1; i++){
            for(int j = array.length-1; j>i; j--) {
                int tmp = 0;
                if (array[i] < array[j]) {
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] getIntegers (int quantity){
        int[] array = new int[quantity];
        for(int i = 0; i< array.length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }
}