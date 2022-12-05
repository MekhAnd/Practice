public class SalariedEmployee extends Employee{

    private double annualSallary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate,String hireDate, double annualSallary) {
        super(name, birthDate, hireDate);
        this.annualSallary = annualSallary;
        this.isRetired = false;
    }

    @Override
    public double collectPay(){

        double paycheck = annualSallary / 26;
        double adjustedPay = (isRetired)? 0.9 *paycheck: paycheck;

        return (int) adjustedPay;
    }

    public void retire() {

        terminate("12/12/2025");
        isRetired = true;

//        if(!isRetired){
//            isRetired = true;
//        }
//        return isRetired;
    }

}
