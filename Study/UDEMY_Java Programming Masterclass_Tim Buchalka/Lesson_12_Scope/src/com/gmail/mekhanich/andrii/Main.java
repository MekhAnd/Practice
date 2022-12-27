package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        String var04 = "Private var from Main";

        ScopeCheck sccheck = new ScopeCheck();
        sccheck.useInner();

        ScopeCheck.InnerClass innerClass = sccheck.new InnerClass();

//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        System.out.println("var03 is not accessible here because of private!!! " + innerClass.var03);
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//        System.out.println("Scope Instanse sccheck privateVar(var01) = " + sccheck.getPrivateVar());
//        System.out.println(var04);
//
//        sccheck.timesTwo();
//        System.out.println("*".repeat(10));
//        ScopeCheck.InnerClass innerClass = sccheck.new InnerClass();
//        System.out.println("*".repeat(10));
//        innerClass.timesTwo();
    }
}