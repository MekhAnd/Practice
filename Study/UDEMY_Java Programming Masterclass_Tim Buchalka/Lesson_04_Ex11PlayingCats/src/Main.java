public class Main {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
    }

    public static boolean isCatPlaying (boolean summer, int temperature){
        return (summer &&temperature>=25 ) ? ((temperature<=45)? true: false) :((temperature<=35)? true: false);
    }
}