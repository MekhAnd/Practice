import java.util.Scanner;

public class Meal {
    private String type;
    private double price;

    public Meal() {
    }

    public Meal(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Meal mealSet(){
        Meal ml = new Meal();
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls set your meal: " +
                "\n\t- F for Fries" +
                "\n\t- E for Eggs" +
                "\n\t- S for Salad");
        char instanceType = sc.nextLine().toUpperCase().charAt(0);
        switch (instanceType){
            case 'F' -> {
                return ml = new Fries();
            }
            case 'E' -> {
                return ml = new Eggs();
            }
            case 'S' -> {
                return ml = new Salad();
            }
        }
        return ml;
    }

    public static void mealPrice (){
        Fries fries = new Fries();
        Eggs eggs = new Eggs();
        Salad salad = new Salad();


        System.out.println("\nMEAL MENU\n" +
                "\t\t" + fries.getType() + "\t\t\t" + fries.getPrice() + "\n" +
                "\t\t" + eggs.getType() + "\t\t\t" + eggs.getPrice() + "\n" +
                "\t\t" + salad.getType() + "\t\t\t" + salad.getPrice() + "\n" +
                "\n");

    }

    @Override
    public String toString() {
        return "Meal{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

class Fries extends Meal{
    private String type;
    private double price;

    public Fries() {
        super();
        this.type = "Fries";
        this.price = 1.8;
    }

    public Fries(String type, int price) {
        super();
        this.type = "Fries";
        this.price = 1.8;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fries{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class Eggs extends Meal{
    private String type;
    private double price;

    public Eggs() {
        super();
        this.type = "Eggs";
        this.price = 3.99;
    }

    public Eggs(String type, int price) {
        super();
        this.type = "Eggs";
        this.price = 3.99;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Eggs{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class Salad extends Meal{
    private String type;
    private double price;

    public Salad() {
        super();
        this.type = "Salad";
        this.price = 4.79;
    }

    public Salad(String type, int price) {
        super();
        this.type = "Salad";
        this.price = 4.79;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}