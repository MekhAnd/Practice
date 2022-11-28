//Speed Converter
//
//1. Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour. This method needs to return the rounded value of the calculation of type long.
//If the parameter kilometersPerHour is less than 0, the method toMilesPerHour needs to return -1 to indicate an invalid value.
//Otherwise, if it is positive, calculate the value of miles per hour, round it and return it. For conversion and rounding, check the notes in the text below.

//Examples of input/output:
//        toMilesPerHour(1.5); → should return value 1
//        toMilesPerHour(10.25); → should return value 6
//        toMilesPerHour(-5.6); → should return value -1
//        toMilesPerHour(25.42); → should return value 16
//        toMilesPerHour(75.114); → should return value 47


public class Main {
    public static void main(String[] args) {
//        System.out.println(toMilesPerHour(1.5));
//        System.out.println(toMilesPerHour(10.25));
//        System.out.println(toMilesPerHour(-5.6));
//        System.out.println(toMilesPerHour(25.42));
//        System.out.println(toMilesPerHour(75.114));
        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
        printConversion(25.42);
        printConversion(75.114);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometersPerHour / 1.609);
        }
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }

}
