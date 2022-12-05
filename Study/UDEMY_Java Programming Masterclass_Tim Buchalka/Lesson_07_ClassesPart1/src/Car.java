public class Car {
    private String make = "Tesla";
    private String model = "Madel X";
    private String color = "Black";
    private int doors = 5;
    private boolean convertible = true;

    public Car (){
        System.out.println("Empty constructor called!");
    }

    public Car ( String make, String model, String color, int doors, boolean convertible ){
        System.out.println("Constructor with parameters called");
        this.make = make;
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.convertible = convertible;
    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setMake(String make) {
        if(make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake){
            case "holden", "porsche", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            }
        }
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertable(boolean convertable) {
        this.convertible = convertible;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", convertable=" + convertible +
                '}';
    }

    public void discribeCar() {
        System.out.println(doors + " - Doors " + color + " Color " + make + " " + model + " " +
                (convertible ? "Convertable" : " "));
    }

}
