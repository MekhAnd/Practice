package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank() {
        this.branches = new ArrayList<Branch>();
    }

    public Bank(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public void addBrunch(String name) {
        if (findBranch(name)<0) {
            Branch branch = new Branch(name);
            branches.add(branch);
            System.out.println("New branch was successfully added!");
        } else {
            System.out.println("This branch is already exists!");
        }
    }

    public void addBrunch(Branch branch) {
        if (findBranch(branch)<0) {
            branches.add(branch);
            System.out.println("New branch was successfully added!");
        } else {
            System.out.println("This branch is already exists!");
        }
    }

    public void addCustomerToBrunch(String branchName, String customerName, double initialTransaction) {
        if(findBranch(branchName)>=0){
            branches.get(findBranch(branchName)).addNewCustomer(customerName, initialTransaction);
        } else System.out.println("This branch is not exist!");
    }


    public void addNewTransaction(String branchName, String customerName, double initialTransaction) {
        if(findBranch(branchName)>=0){
            branches.get(findBranch(branchName)).transaction(customerName, initialTransaction);
        } else System.out.println("This branch is not exist!");
    }

    public int findBranch (String name){
        int index = -100;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public int findBranch (Branch branch){
        return findBranch(branch.getName());
    }

    public void listOfBranches (){
        for(int i = 0; i < branches.size(); i++){
            System.out.println((i+1) + ". " + branches.get(i).getName() + " with " + branches.get(i).getAccounts().size() + " accounts.");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "branches=" + branches +
                '}';
    }
}
