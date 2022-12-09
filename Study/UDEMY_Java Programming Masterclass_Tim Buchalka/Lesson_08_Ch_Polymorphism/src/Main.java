public class Main {
    public static void main(String[] args) {

        Car car = new Car("Just OPEL");
        car.startEngine();
        car.drive();
        System.out.println();
        GasPoweredCar gpc = new GasPoweredCar("Daewoo", 25.5, 4);
        gpc.startEngine();
        gpc.drive();

        System.out.println();
        ElectricCar ec = new ElectricCar("Tesla", 200,  2500);
        ec.startEngine();
        ec.drive();

        System.out.println();
        HybridCar hc = new HybridCar("Toyota", 200,  2500, 4);
        hc.startEngine();
        hc.drive();

        Car newCar = new HybridCar("Fiat", 50, 1, 3);


    }
}