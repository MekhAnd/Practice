package com.gmail.mekhanich.andrii;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
//        sorted.forEach(System.out::println); //error Comparator

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justName = new TreeSet<>();
        phones.forEach(c->justName.add(c.getName()));
        System.out.println(justName);
        System.out.println("****FULLSET*HERE****");
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("*****************************************");
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println("*****************************************");
        System.out.printf("min = %s, first = %s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last = %s %n", max.getName(), last.getName());
        System.out.println("*****************************************");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Lfst element = " + copiedSet.pollLast());
        System.out.println("*****************************************");
        copiedSet.forEach(System.out::println);
        System.out.println("*****************************************");

        Contact daffy = new Contact ("Daffy Duck");
        Contact daisy = new Contact ("Daisy Duck");
        Contact snoopy = new Contact ("Snoopy");
        Contact archie = new Contact ("Archie");

        System.out.println("*****************************************");
        for(Contact c:List.of(daffy, daisy, last, snoopy)){
            System.out.printf("ceiling(%s)=%s%n", c.getName(),fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(),fullSet.higher(c));
        }
        System.out.println("*****************************************");

        System.out.println("*****************************************");
        for(Contact c:List.of(daffy, daisy, first, archie)){
            System.out.printf("floor(%s)=%s%n", c.getName(),fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(),fullSet.lower(c));
        }
        System.out.println("*****************************************");

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("*****************************************");

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("*****************************************");
        fullSet.forEach(System.out::println);
        descendingSet.forEach(System.out::println);
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        Contact marion = new Contact("Maid MArion");
//        var headSet = fullSet.headSet(marion);
//        headSet.forEach(System.out::println);
//        System.out.println("*****************************************");
//        System.out.println("*****************************************");
//        System.out.println();
//        var tailSet = fullSet.tailSet(marion);
//        tailSet.forEach(System.out::println);
//        System.out.println("*****************************************");
//        System.out.println("*****************************************");
//        System.out.println();
        System.out.println("OVERLOADED METHOD");
        System.out.println();
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        var headSetOV = fullSet.headSet(marion, true);
        headSetOV.forEach(System.out::println);
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println();
        var tailSetOV = fullSet.tailSet(marion, false);
        tailSetOV.forEach(System.out::println);
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println();

        Contact linus = new Contact("Linus Van Pelt");
        var subSet = fullSet.subSet(linus, marion);
        subSet.forEach(System.out::println);
        System.out.println("OVERLOADED METHOD");


        var subSetOV = fullSet.subSet(
                linus, false, marion, true);
        subSetOV.forEach(System.out::println);


    }
}
