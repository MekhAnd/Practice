package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ContactList cl = new ContactList();
    private static MobileList ml = new MobileList();


    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printAllContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choise option ");
        System.out.println("\t 1 - To print contact list ");
        System.out.println("\t 2 - To add contact ");
        System.out.println("\t 3 - To modify contact ");
        System.out.println("\t 4 - To remove contact ");
        System.out.println("\t 5 - To search contact ");
        System.out.println("\t 6 - To quit! ");
    }

    public static void printAllContacts() {
        for (int i = 0; i < cl.getSize(); i++) {
            System.out.println((i + 1) + "\t Contact name: " + cl.returnString(i) + " phone #: " + ml.returnString(i));
        }
    }

    public static void addContact() {
        System.out.println("\n Pls enter the name of your new contact:");
        String name = sc.nextLine();
        if (cl.find(name) < 0) {
            cl.addContact(name);
            System.out.println("\n Pls enter the number of your new contact:");
            String number = sc.nextLine();
            ml.addContact(number);
        } else {
            System.out.println("This contact name is exist!");
        }

    }

    public static void modifyContact() {
        System.out.println("\n Pls enter the name of contact which you want to edit or Q for break: ");
        String name = sc.nextLine();
        int index = cl.find(name);
        switch (index) {
            case -1:
                break;
            default:
                System.out.println("Pls enter new name for contact");
                String newName = sc.nextLine();
                cl.editContact(index, newName);
                System.out.println("Pls enter new mobile number for this name");
                String newNumber = sc.nextLine();
                ml.editContact(index, newNumber);
        }

    }

    public static void removeContact() {
        System.out.println("\n Pls enter the name of contact which you want to delete: ");
        String name = sc.nextLine();
        int index = cl.find(name);
        cl.removeContact(index);
        ml.removeContact(index);
        System.out.println("\n Successfully!");
    }

    public static void searchContact() {
        System.out.println("\n Pls enter the name of contact which you want to search: ");
        String name = sc.nextLine();
        int index = cl.find(name);
        System.out.println("\n Name" + cl.returnString(index) + "\t phone# " + ml.returnString(index));
    }


}