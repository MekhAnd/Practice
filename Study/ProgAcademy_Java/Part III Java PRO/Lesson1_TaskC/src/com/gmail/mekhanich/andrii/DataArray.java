package com.gmail.mekhanich.andrii;

import java.io.Serializable;
import java.util.Arrays;

public class DataArray implements Serializable {
    @Save private int a;
    @Save private String b;
    private String text;

    public DataArray() {
    }

    public DataArray(int a, String b) {
        this.a = a;
        this.b = b;
        this.text = "";
    }

    public DataArray(int a, String b, String text) {
        this.a = a;
        this.b = b;
        this.text = text;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "DataArray{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
