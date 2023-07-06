package com.gmail.mekhanich.andrii;


import java.util.Arrays;

public abstract class Point implements Mappable {
    private double[] location;

    public Point(){};

    public Point(double[] location) {
        this.location = location;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(String stringLocation) {
        this.location = Mappable.stringToLocation(stringLocation);
    }

    public String location(){
        return Arrays.toString(location);
    }

    public void render(){};
}
