public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            LPAStudent s = new LPAStudent("0001" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Kisa";
                        default -> "Annonymous";
                    }, "11/0" + i + "/2022", "Java");

            System.out.println(s);
        }

        Student pojoStudent = new Student("000001", "Ann",
                "05/05/1995", "Java Masterclass");
        LPAStudent recordStudent = new LPAStudent("000002", "Kate",
                "21/06/1999", "Java Masterclass");

        System.out.println(recordStudent.name() + " " + pojoStudent.getName());


    }
}