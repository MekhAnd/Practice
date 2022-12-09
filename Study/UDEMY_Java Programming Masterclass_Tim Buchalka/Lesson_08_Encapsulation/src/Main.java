public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player pl = new Player();
        PlayerEn plEn = new PlayerEn("Andrii", 85, "Rifle");
        PlayerEn plEn01 = new PlayerEn("Andrii", 200, "Rifle");
        PlayerEn plEn02 = new PlayerEn("Andrii");

        System.out.println("Initial health is " + plEn.healthRemaining());
        System.out.println("Initial health is " + plEn01.healthRemaining());
        System.out.println("Initial health is " + plEn02.healthRemaining());

        pl.name = "Andrii";
        pl.health = 20;
        pl.weapon = "Rifle";

        // plEn.name = Andrii;

        int damage = 10;

        pl.looseHealth(damage);
        System.out.println("Remaining health = " + pl.healthRemaining());

        pl.health = 200; //someone has direct control!!!!

        pl.looseHealth((11));
        System.out.println("Remaining health = " + pl.healthRemaining());


    }
}