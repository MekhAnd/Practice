public class Main {
    public static void main(String[] args) {
//        System.out.println(hasSharedDigit(9, 10));
//        System.out.println(hasSharedDigit(15, 56));
//        System.out.println(hasSharedDigit(15, 65));
//        System.out.println(hasSharedDigit(61, 10));
//        System.out.println(hasSharedDigit(19, 99));
//        System.out.println(hasSharedDigit(10, 100));
//        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(51, 52));
    }

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        if((firstNumber < 10 || firstNumber > 99) || (secondNumber < 10 || secondNumber > 99)) return false;

        // Eddie solution
//        for(int i = firstNumber; i > 0; i /= 10) {
//            for(int j = secondNumber; j > 0 ; j /= 10) {
//                if(i % 10 == j % 10){
//                    return true;
//                }
//            }
//        }

        int firstTestNumber = firstNumber;

        for (int i = 1; i <= 2; i++) {
            int secondTestNumber = secondNumber;
            int testDigit = firstTestNumber % 10;
            for (int j = 1; j <= 2; j++) {
                if (secondTestNumber % 10 == testDigit) return true;
                secondTestNumber /= 10;
            }
            firstTestNumber /= 10;

        }
        return false;
    }

}

//Shared Digit
//
//Write a method named hasSharedDigit with two parameters of type int.
//
//Each number should be within the range of 10 (inclusive) - 99 (inclusive). If one of the numbers is not within the range, the method should return false.
//
//The method should return true if there is a digit that appears in both numbers, such as 2 in 12 and 23; otherwise, the method should return false.
//
//
//EXAMPLE INPUT/OUTPUT:
//
//    hasSharedDigit(12, 23); → should return true since the digit 2 appears in both numbers
//
//    hasSharedDigit(9, 99); → should return false since 9 is not within the range of 10-99
//
//    hasSharedDigit(15, 55); → should return true since the digit 5 appears in both numbers
//
//
//NOTE: The method hasSharedDigit​ should be defined as public static like we have been doing so far in the course.
//
//NOTE: Do not add a main method to the solution code.