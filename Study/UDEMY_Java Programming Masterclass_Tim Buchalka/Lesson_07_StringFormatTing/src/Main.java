public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String buletIt = "Print a bulleted List:\n" +
                "\u2022\t I \n"+
                "\t\u2022\t II\n"+
                "\t\t\u2022\t III";
        System.out.println(buletIt);

        String textBlock = """
                    Print a bulleted List:\n 
                                    \u2022\t I \n
                                    \t\u2022\t II\n
                                    \t\t\u2022\t III
                """;
        System.out.println(textBlock);

        int age = 46;
        System.out.printf("your age is %d%n", age);

        System.out.println();
        int yearOfBirth = 2022 - age;
        System.out.printf("Age is %d, Birth year is %d%n", age, yearOfBirth);
        System.out.println();
        System.out.printf("Age is %d, Birth year is %.2f%n", age, (float)yearOfBirth);

        for (int i=1; i<=100000; i*=10){
            System.out.printf("Printing %6d %n", i); //%6d => 6 digits in number if less  => 6 spaces before

        }
        String formatedString = String.format("Your age %d", age );
        System.out.println(formatedString);
        //or

        formatedString = "Your age %d".formatted(age);
        System.out.println(formatedString);

    }
}