package com.gmail.mekhanich.andrii;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@MyAnnotations
public class Saver {
    private TextContainer text;
    private File a;

    public Saver(TextContainer text) {
        this.text = text;
    }

    public Saver(TextContainer text, File a) {
        this.text = text;
        this.a = a;
    }

    public void setText(TextContainer text) {
        this.text = text;
    }

    @Method
    public void saveTo (){
        try(PrintWriter pw = new PrintWriter(new FileWriter(this.a))){
            pw.print(this.text.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Well Done!");
    }
}
