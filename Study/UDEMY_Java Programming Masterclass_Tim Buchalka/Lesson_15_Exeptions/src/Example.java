import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException ae){
            System.out.println(ae.toString());
            System.out.println("Unable to perform division, autopilot is shutting down");
        }
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException nsee) {
          throw new ArithmeticException("The input is not correct");
        } catch (ArithmeticException ae) {
            throw new ArithmeticException("attempt divide by 0");
        }

    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the integer: ");
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException ime) {
                sc.nextLine();
                System.out.println("Please enter only digits");
            }


        }
    }
}
