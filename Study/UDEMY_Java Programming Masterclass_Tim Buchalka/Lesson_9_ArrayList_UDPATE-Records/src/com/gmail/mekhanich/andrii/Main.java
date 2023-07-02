package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem (String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString (){
        String format = String.format("%d,%s in %s", count, name.toUpperCase(), type);
        return format;
    }
}

public class Main {
    public static void main(String[] args) {
        GroceryItem [] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "fruits", 16);
        groceryArray[2] =  new GroceryItem("oranges", "fruits", 5);

        System.out.println(Arrays.toString(groceryArray));

        ArrayList  objecList = new ArrayList ();
        objecList.add(new GroceryItem("Butter"));
        objecList.add("Yourt");


        ArrayList <GroceryItem> groceryItemsList = new ArrayList <GroceryItem>();
        groceryItemsList.add(new GroceryItem("Butter"));
        groceryItemsList.add(new GroceryItem("milk"));
        groceryItemsList.add(new GroceryItem("apples", "fruits", 16));
        groceryItemsList.add(0, new GroceryItem("vine", "beverages", 1));
        groceryItemsList.remove(1);

        System.out.println(groceryItemsList);


    }
}