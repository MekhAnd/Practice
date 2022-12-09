public class Refrigirator extends Appliance{
    private boolean hasWorkToDo;

    public Refrigirator() {
        this.hasWorkToDo = true;
    }

    public Refrigirator(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood(){
        if (hasWorkToDo) System.out.println("Products has been ordered");
        else System.out.println("Refrigirator is busy now, try call later!");
        hasWorkToDo = !hasWorkToDo;
    }
}
