public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer() {
    }

    public Printer(int tonerLevel, boolean duplex) {
//        if (tonerLevel < 0) this.tonerLevel = -1;
//        else if(tonerLevel > 100) this.tonerLevel = -1;
//        else this.tonerLevel = tonerLevel;

        this.tonerLevel = ((tonerLevel < 0) && (tonerLevel > 100) ) ? -1 : tonerLevel; // Tim`s solution
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner( int tonerAmount){
//        if(tonerLevel + tonerAmount > 100){
//            return -1;
//        } else if (tonerLevel + tonerAmount <0){
//            return -1;
//        } else {
//            return tonerLevel += tonerAmount;
//        }
        if(tonerLevel + tonerAmount > 100 || tonerLevel + tonerAmount <0) return -1;        // Tim`s solution
        return tonerLevel += tonerAmount;
    }

    public int printPages(int pages){
        if(duplex){
            System.out.println("Duplex mode on");
            pagesPrinted += (pages / 2 + pages % 2);
        } else {
            System.out.println("Duplex mode off");
            pagesPrinted += pages;
        }
        return pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
