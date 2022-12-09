public class HealthyBurger extends Hamburger{

    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", meat, price, "Brown");
    }

    public void addHealthyAddition1(String healthyExtra1Name, double healthyExtra1Price){
        this.healthyExtra1Name=healthyExtra1Name;
        this.healthyExtra1Price=healthyExtra1Price;
        
        System.out.println("Added " + healthyExtra1Name + " for an extra " + healthyExtra1Price);
    }

    public void addHealthyAddition2(String healthyExtra2Name, double healthyExtra2Price){
        this.healthyExtra2Name=healthyExtra2Name;
        this.healthyExtra2Price=healthyExtra2Price;

        System.out.println("Added " + healthyExtra2Name + " for an extra " + healthyExtra2Price);
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger() + this.healthyExtra1Price + this.healthyExtra2Price;
    }
}

// And for the third class, HealthyBurger, there will be four(4) additional member variables
// called healthyExtra1Name, healthyExtra1Price, healthyExtra2Name, and healthyExtra2Price.

// The names are type String and the prices are type double. The constructor for this class
// accepts two(2) parameters for meat and price. Those are set in the constructor along with
// an appropriate name for the type of burger.
//
//Two methods, addHealthyAddition1 and addHealthyAddition2 should be created that each accept
// a name and price for the addition, allowing for up to two(2) addons to the basic healthy burger.

// And finally the itemizeHamburger method created in the Hamburger class should be overridden
// to generate a message appropriate to the type of burger along with any addons.
// The method also returns the total price of the healthy burger of type double.