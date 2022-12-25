package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ITelephone myPhone;
//        DeskPhone myPhone;
        myPhone = new DeskPhone(41313);
        myPhone.powerOn();
        myPhone.isRinging();
        myPhone.answer();
        myPhone.dial(462825);
        myPhone.callPhone(462825);

        ITelephone myPhone01;
//        DeskPhone myPhone;
        myPhone01 = new MobilePhone(6006565);
        myPhone01.powerOn();
        myPhone01.isRinging();
        myPhone01.answer();
        myPhone01.dial(462825);
        myPhone01.callPhone(6006565);


    }
}