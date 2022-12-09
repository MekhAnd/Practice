import java.util.Scanner;

public class Drink {

    private String type;
    private String syze;
    private double price;


    public Drink() {
    }

    public Drink(String type, double price, String syze) {
        this.type = type;
        this.price = price;
        this.syze = syze;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getSyze() {
        return syze;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Drink drinkSet() {
        Drink drink = new Drink();
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls set your drink: " +
                "\n\t- C for Cola" +
                "\n\t- F for Fanta" +
                "\n\t- S for Sprite");
        char instanceType = sc.nextLine().toUpperCase().charAt(0);

        if (instanceType == 'C') {
            System.out.println("Pls set your burger: " +
                    "\n\t- S for Small" +
                    "\n\t- R for Regular" +
                    "\n\t- B for Big");
            char instanceSize = sc.nextLine().toUpperCase().charAt(0);
            switch (instanceSize) {
                case 'S' -> {
                    drink = new Cola("Cola", 1.00, "Small");
                    return drink;
                }
                case 'R' -> {
                    drink = new Cola("Cola", 2.00, "Regular");
                    return drink;
                }
                default -> {
                    drink = new Cola("Cola", 3.00, "Big");
                    return drink;
                }
            }
        } else if (instanceType == 'F') {
            System.out.println("Pls set your burger: " +
                    "\n\t- S for Small" +
                    "\n\t- R for Regular" +
                    "\n\t- B for Big");
            char instanceSize = sc.nextLine().toUpperCase().charAt(0);
            switch (instanceSize) {
                case 'S' -> {
                    drink = new Fanta("Fanta", 1.20, "Small");
                    return drink;
                }
                case 'R' -> {
                    drink = new Fanta("Fanta", 2.10, "Regular");
                    return drink;
                }
                default -> {
                    drink = new Fanta("Fanta", 3.00, "Big");
                    return drink;
                }
            }
        } else if (instanceType == 'S') {
            System.out.println("Pls set your burger: " +
                    "\n\t- S for Small" +
                    "\n\t- R for Regular" +
                    "\n\t- B for Big");
            char instanceSize = sc.nextLine().toUpperCase().charAt(0);
            switch (instanceSize) {
                case 'S' -> {
                    drink = new Sprite("Sprite", 0.95, "Small");
                    return drink;
                }
                case 'R' -> {
                    drink = new Sprite("Sprite", 1.85, "Regular");
                    return drink;
                }
                default -> {
                    drink = new Sprite("Sprite", 3.50, "Big");
                    return drink;
                }
            }

        }
        return drink;
    }

    public static void drinksPrice() {
        Cola cola = new Cola();
        Fanta fanta = new Fanta();
        Sprite sprite = new Sprite();


        System.out.println("\nDRINKS MENU\n" +
                "\t\t" + cola.getType() + "\t\t\t" + "Small $1.00" + "\n" +
                "\t\t" + cola.getType() + "\t\t\t" + "Regular $2.00" + "\n" +
                "\t\t" + cola.getType() + "\t\t\t" + "Big $3.00" + "\n" +
                "************\n"+
                "\t\t" + fanta.getType() + "\t\t\t" + "Small $1.20" + "\n" +
                "\t\t" + fanta.getType() + "\t\t\t" + "Regular $2.10" + "\n" +
                "\t\t" + fanta.getType() + "\t\t\t" + "Big $3.00" + "\n" +
                "************\n"+
                "\t\t" + sprite.getType() + "\t\t\t" + "Small $0.95" + "\n" +
                "\t\t" + sprite.getType() + "\t\t\t" + "Regular $1.85" + "\n" +
                "\t\t" + sprite.getType() + "\t\t\t" + "Big $3.50" + "\n" +
                "\n");

    }
}

    class Cola extends Drink {
        private String type;
        private String syze;
        private double price;

        public Cola() {
            super();
            this.type = "Cola";
        }

        public Cola(String type, double price, String syze) {
            super();
            this.type = "Cola";
            this.syze = syze;
            this.price = price;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getSyze() {
            return syze;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Cola{" +
                    "type='" + type + '\'' +
                    ", syze='" + syze + '\'' +
                    ", price=" + price +
                    "} " + super.toString();
        }
    }

    class Fanta extends Drink {
        private String type;
        private String syze;
        private double price;

        public Fanta() {
            this.type = "Fanta";
        }

        public Fanta(String type, double price, String syze) {
            super();
            this.type = "Fanta";
            this.syze = syze;
            this.price = price;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getSyze() {
            return syze;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Fanta{" +
                    "type='" + type + '\'' +
                    ", syze='" + syze + '\'' +
                    ", price=" + price +
                    "} " + super.toString();
        }
    }

    class Sprite extends Drink {
        private String type;
        private String syze;
        private double price;

        public Sprite() {
            this.type = "Sprite";
        }

        public Sprite(String type, double price, String syze) {
            super();
            this.type = "Fanta";
            this.syze = syze;
            this.price = price;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getSyze() {
            return syze;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Sprite{" +
                    "type='" + type + '\'' +
                    ", syze='" + syze + '\'' +
                    ", price=" + price +
                    "} " + super.toString();
        }
    }


