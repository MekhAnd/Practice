public class OtherStringMethods {
    public static void main(String[] args) {
        String birthDay = "11/01/1976";
        int startingIndex = birthDay.indexOf("1976");
        System.out.println("starting index -> " + startingIndex);
        System.out.println("Birth year -> " + birthDay.substring(startingIndex));
        System.out.println("*******");
        System.out.println("Month -> " + birthDay.substring(3, 5));

        String newDate = String.join("/", "23", "04", "1977" );
        System.out.println(newDate);

        String newDate01 = "21";
        newDate01 = newDate01.concat("/");
        System.out.println(newDate01);
        newDate01 = newDate01.concat("06/1999");
        System.out.println(newDate01);

        System.out.println(newDate.replace('/', '.'));
        System.out.println(birthDay.replaceFirst("/", "."));
        System.out.println(newDate01.replaceAll("/", "."));

        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));


    }

}
