package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable> {
    private List<T> elementList = new ArrayList<>();

    public Layer() {
    }

    public void addElement(T place){
       this.elementList.add(place);
    }


    public void render(){
        for (var element: elementList) {
            element.render();
        }
    }
}
