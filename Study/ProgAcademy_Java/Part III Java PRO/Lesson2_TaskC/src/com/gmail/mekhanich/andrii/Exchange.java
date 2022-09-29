package com.gmail.mekhanich.andrii;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "exchange")
public class Exchange {

    @XmlElement(name = "currency")
    private List <Currency> rate= new ArrayList<>();

    public Exchange() {
    }


    public void addCurrency (Currency a){
        rate.add(a);
    }


    @Override
    public String toString() {
        return "Exhange{" + "rate=" + rate +'}';
    }
}
