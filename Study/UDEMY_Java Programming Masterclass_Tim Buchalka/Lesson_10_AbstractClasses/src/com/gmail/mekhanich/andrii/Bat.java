package com.gmail.mekhanich.andrii;

public class Bat extends Animal implements CanFly{
    public Bat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void eat() {
        System.out.println("Eat fruits!");

    }

    @Override
    public void breathe() {
        System.out.println("Like other animals");

    }

    @Override
    public void fly() {
        System.out.println("Like a bird!");

    }
}
