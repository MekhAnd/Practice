package com.gmail.mekhamich.andrii;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
            String lambdaStringArra = "Hello new World!";
            StringSeparator separator =( (String str) -> {
                String[] array = str.split(" ");
                System.out.println(Arrays.toString(array));
            });

            separator.separator(lambdaStringArra);

            Consumer<String> cons = str ->{
                String[] array = str.split(" ");
                System.out.println(Arrays.toString(array));
            };

            cons.accept(lambdaStringArra);

            Function<String, String> cons01 = str->{
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<str.length(); i++){
                    if(i%2 == 0){
                        sb.append(str.charAt(i));
                    }
                }
                return sb.toString();
            };

            System.out.println(cons01.apply(lambdaStringArra));

        UnaryOperator<String> cons02 = str->{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<str.length(); i++){
                if(i%2 == 0){
                    sb.append(str.charAt(i));
                }
            }
            return sb.toString();
        };

        System.out.println(cons02.apply(lambdaStringArra));

        System.out.println(everySecondCharacter(cons01, lambdaStringArra));

        Supplier<String> supl = ()-> "I love Java";
        String iLoveJava = supl.get();
        System.out.println(iLoveJava);

    }

    public static String everySecondCharacter (Function<String, String> funct, String str){
       return funct.apply(str);
    }

}

@FunctionalInterface
 interface StringSeparator {
    void separator(String exapmle);
 }