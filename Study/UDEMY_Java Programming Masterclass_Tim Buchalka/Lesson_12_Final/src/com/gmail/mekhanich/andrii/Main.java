package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {

//        SomeClass one = new SomeClass("One");
//        SomeClass two = new SomeClass("Two");
//        SomeClass three = new SomeClass("Three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//
//        int pw = 674312;
//        Password password = new Password(pw);
//        password.storePassword();
//
//        password.letMeIn(1);
//        password.letMeIn(523266);
//        password.letMeIn(9773);
//        password.letMeIn(0);
//        password.letMeIn(-1);
//        password.letMeIn(674312);

        System.out.println("Main method called");
        SttaticInitializBlockTest test = new SttaticInitializBlockTest();
        test.soneMethod();
        System.out.println("owner is " + SttaticInitializBlockTest.owner);

    }
}