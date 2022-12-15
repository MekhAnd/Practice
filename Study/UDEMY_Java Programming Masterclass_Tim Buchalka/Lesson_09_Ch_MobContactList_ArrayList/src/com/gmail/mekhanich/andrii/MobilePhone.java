package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<String> list = new ArrayList();

    private ArrayList<String> getList() {
        return list;
    }

    public MobilePhone() {
    }

    public void addContact(String newName) {
        if(find (newName)<0) {
            list.add(newName);
            System.out.println("Successfully!");
        } else {
            System.out.println("The same contact was found");
        }
    }

    public int find(String name) {
        return list.indexOf(name);
    }

    public void removeContact(int index) {
        list.remove(index);
    }

    public void editContact(int index, String newName) {
        list.set(index, newName);
        System.out.println("This contact " + " was successfully updated\n" + find(newName) + ". " + list.get(find(newName)));
    }

    public String returnString(int index){
        return this.getList().get(index);
    }

    public int getSize (){
        return this.getList().size();
    }
}
