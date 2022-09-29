package com.gmail.mekhanich.andrii;


public class TextContainer {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


}
