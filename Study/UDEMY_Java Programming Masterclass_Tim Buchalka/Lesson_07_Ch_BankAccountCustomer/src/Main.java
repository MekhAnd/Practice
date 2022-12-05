public class Main {
    public static void main(String[] args) {
        Customer a = new Customer();
        Customer b = new Customer("b", "b@b.com");
        Customer c = new Customer("c", 100.00, "c@c.com");

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

    }
}