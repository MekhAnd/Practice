package com.gmail.mekhanich.andrii;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Milk", 1.25, 25);
        stockList.addStock(temp);

        temp = new StockItem("Cheese", 4.10, 50);
        stockList.addStock(temp);

        temp = new StockItem("Beef", 3.50, 12);
        stockList.addStock(temp);

        temp = new StockItem("Butter", 3.10, 15);
        stockList.addStock(temp);

        temp = new StockItem("Coffee", 1.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Coffee", 1.25, 50);
        stockList.addStock(temp);

        temp = new StockItem("Tea", 5.10, 100);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.40, 50);
        stockList.addStock(temp);

        temp = new StockItem("Mineral Vater", 1.50, 150);
        stockList.addStock(temp);

        temp = new StockItem("Sausages", 4.10, 9);
        stockList.addStock(temp);

        temp = new StockItem("Tomatoes", 0.75, 50);
        stockList.addStock(temp);

        System.out.println(stockList);
        System.out.println();
        for (String s : stockList.Items().keySet()) {
            System.out.println(s);

        }

        Basket my = new Basket("Andrii");
        sellItem(my, "Coffee", 1);
        System.out.println(my);

        sellItem(my, "Cheese", 1);
        sellItem(my, "Sausages", 2);
        sellItem(my, "Bread", 2);

        System.out.println(my);

        sellItem(my, "Cake", 7);
        sellItem(my, "Vodka", 2);

        System.out.println(my);

        sellItem(my, "Cake", 7);
        System.out.println(my);

        System.out.println();
        System.out.println();

        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
//        Exception in thread "main" java.lang.UnsupportedOperationException
//	        at java.base/java.util.Collections$UnmodifiableMap.put(Collections.java:1505)
//	        at com.gmail.mekhanich.andrii.Main.main(Main.java:77)

        stockList.Items().get("Coffee").adjustStock(-20000);
        stockList.get("Coffee").adjustStock(-20000);
        System.out.println();

        System.out.println(stockList);

        for(Map.Entry<String, Double> price: stockList.priceList().entrySet()){
            System.out.println(price.getKey() +  ".".repeat(20) + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don`t sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBacket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}