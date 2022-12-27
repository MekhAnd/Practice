package com.gmail.mekhanich.andrii;

public class X {
    private int x;

    public X(int x) {
        this.x = x;
    }

    public long getX() {
        return x;
    }

    public void times(){
        for(int x = 1; x<12 ; x++){
            System.out.println("This number " + this.x + " times " + x + " is " + this.x*x);
        }
    }
}
