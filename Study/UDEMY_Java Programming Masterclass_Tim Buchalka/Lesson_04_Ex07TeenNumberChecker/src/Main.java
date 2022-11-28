public class Main {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(25, 15, 42));
        System.out.println(hasTeen(22, 23, 34));
        System.out.println(hasTeen(13, 23, 34));
        System.out.println(hasTeen(22, 23, 19));

    }

    public static boolean hasTeen(int one, int two, int three) {
        if(isTeen(one) || isTeen(two)|| isTeen(three)){
            return true;
        }
        return false;
    }

    public static boolean isTeen(int one) {
        if(one>=13 && one<=19){
            return true;
        } else {
            return false;
        }
    }

}