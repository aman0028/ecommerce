package com.retailer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.retailer.entity.ProductCategory;

@Component
public class CategoryDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public CategoryDAO(){}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ProductCategory> getAllCategories() 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductCategory.class);
		criteria.addOrder(Order.asc("categoryName"));
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ProductCategory getCategoryById(String categoryId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductCategory.class);
		criteria.add(Restrictions.eq("categoryId", categoryId));
		List<ProductCategory> list = criteria.list();
        if(!list.isEmpty())
            return list.get(0);
        return null;
	}

}
