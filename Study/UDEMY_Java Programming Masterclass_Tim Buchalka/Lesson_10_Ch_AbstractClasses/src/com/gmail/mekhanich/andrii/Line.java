package com.gmail.mekhanich.andrii;

public class Line {
    private ListItem mainItem;

    public Line() {
    }

    public boolean addItem(ListItem item) {
        if (this.mainItem == null) {
            this.mainItem = item;
            return true;
        } else {
            int comapreResult = item.comapreTo(this.mainItem);
            if (comapreResult < 0) {
                this.checkLeftPosition(this.mainItem, item);
            } else if (comapreResult > 0) {
                this.checkRightPosition(this.mainItem, item);
            }
        }
        return true;
    }

    public boolean removeItem(ListItem item) {
        boolean isRemoved = false;
        ListItem next = this.mainItem;
//      first of all check condition when this item is the last element of sequence
        if (item.nextItem() == null) {

            ListItem lastInLine = item.previousItem();
            lastInLine.setRightObject(null);
            positionSetter(lastInLine.previousItem(), lastInLine, null);
            isRemoved = true;

        } else {
            while (next.nextItem() != null) {
                if (next.getCurrentObject() == item.getCurrentObject()) {
//              Looking for left Object
                    ListItem leftObject = item.previousItem();
                    if (leftObject == null) {
//                  if this item is first in line = just take next and set his first position is null
                        this.mainItem = item.nextItem();
                        this.mainItem.setPreviousItem(null);
                        positionSetter(null, this.mainItem, this.mainItem.nextItem());
                    } else {
//              set new order for member before deleted
                        positionSetter(leftObject.previousItem(), leftObject, item.nextItem());
//              set new order for member after deleted
                        positionSetter(leftObject, item.nextItem(), (item.nextItem()).nextItem());
                    }
                    isRemoved = true;
                    break;
                } else {
                    next = next.nextItem();
                }
            }
        }
        return isRemoved;
    }

    public ListItem next(ListItem item) {
        return (item.nextItem() == null) ? null : item.nextItem();
    }

    public ListItem previous(ListItem item) {
        return (item.previousItem() == null) ? null : item.previousItem();
    }

    public void lineToPrint() {
        System.out.println("******");
        System.out.println(this.mainItem + ";");
        ListItem next = this.mainItem;
        while (next.nextItem() != null) {
            next = next.nextItem();
            System.out.println(next + ";");
        }
        System.out.println("******");
    }

    public boolean checkLeftPosition(ListItem currentItem, ListItem item) {
        boolean isPlaced = false;
        positionSetter(null, item, currentItem);
        this.mainItem = item;
        return !isPlaced;
    }

    public boolean checkRightPosition(ListItem currentItem, ListItem item) {
        boolean isPlaced = false;
        ListItem rightObject = currentItem.nextItem();
        if (rightObject != null) {
            int result = item.comapreTo(rightObject);
            if (result < 0) {
                ListItem tmpObject = rightObject;
                rightObject = item;
                positionSetter(currentItem, rightObject, null);
                checkRightPosition(item, tmpObject);

            } else if (result > 0) {
                checkRightPosition(rightObject, item);
            }
        } else {
            positionSetter(currentItem, item, null);
            return !isPlaced;
        }
        return isPlaced;
    }

    public void positionSetter(ListItem left, ListItem central, ListItem right) {
        if (left == null) {
            central.setNextItem(right);
            right.setPreviousItem(central);
        } else if (left != null && right != null) {
            left.setNextItem(central);
            central.setPreviousItem(left);
            central.setNextItem(right);
            right.setPreviousItem(central);
        } else {
            left.setNextItem(central);
            central.setPreviousItem(left);
        }
    }
}


