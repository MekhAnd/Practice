public class HybridCar extends Car{
    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("PTUH ALREADY WORKING PTUH ALREADY WORKING PTUH ALREADY WORKING PTUH ALREADY WORKING PTUH ALREADY WORKING");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("All %d cylinders are working! All %d battery are working! Avg fuel consumption is %f", cylinders, batterySize, avgKmPerLitre);
    }
}
