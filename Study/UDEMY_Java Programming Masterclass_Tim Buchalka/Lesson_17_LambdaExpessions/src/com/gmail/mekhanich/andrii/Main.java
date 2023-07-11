package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

//        accept
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        for(String s:list){
            System.out.println(s);
        }

        System.out.println("_____________________");
        list.forEach((s)-> System.out.println(s));
        System.out.println("_____________________");
        list.forEach((str)-> System.out.println(str));

        System.out.println("_____________________");
        list.forEach(str-> System.out.println(str));

        System.out.println("_____________________");
        String prefix = "nato";
//        String str = "My String"; ERROR IN LAMBDA prefix
        list.forEach((var str)-> {
            char first = str.charAt(0);
            System.out.println(prefix + " " +str + " means " + first);
        });
//        prefix= "NATO"; ERROR IN LAMBDA prefix


//        operate
        int result = calulator((a,b) -> a+b, 5, 2);
        int result0 = calulator((a,b) -> {
            int c = a+b;
            return c;
        }, 5, 2);


        int result00 = calulator((Integer a, Integer b) -> a+b, 5, 2);
        int result01 = calulator((var a, var b) -> a+b, 5, 2);

        var result02 = calulator((var a, var b) -> a/b, 10.0, 2.5);
        String result03 = calulator((a,b) -> a+b, "Hello ", "world!");
        String result03A1 = calulator01((a,b) -> a+b, "Hello ", "world!");

        var coords = Arrays.asList(
                new double[]{47.2160,-95.2346},
                new double[]{29.1566,-89.2495},
                new double[]{34.1556,-90.0659});

        coords.forEach(s-> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double>  bic1 = (lat, lng)->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], bic1);

        System.out.println("______________________");
        coords.forEach(s->processPoint(s[0], s[1], bic1));
        System.out.println("______________________");
        coords.forEach(s->processPoint(s[0], s[1],
                (lat, lng)->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        System.out.println("______________________");
        list.removeIf(s ->s.equalsIgnoreCase("bravo"));
        list.forEach(s-> System.out.println(s));
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s-> System.out.println(s));
        System.out.println("______________________");
        list.removeIf(s ->s.startsWith("e"));
        list.forEach(s-> System.out.println(s));
        System.out.println("______________________");

        list.replaceAll(s->s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s-> System.out.println(s));

        System.out.println("______________________");
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.fill(emptyStrings,"1");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i)-> "" +(i+1) + ".");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("______________________");
        Arrays.setAll(emptyStrings, (i)-> "" +(i+1) + "."
            + switch (i){
                case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "10";
                }
        );

        System.out.println(Arrays.toString(emptyStrings));

        String [] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String [] randomLIst = randomlySelectedValues(15, names,
                () -> new Random().nextInt(names.length));
        System.out.println(Arrays.toString(randomLIst));


    }

    public static <T> T calulator (Operations<T> function, T value1, T value2){
        T result =  function.operate(value1, value2);
        System.out.println(result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
         consumer.accept(t1, t2);
    }

    public static <T> T calulator01 (BinaryOperator<T> function, T value1, T value2){
        T result =  function.apply(value1, value2);
        System.out.println(result);
        return result;
    }

    public static String[] randomlySelectedValues (int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for(int i = 0; i<count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}