package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Gek");
        dog.eat();
        dog.breathe();

//        Bird bird = new Bird("Parrot");
        Parrot bird = new Parrot("Parrot");
        bird.eat();
        bird.breathe();
        bird.fly();

        Penguin pin = new Penguin("Pin");
        pin.fly();
        pin.breathe();
        pin.eat();
        pin.getName();

        Bat bat = new Bat("Battie");

    }
}