package com.gmail.mekhanich.andrii;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File vc = new File("G:\\Java_Enterprise_WorkSpace\\JavaProAll1\\JavaProAll\\JSON1\\json.txt");
        StringBuffer sb = new StringBuffer();
        String result ="";
        try (BufferedReader bfr = new BufferedReader(new FileReader(vc))){
            String line = "";
            for(;(line = bfr.readLine())!=null;){
                sb.append(line);
            }
            result = sb.toString();
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }

        Gson parser =new GsonBuilder().create();
        Person readParse = (Person) parser.fromJson(result, Person.class);

        
        System.out.println(readParse.toString());

    }
}
