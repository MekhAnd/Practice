package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> accounts;

    public Branch(String name) {
        this.name = name;
        this.accounts = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getAccounts() {
        return accounts;
    }

    public boolean addNewCustomer (String name, double initialTransaction){
        int index = -1;
        for(int i = 0; i<accounts.size(); i++){
            if(accounts.get(i).getName() == name){
                index = 1;
            }
        }
        if(index == -1) {
//            Customer newCustomer =
            accounts.add(new Customer(name, initialTransaction));
            System.out.println("Successfully added!");
            return true;
        } else {
            System.out.println("Customer with the same name already exist!");
            return false;
        }
    }

    public boolean addNewCustomer (Customer customer){
        Double transaction =  customer.getTransactions().get(0);
        double convert = transaction.doubleValue();
        return addNewCustomer(customer.getName(), convert);
    }

    public boolean transaction (String name, double transaction){
        boolean index = false;
        int accIndex = -1;
        for(int i = 0; i<accounts.size(); i++){
            System.out.println(accounts.get(i).getName());
            System.out.println(accounts.get(i).getTransactions());
            if(accounts.get(i).getName() == name){
                this.accounts.get(i).getTransactions().add(Double.valueOf(transaction));
//                accounts.get(i).listOfTransactions(new Customer(name, transaction));
                System.out.println("Successfully added!");
                index = true;
                break;
            }

        }
        System.out.println("!".repeat(20));
        System.out.println(accounts.get(0).getName());
        System.out.println(accounts.get(0).getTransactions());
        if(!index) System.out.println("Customer with the same name already exist!");
        return index;
    }

    public void listOfCustomer (){
        for(int i = 0; i < accounts.size(); i++){
            System.out.println((i+1) + ". " + accounts.get(i).getName() + " with "
                    + accounts.get(i).getTransactions().size() + " transaction");
        }
    }

    public void listOfTransaction (Customer customer){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getName() == customer.getName()){
                System.out.println(accounts.get(i));
                System.out.println(accounts.get(i).getTransactions());
            }
        }
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
