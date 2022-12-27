package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Account myAccont = new Account("Andrii");
        myAccont.deposit(10000);
        myAccont.withdraw(500);
        myAccont.withdraw(-200);
        myAccont.deposit(-200);
        myAccont.calculateBalance();

        System.out.println("Balance on account is " + myAccont.getBalance());

//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
////      without private modif. possible:
//        myAccont.balance = 1_000_000;
//        myAccont.transactions.add(1_000_000);
    }
}