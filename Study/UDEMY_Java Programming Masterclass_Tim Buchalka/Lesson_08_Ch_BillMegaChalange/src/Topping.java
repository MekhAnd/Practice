public class Topping {
    private String type;
    private double price;

    public Topping() {
    }

    public double getPrice() {
        return price;
    }

    public static void toppingPrice() {
        Beef beef = new Beef();
        Fish fish = new Fish();
        Cheese cheese = new Cheese();
        Vegetable vegetable = new Vegetable();

        System.out.println("\nADDITIONAL TOPPING MENU\n" +
                "\t\t" + beef.getType() + "\t\t\t" + beef.getPrice() + "\n" +
                "\t\t" + fish.getType() + "\t\t\t" + fish.getPrice() + "\n" +
                "\t\t" + cheese.getType() + "\t\t\t" + cheese.getPrice() + "\n" +
                "\t\t" + vegetable.getType() + "\t\t\t" + vegetable.getPrice() + "\n" +
                "\n" );

    }


}


class Beef extends Topping {
    private String type;
    private double price;

    public Beef() {
        super();
        this.type = "Beef";
        this.price = 5;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }


}

class Fish extends Topping {

    private String type;
    private double price;

    public Fish() {
        super();
        this.type = "Fish";
        this.price = 4.5;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class Cheese extends Topping {
    private String type;
    private double price;

    public Cheese() {
        super();
        this.type = "Chesse";
        this.price = 2.5;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class Vegetable extends Topping {
    private String type;
    private double price;

    public Vegetable() {
        super();
        this.type = "Vegetable";
        this.price = 1.5;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
