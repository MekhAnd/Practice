public class Main {
    public static void main(String[] args) {
//        numberToWords(123);
//        numberToWords(100);
//        numberToWords(1010);
//        numberToWords(1000);
//        numberToWords(-12);

        System.out.println(reverse(-121));
    }

    public static void numberToWords(int number) {
        if (number < 0) System.out.println("Invalid Value");

        int digits = getDigitCount(number);
        int originalNumber = reverse(number);

        //zero, one, two, three, four, five, six, seven, eight, nine
        for (int i = 1; i <= digits; i++) {
            switch (originalNumber % 10) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            originalNumber /= 10;
        }
    }

    public static int reverse(int number) {
        int reverseNumber = 0;
        int originalNumber = number;

        while (Math.abs(originalNumber) > 0) {
            reverseNumber = reverseNumber * 10 + originalNumber % 10;
            originalNumber /= 10;
        }
        return (originalNumber<0) ? reverseNumber*(-1): reverseNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;
        return String.valueOf(number).length();
    }
}