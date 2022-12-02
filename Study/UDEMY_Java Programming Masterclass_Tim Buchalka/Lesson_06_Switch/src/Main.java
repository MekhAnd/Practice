public class Main {
    public static void main(String[] args) {
        int value = 5;

        if (value == 1){
            System.out.println("Value was 1");
        } else if (value == 2){
            System.out.println("Value was 2");
        } else{
            System.out.println("Was not 1 or 2");
        }

        switch (value){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 3");
                break;
            case 3: case 4: case 5:
                System.out.println("Was a 3, a 4, a 5 ");
                System.out.println("Actually it was a " + value);
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }


//SWITCH AFTER JDK 11 (or 14)!?

        //        switch (value){
//            case 1 -> System.out.println("Value was 1");
//            case 2 -> System.out.println("Value was 3");
//            case 3, case 4, case 5 -> {
//                System.out.println("Was a 3, a 4, a 5 ");
//                System.out.println("Actually it was a " + value);
//            }
//            default -> System.out.println("Was not 1 or 2");
//
//        }

    }

    public static String getQuareter (String month){
        switch (month){
            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
                return "1st";
            case "APRIL":
            case "MAY":
            case "JUNE":
                return "2st";
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                return "3st";
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                return "4st";
            default:
                return "wrong";
        }
    }
}
//
//
//
//    }