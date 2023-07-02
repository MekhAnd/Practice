package com.gmail.mekhanich.andrii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String [] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items); // transform String [] to List
        System.out.println(list);

        System.out.println(list.getClass().getName());
//        list.add("chicken");// ERROR - ImmutableCollections$ListN

        ArrayList<String> griceries = new ArrayList<>(list);
        griceries.add("chicken");
        System.out.println(griceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("apples", "bananas", "milk", "eggs")
        );

        System.out.println(nextList);

        griceries.addAll(nextList);
        System.out.println("griceries - " +griceries );

        System.out.println("get from griceries 2nd element -" + griceries.get(2));

        if(griceries.contains("milk")){
            System.out.println("Contains");
        }

        griceries.add("milk");
        System.out.println("first =" + griceries.indexOf("milk") );
        System.out.println("last =" + griceries.lastIndexOf("milk") );

        griceries.remove(7);
        griceries.remove(6);
        griceries.remove(5);
        griceries.remove("milk");
        System.out.println(griceries);
        System.out.println(griceries.size());

        griceries.removeAll(List.of("milk", "eggs"));
        System.out.println(griceries);

        griceries.retainAll(List.of("eggs", "milk", "apples")); //clear all elements which do not exist in argument list
        System.out.println(griceries);

        griceries.clear();
        System.out.println(griceries);
        System.out.println(griceries.isEmpty());

        griceries.addAll(List.of("1","11","12","13","144"));
        griceries.addAll(Arrays.asList("1","11-1","12","131-","144-1"));
        System.out.println(griceries);

        griceries.sort(Comparator.naturalOrder());
        System.out.println(griceries);

        griceries.sort(Comparator.reverseOrder());
        System.out.println(griceries);

        var grArray = griceries.toArray(new String[griceries.size()]);
        System.out.println("Array ->" + Arrays.toString(grArray));
    }
}


