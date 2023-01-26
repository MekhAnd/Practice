package com.gmail.mekhanich.andrii;

/*
    Do not change anything in this class
*/

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null){
            this.exits = new HashMap<String, Integer>(exits);

        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

    // public void addExit(String direction, int location) {
    //     exits.put(direction, location);
    // }



    // public void setLocationID(int locationID) {
    //     this.locationID = locationID;
    // }

    public int getLocationID() {
        return locationID;
    }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    public String getDescription() {
        return description;
    }

    // public void setExits(Map<String, Integer> exits) {
    //     this.exits = exits;
    // }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

}