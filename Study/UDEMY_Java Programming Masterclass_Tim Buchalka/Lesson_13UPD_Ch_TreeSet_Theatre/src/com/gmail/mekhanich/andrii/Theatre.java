package com.gmail.mekhanich.andrii;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

class Seat {
    private int seatNumber;
    private char row;
    private boolean reserved;
    private String address;

    public Seat (int seatNumber, char row){
        this.seatNumber = seatNumber;
        this.row = row;
        address = "" + row + (seatNumber<10 ? "00"+seatNumber : seatNumber<100 ?"0"+seatNumber:+seatNumber);
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public char getRow() {
        return row;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        if(this.isReserved()){
            return "[    ]";
        } else {
            return "[" + address + "]";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (seatNumber != seat.seatNumber) return false;
        return row == seat.row;
    }

    @Override
    public int hashCode() {
        int result = seatNumber;
        result = 31 * result + (int) row;
        return result;
    }
}

public class Theatre {
    private String name;
    private int seatsInRow;
    private TreeSet<Seat> totalSeats;

    public Theatre(String name, int seatsInRow){
        this.name = name;
        this.seatsInRow = seatsInRow;
        Comparator<Seat> comparator = Comparator.comparing(Seat::getRow).thenComparing(Seat::getSeatNumber);
        this.totalSeats = new TreeSet<>(comparator);
        for(int i = 65; i < 91; i++){
            for(int j = 0; j <seatsInRow+1 ; j++){
                totalSeats.add(new Seat(j, (char)i));
            }
        }

    }

    public TreeSet<Seat> getTotalSeats() {
        return totalSeats;
    }

    public void setReservedSeat(Seat seat){
//        for(Seat s: this.totalSeats){
//            if(s.equals(seat) && !s.isReserved()){
//                s.setReserved(true);
//            }
//        }

        //Tim variant

        Seat requested = totalSeats.floor(seat);
        if(!requested.isReserved()) {
            if(seat.getSeatNumber()<= seatsInRow) {
                requested.setReserved(true);
            } else {
                System.out.println("There aren`t seats with this number");
            }
        } else {
            System.out.println("This seat already reserved");
        };
    }

//    public void reservationsReport (){
//        System.out.println("**************************");
//        System.out.println("The reservation report");
//        System.out.println("These seats was reserved:");
//        String reservedRows = "";
//        char tempRow = 0;
//        int totalReservedSeats = 0;
//        for(Seat s: totalSeats){
//            if(s.isReserved()){
//                if(s.getRow()!= tempRow) {
//                    tempRow = s.getRow();
//                    reservedRows += s.getRow() + ",";
//                }
//                System.out.print(s.getAddress() + " ");
//                totalReservedSeats++;
//            }
//        }
//        System.out.println();
//        System.out.println("Rows reserved");
//        System.out.println(reservedRows);
//        System.out.println("Total reserved seats " + totalReservedSeats);
//    }
//
    private boolean validate (int count, char first, char last,  int min, int max){
        boolean result = (min > 0 || count <= seatsInRow || (max - min +1) >= count);
        result = result && totalSeats.contains(new Seat(min, first));

        if(!result){
            System.out.printf("Invalid! %1$d seats between " + "%2$c[%3$d-%4$d -%5$c[%3$d-%4$d] Try again",
                    count, first, min, max, last
                    );
            System.out.printf(": Seat must be between %s and %s%n",
                    totalSeats.first().getSeatNumber(), totalSeats.last().getSeatNumber()
                    );
        }
        return result;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,  int minSeat, int maxSeat) {

        char lastValid = totalSeats.last().getRow();
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;

        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }
        NavigableSet<Seat> selected = null;
        for (char letter = minRow; letter <= maxRow; letter++){
            NavigableSet<Seat> contiguous = totalSeats.subSet(
                    new Seat(minSeat, letter), true,
                    new Seat(maxSeat, letter), true
            );
            int index = 0;
            Seat first = null;
            for (Seat current: contiguous){
                if(current.isReserved()){
                    index = 0;
                    continue;
                }
                first = (index == 0) ? current:first;
                if(++index == count){
                    selected = contiguous.subSet(first, true, current,true);
                    break;
                }
            }
            if(selected !=null){
                break;
            }
        }
        Set<Seat> reservedSeats = null;
        if(selected !=null){
            selected.forEach(s->s.setReserved(true));
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }

    public void printSeatMap(){
        char control = 65;
        for(Seat s: totalSeats){
            if(s.getRow() == control){
                System.out.print(s);
            } else {
                System.out.println();
                System.out.print(s);
                control = s.getRow();
            }
        }
    }

    @Override
    public String toString() {
        return "com.gmail.mekhanich.andrii.Theatre{" +
                "name='" + name + '\'' +
                ", seatsInRow=" + seatsInRow +
                ", totalSeats=" + totalSeats.size() +
                '}';
    }
}
