import java.util.Arrays;
import java.util.Scanner;

public class ToppingSet {
    private String toppings;
    private double totalPrice;

    public ToppingSet() {
    }

    public ToppingSet(String toppings, double totalPrice) {
        this.toppings = toppings;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "ToppingSet{" +
                "toppings=" + toppings +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public ToppingSet addToppingSet() {
        Scanner sc = new Scanner(System.in);
        String toppingsString = "";
        double toppingPrice = 0.00;
        boolean isReady = false;
        while (true) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Pls make your choice: " +
                        "\n\t- B for Beef cotlet topping" +
                        "\n\t- F for Fish topping" +
                        "\n\t- C for Cheese topping" +
                        "\n\t- V for Vegetable topping" +
                        "\n\t or press Q for exit");
                char instance = sc.next().toUpperCase().charAt(0);
                if (instance == 'B') {
                    Beef topping = new Beef();
                    System.out.println("beef");
                    double price = topping.getPrice();
                    System.out.println(price);
                    toppingsString += "\n\t-Beef $" + price;
                    toppingPrice += price;

                } else if (instance == 'F') {
                    Fish topping = new Fish();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Fish $" + price;
                    toppingPrice += price;

                } else if (instance == 'C') {
                    Cheese topping = new Cheese();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Cheese $" + price;
                    toppingPrice += price;

                } else if (instance == 'V') {
                    Vegetable topping = new Vegetable();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Vegetable $" + price;
                    toppingPrice += price;

                } else {
//                    isReady = true;
//                    System.out.println("STOP");
                    break;

                }
            }
            break;
        }
        return new ToppingSet(toppingsString, toppingPrice);
    }

    public ToppingSet addToppingSet(int deluxe) {
        Scanner sc = new Scanner(System.in);
        String toppingsString = "";
        boolean isReady = false;
        while (!isReady) {
            for (int i = 0; i < deluxe; i++) {
                System.out.println("Pls make your choice: " +
                        "\n\t- B for Beef cotlet topping" +
                        "\n\t- F for Fish topping" +
                        "\n\t- C for Cheese topping" +
                        "\n\t- V for Vegetable topping" +
                        "\n\t or press Q for exit");
                char instance = sc.next().toUpperCase().charAt(0);
                if (instance == 'B') {
                    Beef topping = new Beef();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Beef free for Deluxe Burger";
                } else if (instance == 'F') {
                    Fish topping = new Fish();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Fish free for Deluxe Burger";

                } else if (instance == 'C') {
                    Cheese topping = new Cheese();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Cheese free for Deluxe Burger";

                } else if (instance == 'V') {
                    Vegetable topping = new Vegetable();
                    double price = topping.getPrice();
                    toppingsString += "\n\t-Vegetable free for Deluxe Burger";

                } else {
                    isReady = true;
                    System.out.println("STOP");
                    break;
                }
            }
            break;
        }
        return new ToppingSet(toppingsString, 0.00);
    }
}
