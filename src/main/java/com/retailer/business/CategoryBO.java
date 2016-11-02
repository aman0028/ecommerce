package com.retailer.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retailer.dao.CategoryDAO;
import com.retailer.entity.ProductCategory;

@Component
public class CategoryBO {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryBO() {}

	public List<ProductCategory> getCategories() 
	{
		return categoryDAO.getAllCategories();
	}

	public ProductCategory getCategoryById(String categoryId) 
	{
		
		return categoryDAO.getCategoryById(categoryId);
	}

}
