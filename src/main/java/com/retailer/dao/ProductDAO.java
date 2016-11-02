package com.retailer.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.retailer.entity.ProductEntity;

@Component
public class ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAO(){}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<ProductEntity> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductEntity.class);
		criteria.add(Restrictions.eq("status", "A"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<ProductEntity> getProductById(String productId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductEntity.class);
		criteria.add(Restrictions.eq("status", "A"));
		criteria.add(Restrictions.eq("productId", productId));
		return criteria.list();
	}

}
