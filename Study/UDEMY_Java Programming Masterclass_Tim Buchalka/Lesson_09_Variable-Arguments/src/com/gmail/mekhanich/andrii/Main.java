package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello world again!");

        String[] splitString = "Hello world again!".split(" ");
        printText(splitString);
        printTextPeriods(splitString);

        System.out.println("*************************");

        printTextPeriods("String without split");
//        printText("String without split"); ERROR

        System.out.println("*************************");

        printTextPeriods("String without split", "hello", "new");
//       printText("String without split", "hello", "new"); ERROR

        System.out.println("*************************");

        String[] sArray = {"one", "two", "three", "four", "five"};
        System.out.println(String.join(", ", sArray));

    }

    private static  void printText(String[] textList){
        for (String text:textList) {
            System.out.println(text);
        }
    }

    private static  void printTextPeriods(String... textList){
        for (String text:textList) {
            System.out.println(text);
        }
    }
}