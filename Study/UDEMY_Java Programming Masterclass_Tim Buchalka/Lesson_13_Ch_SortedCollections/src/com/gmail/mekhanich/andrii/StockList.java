package com.gmail.mekhanich.andrii;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public StockItem get(String key) {
        return this.list.get(key);
    }

    public int addStock(StockItem item) {
        if (item != null) {
//            StockItem inStock = list.getOrDefault(item.getName(), item);
            StockItem inStock = list.get(item.getName());
            if (inStock != null) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int unreserve(String item, int quantity) {
        StockItem currentItem = list.getOrDefault(item, null);

        if(currentItem != null){
            currentItem.setBookedQuantity(currentItem.getBookedQuantity()-quantity);
            System.out.println("Unreserved " + quantity);
            return quantity;
        }
        return 0;
    }


    public int bookItems(String item, int quantity) {
//        System.out.println("bookItems");
        StockItem currentItem = list.getOrDefault(item, null);
        if (currentItem != null && currentItem.quantityInStock() - currentItem.getBookedQuantity() >= quantity
                && quantity > 0) {

            currentItem.setBookedQuantity(quantity);
            System.out.println("booked " + currentItem.getBookedQuantity());
            return quantity;
        }
        System.out.println("You can`t reserve this quantity");
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null)) {
            inStock.setBookedQuantity(inStock.getBookedQuantity() - quantity);
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> priceList = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            priceList.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(priceList);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() +
                    " in stock. Value of items is " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
