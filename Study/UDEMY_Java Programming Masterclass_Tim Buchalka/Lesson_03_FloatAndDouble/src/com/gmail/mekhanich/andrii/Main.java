package com.gmail.mekhanich.andrii;

public class Main {
    public static void main(String[] args) {
        float myMin = Float.MIN_VALUE;
        float myMax = Float.MAX_VALUE;

        double myDoubleMin = Double.MIN_VALUE;
        double myDoubleMax = Double.MAX_VALUE;


        System.out.println(myMin);
        System.out.println(myMax);
        System.out.println(myDoubleMin);
        System.out.println(myDoubleMax);

        int myIntValue = 5;
        float myFloatValue = (float)5.25; // incorrect when just 5.25 => need cast to double
        double myDoubleValue = 5.25;

        System.out.println("int 5/3 =>" + myIntValue/3);
        System.out.println("float 5.25/3.25 =>" + myFloatValue/3.25f); //float 5.25/3.25 =>1.6153846
        System.out.println("double 5.25/3.25 =>" + myDoubleValue/3.25); //double 5.25/3.25 =>1.6153846153846154
    }
}