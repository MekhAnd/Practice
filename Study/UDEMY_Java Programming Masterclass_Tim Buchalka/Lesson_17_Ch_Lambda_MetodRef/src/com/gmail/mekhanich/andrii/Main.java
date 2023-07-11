package com.gmail.mekhanich.andrii;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class ArrayHelper{
    static Character firstChar(String name){
        return name.charAt(0);
    }

    static String upper (String name){
        return name.toUpperCase();
    }

    static String reverse(String string){
        String[] newStringArray = string.split(" ");
        char[] charArray = newStringArray[0].toCharArray();

        String newString ="";
        for(int i = charArray.length-1; i>=0; i--){
            newString += (char)charArray[i];
        }
        string = string + " " +newString;
        return string;
    }

}
public class Main {
    public static void main(String[] args) {

        String[] names = new String[]{"Bob", "Anna", "Den", "Poul", "Kate"};
        Arrays.asList(names).forEach(System.out::println);

        System.out.println("***************************************");

        Function<String, Character> ahFirstChar = ArrayHelper::firstChar;
        Arrays.setAll(names, i-> names[i] + " " + addCharacter(ahFirstChar, names[i]));
        Arrays.asList(names).forEach(System.out::println);

        System.out.println("***************************************");

        Function<String, String> upper = ArrayHelper::upper;
        Arrays.setAll(names, i-> upperCase(upper, names[i]));
        Arrays.asList(names).forEach(System.out::println);

        System.out.println("***************************************");

        Function <String, String> reverse = ArrayHelper::reverse;

//        Arrays.setAll(names, i-> reverseString(reverse, names[i]));
        Arrays.setAll(names, i-> upperCase(reverse, names[i]));
        Arrays.asList(names).forEach(System.out::println);

        System.out.println("***************************************");

        Consumer<String[]> consumer = Arrays::sort;
        sort(consumer, names);
        Arrays.asList(names).forEach(System.out::println);

    }

    private static Character addCharacter (Function <String, Character> function, String string ){
        return function.apply(string);
    }

    private static String upperCase (Function <String, String> function, String string ){
        return function.apply(string);
    }

    private static String reverseString (Function <String, String> function, String string ){
        return function.apply(string);
    }

    private static String[] sort (Consumer <String[]> consumer, String[] string ){
        consumer.accept(string);
        return string;
    }
}