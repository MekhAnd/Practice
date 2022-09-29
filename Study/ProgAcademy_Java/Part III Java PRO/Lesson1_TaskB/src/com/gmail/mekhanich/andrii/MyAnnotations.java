package com.gmail.mekhanich.andrii;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface  MyAnnotations {
    String path () default "G:\\Java_Enterprise_WorkSpace\\Homework\\LessonOne_TaskB\\safe.txt";
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Method{}
