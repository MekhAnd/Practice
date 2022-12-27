package com.gmail.mekhanich.andrii;

public class ScopeCheck {

    public int publicVar = 0;
    private int var01 = 1;

    public ScopeCheck() {
        System.out.println("Created with publicVar = " + publicVar + " privateVar = " + var01 );
    }

    public int getPrivateVar() {
        return var01;
    }

    public void timesTwo(){
        int var02 = 2;
        for(int i = 0; i<10; i++){
            System.out.println(i + " times two is " + i* var02);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("var03 from outer class: " +innerClass.var03);
    }

    public class InnerClass{
        private int var03 = 3;

        public InnerClass() {
            System.out.println("InnerClass created. PrivateVar (var03) is " + var03
                    + "PrivateVar (var01) is " + var01 );
        }

        public void timesTwo(){
            System.out.println("*".repeat(10));
            System.out.println("var01 is steal available here " + var01);
            for(int i = 0; i<10; i++){
                System.out.println(i + " times two is " + i* var03);
            }
        }
    }
}
