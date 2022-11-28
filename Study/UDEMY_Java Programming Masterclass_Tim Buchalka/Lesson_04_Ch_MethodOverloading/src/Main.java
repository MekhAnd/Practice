public class Main {
    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(5.0, 10.0)); // 177.8 cm
        System.out.println(calcFeetAndInchesToCentimeters(-12)); //  -1
        System.out.println(calcFeetAndInchesToCentimeters(0));  //  1993.9 cm
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        return (feet < 0 || (inches >= 12 || inches < 0)) ? -1 : (feet * 12 + inches) * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(int inches) {
        return (inches < 0) ? -1 : calcFeetAndInchesToCentimeters(inches / 12, inches % 12);
    }

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        return (feet < 0 || (inches >= 12 || inches < 0)) ? -1 : (feet * 12 + inches) * 2.54;
    }

}