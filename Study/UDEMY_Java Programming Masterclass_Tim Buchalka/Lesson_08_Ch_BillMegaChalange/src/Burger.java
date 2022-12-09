import java.util.Scanner;

public class Burger {
    private String type;
    private double price;

    public Burger() {
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Burger burgerSet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls set your burger: " +
                "\n\t- S for Small" +
                "\n\t- R for Regular" +
                "\n\t- K for King size" +
                "\n\t- D for Deluxe" +
                "\n\t or press Q for exit");
        char instance = sc.nextLine().toUpperCase().charAt(0);

        if (instance == 'S') {
            SmallBurger burger = new SmallBurger();
            return burger;
        } else if (instance == 'R') {
            RegularBurger burger = new RegularBurger();
            return burger;
        } else if (instance == 'K') {
            KingSizeBurger burger = new KingSizeBurger();
            return burger;
        } else if (instance == 'D') {
            DeluxeBurger burger = new DeluxeBurger();
            return burger;
        } else {
            Burger burger = new Burger();
            return burger;
        }

    }

    public static void burgerPrice (){
        SmallBurger sb = new SmallBurger();
        RegularBurger rb = new RegularBurger();
        KingSizeBurger ksb = new KingSizeBurger();
        DeluxeBurger dlb = new DeluxeBurger();

        System.out.println("\nBURGER MENU\n" +
                "\t\t" + sb.getType() + "\t\t\t$" + sb.getPrice() + "\n" +
                "\t\t" + rb.getType() + "\t\t\t$" + rb.getPrice() + "\n" +
                "\t\t" + ksb.getType() + "\t\t\t$" + ksb.getPrice() + "\n" +
                "\t\t" + dlb.getType() + "\t\t\t$" + dlb.getPrice() + "\n"+
                "\n");
    }
}

class SmallBurger extends Burger {
    private String type;
    private double price;


    public SmallBurger() {
//        super();
        this.type = "Small Burger";
        this.price = 10.0;

    }

    public SmallBurger(String type, double price) {
//        super();
        this.type = type;
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "SmallBurger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class RegularBurger extends Burger {
    private String type;
    private double price;


    public RegularBurger() {
//        super();
        this.type = "Regular Burger";
        this.price = 15.0;

    }

    public RegularBurger(String type, double price) {
//        super();
        this.type = type;
        this.price = price;
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
        return "RegularBurger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class KingSizeBurger extends Burger {
    private String type;
    private double price;


    public KingSizeBurger() {
        super();
        this.type = "KingSize Burger";
        this.price = 20.0;

    }

    public KingSizeBurger(String type, double price) {
        super();
        this.type = type;
        this.price = price;
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
        return "KingSizeBurger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}

class DeluxeBurger extends Burger {
    private String type;
    private double price;


    public DeluxeBurger() {
        super();
        this.type = "Deluxe Burger";
        this.price = 30.0;

    }

    public DeluxeBurger(String type, double price) {
        super();
        this.type = type;
        this.price = price;
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
        return "Deluxe Burger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}