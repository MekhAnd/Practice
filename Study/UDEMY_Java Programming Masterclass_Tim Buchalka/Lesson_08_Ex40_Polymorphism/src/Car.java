public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;


    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this. wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        String instance = this.getClass().getSimpleName();
        return instance + " -> startEngine()";
    }

    public String accelerate(){
        String instance = this.getClass().getSimpleName();
        return instance + " -> accelerate()";
    }

    public String brake(){
        String instance = this.getClass().getSimpleName();
        return instance + " -> accelerate()";
    }


}
