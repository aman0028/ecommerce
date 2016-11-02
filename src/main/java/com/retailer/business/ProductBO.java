package com.retailer.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retailer.dao.ProductDAO;
import com.retailer.entity.ProductEntity;

@Component
public class ProductBO
{
	@Autowired
	private ProductDAO productDAO;
	
	public ProductBO(){}
	
	public List<ProductEntity> getProducts(String locale) 
	{
		return productDAO.getProductByLocale(locale);
	}

	public ProductEntity getProductById(String productId) 
	{
		 List<ProductEntity> products = productDAO.getProductById(productId);
		 if(products.isEmpty())
			  return null;
		 return products.get(0);
	}

}
