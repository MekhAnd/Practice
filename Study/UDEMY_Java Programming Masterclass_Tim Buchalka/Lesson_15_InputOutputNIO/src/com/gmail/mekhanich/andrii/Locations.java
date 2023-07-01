package com.gmail.mekhanich.andrii;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        Path locationPath = FileSystems.getDefault().getPath("locations.dat");

        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locationPath)))){
            for (Location location: locations.values()){
                locFile.writeObject(location);
            }
        }

//        Path locationPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path directionPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (BufferedWriter localFile = Files.newBufferedWriter(locationPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(directionPath)) {
//            for (Location location : locations.values()) {
//                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String directions : location.getExits().keySet()) {
//                    if (!directions.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + directions + "," +
//                                location.getExits().get(directions) + "\n");
//                    }
//                }
//            }
//        } catch (IOException ioe) {
//            System.out.println("IOEXception: " + ioe.getMessage());
//        }
 }

    static {
        Path locationPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectInputStream locFile =new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locationPath)))){
            boolean endOfFile = false;
            while(!endOfFile){
                try{
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                }catch (EOFException e){
                    endOfFile = true;
                }
            }
        }  catch(InvalidClassException e){
            System.out.println("Class exception " + e.getMessage());
        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Class Not Found exception " + e.getMessage());
        }


//        Path locationPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path directionPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (Scanner sc = new Scanner(Files.newBufferedReader(locationPath))) {
//            sc.useDelimiter(",");
//            while (sc.hasNextLine()) {
//                int loc = sc.nextInt();
//                sc.skip(sc.delimiter());
//                String description = sc.nextLine();
//                System.out.println("Imported location " + loc + ":" + description);
//                locations.put(loc, new Location(loc, description, null));
//            }
//        } catch (IOException ioe) {
//            System.out.println("IOException in static initialing block: " + ioe.getMessage());
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(directionPath)) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
