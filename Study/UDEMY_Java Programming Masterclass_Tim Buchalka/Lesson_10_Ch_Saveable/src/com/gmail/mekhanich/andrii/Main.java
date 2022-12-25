package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contacts contact01 = new Contacts("001", "000-000-001");
        Contacts contact02 = new Contacts("002", "000-000-002");


        ISaveable entity;
        entity = new Contacts();
        entity.saved(contact01);
        entity.saved(contact02);

        System.out.println(entity.getList());
        System.out.println();
        Contacts searchResult = (Contacts) entity.populate(entity.getList(),"001");
        System.out.println(searchResult);
        System.out.println("*".repeat(10));

        Items item01 = new Items("First", "Tablet", 001);
        Items item02 = new Items("Second", "Tablet", 002);

        ISaveable entity01;
        entity01 = new Items();
        entity01.saved(item01);
        entity01.saved(item02);

        System.out.println(entity01.getList());
        System.out.println();
        Items searchItem = (Items) entity01.populate(entity01.getList(),"First");
        System.out.println(searchItem);
        System.out.println("*".repeat(10));

        System.out.println();
    }
}