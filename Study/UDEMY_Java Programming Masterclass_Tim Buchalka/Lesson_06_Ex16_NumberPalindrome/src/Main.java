public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1211));
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
        System.out.println(isPalindrome(11211));

    }

    public static boolean isPalindrome(int number) {
        int res = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            res = res * 10 + originalNumber % 10;
            originalNumber /= 10;
        }

        return (number == res);
    }
}
