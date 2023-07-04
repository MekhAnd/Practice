package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        menu(list);
        boolean shutdown = false;

        while (!shutdown){
            int chooser = Integer.parseInt(scanner());
            switch (chooser){
                case 0:
                    shutdown = true;
                    break;
                case 1:
                    System.out.println("Enter list of products");
                    String items = scanner();
                    addNewItem(items, list);
                    break;
                case 2:
                    System.out.println("Enter item which you want to delete!");
                    String item = scanner();
                    removeItem(item, list);
                    break;
                default:
                    System.out.println("Error!");
            }
        }
    }
    public static void menu (ArrayList<String>list){
        System.out.println("Avaliable actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add new item(s) (comma delimited list)");
        System.out.println("2 - to remove any item(s) (comma delimited list)");
        System.out.println("Enter a number for which actions what you do:");
        System.out.println("******Your list******");
        if (list.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(list);
        }
        System.out.println("**********************");
    }
    public static String scanner(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static ArrayList<String> addNewItem(String items, ArrayList <String> list){
        if(list.size() == 0){
            ArrayList<String> itemsArray = new ArrayList<String>(Arrays.asList(items));
            list.addAll(Arrays.asList(items.split(",")));
        } else {
            String[] itemsArray = items.split(",");
            for (int i = 0; i < itemsArray.length; i++) {
                if(list.indexOf(itemsArray[i])>=0){
                    System.out.println(itemsArray[i] + " Already Exist!");
                } else {
                    list.add(itemsArray[i]);
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        menu(list);
        return list;
    }

    public static ArrayList<String> removeItem (String item, ArrayList <String> list){
            if(list.size() == 0) {
                System.out.println("List is empty!");
            } else {
                list.remove(item);
            }
        list.sort(Comparator.naturalOrder());
            menu(list);
            return list;
    }

}
