package com.retailer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "product_languages")
public class ProductLanguageEntity implements Serializable
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_language_id", nullable = false)
    private Integer productLanguageId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "locale")
    private String locale;
    
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_currency")
    private String productCurrency;
    
    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_short_description")
    private String productShortDescription;
    
    @Column(name = "product_description")
    private String productDescription;

	public Integer getProductLanguageId() {
		return productLanguageId;
	}

	public void setProductLanguageId(Integer productLanguageId) {
		this.productLanguageId = productLanguageId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductShortDescription() {
		return productShortDescription;
	}

	public void setProductShortDescription(String productShortDescription) {
		this.productShortDescription = productShortDescription;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "ProductLanguageEntity [productLanguageId=" + productLanguageId + ", productId=" + productId
				+ ", locale=" + locale + ", productName=" + productName + ", productCurrency=" + productCurrency
				+ ", productPrice=" + productPrice + ", productShortDescription=" + productShortDescription
				+ ", productDescription=" + productDescription + "]";
	}

}
