package com.gmail.mekhanich.andrii;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface MyAnnotations {
}

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Save{}