package com.gmail.mekhanich.andrii;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Buchalka");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.toUpperCase())
                .andThen(s -> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.toUpperCase())
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toLowerCase() + ", " + s[0].toLowerCase())
                .andThen(s -> s.toUpperCase());
        System.out.println(f1.apply(name));

        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);

        System.out.println(f2.apply(name));

        String[] names = {"Anna", "Bob", "Tim"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;

        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1)
        );

        Predicate<String> p0 = s -> s.equals("TOM");
        Predicate<String> p1 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p2 = s -> s.startsWith("T");
        Predicate<String> p3 = s -> s.endsWith("e");

        Predicate<String> comdine1 = p0.or(p1);
        System.out.println("comdine1 = " + comdine1.test(name));

        Predicate<String> comdine2 = p2.and(p3);
        System.out.println("comdine2 = " + comdine2.test(name));

        Predicate<String> comdine3 = p2.and(p3).negate();
        System.out.println("comdine3 = " + comdine3.test(name));

        record Person(String firstName, String lastName) {}

        List<Person> list = new ArrayList<>(List.of(
                new Person("Peter", "Pen"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort((o1,o2)->o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("------------------------------------------");

        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("------------------------------------------");

        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("------------------------------------------");

        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .reversed()

        );
        list.forEach(System.out::println);

    }

}