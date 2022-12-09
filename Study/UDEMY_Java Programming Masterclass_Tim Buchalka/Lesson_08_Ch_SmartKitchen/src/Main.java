public class Main {
    public static void main(String[] args) {
      CoffeeMaker coffee = new CoffeeMaker(true);
      Refrigirator ref = new Refrigirator(true);
      DishWasher dish = new DishWasher(true);

      SmartKitchen smk01 = new SmartKitchen(coffee, ref, dish);

      smk01.doKithenWork();
      smk01.getCoffeeMaker().brewCoffee();
         }
}