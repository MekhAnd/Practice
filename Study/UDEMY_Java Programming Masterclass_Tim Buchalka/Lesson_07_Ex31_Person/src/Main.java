public class Main {
    public static void main(String[] args) {
    Person person =new Person();
    person.setFirstName("");// firstName is set to empty string
    person.setLastName("");// lastName is set to empty string

    System.out.println("fullName= " + person.getFullName());

        person.setFirstName("Andrii");// firstName is set to empty string
        person.setLastName("");// lastName is set to empty string

        System.out.println("fullName= " + person.getFullName());

        person.setFirstName("");// firstName is set to empty string
        person.setLastName("Mekhanich");// lastName is set to empty string

        System.out.println("fullName= " + person.getFullName());

        person.setFirstName("Andrii");// firstName is set to empty string
        person.setLastName("Mekhanich");// lastName is set to empty string

        System.out.println("fullName= " + person.getFullName());

    }
}