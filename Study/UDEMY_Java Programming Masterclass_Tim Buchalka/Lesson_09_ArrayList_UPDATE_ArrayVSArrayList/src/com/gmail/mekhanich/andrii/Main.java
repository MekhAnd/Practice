package com.gmail.mekhanich.andrii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] originalArray = new String[]{"First", "second", "Third"};
        var originalList = Arrays.asList(originalArray); //will change both Array and List

        originalList.set(0, "Zero");
        System.out.println("originalList -" +originalList);
        System.out.println("originalArray - "+Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder()); //sort both of them

        System.out.println("originalList -" +originalList);
        System.out.println("originalArray - "+Arrays.toString(originalArray));

//        originalList.remove(0); //error!!! immutable!!!!
//        originalList.add("fourth");//error!!! immutable!!!!

        List<String> newStringList = Arrays.asList("one", "two", "three");
        System.out.println(newStringList);


    }
}