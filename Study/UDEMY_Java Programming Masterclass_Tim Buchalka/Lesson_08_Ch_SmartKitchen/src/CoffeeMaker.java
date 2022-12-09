public class CoffeeMaker extends Appliance{
    private boolean hasWorkToDo;

    public CoffeeMaker() {
        this.hasWorkToDo = true;
    }

    public CoffeeMaker(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee(){
        if (hasWorkToDo) System.out.println("Coffee will be ready in few minutes");
        else System.out.println("Coffee machine is busy now, try call machine later!");
        hasWorkToDo = false;
    }

}
