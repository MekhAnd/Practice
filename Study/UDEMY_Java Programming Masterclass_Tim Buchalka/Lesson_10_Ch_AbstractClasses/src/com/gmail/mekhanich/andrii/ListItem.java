package com.gmail.mekhanich.andrii;

public abstract class ListItem {
    private ListItem leftObj;  //protected in Tim solution
    private ListItem rightObject; //protected in Tim solution
    private Object currentObject; //protected in Tim solution

    public ListItem(Object currentObject) {
        this.currentObject = currentObject;
    }

    public Object getCurrentObject() {
        return currentObject;
    }

    public void setCurrentObject(Object currentObject) {
        this.currentObject = currentObject;
    }

    public ListItem getLeftObj() {
        return leftObj;
    }

    public ListItem getRightObject() {
        return rightObject;
    }

    public void setLeftObj(ListItem leftObj) {
        this.leftObj = leftObj;
    }

    public void setRightObject(ListItem rightObject) {
        this.rightObject = rightObject;
    }

    public abstract ListItem nextItem(); //not public in Tim Solution
    public abstract ListItem previousItem(); //not public in Tim Solution
    public abstract void setNextItem(ListItem item); //not public in Tim Solution
    public abstract void setPreviousItem(ListItem item); //not public in Tim Solution
    public abstract int comapreTo(ListItem item);

    @Override
    public String toString() {
        return "ListItem{" +
                "current Object=" + currentObject +
                '}';
    }
}
