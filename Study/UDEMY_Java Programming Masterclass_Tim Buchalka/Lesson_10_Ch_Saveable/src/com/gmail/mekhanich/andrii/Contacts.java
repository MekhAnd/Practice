package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Contacts implements ISaveable{
    private String name;
    private String number;
    ArrayList <Contacts> contactList;

    public Contacts() {
        this.contactList = new ArrayList<>();
    }

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
        this.contactList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<Contacts> getContactList() {
        return contactList;
    }

    @Override
    public ArrayList getList() {
        return this.contactList;
    }

    @Override
    public ArrayList saved(Object contact) {
        this.contactList.add((Contacts) contact);
        return contactList;
    }

    @Override
    public Object populate(ArrayList saved, String name) {
        contactList = saved;
        Contacts currentContact = null;
        for(int i = 0; i < contactList.size(); i++){
            if(contactList.get(i).getName() == name){
                currentContact = contactList.get(i);
            }
        }
        return currentContact;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
