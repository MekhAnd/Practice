package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {

        Node new01 = new Node("1");
        Node new02 = new Node("2");
        Node new03 = new Node("3");
        Node new04 = new Node("4");
        Node new05 = new Node("5");
        Node new06 = new Node("6");
        Node new07 = new Node("7");
        Node new08 = new Node("8");
        Node new09 = new Node("9");
        Node new10 = new Node("0");
        Node new11 = new Node("0");

        Line line = new Line();
        line.addItem(new10);
        line.addItem(new04);
        line.addItem(new09);
        line.addItem(new08);
        line.addItem(new02);
        line.addItem(new07);
        line.addItem(new03);
        line.addItem(new06);
        line.addItem(new04);
        line.addItem(new05);
        line.addItem(new01);

        line.lineToPrint();

        line.removeItem(new06);

        line.lineToPrint();

        line.removeItem(new10);

        line.lineToPrint();

        line.removeItem(new09);

        line.lineToPrint();

        System.out.println("Next");
        System.out.println(line.next(new08));
        System.out.println(line.next(new01));

        System.out.println("Previous");
        System.out.println(line.previous(new08));
        System.out.println(line.previous(new01));

        Line newLine = new Line();
        String stringData = "Melbourne Adelaide Sydney Brisbane Darwin Perth Melbourne";
        String [] data = stringData.split(" ");
        for(String word: data){
            newLine.addItem(new Node (word));
        }

        newLine.lineToPrint();
    }
}