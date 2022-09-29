import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ProductList a = new ProductList();

//        Product one = new Product("IPHONE 10", "APPLE", "PHONE", 20000.00);
//        Product two = new Product("IPHONE 11", "APPLE", "PHONE", 22000.00);
//        Product three = new Product("IPHONE 12", "APPLE", "PHONE", 23000.00);
//        Product four = new Product("IPHONE 13", "APPLE", "PHONE", 35000.00);
//
//        try {
//            a.addProduct(one);
//            a.addProduct(two);
//            a.addProduct(three);
//            a.addProduct(four);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        a.getProductList();

        UserList b = new UserList();

//        User first = new User("ALEX", "PETROV","123@UA","123456", "qwerty1");
//        User second = new User("AL", "SIDOROV","234@UA","234561", "qwerty2");
//        User third = new User("EX", "IVANOV","345@UA","345612", "qwerty3");
//
//        try {
//            b.addUser(first);
//            b.addUser(second);
//            b.addUser(third);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        UserList.getUserList();

        Order firstOne = new Order();
//        Order firstTwo = new Order();
//
//        try {
//            firstOne.createOrder("123@UA", "123456","IPHONE 12", 23000.0);
//            firstTwo.createOrder("345@UA", "345612","IPHONE 13", 35000.0);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        firstOne.viewAllOrder();




    }

}
