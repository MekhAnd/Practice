import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String currentYear = "2022";
        int currentIntYear = 2022;
        String userDateOfBirth = "1999";
        System.out.println("Age = " + (Integer.parseInt(currentYear) - Integer.parseInt(userDateOfBirth)));
//        System.out.println(getInputFromConsole(currentIntYear));
        System.out.println(getInputFromScanner(currentIntYear));
    }

//    public  static String getInputFromConsole (int currentYear){
//
//        String name = System.console().readLine("Hi, what`s your Name&");
//        System.out.println("Hi " + name);
//
//        return "";
//    }

    public  static String getInputFromScanner (int currentYear){
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi, what`s your Name?");
        boolean validDob = false;
        int age = 0;

        String name = sc.nextLine();
        System.out.println("What  year were you born");
        do{
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <=" + currentYear );
            try{
                age = checkData(currentYear, sc.nextLine());
                validDob = age < 0 ? false : true;
            } catch (NumberFormatException badUserData){
                System.out.println("You try to enter characters which not allowed!");
            }
        } while (!validDob);

//        System.out.println("Hi " + name + " " + dateOfBirth + checkData(currentYear, dateOfBirth));


        return "So you are " + age + " years old";
    }

    public static int checkData (int currentYear, String dataOfBirth){
        int dob = Integer.parseInt(dataOfBirth);
        int minimumYear = currentYear - 125;

        if((dob < minimumYear) || (dob > currentYear)){
            return -1;
        }
        return (currentYear - dob);
    }


}