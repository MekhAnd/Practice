package com.gmail.mekhanich.andrii;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this. list = new TreeMap<>();
    }

    public int addToBacket(StockItem item, int quantity){
        if((item !=null)&& (quantity >0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items (){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n Shopping busket " + name + " contains " + list.size() + (list.size() == 1 ?" item\n":" items\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item :list.entrySet()){
            s= s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + " Total cost " + totalCost;
    }
}
