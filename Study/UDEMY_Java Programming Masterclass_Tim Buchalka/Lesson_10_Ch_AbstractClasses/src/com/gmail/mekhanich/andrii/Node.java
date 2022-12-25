package com.gmail.mekhanich.andrii;

public class Node extends ListItem{
    public Node(Object currentObject) {
        super(currentObject);
    }

    @Override
    public ListItem nextItem() {
        return this.getRightObject();
    }

    @Override
    public ListItem previousItem() {
        return this.getLeftObj();
    }

    @Override
    public void setNextItem(ListItem item) {
       this.setRightObject(item);
    }

    @Override
    public void setPreviousItem(ListItem item) {
        if(item == null){
            this.setLeftObj(null);
        } else this.setLeftObj(item);
    }

    @Override
    public int comapreTo(ListItem item) {
        return ((String) super.getCurrentObject()).compareTo((String) item.getCurrentObject());
    }

}
