package com.retailer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "categories")
public class ProductCategory implements Serializable{
	
	@Id
	@Column(name = "category_id", nullable = false)
	private String categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_type")
	private String categoryType;
	
	@Column(name = "tax_percentage")
    private String taxPercentage;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", taxPercentage=" + taxPercentage + "]";
	}
	
}
