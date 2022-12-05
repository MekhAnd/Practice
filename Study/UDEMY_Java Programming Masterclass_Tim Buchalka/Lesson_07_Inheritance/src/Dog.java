public class Dog extends Animal {
    private String earShape;
    private String tailsShape;

    public Dog() {
        super("Mutt", "Big", 50);
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailsShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailsShape = tailsShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailsShape='" + tailsShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise() {
        if(type == "Wolf"){
            System.out.println("Ow Woooooo!");
        }
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
//        System.out.println("Dog walk, run and wag their tail");
        if(speed == "slow"){
            walk();
            wagTail();
        } else {
            run();
            bark();
        }
        System.out.println();
    }

    private void bark() {
        System.out.println("Woof!");
    }

    private void run() {
        System.out.println("Dog Running");
    }

    private void walk() {
        System.out.println("Dog walking!");
    }
    private void wagTail (){
        System.out.println("Tail Wagging");
    }
}
