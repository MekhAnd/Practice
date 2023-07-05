package com.gmail.mekhanich.andrii;

public enum Topping {

    MUSTARD, PICKERS, BACON, CHEDDAR, TOMATO;

    public double getPrice (){
        return switch (this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.00;
        };
    }
}
