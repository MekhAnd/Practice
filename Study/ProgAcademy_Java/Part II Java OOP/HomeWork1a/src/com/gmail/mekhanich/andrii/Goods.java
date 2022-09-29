package com.gmail.mekhanich.andrii;

public class Goods {
	
	private String article;
	private String productGroup;
	private String productSubGroup;
	private String productBrand;
	private String productName;
	private double saleInPrice;
	private double saleOutPrice;
	
	public Goods(String article, String productGroup, String productSubGroup, String productBrand, String productName,
			double saleInPrice, double saleOutPrice) {
		super();
		this.article = article;
		this.productGroup = productGroup;
		this.productSubGroup = productSubGroup;
		this.productBrand = productBrand;
		this.productName = productName;
		this.saleInPrice = saleInPrice;
		this.saleOutPrice = saleOutPrice;
	}

	public Goods() {
		super();
	}
	
	
	
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductSubGroup() {
		return productSubGroup;
	}

	public void setProductSubGroup(String productSubGroup) {
		this.productSubGroup = productSubGroup;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSaleInPrice() {
		return saleInPrice;
	}

	public void setSaleInPrice(double saleInPrice) {
		this.saleInPrice = saleInPrice;
	}

	public double getSaleOutPrice() {
		return saleOutPrice;
	}

	public void setSaleOutPrice(double saleOutPrice) {
		this.saleOutPrice = saleOutPrice;
	}

	public double getMargin () {
		double margin = (saleOutPrice - saleInPrice) / saleInPrice;
		return margin;
	}
	
	
	
	@Override
	public String toString() {
		return "Goods [article=" + article + ", productGroup=" + productGroup + ", productSubGroup=" + productSubGroup
				+ ", productBrand=" + productBrand + ", productName=" + productName + ", saleInPrice=" + saleInPrice
				+ ", saleOutPrice=" + saleOutPrice + "]";
	}
	
	
}
