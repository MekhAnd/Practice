import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter 5 numbers");
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        boolean isValidInt = false;
        int count = 1;

        do{
            System.out.println("Enter number # " + count + ":");
            try {
                sum += Integer.parseInt(sc.nextLine());
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number");
            }
        } while (count <= 5);

        System.out.println(sum);

    }
}