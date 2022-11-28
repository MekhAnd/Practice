public class Main {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int a01 = (int) (a * 1000);
        int b01 = (int) (b * 1000);

        if ((a01) == (b01)) {
            return true;
        } else {
            return false;
        }
    }

}