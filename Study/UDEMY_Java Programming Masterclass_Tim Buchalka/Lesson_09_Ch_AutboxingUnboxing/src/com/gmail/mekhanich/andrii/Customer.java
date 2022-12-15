package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Customer {
    private String name;    // !
    private ArrayList <Double> transactions = new ArrayList(); // !

    public Customer(String name, double transaction) { // !
        this.name = name;
        this.transactions.add(Double.valueOf(transaction));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
