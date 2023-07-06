package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Park extends Point {

    private String name;

    public Park(String name) {
        this.name = name;
    }

    public Park(double[] location, String name) {
        super(location);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void render() {
        System.out.println("Render " + getName() + " as POINT"  + " ("+ super.location()+")");
    }
}
