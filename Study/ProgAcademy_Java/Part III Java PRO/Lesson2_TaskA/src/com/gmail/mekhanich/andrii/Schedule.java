package com.gmail.mekhanich.andrii;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="trains")
public class Schedule {

    public Schedule() {
    }

    @XmlElement(name="train")
    private List<Train> graph = new ArrayList<Train>();

    public List<Train> getGraph() {
        return graph;
    }

    public void addTrain (Train train){
        try {
            train.setTruDate();
            graph.add(train);
            } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "graph=" + graph +
                '}';
    }
}
