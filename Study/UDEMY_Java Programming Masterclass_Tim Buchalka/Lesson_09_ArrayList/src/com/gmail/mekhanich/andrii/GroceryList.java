package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList();


    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printList() {
        System.out.println("Size " + groceryList.size());
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println(i + 1 + " - " + groceryList.get(i));
        }
    }

    private void modifyList(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyList(position, newItem);
        }
    }

    public void modifyList(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println(groceryList);
    }

    private void deleteItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            deleteItem(position);
        }
    }

     public void deleteItem(int position) {
        groceryList.remove(position);
    }

    public int findItem(String serchString) {
        return groceryList.indexOf(serchString);
    }
}
