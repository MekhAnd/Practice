package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number pls ");
        int x = sc.nextInt();
        x(x);
    }

    public static void x(int x){
        new X(x).times();
    }
}