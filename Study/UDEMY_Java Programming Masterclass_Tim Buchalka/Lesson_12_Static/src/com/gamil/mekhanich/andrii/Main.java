package com.gamil.mekhanich.andrii;

public class Main {

    public int multiplier = 7;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        StaticTests first = new StaticTests("First");
        System.out.println(first.getName() + " it`s inst number is " + first.getNumInstances()
                + " class instances counter " + StaticTests.getClassCounter() // preferable notation
                + " this inst counter for " + first.getName());
        // private and public belong to the class instance, but static belongs to a class

        StaticTests second = new StaticTests("Second");

        System.out.println(second.getName() + " it`s inst number is " + second.getNumInstances()
                + " class instances counter " + second.getClassCounter() //!!!!!!!!!!!!!!!!!!prohibited notation
                + " this inst counter for " + second.getName());

//        int answer = multiplay(5);
    }

    public int multiplier(int num) {
        return num * multiplier;
    }


}