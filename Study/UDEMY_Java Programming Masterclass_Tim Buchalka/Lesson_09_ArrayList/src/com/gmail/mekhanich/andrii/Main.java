package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GroceryList gl = new GroceryList();

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
                    gl.printList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choise option ");
        System.out.println("\t 1 - To print grocery list ");
        System.out.println("\t 2 - To add item ");
        System.out.println("\t 3 - To modify item ");
        System.out.println("\t 4 - To remove item ");
        System.out.println("\t 5 - To search item ");
        System.out.println("\t 6 - To quit! ");
    }

    public static void addItem(){
        System.out.println("\n Pls enter the grocery item");
        gl.addGroceryItem(sc.nextLine());
    }

    public static void modifyItem(){
        System.out.println("\n Pls enter the item number");
        String itemNum = sc.nextLine();
        sc.nextLine();
        System.out.println("Enterthe placement item: ");
        String newItem = sc.nextLine();
        gl.modifyList(itemNum, newItem);
    }

    public static void removeItem(){
        System.out.println("\n Pls enter the item number");
        int itemNum = sc.nextInt();
        sc.nextLine();
        gl.deleteItem(itemNum-1);
    }

    public static void searchItem(){
        System.out.println("\n Pls enter item to search");
        String newItem = sc.nextLine();
        if(gl.findItem(newItem) != null){
            System.out.println("Found " + newItem + " in your grocery list");
        } else {
            System.out.println("Item " + newItem + " is not in your grocery list");
        }

    }

}