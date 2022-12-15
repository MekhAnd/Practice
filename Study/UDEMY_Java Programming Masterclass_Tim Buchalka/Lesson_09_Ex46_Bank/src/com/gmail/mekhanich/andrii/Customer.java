package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions.add(Double.valueOf(initialTransaction));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        this.transactions.add(Double.valueOf(transaction));
    }

}
