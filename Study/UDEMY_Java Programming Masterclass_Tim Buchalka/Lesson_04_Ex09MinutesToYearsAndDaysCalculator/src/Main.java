
public class Main {
    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
        printYearsAndDays(0);
    }

    public static void printYearsAndDays(long minutes) {

        if (minutes >= 0) {
            int years = (int) minutes / 525600;
            int days =  (int) (minutes % 525600)/1440;
            String resYears = (years<10) ? "0"+years:""+years;
            String resDays = (days<10) ? "0"+days:""+days;
            System.out.println(minutes + " min = "+ resYears +" y and " + resDays + " d");
        } else {
            System.out.println("Invalid Value");
        }
    }
}