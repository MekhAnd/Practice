package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {

        byte a = 10;
        short b = 20;
        int c = 30;
        long d = 50000L;

        long d1, d2, d3, d4;


        d = d + 10L*((long)a + (long)b + (long)c);
        d1 = 50000L + 10L*(a + (long)b + (long)c);
        d2 = 50000L + 10*((long)a + b + (long)c);
        d3 = 50000L + 10*((a + b + c));


        System.out.println("long d = " + d);
        System.out.println("long d1 = " + d1);
        System.out.println("long d2 = " + d2);
        System.out.println("long d3 = " + d3);
    }
}