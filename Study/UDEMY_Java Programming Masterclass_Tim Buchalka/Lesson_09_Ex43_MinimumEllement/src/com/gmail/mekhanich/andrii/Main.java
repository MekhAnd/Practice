package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int count = readInteger();
        int []array =readElements(count);
        int min = findMin(array);
        System.out.println(min);

    }

    public static int readInteger(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the quantity of elements: \r");
        int count = sc.nextInt();
        return count;
    }

    public static int [] readElements (int count){
        Scanner sc = new Scanner(System.in);
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