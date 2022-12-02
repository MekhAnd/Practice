public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        printFactors(6);
        printFactors(32);
        printFactors(10);
        printFactors(-1);
    }

    public static void printFactors(int number){
        if(number < 1) System.out.println("Invalid Value");

        for (int i = 1; i <= number; i++){
            if (number % i == 0) System.out.println(i);
        }
    }
}