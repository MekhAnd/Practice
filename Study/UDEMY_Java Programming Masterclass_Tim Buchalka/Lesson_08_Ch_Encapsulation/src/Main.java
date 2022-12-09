public class Main {
    public static void main(String[] args) {
        Printer pr = new Printer(50, true);
        System.out.println("initial page count = " + pr.getPagesPrinted());

        int pagesPrinted = pr.printPages(25);
        System.out.printf("Current Job Pages %d, Printer total %d%n", pagesPrinted, pr.getPagesPrinted());

        System.out.println();

        pagesPrinted = pr.printPages(20);
        System.out.printf("Current Job Pages %d, Printer total %d%n", pagesPrinted, pr.getPagesPrinted());

        System.out.println();

        Printer pr01 = new Printer(-12,  false);
        System.out.println("initial page count = " + pr01.getPagesPrinted());
        Printer pr02 = new Printer(125, true);
        System.out.println("initial page count = " + pr02.getPagesPrinted());
        Printer pr03 = new Printer(25, false);
        System.out.println("initial page count = " + pr03.getPagesPrinted());

        int pagesPrinted03 = pr03.printPages(25);
        System.out.printf("Current Job Pages %d, Printer total %d%n", pagesPrinted03, pr03.getPagesPrinted());

        System.out.println();

        pagesPrinted03 = pr03.printPages(20);
        System.out.printf("Current Job Pages %d, Printer total %d%n", pagesPrinted03, pr03.getPagesPrinted());

        System.out.println();



        System.out.println("Hello world!");
    }
}