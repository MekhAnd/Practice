package com.gmail.mekhanich.andrii;

import java.util.Arrays;

public class Person {
    private String name;
    private String surname;
    private String [] phones;
    private String [] sites;
    private Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", sites=" + Arrays.toString(sites) +
                ", address=" + this.address.toString() +
                '}';
    }
}
