public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigits(1111111111));
        System.out.println(sumDigits(-123));
    }

    public static int sumDigits (int number){
        if (number <0) return -1;
        int sum = 0;
        while (number / 10 >= 1) {    //(number > 9)
            sum += number % 10;
            number /= 10;
        }
        sum += number;
        return sum;
    }
}