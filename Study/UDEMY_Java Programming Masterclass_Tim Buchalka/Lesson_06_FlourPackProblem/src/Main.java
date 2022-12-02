public class Main {
    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4)); //false
        System.out.println();
        System.out.println(canPack(1, 0, 5)); //true
        System.out.println();
        System.out.println(canPack(0, 5, 4)); //true
        System.out.println();
        System.out.println(canPack(2, 2, 11)); //true
        System.out.println();
        System.out.println(canPack(1, 12, -3)); //false
        System.out.println();
        System.out.println(canPack(2, 1, 5)); //true
        System.out.println();
        System.out.println(canPack(0, 5, 5)); //true
        System.out.println();
        System.out.println(canPack(2, 10, 18)); //true
        System.out.println();
        System.out.println(canPack(1, 0, 6)); //false
        System.out.println();
        System.out.println(canPack(5, 3, 24)); //false
        System.out.println();
        System.out.println(canPack(2, 1, 5)); //true
        System.out.println();
        System.out.println(canPack(0, 60, 25)); //true
        System.out.println();
        System.out.println(canPack(2, 10, 20)); //true

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        boolean pack = false;
        int needBigPack = goal / 5;
        int needSmallPack = goal % 5;

        if (bigCount < 0 || smallCount < 0 || goal < 0 || (bigCount * 5 + smallCount) < goal) pack = false;
        else if (bigCount * 5 + smallCount == goal) pack = true;
        else {
            if (bigCount == 0) {
                if (smallCount >= goal) pack = true;
            } else if (smallCount == 0) {
                if (goal % 5 <= bigCount) pack = true;
            } else {
                if (needBigPack <= bigCount && needSmallPack <= smallCount) pack = true;
                else if (needBigPack > bigCount && (goal - bigCount * 5) < smallCount) pack = true;
                else {
                    pack = false;
                    System.out.println("bigCount " + bigCount + "; smallCount " + smallCount + "; goal " + goal);
                    System.out.print("needBigPack " + needBigPack + "; needSmallPack " + needSmallPack + "; result is ->");
                }
            }
        }

        return pack;
    }
}


//Flour Pack Problem
//
//Write a method named canPack with three parameters of type int named bigCount, smallCount, and goal.
///The parameter bigCount represents the count of big flour bags (5 kilos each).
//The parameter smallCount represents the count of small flour bags (1 kilo each).
//The parameter goal represents the goal amount of kilos of flour needed to assemble a package.
//
//Therefore, the sum of the kilos of bigCount and smallCount must be at least equal to the value of goal. The method should return true if it is possible to make a package with goal kilos of flour.
//If the sum is greater than goal, ensure that only full bags are used towards the goal amount. For example, if goal = 9, bigCount = 2, and smallCount = 0, the method should return false since each big bag
// is 5 kilos and cannot be divided.
// However, if goal = 9, bigCount = 1, and smallCount = 5, the method should return true because of 1 full bigCount bag and 4 full smallCount bags equal goal, and it's okay if there are additional bags left over.
//If any of the parameters are negative,return false.
//
//
//EXAMPLE INPUT/OUTPUT:
//
//    canPack(1, 0, 4); should return false since bigCount is 1 (big bag of 5 kilos) and goal is 4 kilos.
//    canPack(1, 0, 5); should return true since bigCount is 1 (big bag of 5 kilos) and goal is 5 kilos.
//    canPack(0, 5, 4); should return true since smallCount is 5 (small bags of 1 kilo) and goal is 4 kilos, and we have 1 bag left which is ok as mentioned above.
//    canPack(2, 2, 11); should return true since bigCount is 2 (big bags 5 kilos each) and smallCount is 2 (small bags of 1 kilo), makes in total 12 kilos and goal is 11 kilos. 
//    canPack(-3, 2, 12); should return false since bigCount is negative.

//
//NOTE: The method canPack should be defined as public static like we have been doing so far in the course.
//
//NOTE: Do not add a main method to the solution code.