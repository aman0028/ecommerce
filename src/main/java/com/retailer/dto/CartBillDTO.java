package com.retailer.dto;

public class CartBillDTO {

	private String productId;
	private String productName;
	private Integer quantity;
	private String categoryId;
	private String pricePerProduct;
	private String productCurrency;
	private String categoryName;
	private String categoryTaxPercentage;
	private Double totalAmount;
	
	public CartBillDTO(String productId, 
			           String productName, 
			           Integer quantity, 
			           String categoryId, 
			           String pricePerProduct,
			           String productCurrency, 
			           String categoryName, 
			           String categoryTaxPercentage) 
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.pricePerProduct = pricePerProduct;
		this.productCurrency = productCurrency;
		this.categoryName = categoryName;
		this.categoryTaxPercentage = categoryTaxPercentage;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTaxPercentage() {
		return categoryTaxPercentage;
	}

	public void setCategoryTaxPercentage(String categoryTaxPercentage) {
		this.categoryTaxPercentage = categoryTaxPercentage;
	}

	public String getPricePerProduct() {
		return pricePerProduct;
	}

	public void setPricePerProduct(String pricePerProduct) {
		this.pricePerProduct = pricePerProduct;
	}

	@Override
	public String toString() {
		return "CartBillDTO [productId=" + productId + ", productName=" + productName + ", productCurrency="
				+ productCurrency + ", categoryName=" + categoryName + ", categoryTaxPercentage="
				+ categoryTaxPercentage + ", pricePerProduct=" + pricePerProduct + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + ", categoryId=" + categoryId + "]";
	}
	

}
