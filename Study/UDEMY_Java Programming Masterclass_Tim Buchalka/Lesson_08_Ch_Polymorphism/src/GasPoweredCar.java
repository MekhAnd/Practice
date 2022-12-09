public class GasPoweredCar extends Car{
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("PTUHPTUHPTUHPTUHPTUHPTUHPTUHPTUHPTUHPTUHPTUH");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("All %d cylinders are working! Avg fuel consumption is %,.2f", cylinders, avgKmPerLitre);
    }
}
