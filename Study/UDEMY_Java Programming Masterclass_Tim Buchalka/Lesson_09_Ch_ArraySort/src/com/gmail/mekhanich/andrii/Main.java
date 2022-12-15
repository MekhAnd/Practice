package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] array = new int [15];
        for (int i = 0; i<array.length-1; i++){
            array[i] = (int)((Math.random()*10)*100);
        }
        System.out.println(Arrays.toString(array));
        arraySort(array);

    }

    public static int[] arraySort(int[] oldArray) {
//        int [] array = new int [oldArray.length];
//
//        for (int i = 0; i<array.length-1; i++){
//            array[i] = oldArray[i];
//        }

        int [] array = Arrays.copyOf(oldArray, oldArray.length); //Tim`s solution

        for (int i = 0; i<array.length-1; i++){
            for(int j = array.length-1; j>i; j--) {
                int tmp = 0;
                if (array[i] < array[j]) {
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                } else {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}