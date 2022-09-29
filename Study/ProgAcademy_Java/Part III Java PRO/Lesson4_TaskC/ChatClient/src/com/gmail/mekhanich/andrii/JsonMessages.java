package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;



    public JsonMessages(List<Message> sourceList, int fromIndex) {
        this.list = new ArrayList<>();

        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
    }

    public List<Message> getList() {
        return Collections.unmodifiableList(list);
    }
}