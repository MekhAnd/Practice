package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class MobileList extends MobilePhone{
    public MobileList() {
    }

    @Override
    public String returnString(int index) {
        return super.returnString(index);
    }

    @Override
    public void addContact(String newName) {
        super.addContact(newName);
    }

    @Override
    public int find(String name) {
        return super.find(name);
    }

    @Override
    public void removeContact(int index) {
        super.removeContact(index);
    }

    @Override
    public void editContact(int index, String newName) {
        super.editContact(index, newName);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }
}
