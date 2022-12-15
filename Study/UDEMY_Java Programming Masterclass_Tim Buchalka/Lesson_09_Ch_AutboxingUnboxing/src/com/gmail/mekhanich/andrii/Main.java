package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        Customer customer00 = new Customer("Andrii Man", 10000.00);
        Customer customer01 = new Customer("Liudmila Man", 10000.00);
        Customer customer02 = new Customer("Kate Man", 10000.00);

        System.out.println("*".repeat(10) + "FALSE" + "*".repeat(10));
        Customer customer03 = new Customer("Kate Man", 10000.00);
        System.out.println("*".repeat(10) + "FALSE" + "*".repeat(10));
        System.out.println();

        Branch leftBranch = new Branch("Left bank");
        Branch rightBranch = new Branch("Right bank");

        System.out.println("*".repeat(10) + "FALSE" + "*".repeat(10));
        Branch middleBranch = new Branch("Right bank");
        System.out.println("*".repeat(10) + "FALSE" + "*".repeat(10));
        System.out.println();

        Bank bank = new Bank();

        System.out.println(customer00 + "\n" + customer01 + "\n" + customer02 + "\n" + customer03);
        System.out.println(leftBranch + "\n" + rightBranch + "\n" + middleBranch);
        System.out.println(bank);
        System.out.println();
        System.out.println("*".repeat(10) + "*".repeat(10));
        System.out.println("*".repeat(10) + "*".repeat(10));
        System.out.println();

        leftBranch.addNewCustomer(customer00);
        leftBranch.addNewCustomer(customer01);
        leftBranch.addNewCustomer(customer02);
        leftBranch.addNewCustomer(customer03);
        leftBranch.addNewCustomer("Kate Man", 10000.00);

        leftBranch.listOfCustomer();

        bank.addBrunch(leftBranch);
        bank.listOfBranches();

        bank.addCustomerToBrunch("Left bank","Andrii Man", 10000.00);
        bank.addCustomerToBrunch("Left bank","Mykola Man", 10000.00);

        bank.listOfBranches();
        System.out.println("*".repeat(10) + "*".repeat(10));
        bank.addNewTransaction("Left bank", "Andrii Man", -100.00);
        System.out.println("*".repeat(10) + "*".repeat(10));

        leftBranch.listOfCustomer();

        leftBranch.listOfTransaction(customer00);

    }
}