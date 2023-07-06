package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public abstract class Line implements Mappable {
    private double[][] locations;

    public Line() {}
    public Line(double[][] locations ) {
        this.locations = locations;
    }

    public double[][] getLocations() {
        return locations;
    }

    public void setLocations(double[][] locations) {
        this.locations = locations;
    }

    public void setLocations(String location) {
        if(this.locations == null){
            double [][] tmpArray = new double[1][];
            tmpArray[0] = Mappable.stringToLocation(location);
            this.setLocations(tmpArray);
        } else {
            double[][] tmpArray = Arrays.copyOf(this.locations, this.locations.length + 1);
            tmpArray[this.locations.length] = Mappable.stringToLocation(location);
            this.setLocations(tmpArray);
        }
    }


    String locations(){
        return Arrays.deepToString(locations);
    };
    public void render(){};
}
