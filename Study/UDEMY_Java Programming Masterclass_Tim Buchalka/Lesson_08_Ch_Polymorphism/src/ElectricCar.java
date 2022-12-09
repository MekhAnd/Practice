public class ElectricCar extends Car{
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Already working!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("All %d battery are working! Next charge in %f", batterySize, avgKmPerCharge);
    }
}
