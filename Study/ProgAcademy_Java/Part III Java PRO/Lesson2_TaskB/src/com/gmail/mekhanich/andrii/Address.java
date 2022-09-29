package com.gmail.mekhanich.andrii;

public class Address {
    private String country;
    private String city;
    private String street;


    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
