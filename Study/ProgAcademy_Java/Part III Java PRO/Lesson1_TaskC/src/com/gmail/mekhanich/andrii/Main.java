package com.gmail.mekhanich.andrii;


public class Main {

    public static void main(String[] args) {



        DataArray dar = new DataArray(100,"Just example", "Test text");
        System.out.println(dar.toString());

        SaveTo.saveTo(dar);
        DataArray one = ReadFrom.readFrom();

        System.out.println("This is araay from file " + one.toString());

    }
}
