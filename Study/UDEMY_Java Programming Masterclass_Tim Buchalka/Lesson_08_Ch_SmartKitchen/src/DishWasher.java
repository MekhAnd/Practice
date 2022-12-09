public class DishWasher extends Appliance {
    private boolean hasWorkToDo;

    public DishWasher() {
        this.hasWorkToDo = true;
    }

    public DishWasher(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean isHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes() {
        if (hasWorkToDo) System.out.println("Dishes has been washed");
        else System.out.println("Dishwasher is working now, try call later!");
        hasWorkToDo = !hasWorkToDo;
    }


}
