package com.gmail.mekhanich.andrii;

@FunctionalInterface
public interface Operations <T> {
    T operate (T value1, T value2);
}
