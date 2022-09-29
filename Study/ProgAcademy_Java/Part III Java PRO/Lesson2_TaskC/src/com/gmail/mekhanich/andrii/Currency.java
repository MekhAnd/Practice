package com.gmail.mekhanich.andrii;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "currency")
@XmlType(name = "currency")
public class Currency {

    private String r030;
    private String txt;
    private double rate;
    private String cc;
     private String exchangedate;

    public Currency() {
    }

    public Currency(String r030, String txt, double rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public String getR030() {
        return r030;
    }
    @XmlElement(name = "r030")
    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }
    @XmlElement(name ="txt")
    public void setTxt(String txt) {
        this.txt = txt;
    }

    public double getRate() {
        return rate;
    }
    @XmlElement(name = "rate")
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }
    @XmlElement (name = "cc")
    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }
    @XmlElement(name = "exchangedate")
    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }
    @Override
    public String toString() {
        return "Currency{" +
                "r030= " + r030 + "\t txt= " + txt +"\t rate=" + rate +"\t cc=" + cc + "\t exchangedate='" + exchangedate + '}'+"\n";
    }
}
