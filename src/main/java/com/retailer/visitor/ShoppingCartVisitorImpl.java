package com.retailer.visitor;


import com.retailer.entity.ProductCategory;
import com.retailer.entity.ProductEntity;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	
	public double visit(ProductEntity product, ProductCategory category, Integer quantity)
	{
	    double sum = 0.0;
	    sum = quantity*(Double.parseDouble(product.getProductPrice()));
	    double taxAddedValue = Double.parseDouble(category.getTaxPercentage());
	    return sum + sum*(taxAddedValue/100);
	}

}
