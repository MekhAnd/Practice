public class Main {
    public static void main(String[] args) {
        prinInformation("Hello World");
        prinInformation("");
        prinInformation("\n \t");

        String hello = "Hello World";
        System.out.printf("index of r= %d%n", hello.indexOf('r'));
        System.out.printf("index of World= %d%n", hello.indexOf("World"));
        System.out.printf("index of l= %d%n", hello.lastIndexOf("l", 3));

        System.out.println();
        System.out.println();
        System.out.println("*********");

        String helloWorldLover = hello.toLowerCase();
        if(hello.equals(helloWorldLover)){
            System.out.println("Match exactly");
        }
        if(hello.equalsIgnoreCase(helloWorldLover)){
            System.out.println("Match exactly ignor case!");
        }

        if(hello.startsWith("Hello")){
            System.out.println("String starts");
        }
        if(hello.endsWith("World")){
            System.out.println("String ends");
        }
        if(hello.contains("World")){
            System.out.println("String contains World");
        }

        if(hello.contentEquals("Hello World")){
            System.out.println("Contains Equals");
        }
    }

    public static void prinInformation (String string){

        int length = string.length();
        System.out.printf("length -> %d%n", length);
        if(string.isEmpty()){
            System.out.println("String is empty");
            return;
        }
        if(string.isBlank()){
            System.out.println("String is blank");
            return;
        }
        System.out.printf("First char -> %c%n", string.charAt(0) );
        System.out.printf("Last char -> %c%n", string.charAt(length-1));
    }
}