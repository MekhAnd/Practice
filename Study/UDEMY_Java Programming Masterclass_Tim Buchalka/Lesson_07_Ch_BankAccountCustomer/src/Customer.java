public class Customer {
    private String customerName;
    private double cuctomerCreditLimit;
    private String customerEmail;

    public Customer(String customerName, double cuctomerCreditLimit, String customerEmail) {
        this.customerName = customerName;
        this.cuctomerCreditLimit = cuctomerCreditLimit;
        this.customerEmail = customerEmail;
        System.out.println("Full constructor!");
    }

    public Customer(String customerName, String customerEmail) {
        this(customerName, 0.00, customerEmail);
        System.out.println("Two parameters constructor!");
    }

    public Customer() {
        this("Default Name", "Default e-mail");
        System.out.println("Empty parameters constructor!");
    }


    public String getCustomerName() {
        return customerName;
    }

    public double getCuctomerCreditLimit() {
        return cuctomerCreditLimit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", cuctomerCreditLimit=" + cuctomerCreditLimit +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
