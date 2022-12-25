package com.gmail.mekhanich.andrii;


import java.util.ArrayList;
public class Items implements ISaveable{

    private String name;
    private String type;
    private int number;

    private ArrayList <Items> savedItems ;

    public Items() {
        this.savedItems = new ArrayList();
    }

    public Items(String name, String type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.savedItems = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public ArrayList getList() {
        return this.savedItems;
    }

    @Override
    public ArrayList saved( Object obj) {
        this.savedItems.add((Items) obj);
        return savedItems;
    }

    @Override
    public Object populate(ArrayList saved, String name) {
        savedItems = saved;
        Items currentItem = null;
        for(int i = 0; i < savedItems.size(); i++){
            if(savedItems.get(i).getName() == name){
                currentItem = savedItems.get(i);
            }
        }
        return currentItem;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
