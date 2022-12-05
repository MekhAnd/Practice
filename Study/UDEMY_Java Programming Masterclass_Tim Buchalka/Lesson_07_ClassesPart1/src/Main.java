public class Main {
    public static void main(String[] args) {

        Car myFirstCar = new Car ();
        myFirstCar.discribeCar();

        Car mySecondCar = new Car ("Toyota", "Camry", "black", 4, false);



        System.out.println(myFirstCar.getModel());

        System.out.println("Hello world!");


    }
}