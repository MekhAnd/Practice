public class Product {
    private String model;
    private String manufactorer;
    private int width;
    private int height;
    private int depth;

    public Product(String model, String manufactorer) {
        this.model = model;
        this.manufactorer = manufactorer;
    }

}

class Monitor extends Product{
    private int size;
    private String resolution;

    public Monitor(String model, String manufactorer) {
        super(model, manufactorer);
    }

    public Monitor(String model, String manufactorer, int size, String resolution) {
        super(model, manufactorer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.println(String.format("Drawing pixel at %d, %d in color %s", x,y, color));
    }
}

class Motherboard extends Product{
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufactorer) {
        super(model, manufactorer);
    }

    public Motherboard(String model, String manufactorer, int ramSlots, int cardSlots, String bios) {
        super(model, manufactorer);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName){
        System.out.println("Program " + programName + " is now loading...");
    }
}

class ComputerCase extends Product{
    private String powerSuply;

    public ComputerCase(String model, String manufactorer) {
        super(model, manufactorer);
    }

    public ComputerCase(String model, String manufactorer, String powerSuply) {
        super(model, manufactorer);
        this.powerSuply = powerSuply;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}