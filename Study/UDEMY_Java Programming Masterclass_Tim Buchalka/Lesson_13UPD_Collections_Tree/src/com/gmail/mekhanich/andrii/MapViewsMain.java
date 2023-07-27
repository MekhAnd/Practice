package com.gmail.mekhanich.andrii;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c->contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c->contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus and I go way back, so of course I have info");
        }

        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v) -> System.out.println(v));

        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown",
                        "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

        // Error contacts need key value pare
//        keysView.add("Daffy Duck");
//        System.out.println(contacts);

        ContactData.getData("email").forEach(c->contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c->contacts.put(c.getName(), c));

        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("----------------------------------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getLastNameFirst));
        list.forEach(c-> System.out.println(c.getLastNameFirst() + ": " + c));

        System.out.println("----------------------------------------");

        Contact first = list.get(0);
        contacts.put(first.getLastNameFirst(), first);
        System.out.println("VALUES");
        values.forEach(System.out::println);
        System.out.println("KEYS");
        keysView.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);

        if(set.size()<contacts.keySet().size()){
            System.out.println("Duplicate Values are in Map");
        }

        var nodeSet = contacts.entrySet();
        for(var node: nodeSet){
            System.out.println(node.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn`t match the name: " + node.getKey()
                        + node.getValue());
            }
        }
    }
}
