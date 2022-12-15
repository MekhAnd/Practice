package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String nameOfTheBranch) {
        if (findBranch(nameOfTheBranch) == null) {
            branches.add(new Branch(nameOfTheBranch));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String nameOfTheBranch, String nameOfTheCustomer, double initialTransaction) {
        Branch branch = findBranch(nameOfTheBranch);
        if (branch != null) {
            return branch.newCustomer(nameOfTheCustomer, initialTransaction);
        } else return false;
    }

    public boolean addCustomerTransaction(String nameOfTheBranch, String nameOfTheCustomer, double transaction) {
        Branch branch = findBranch(nameOfTheBranch);
        if (branch != null) {
            return branch.addCustomerTransaction(nameOfTheCustomer, transaction);
        } else return false;
    }

    public boolean listCustomers(String nameOfTheBranch, boolean printTransactions) {
        Branch branch = findBranch(nameOfTheBranch);

        if (branch != null) {
            ArrayList<Customer> customers = branch.getCustomers();
            System.out.println("Customer details for branch " + branch.getName());
            for (int i = 0; i < customers.size(); i++) {
                System.out.println("****" + customers.size() + " " + i);
                System.out.println("Customer: " + customers.get(i).getName() + "[" + (i+1) + "]");
                if (printTransactions) {
                    Customer currentCustomer = customers.get(i);
                    ArrayList <Double> customerAccount = currentCustomer.getTransactions();
                    System.out.println("Transactions");
                    for (int j = 0; j < customerAccount.size(); j++) {
                        System.out.println("****" + customerAccount.size() + " " + j + " " + i);
                        System.out.println("[" + (j+1) + "]  Amount " + customerAccount.get(j));
                    }
                }
            }
            return true;
        } else return false;
    }

    private Branch findBranch(String nameOfTheBranch) {
        Branch branch = null;
        for (int i = 0; i < branches.size(); i++) {
            return (branches.get(i).getName() == nameOfTheBranch) ? branch = branches.get(i) : null;
        }
        return branch;
    }

}
