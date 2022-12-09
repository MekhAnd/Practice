public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Engine was started!");
    }

    protected void runEngine(){
        System.out.println("Let`s go!");
    }

    public void drive(){
        String instance = this.getClass().getTypeName();
        System.out.println(instance + " engine was started! Ready to drive!");
        runEngine();
    }


}
