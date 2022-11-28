public class Main {
    public static void main(String[] args) {
        System.out.println(getDurationString(1650, 15)); // 27h 30m 15s
        System.out.println(getDurationString(1650)); //00h 27m 30s
        System.out.println(getDurationString(-1650)); //Invalid parameters
        System.out.println(getDurationString(-1650, 15)); // Invalid parameters
        System.out.println(getDurationString(1650, -15)); // Invalid parameters

    }

    public static String getDurationString(int minutes, int seconds) {
        int totalSeconds = minutes * 60 + seconds;
        int resHours = totalSeconds / 3600;
        int resMinutes = (totalSeconds % 3600) / 60;
        int resSeconds = (totalSeconds % 3600) % 60;

        return (minutes < 0 || (seconds > 59 || seconds < 0)) ? "Invalid parameters" : convertNumber(resHours) + "h " + convertNumber(resMinutes) + "m " + convertNumber(resSeconds) + "s";
    }

    public static String getDurationString(int seconds) {

        int resMinutes = seconds / 60;
        int resSeconds = (seconds % 3600) % 60;

        return (seconds < 0) ? "Invalid parametrs" : getDurationString(resMinutes, resSeconds);
    }

    public static String convertNumber(int number) {
        return (number < 10) ? "0" + number : "" + number;
    }
}