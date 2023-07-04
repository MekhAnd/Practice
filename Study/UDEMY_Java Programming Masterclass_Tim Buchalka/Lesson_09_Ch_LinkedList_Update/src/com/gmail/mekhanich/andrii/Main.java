package com.gmail.mekhanich.andrii;

import java.util.*;

record Place(String place, int dist) {

}

public class Main {
    public static LinkedList<Place> placesToVisit = new LinkedList<>();
    public static Place currentPlace;

    public static void main(String[] args) {
        boolean shutdown = false;

        Place Sydney = new Place("Sydney", 0);
        Place Melbourne = new Place("Melbourne", 877);
        Place Brisbane = new Place("Brisbane", 917);
        Place Adelaide = new Place("Adelaide", 1374);
        Place AliseSprings = new Place("Alise Springs", 2771);
        Place Perth = new Place("Perth", 3923);
        Place Darwin = new Place("Darwin", 3972);

        placesToVisit.add(Sydney);
        placesToVisit.add(Melbourne);
        placesToVisit.add(Brisbane);
        placesToVisit.add(Adelaide);
        placesToVisit.add(AliseSprings);
        placesToVisit.add(Perth);
        placesToVisit.add(Darwin);

        ListIterator<Place> route = placesToVisit.listIterator();
        menu();

        while (!shutdown) {
            switch (scanner().toLowerCase()) {
                case "a":
                    addNewPlace();
                    break;
                case "q":
                    shutdown = true;
                    break;
                case "f":
                    moveForward();
                    break;
                case "b":
                    moveBackward();
                    break;
                case "l":
                    listOfPoints();
                    break;
                case "m":
                    menu();
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu() {
        String menu = """
                    Available actions (select word or letter):
                    (A)dd new place
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit
                    
                """ + " ";
        System.out.println(menu);
    }

    public static String scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void addNewPlace() {
        System.out.println("PLease add city name and after coma add distance to this place:");
        String[] data = scanner().split(",");
        Place newPlace = new Place(data[0].trim(), Integer.parseInt(data[1].trim()));

        ListIterator<Place> route = placesToVisit.listIterator();

        while (route.hasNext()) {
            String city = route.next().place();
            String currentUserCity = newPlace.place();

            if (city.equals(currentUserCity)) {
                System.out.println("This place is already exists!");
            } else {
                placesToVisit.add(newPlace);
                placesToVisit.sort(new Comparator<Place>() {
                    @Override
                    public int compare(Place o1, Place o2) {
                        if (o1.dist() > o2.dist()) {
                            return 1;
                        } else if (o1.dist() < o2.dist()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                route = placesToVisit.listIterator();
                while (route.hasNext()) {
                    System.out.println(route.next());
                }
            }
        }
    }

    public static Place moveForward() {
        ListIterator<Place> route = placesToVisit.listIterator();
        if (currentPlace == null) {
            if (route.hasNext()) {
                System.out.println("Current point is " + route.next());
                if (route.hasNext()) {
                    System.out.println("Move to the next point");
                    currentPlace = route.next();
                    System.out.println("Next point is " + currentPlace.place() + ". The distance is " + currentPlace.dist());
                }
            } else {
                System.out.println("Rich the end of the route");
            }
        } else {
            boolean place = true;
            while (place) {
                if (route.hasNext()) {
                    if (route.next().equals(currentPlace)) {
                        System.out.println("Current point is " + currentPlace.place());
                        if (route.hasNext()) {
                            System.out.println("Move to the next point");
                            currentPlace = route.next();
                            System.out.println("Next point is " + currentPlace.place() + ". The distance is " + currentPlace.dist());
                            place = false;
                        }
                    }
                } else {
                    System.out.println("Rich the end of the route");
                    place = false;
                }
            }
        }

        return currentPlace;
    }

    public static Place moveBackward() {
        ListIterator<Place> route = placesToVisit.listIterator();
        if (currentPlace == null) {
            System.out.println("Rich the end of the route");
        } else {
            boolean place = true;
            while (place) {
                if (route.hasNext()) {
                    if (route.next().equals(currentPlace)) {
                        System.out.println("Current point is " + currentPlace.place());
                        route.previous();
                        if (route.hasPrevious()) {
                            System.out.println("Move to the next point");
                            currentPlace = route.previous();
                            System.out.println("Next point is " + currentPlace.place() + ". The distance is " + currentPlace.dist());
                            place = false;
                        } else {
                            System.out.println("This is first point of your route");
                            place = false;
                        }
                    }
                } else {
                    System.out.println("Rich the end of the route");
                    place = false;
                }
            }
        }
        return currentPlace;
    }

    public static void listOfPoints() {
        ListIterator<Place> route = placesToVisit.listIterator();
        boolean marker = true;
        System.out.println("You set of places is:");
        System.out.println("*************************");
        while (marker) {
            if (route.hasNext()) {
                System.out.println(route.next().place());
            } else {
                System.out.println("*************************");
                marker = false;
            }
        }
    }
}


