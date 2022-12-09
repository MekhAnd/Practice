public class PersonalComputer extends Product{

    private ComputerCase compCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(String model, String manufactorer, ComputerCase compCase, Monitor monitor, Motherboard motherboard) {
        super(model, manufactorer);
        this.compCase = compCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    private void drawLogo(){
        monitor.drawPixelAt(15,15, "green");
    }

    public void powerUp(){
        compCase.pressPowerButton();
        drawLogo();
    }


//    public ComputerCase getCompCase() {
//        return compCase;
//    }
//
//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }


}
