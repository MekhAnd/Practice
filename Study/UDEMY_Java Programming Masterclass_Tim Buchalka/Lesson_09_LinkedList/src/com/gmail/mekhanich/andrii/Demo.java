package com.gmail.mekhanich.andrii;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<String>();

        addInOrder(places, "Chernivtsi");
        addInOrder(places, "Ivano-Frankivsk");
        addInOrder(places, "Uzhgorod");
        addInOrder(places, "Kyiv");
        addInOrder(places, "Zhitomir");
        addInOrder(places, "Rivne");
        addInOrder(places, "Lutsk");
        addInOrder(places, "Khmelnitskiy");
        addInOrder(places, "Ternopil");
        addInOrder(places, "Lviv");
        addInOrder(places, "Vinnitsa");
        addInOrder(places, "Vinnitsa");
        visits(places);

//        places.add("");
//        places.add("");
//        places.add("");
//        places.add("");
//        places.add("");
//        places.add("Ternopil");
//        places.add("Khmelnitskiy");

        printList(places);
//        System.out.println(places);

//        places.add(2, "Vinnitsa");

//        printList(places);

//        places.remove(4);

//        printList(places);


    }

    public static void printList(LinkedList<String> places){
        Iterator<String> iterator = places.iterator();
        while (iterator.hasNext()){
            System.out.println("Now visiting " + iterator.next());
        }
        System.out.println("======");
    }

    private static boolean addInOrder (LinkedList<String> places, String newCity){
        ListIterator<String> stringListIterator = places.listIterator();
        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                // newCity in already exists in list
                System.out.println(newCity + "is already exists in list of destinations");
                return false;
            } else if(comparison > 0){
                // newCity should appear before
                // Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0){
                //move to the next position
//                stringListIterator.next();
//                stringListIterator.add(newCity);
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visits (LinkedList<String> places){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean goingForvard = true;
        ListIterator<String> listIterator = places.listIterator();

        if(places.isEmpty()){
            System.out.println("No cities in itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForvard){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForvard = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());

                    } else {
                        System.out.println("Rich the end of the list");
                        goingForvard = false;
                    }
                    break;
                case 2:
                    if(goingForvard){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForvard = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());

                    } else {
                        System.out.println("We are at the start of the list");
                        goingForvard = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    quit = true;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\n press ");
        System.out.println("0 - quit\n" + "1 - go to next point\n" + "2 - go to previous point\n"
                + "3 - read menu\n");
    }

}
