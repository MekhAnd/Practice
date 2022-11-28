public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static String checkNumber (int number){
        if(number<0)
        {return "negative";}
        else if (number>0) {return "positive";}
        else {return "zero";}
    }

}