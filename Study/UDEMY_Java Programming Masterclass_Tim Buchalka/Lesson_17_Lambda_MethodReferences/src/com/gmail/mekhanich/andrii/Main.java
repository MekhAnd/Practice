package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld{
    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Bob", "Anna", "Den", "Poul", "Kate"));
        list.forEach(s-> System.out.println(s));
        list.forEach(System.out::println);

        calculator((a,b)->a+b, 10, 12);
        calculator(Integer::sum, 10, 12);

        calculator((a,b)->a*b, 12.1, 11.1);

        Supplier<PlainOld> suppl = ()-> new PlainOld();
        Supplier<PlainOld> suppl01 = PlainOld::new;

        PlainOld newObj = suppl.get();
        PlainOld newObj1 = suppl01.get();

        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

    }

    private static <T> void calculator(BinaryOperator<T> function, T t1, T t2){
        T result =  function.apply(t1, t2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> ref, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i->ref.get());
        return array;
    }
}