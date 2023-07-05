package com.gmail.mekhanich.andrii;

import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.FRI;
        System.out.println(weekDay);

        for (int i = 0; i<10; i++){
            weekDay = getRandom();
          switchDay(weekDay);
        }
//        System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());

        System.out.println();

//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
//        System.out.println(getRandom());
        for(Topping topping:Topping.values()){
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static DayOfTheWeek getRandom (){
        int randomInt = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInt];
    }

    public static void switchDay (DayOfTheWeek weekDay){
        int weekDayInt = weekDay.ordinal() +1;
        switch (weekDay){
            case WED -> System.out.println("Wednesday is Day " + weekDayInt);
            case SAT -> System.out.println("Saturday is Day " + weekDayInt);
            default -> System.out.println(weekDay.name().charAt(0)+ weekDay.name().substring(1).toLowerCase()+
                    "day is Day " + weekDayInt);
        }
    }
}