package com.gmail.mekhanich.andrii;


public interface Mappable {

    void render();
    static double[] stringToLocation(String location){
        double[] doubleLocation = new double [2];
        doubleLocation[0] = Double.parseDouble(location.split(", ")[0]);
        doubleLocation[1] = Double.parseDouble(location.split(", ")[1]);
        return doubleLocation;
    };
}
