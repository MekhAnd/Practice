package com.gmail.mekhanich.andrii;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I am not fly at all I am only swim!");
    }
}
