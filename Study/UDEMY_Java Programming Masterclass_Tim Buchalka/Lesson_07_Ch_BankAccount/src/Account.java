import java.sql.SQLOutput;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() {
        this("L000023041977", 2.5, "Unknown name", "Unknown address", "Unknown number");
        System.out.println("Empty constructor called!");
    }

    public Account(String customerName, String email, String phoneNumber) {
        this("K000021061999", 0.0, customerName, email, phoneNumber);
    }

    public Account(String number, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("Constructor with parametrs called!");

        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void depositFounds(double sum) {
        this.setBalance(this.getBalance() + sum);
        System.out.println("Successfully operation. Your new balance is " + this.getBalance());
    }

    public void withdrawFounds(double sum) {
        if (this.getBalance() >= sum) {
            this.setBalance(this.getBalance() - sum);
            System.out.println("Successfully operation. Your new balance is " + this.getBalance());
        } else {
            System.out.println("This operation is impossible! There is not enogth money");
        }
    }


}
