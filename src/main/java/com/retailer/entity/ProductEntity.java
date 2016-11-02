package com.retailer.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import com.retailer.visitor.ItemElement;
import com.retailer.visitor.ShoppingCartVisitor;

@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class ProductEntity implements ItemElement, Serializable {

	@Id
	@Column(name = "product_id", nullable = false)
	private String productId;

	@Column(name = "status")
	private String status;

	@Column(name = "category_id")
	private String categoryId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Set<ProductLanguageEntity> productLanguages;

	@Transient
	private Map<String, ProductLanguageEntity> productLanguageMap;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Transient
	public ProductLanguageEntity getProductLanguage(String locale) {
		if (productLanguageMap == null) {
			productLanguageMap = new HashMap<String, ProductLanguageEntity>();
			for (ProductLanguageEntity productLanguage : productLanguages) {
				productLanguageMap.put(productLanguage.getLocale(), productLanguage);
			}
		}
		ProductLanguageEntity productLanguage = null;
		if(StringUtils.isNotBlank(locale))
		    productLanguage = productLanguageMap.get(locale);
		
		if(null == productLanguage)
			productLanguageMap.get("en");
		return productLanguage;
	}
	
	@Transient
	public String getProductName() {
		if(getProductLanguage("en")!=null && StringUtils.isNotBlank(getProductLanguage("en").getProductName()))
		   return getProductLanguage("en").getProductName();
		return null;
	}
	
	@Transient
	public String getProductCurrency() {
		if(getProductLanguage("en")!=null && StringUtils.isNotBlank(getProductLanguage("en").getProductCurrency()))
			   return getProductLanguage("en").getProductCurrency();
		return null;
	}
	
	@Transient
	public String getProductPrice() {
		if(getProductLanguage("en")!=null && StringUtils.isNotBlank(getProductLanguage("en").getProductPrice()))
			   return getProductLanguage("en").getProductPrice();
		return null;
	}
	
	@Transient
	public String getProductShortDescription() {
		if(getProductLanguage("en")!=null && StringUtils.isNotBlank(getProductLanguage("en").getProductShortDescription()))
			   return getProductLanguage("en").getProductShortDescription();
		return null;
	}
	
	@Transient
	public String getProductDescription() {
		if(getProductLanguage("en")!=null && StringUtils.isNotBlank(getProductLanguage("en").getProductDescription()))
			   return getProductLanguage("en").getProductDescription();
		return null;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", status=" + status + ", categoryId=" + categoryId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public double accept(ShoppingCartVisitor shoppingCartVisitor, ProductCategory category, Integer quantity) {
		return shoppingCartVisitor.visit(this, category, quantity);
	}
}
