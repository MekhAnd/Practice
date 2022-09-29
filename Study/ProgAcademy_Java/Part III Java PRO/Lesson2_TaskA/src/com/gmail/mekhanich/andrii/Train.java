package com.gmail.mekhanich.andrii;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement (name="train")
public class Train {

    private String id;
    private String from;
    private String to;
    private String date;
    private String departure;
    private Date sdfDate;


    public Train() throws ParseException {
    }

    public Train(String id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train "+ "{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", date=" + date +", departure=" + departure + ", Date=" + sdfDate+'}';
    }

    public String getId() {return id;}

    public String getFrom() {return from;}

    public String getTo() {return to;}

    public String getStrDate() {return date;}

    public String getStrDeparture() {return departure;}

    public Date getSdfDate() {return sdfDate;}

    @XmlElement (name="id")
    public void setId(String id){
        this.id = id;
    }

    @XmlElement (name = "from")
    public void setFrom(String from) {
        this.from = from;
    }
    @XmlElement (name = "to")
    public void setTo(String to) {
        this.to = to;
    }
    @XmlElement (name = "date")
    public void setStrDate(String date) {
        this.date = date;
    }
    @XmlElement (name = "departure")
    public void setStrDeparture(String departure) {
        this.departure = departure;
    }

    public  Date setTruDate() throws ParseException {
        String time = this.date + " " + this.departure;
        this.sdfDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(time);
        return sdfDate;
    }
}

//Date truDate = new SimpleDateFormat().parse(a);
//Date truTime = new SimpleDateFormat("").parse(b);