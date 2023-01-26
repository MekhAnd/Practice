package com.gmail.mekhanich.andrii;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Map <String,String> chooseDirection = new HashMap<>();
        chooseDirection.put("E", "E");
        chooseDirection.put("W", "W");
        chooseDirection.put("S", "S");
        chooseDirection.put("N", "N");
        chooseDirection.put("Q", "Q");

        chooseDirection.put("EAST", "E");
        chooseDirection.put("WEST", "W");
        chooseDirection.put("SOUTH", "S");
        chooseDirection.put("NORTH", "N");

        Scanner sc = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of the hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
//        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("Q", 0);

        int loc= 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");

            for (String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = sc.nextLine().toUpperCase();

            System.out.println(direction);



            // FIRST VARIANT
            String[] directionResult = direction.split(" ");
            for(String directionWord:chooseDirection.keySet()){
                System.out.println(directionWord);
                for(String dir: directionResult){
                    if(dir.equals(directionWord)){
                        System.out.println("DIR " + dir);
                        System.out.println("directionWord " + directionWord);
                        direction = dir.substring(0,1);
                        break;
                    }
                }
            }


            // Second variant
//            if(direction.length()>1) {
//                String[] directionResult = direction.split(" ");
//                for (String words : directionResult) {
//                    if (direction.contains("EAST")) {
//                        System.out.println("Choose E");
//                        direction = "E";
//                    } else if (direction.contains("WEST")) {
//                        System.out.println("Choose W");
//                        direction = "W";
//                    } else if (direction.contains("NORTH")) {
//                        System.out.println("Choose N");
//                        direction = "N";
//                    } else if (direction.contains("SOUTH")) {
//                        System.out.println("Choose S");
//                        direction = "S";
//                    }
//                }
//            } else{
//                if (direction.contains("E")) {
//                    System.out.println("Choose E");
//                    direction = "E";
//                } else if (direction.contains("W")) {
//                    System.out.println("Choose W");
//                    direction = "W";
//                } else if (direction.contains("N")) {
//                    System.out.println("Choose N");
//                    direction = "N";
//                } else if (direction.contains("S")) {
//                    System.out.println("Choose S");
//                    direction = "S";
//                }
//            }
            System.out.println(direction + " after for loop");
            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else{
                System.out.println("You can not go in that direction!");
            }

        }


    }
}