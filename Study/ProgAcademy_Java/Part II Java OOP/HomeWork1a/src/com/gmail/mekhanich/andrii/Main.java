package com.gmail.mekhanich.andrii;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Goods firstProduct = new Goods();
		firstProduct.setArticle("A0001");
		firstProduct.setProductBrand("ACER");
		firstProduct.setProductGroup("Computer Engineering");
		firstProduct.setProductSubGroup("Laptop");
		firstProduct.setProductName("Aspire 3");
		firstProduct.setSaleInPrice(15000);
		firstProduct.setSaleOutPrice(20000);

		Goods secondProduct = new Goods("A0002", "Computer Engineering", "Laptop", "ACER", "Aspire 5", 25000, 35000);
		Goods thirdProduct = new Goods("A0003", "Computer Engineering", "Laptop", "ACER", "Aspire 1", 7500, 10000);
		Goods fourthProduct = new Goods("A0004", "Computer Engineering", "Laptop", "ACER", "Aspire 2", 1000, 12000);

		Goods[] productArray = new Goods[] { firstProduct, secondProduct, thirdProduct, fourthProduct };
		
		for (Goods goods : productArray) {
			System.out.println(goods);
		}
		
		System.out.println();
		System.out.println("The best margin in: "+bestMargin(productArray));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Point the changes in price, in percentages:");
		double precents = sc.nextDouble();
		
		setSaleOutPrice(precents, productArray);
		
		for (Goods goods : productArray) {
			System.out.println(goods);
		}
		
		System.out.println();
		System.out.println("The best margin in: "+bestMargin(productArray));
		sc.close();
		
	}
	public static Goods bestMargin (Goods[] productArray) {
		Goods bestMargin = productArray[0];
		for (Goods goods : productArray) {
			if(goods.getMargin() > bestMargin.getMargin()) {
				bestMargin = goods;
			}
		}
		return bestMargin;
	}
	
	public static Goods [] setSaleOutPrice(double presents, Goods [] productArray) {
		for (Goods goods : productArray) {
			goods.setSaleOutPrice(goods.getSaleOutPrice() + goods.getSaleOutPrice() * (presents/100));
		}
		return productArray;
	}
}
