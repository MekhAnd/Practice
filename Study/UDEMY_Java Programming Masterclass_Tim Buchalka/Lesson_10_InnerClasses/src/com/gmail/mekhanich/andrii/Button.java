package com.gmail.mekhanich.andrii;

public class Button {
    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListner(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public void onClick(){
        this.onClickListener.onCLick(this.title);
    }

    public interface OnClickListener {
        public void onCLick(String title);
    }
}
