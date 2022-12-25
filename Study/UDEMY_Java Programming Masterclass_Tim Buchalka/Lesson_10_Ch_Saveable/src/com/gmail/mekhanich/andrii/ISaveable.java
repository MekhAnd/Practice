package com.gmail.mekhanich.andrii;

import java.util.ArrayList;

public interface ISaveable {
    public ArrayList saved(Object obj);
    public Object populate (ArrayList saved, String name);
    public ArrayList getList();
}
