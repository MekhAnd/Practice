import java.util.Scanner;

public class Order {
    private Burger burger;
    //    private Topping topping;
    private ToppingSet set;
    private Drink drink;
    private Meal meal;


    public Order() {
    }

    public Order(Burger burger, ToppingSet set, Drink drink, Meal meal) {
        this.burger = burger;
        this.set = set;
        this.drink = drink;
        this.meal = meal;
    }

    public Order(Burger burger, Drink drink, Meal meal) {
        this.burger = burger;
        this.drink = drink;
        this.meal = meal;
    }

    public Burger getBurger() {
        return burger;
    }

//    public Topping getTopping() {
//        return topping;
//    }

    public Drink getDrink() {
        return drink;
    }

    public Meal getMeal() {
        return meal;
    }

    public void priceLIst() {
        Burger.burgerPrice();
        Topping.toppingPrice();
        Drink.drinksPrice();
        Meal.mealPrice();
    }

    public double amount() {

       double total = this.burger.getPrice() + this.meal.getPrice() + this.drink.getPrice() + this.set.getTotalPrice();
        System.out.println("\n" +
                "ORDER:\n" +
                "-\t" + this.burger.getType() + "\t\t" + this.burger.getPrice() + "\n" +
                "-\t" + this.set.getToppings() + "\t\t" + this.set.getTotalPrice() + "\n" +
                "-\t" + this.meal.getType() + "\t\t" + this.meal.getPrice() + "\n" +
                "-\t" + this.drink.getType() + "\t\t" + this.drink.getPrice() + "\n" +
                "Total Amount is: " + total
        );
        return total;
    }

    public double amountStandart() {
        double total = this.burger.getPrice() + this.meal.getPrice() + this.drink.getPrice();
        System.out.println("\n" +
                "ORDER:\n" +
                "-\t" + this.burger.getType() + "\t\t" + this.burger.getPrice() + "\n" +
                "-\t" + this.meal.getType() + "\t\t" + this.meal.getPrice() + "\n" +
                "-\t" + this.drink.getType() + "\t\t" + this.drink.getPrice() + "\n" +
                "Total Amount is: " + total
        );
        return total;
    }

    public Order makeOrder() {
        Order order = new Order();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Hi!
                    This is 'Bill`s Burger Challenge' Chat bot!
                    Here you can make your order.
                    * \tIn order to create Standard Order ( Regular Burger, without additional topping,
                    Regular Cola, Fries):
                    Type STANDARD below.
                    * \tIn order to customize your Order:
                    Type CUSTOM below.
                    * \tIn order to read price list:
                    Type PRICE below.
                    """);
            String orderType = sc.nextLine();

            if (orderType.toUpperCase().charAt(0) == 'P') {
                System.out.println(orderType);
                priceLIst();
            } else if (orderType.toUpperCase().charAt(0) == 'S') {
                order = new Order(new RegularBurger(), new Cola("Cola", 2, "Regular"), new Fries());
                order.amountStandart();
                break;
            } else if (orderType.toUpperCase().charAt(0) == 'C') {
                var burger = new Burger().burgerSet();

                var topping = new ToppingSet();
                System.out.println("Would you like some additional toppings? \n I oder to choose press Y \n Press Q in other case");
                String additionalToppings = sc.nextLine();
                if (additionalToppings.toUpperCase().charAt(0) == 'Y' && burger.getClass().getSimpleName() != "DeluxeBurger") {
                    topping = new ToppingSet().addToppingSet();
                } else if((additionalToppings.toUpperCase().charAt(0) == 'Y' && burger.getClass().getSimpleName() == "DeluxeBurger")) {
                    topping = new ToppingSet().addToppingSet(5);
                }

                var drink = new Drink().drinkSet();

                var meal = new Meal().mealSet();

                order = new Order(burger, topping, drink, meal);
                order.amount();
                break;
            }
        }
        return order;
    }
}
