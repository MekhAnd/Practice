public class Main {
    public static void main(String[] args) {
       Worker new01 = new Worker ("Andrii", "11/01/1976");
       Employee new02 = new Employee("Andii01", "12/02/1980", "2023");
       HourlyEmployee new03 = new HourlyEmployee("Mary", "05/05/1970", "03/03/2021", 51);

        System.out.println(new01.getAge());
        System.out.println(new02.getAge());

        System.out.println(new01.collectPay());
        System.out.println(new02.collectPay());
        System.out.println(new02);

        SalariedEmployee joe = new SalariedEmployee("Joe", "11/11/1998", "03/03/2020", 35000);

        System.out.println(joe);

        System.out.println(joe.collectPay());
        System.out.println();
        joe.retire();
        System.out.println(joe.collectPay());
        System.out.println();

        System.out.println(new03);
        System.out.println(new03.collectPay());
        System.out.println(new03.getDoublePay());


    }
}
