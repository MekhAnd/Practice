package com.gmail.mekhanich.andrii;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
//        try (ObjectOutputStream localFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//                for(Location location: locations.values()){
//                    localFile.writeObject(location);
//                }
//        }




//        try (DataOutputStream localFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            for (Location location : locations.values()) {
//                localFile.writeInt(location.getLocationID());
//                localFile.writeUTF(location.getDescription());
//                System.out.println("Writing location: " + location.getLocationID() + "; " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits");
//                localFile.writeInt(location.getExits().size()-1);
//                for(String directions : location.getExits().keySet()){
//                    if(!directions.equalsIgnoreCase("Q")){
//                        System.out.println("\t\t " + directions + ", " + location.getExits().get(directions));
//                        localFile.writeUTF(directions);
//                        localFile.writeInt(location.getExits().get(directions));
//                    }
//                }
//            }
//        }

//        try (BufferedWriter localFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String directions : location.getExits().keySet()) {
//                    if(!directions.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + directions +
//                                "," + location.getExits().get(directions) + "\n");
//                    }
//                }
//            }
    }


//        FileWriter localFile = null;
//        try {
//            localFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
////                throw new IOException("Test exception thrown while writing");
//            }
//        } finally {
//            System.out.println("finally block");
//            if (localFile != null) {
//                System.out.println("location File is not null, attempting close file");
//                localFile.close();
//            }
//
//        }
//}

static {
        try(ObjectInputStream localFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            boolean endOfFile = false;
            while (!endOfFile){
                try{
                    Location location = (Location) localFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + ": " +location.getDescription());
                    System.out.println("Found " + location.getExits().size()+ "exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException eof){
                    endOfFile = true;
                }
            }
        }catch (InvalidClassException ince){
            ince.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }

//        Scanner sc = null;
//        try(BufferedReader bf=new BufferedReader(new FileReader("locations.txt"))){
//            Scanner sc = new Scanner(new FileReader("locations.txt"))) {
//            sc = new Scanner(new FileReader("locations.txt"));
//            sc.useDelimiter(",");
//        String input;
//        while((input=bf.readLine())!=null){
//        String[]readData=input.split(",");
//        int loc=Integer.parseInt(readData[0]);
//        String description=readData[1];
//        System.out.println("Imported location id "+loc+": description "+description);
//        Map<String, Integer> tempExit=new HashMap<>();
//        locations.put(loc,new Location(loc,description,tempExit));
//        }
//        }catch(IOException e){
//        e.printStackTrace();
//        }
//
//
//        try(BufferedReader bf=new BufferedReader(new FileReader("directions.txt"))){
//        String input;
//        while((input=bf.readLine())!=null){
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String directions = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt((dest));
//                System.out.println(loc + ": " + directions + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(directions, destination);

//        String[]data=input.split(",");
//        System.out.println(data[0]+": "+data[1]+": "+data[2]);
//
//        Location location=locations.get(Integer.parseInt(data[0]));
//        location.addExit(data[1],Integer.parseInt(data[2]));
//        }
//        }catch(IOException e){
//        e.printStackTrace();
//        }

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));
        }

@Override
public int size(){
        return locations.size();
        }

@Override
public boolean isEmpty(){
        return locations.isEmpty();
        }

@Override
public boolean containsKey(Object key){
        return locations.containsKey(key);
        }

@Override
public boolean containsValue(Object value){
        return locations.containsValue(value);
        }

@Override
public Location get(Object key){
        return locations.get(key);
        }

@Override
public Location put(Integer key,Location value){
        return locations.put(key,value);
        }

@Override
public Location remove(Object key){
        return locations.remove(key);
        }

@Override
public void putAll(Map<?extends Integer, ?extends Location> m){

        }

@Override
public void clear(){
        locations.clear();
        }

@Override
public Set<Integer> keySet(){
        return locations.keySet();
        }

@Override
public Collection<Location> values(){
        return locations.values();
        }

@Override
public Set<Entry<Integer, Location>>entrySet(){
        return locations.entrySet();
        }
        }
