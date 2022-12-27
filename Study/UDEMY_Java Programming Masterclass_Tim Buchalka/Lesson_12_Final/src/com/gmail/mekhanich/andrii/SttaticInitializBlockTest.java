package com.gmail.mekhanich.andrii;

public class SttaticInitializBlockTest {
    public static final String owner;

    static {
        owner = "Me";
        System.out.println("SttaticInitializBlockTest static initialization block called");
    }

    public SttaticInitializBlockTest() {
        System.out.println("SIB constructor called");
    }
    static {
        System.out.println("2nd static initialization block called");
    }

    public void soneMethod(){
        System.out.println("soneMethod() called");
    }
}
