package com.gmail.mekhanich.andrii;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	    final Class<?> cls = Saver.class;

        if (cls.isAnnotationPresent(MyAnnotations.class)){
            MyAnnotations man = cls.getAnnotation(MyAnnotations.class);
            Saver safe = new Saver(new TextContainer("Hello World!"), new File(man.path()));
            safe.saveTo();

        }
    }
}
