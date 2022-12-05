public class Main {
    public static void main(String[] args) {

        Account myAccount = new Account("A00011011976", 1000.00, "Andrii Mekhanich", "andrii.mekhanich@gmail.com", "+380636006565");

//        myAccount.depositFounds(1000.00);
//        myAccount.withdrawFounds(1000.00);
//        myAccount.withdrawFounds(1000.00);
//        myAccount.withdrawFounds(1000.00);
        System.out.println((myAccount.toString()));
        Account bobsAccount = new Account();
        Account timAccount = new Account("Tim", "some@email.com", "+123456789" );

        System.out.println((bobsAccount.toString()));
        System.out.println((timAccount.toString()));



    }
}