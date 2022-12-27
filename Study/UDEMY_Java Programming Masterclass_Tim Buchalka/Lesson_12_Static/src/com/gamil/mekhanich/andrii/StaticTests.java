package com.gamil.mekhanich.andrii;

public class StaticTests {
    private int numInstances = 0;
    private static int classCounter = 0;
    private String name;

    public StaticTests(String name) {
        this.name = name;
        numInstances++;
        classCounter++;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }

    public static int getClassCounter() {
        return classCounter;
    }
}
