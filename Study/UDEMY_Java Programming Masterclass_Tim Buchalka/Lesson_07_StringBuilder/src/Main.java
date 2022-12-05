public class Main {
    public static void main(String[] args) {
        String helloWorld = "Hello " + "World";
        helloWorld.concat(" and Goodbye!");

        StringBuilder helloBuilder = new StringBuilder("Hello " + "World");
        helloBuilder.append(" and Goodbye");

        printInformation(helloWorld);
        printInformation(helloBuilder);
        System.out.println("******");

        StringBuilder emptyStart = new StringBuilder ();
        emptyStart.append("a".repeat(57));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart32);


        StringBuilder helloBuilderPlus = new StringBuilder("Hello " + "World");
        helloBuilderPlus.append(" and Goodbye");

        helloBuilderPlus.deleteCharAt(16).insert(16, 'g');
        System.out.println("*******");

        System.out.println(helloBuilderPlus);

        helloBuilderPlus.replace(16,17, "G");
        System.out.println(helloBuilderPlus);

        helloBuilderPlus.reverse().setLength(7);
        System.out.println(helloBuilderPlus);

    }

    public static void printInformation(String string){
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInformation(StringBuilder builder){
        System.out.println("String = " + builder);
        System.out.println("length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}