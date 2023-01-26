package com.gmail.mekhanich.andrii;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 110);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket my = new Basket("Andrii");
        bookItemsToBasket(my, "Bread", 10);
        System.out.println(my);
        System.out.println();

        Basket my01 = new Basket("Kate");
        bookItemsToBasket(my01, "Bread", 10);

        unreseveItem(my01, "Bread", 5);

//        Basket my02 = new Basket("Luda");
//        bookItemsToBasket(my02, "Bread", 10);


        sellItems(my, "Bread", 10);
        sellItems(my01, "Bread", 5);

//
//        System.out.println(my01);



//        System.out.println(my02);



//        sellItems(my02, "Bread", 10);

        System.out.println(stockList);

    }

    public static int bookItemsToBasket(Basket basket, String item, int quantity) {
//        System.out.println("bookItemsToBasket");
        StockItem stockItem = stockList.get(item);

        if (stockItem == null) {
            System.out.println("We don`t sell " + item);
            return 0;
        }

        if (stockList.bookItems(item, quantity) != 0) {
            basket.addToBacket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static int sellItems (Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);

        if (stockItem == null) {
            System.out.println(" We don`t sell " + item);
            return 0;
        }
        if(basket.confirmOperations(stockItem, quantity)){
            stockList.sellStock(item, quantity);
        } else {
            System.out.println(basket.getName() + " You don`t booked this");
        }
        return 0;
    }

    public static int unreseveItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        System.out.println("unreseveItem " +stockItem);
        if (stockItem == null) {
            System.out.println("We don`t sell " + item);
            return 0;
        }
        System.out.println(basket.getName() + " unreseveItem " + stockItem);
        System.out.println(basket.confirmOperations(stockItem, quantity));
        if(basket.cancelOperations(stockItem, quantity)){
            System.out.println("Ok");
            stockList.unreserve(item, quantity);
            return quantity;
        }
        return 0;
    }

}