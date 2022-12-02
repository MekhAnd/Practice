import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Print number for keeping track minimum and maximum value");
        System.out.println("Print character for keeping end this game");

        boolean isStoped = false;
        double minNumber = 0;
        double maxNumber = 0;
        int count = 0;

        do {
            System.out.println("Please enter somethimg!");
            Scanner sc = new Scanner(System.in);
            String newData = sc.nextLine();
            try {
                double number = Double.parseDouble(newData);

                if (count == 0 || number > maxNumber) {
                    maxNumber = number;
                }
                if (count == 0 || number < minNumber) {
                    minNumber = number;
                }
                count++;
                System.out.println("Maximum number is " + maxNumber + "!!");
                System.out.println("Minimum number is " + minNumber + "!!");
            } catch (NumberFormatException e) {
                System.out.println("Bye!");
                isStoped = true;
                break;
            }
        } while (!isStoped);


    }
}