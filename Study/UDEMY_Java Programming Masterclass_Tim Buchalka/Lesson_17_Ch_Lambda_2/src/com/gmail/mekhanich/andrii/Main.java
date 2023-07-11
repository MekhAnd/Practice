package com.gmail.mekhanich.andrii;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Bob", "Anna", "Den", "Poul", "Kate"};
        Arrays.asList(names).forEach(i-> System.out.println(i));
        System.out.println("********************************");

        Arrays.setAll(names, (i) -> names[i]+names[i].toLowerCase().charAt(0) + names[i].charAt(names[i].length()-2));
        Arrays.asList(names).forEach(i-> System.out.println(i));
        System.out.println("********************************");

        Arrays.setAll(names, (i) -> names[i].toUpperCase());
        Arrays.asList(names).forEach(i-> System.out.println(i));
        System.out.println("********************************");

        Random rand =  new Random();
        Supplier <Character> suplIn = (()-> {
            int character = rand.nextInt((25))+65;
            char symbol = (char) character;
            return symbol;
        });

        Function<String, String> reverse = str ->{
            StringBuilder lastName = new StringBuilder();
            String []firstName = str.split( " ");
            for (int i = firstName[0].length()-1; i>=0; i--){
                lastName.append(firstName[0].charAt(i));
            }
            return lastName.toString();
        };

        Arrays.setAll(names, i-> names[i] + " " + suplIn.get());
        Arrays.asList(names).forEach(i-> System.out.println(i));
        System.out.println("********************************");

        Arrays.setAll(names, i-> names[i] + " " + reverse.apply(names[i]));
        Arrays.asList(names).forEach(i-> System.out.println(i));

//        variant 1
        System.out.println("**************VAR1******************");
        ArrayList<String> namesArrayList = new ArrayList<>(Arrays.asList(names));
        namesArrayList.add("John A John");
        (namesArrayList).forEach(i-> System.out.println(i));
        System.out.println("---------------------------------");

        namesArrayList.removeIf(name ->{
            String [] fullName = name.split(" ");
            return fullName[0].equalsIgnoreCase(fullName[2]);
        });
        (namesArrayList).forEach(i-> System.out.println(i));
        System.out.println("---------------------------------");

//        variant 2

        System.out.println("***************VAR2*****************");
        Function <String[], ArrayList<String>> convert = strings -> {
            ArrayList<String> namesList = new ArrayList<>(Arrays.asList(strings));
            namesList.removeIf(name ->{
                String [] fullName = name.split(" ");
                return fullName[0].equalsIgnoreCase(fullName[2]);
            });
            return namesList;
        };
        ArrayList<String> namesArray = convert.apply(names);
        namesArray.forEach(s-> System.out.println(s));
    }


}