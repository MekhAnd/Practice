package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        Theatre newTheatre = new Theatre("New", 24);
        System.out.println(newTheatre);

//        newTheatre.getTotalSeats().forEach(System.out::print);
//        newTheatre.printHall();

        System.out.println();
        System.out.println("***Reserved seats***");
        System.out.println();
        Seat m10 = new Seat(10, 'M');
        Seat m11 = new Seat(11, 'M');
        Seat z9 = new Seat(10, 'Z');

        Seat z90 = new Seat(90, 'Z');

        newTheatre.setReservedSeat(m10);
        newTheatre.setReservedSeat(z9);
        newTheatre.setReservedSeat(m11);

        newTheatre.setReservedSeat(z90);
        newTheatre.printSeatMap();



        System.out.println();
//        newTheatre.reservationsReport();
        System.out.println();
        bookSeats(newTheatre, 4, 'B', 3, 13);
        System.out.println();
        bookSeats(newTheatre, 4, 'R', 10, 20);

        bookSeats(newTheatre, 8, 'R', 'W', 10, 20);
        bookSeats(newTheatre, 8, 'R', 'W', 10, 20);
        bookSeats(newTheatre, 8, 'R', 'W', 10, 20);
        bookSeats(newTheatre, 8, 'R', 'T', 0, 12);
        bookSeats(newTheatre, 2, 'R', 0, 12);
        bookSeats(newTheatre, 25, 'R', 'Z',0, 24);
    }

    private static void bookSeats (Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat){
        var seats = theatre.reserveSeats(tickets,minRow, maxRow, minSeat, maxSeat);
        System.out.println();
        if(seats != null){
            System.out.print("Congratulations! Your reserved seats are ");
            seats.forEach(s-> System.out.print("["+s.getAddress()+"]"));
            System.out.println();

            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: " + minRow + " - " + maxRow);
        }
    }

    private static void bookSeats (Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat){
        bookSeats(theatre,tickets,minRow, minRow, minSeat, maxSeat);
    }
}