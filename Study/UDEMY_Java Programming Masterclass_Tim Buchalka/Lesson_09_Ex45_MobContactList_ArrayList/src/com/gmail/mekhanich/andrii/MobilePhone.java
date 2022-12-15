package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            myContacts.add(contact);
            return true;
        } else return false;
    }

    public boolean updateContact(Contact old, Contact updated) {
        int indexOld = findContact(old.getName());
        if(indexOld < 0){
            return false;
        } else {
            int indexUpdated = findContact(updated.getName());
            System.out.println(indexOld + " upd " + indexUpdated);
            if(indexOld == indexUpdated){
                myContacts.set(indexOld, updated);
                return true;
            } else {
                System.out.println("The contact with the same name already exist!");
                return false;
            }
        }
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.indexOf(contact) >= 0) {
            myContacts.remove(contact);
            return true;
        } else return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        int index = -1;
        for (int i = 0; i < myContacts.size(); i++) {
            String contactName = myContacts.get(i).getName();
            if (contactName.equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public Contact queryContact(String name) {
        Contact contact = null;
        System.out.println(myContacts.size());
        for (int i = 0; i < myContacts.size(); i++) {
            String contactName = myContacts.get(i).getName();
            if (contactName.equals(name)) {
                contact = myContacts.get(i);
            }
        }
        return contact;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}
