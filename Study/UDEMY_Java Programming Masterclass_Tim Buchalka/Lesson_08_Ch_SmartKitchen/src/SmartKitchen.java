public class SmartKitchen extends Appliance{

    private CoffeeMaker coffeeMaker;
    private Refrigirator ref;
    private DishWasher dish;

    public SmartKitchen(){
        coffeeMaker = new CoffeeMaker();
        ref = new Refrigirator();
        dish = new DishWasher();

    }
    public SmartKitchen(CoffeeMaker coffeeMaker, Refrigirator ref, DishWasher dish) {
        this.coffeeMaker = coffeeMaker;
        this.ref = ref;
        this.dish = dish;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public Refrigirator getRef() {
        return ref;
    }

    public DishWasher getDish() {
        return dish;
    }

    public void addWater(){
        coffeeMaker.setHasWorkToDo(true);
    }

    public void pourMilk(){
        ref.setHasWorkToDo(true);
    }

    public void loadDishwasher(){
        dish.setHasWorkToDo(true);
    }

    public void doKithenWork (){
        coffeeMaker.brewCoffee();
        ref.orderFood();
        dish.doDishes();
    }
}

