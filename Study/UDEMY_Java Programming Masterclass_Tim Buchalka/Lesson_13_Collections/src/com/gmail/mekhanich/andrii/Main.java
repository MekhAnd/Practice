package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Small", 8, 12);

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay");
        } else {
            System.out.println("Already reserved");
        }

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay");
        } else {
            System.out.println("Already reserved");
        }

        if(theatre.reserveSeat("B13")){
            System.out.println("Please pay ");
        } else {
            System.out.println("Already reserved");
        }

        List <Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse( reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13));
        priceSeats.add(theatre.new Seat("A00", 13));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat:list){
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("=".repeat(20));
    }
}