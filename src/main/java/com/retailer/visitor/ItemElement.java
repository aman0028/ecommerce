package com.retailer.visitor;

import com.retailer.entity.ProductCategory;

public interface ItemElement 
{
	public double accept(ShoppingCartVisitor shoppingCartVisitor, ProductCategory category, Integer quantity);
}
