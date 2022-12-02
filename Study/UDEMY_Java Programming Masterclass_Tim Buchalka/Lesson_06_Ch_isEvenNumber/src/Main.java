import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        int i = 5;
        int totalEvenNUmbers = 0;
        int totalOddNUmbers = 0;

        while (i <= 20) {
            if (isEvenNumber(i)) {
                totalEvenNUmbers ++;
                System.out.println("Even number = " +i);
            } else{
                totalOddNUmbers++;
            }

            if(totalEvenNUmbers == 5) break;
            i++;
        }
        System.out.println("Total Even Numbers - "+totalEvenNUmbers);
        System.out.println("Total Odd Numbers - "+totalOddNUmbers);
    }
    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0) ? true : false;
    }


}