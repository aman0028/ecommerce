package com.retailer.visitor;

import com.retailer.entity.ProductCategory;
import com.retailer.entity.ProductEntity;

public interface ShoppingCartVisitor 
{
	public double visit(ProductEntity product, ProductCategory category, Integer quantity);

}
