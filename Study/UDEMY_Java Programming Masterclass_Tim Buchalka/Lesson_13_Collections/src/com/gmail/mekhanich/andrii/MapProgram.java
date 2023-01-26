package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<String,String>();
        languages.put("Java", "Compile OOP languge");
        languages.put("Python", "Interpreted OOP languge");
        languages.put("Algol", "Algorythmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code")); //return null
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));

        if(languages.containsKey("Java")){
            System.out.println("Already in the MAP");
        } else {
            System.out.println(languages.put("Java", "This course aboute JAVA"));// return old pare KEY VALUE (if it exists)
            System.out.println(languages.get("Java"));
        }
        System.out.println("+".repeat(20));

//        System.out.println(languages.remove("Lisp"));
        if(languages.remove("Algol", "Algorythmic language")){
            System.out.println("Removed");
        } else {
            System.out.println("This pair was not found");
        }

        if(languages.replace("Lisp" , "This is smthng...", "a functional programming language...")) {
            System.out.println("Lisp replace");
        } else{
            System.out.println("Not replace");
        }

        System.out.println(languages.replace("Scala" , "this will not be added..."));

        for (String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }



    }
}
