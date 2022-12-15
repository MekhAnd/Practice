package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        if (findCustomer(name) == null) {
            customers.add(new Customer(name, initialTransaction));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String name, double initialTransaction){
        if (findCustomer(name) != null) {
            Customer customer = findCustomer(name);
            customer.addTransaction(initialTransaction);
            return true;
        } else {
            System.out.println("I am here!");
            return false;
        }
    }

    private Customer findCustomer(String name) {
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName() == name) {
                customer = customers.get(i);
            }
        }
        return customer;
    }
}
