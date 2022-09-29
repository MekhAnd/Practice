package com.gmail.mekhanich.andrii;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    int parametrOne() default 2;

    int parametrTwo() default 5;
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Method {
}