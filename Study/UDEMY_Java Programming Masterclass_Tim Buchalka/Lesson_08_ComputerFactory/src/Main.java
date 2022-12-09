public class Main {
    public static void main(String[] args) {

        ComputerCase theCase = new ComputerCase("2208", "Dell", "220");
        Monitor theMonitor = new Monitor("27in", "Acere", 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ200", "Asus", 4, 6, "v2.44");

        PersonalComputer theComputer = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherboard);

//        theComputer.getMonitor().drawPixelAt(10,10, "blue");
//        theComputer.getMotherboard().loadProgram("Windiws 10");
//        theComputer.getCompCase().pressPowerButton();

        theComputer.powerUp();
    }
}