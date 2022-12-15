package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String [] strArray = new String [10];
        int[] intArray = new int [10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

//        ArrayList<int> intArrayList = new ArrayList<Integer>(); !!!!!!error INTEGER

        int myInt = 56;
        Integer myIneger = Integer.valueOf(myInt);

        Integer nextInteger = new Integer(65);
        int nextInt = nextInteger.intValue();

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        strArrayList.add("Tim");
    }
}