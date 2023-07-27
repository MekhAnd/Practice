package com.gmail.mekhanich.andrii;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>(); will work like Collection and like List
//        Collection<String> list = new ArrayList<>();will work like ArrayList and like TreeSet, HashSet
        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Frank");
        list.addAll(List.of("Zack", "Peter", "Igor"));
        System.out.println(list);
        System.out.println("Is Gray in the list? ->" + list.contains("Gray"));
        System.out.println("Is Zack in the list? ->" + list.contains("Zack"));

        list.removeIf(s-> s.charAt(0) == 'Z');
        System.out.println(list);
        System.out.println("Is Gray in the list? ->" + list.contains("Gray"));
        System.out.println("Is Zack in the list? ->" + list.contains("Zack"));

//        list.sort(); Collections does not have method sort...

    }
}