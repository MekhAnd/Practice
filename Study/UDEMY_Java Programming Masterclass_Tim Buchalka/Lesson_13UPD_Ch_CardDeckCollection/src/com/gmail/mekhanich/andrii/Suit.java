package com.gmail.mekhanich.andrii;

public enum Suit {
    CLUB, DIAMOND, HEART, SPADE;

    public char getImage(){
        return (new char[] {9827, 9830, 9829, 9824})[this.ordinal()];
    }

//    public char getImage(Suit s) {
//        char result;
//        switch (s){
//            case CLUB -> result = 9827;
//            case DIAMOND -> result = 9830;
//            case HEAT -> result = 9829;
//            case SPADE -> result =9824;
//            default -> result = 0;
//        }
//        return result;
//    }
}
