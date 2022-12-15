package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int myNum = 10;
        int another = myNum;
        System.out.println(myNum);
        System.out.println(another);

        another++;
        System.out.println();
        System.out.println(myNum);
        System.out.println(another);


        int[]array = {0,1,2,3,4};
        int newArray[] = array;

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArray));

        array[0] = 12;
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArray));

        int[] newRightCopyArray = Arrays.copyOf(array, array.length);
        array[0] = 100;
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(newRightCopyArray));



    }
}