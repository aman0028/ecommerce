package com.retailer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.retailer.dto.CartBillDTO;
import com.retailer.visitor.ShoppingCartVisitor;
import com.retailer.visitor.ShoppingCartVisitorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.retailer.business.CategoryBO;
import com.retailer.business.ProductBO;
import com.retailer.entity.ProductCategory;
import com.retailer.entity.ProductEntity;

@Component
public class StoreUtil 
{
	@Autowired
	private ProductBO productBO;
	@Autowired
	private CategoryBO categoryBO;
	public String dispatchCatalog(Model model, String locale) 
	{
		List<ProductEntity> products = productBO.getProducts(locale);
		model.addAttribute("products", products);
		List<ProductCategory> categories = categoryBO.getCategories();
		model.addAttribute("categories", categories);
		return "/retail/Catalog";
	}
	
	public String renderProductDetailPage(Model model, String productId, String locale) 
	{
		ProductEntity product = productBO.getProductById(productId);
		model.addAttribute("product", product);
		return "retail/ProductDetail";
	}
	
	public List<CartBillDTO> generateBill(Map<ProductEntity,Integer> cart, Model model) 
	{
		
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		List<CartBillDTO> billDTOList = prepareCartBillDTO(cart,visitor, model);
		double totalPaymentAmount = 0.0;
		for(CartBillDTO cartBillDTO : billDTOList)
		{
			totalPaymentAmount+=cartBillDTO.getTotalAmount();
		}
		model.addAttribute("payableAmount", totalPaymentAmount);
		return billDTOList;
	}

	private List<CartBillDTO> prepareCartBillDTO(Map<ProductEntity,Integer> cart, ShoppingCartVisitor visitor, Model model) 
	{
		List<CartBillDTO> cartBillDTOList = new ArrayList<CartBillDTO>();
		for(ProductEntity product : cart.keySet())
		{
			CartBillDTO dto = new CartBillDTO(product.getProductId(), 
											  product.getProductName(),
											  cart.get(product), 
											  product.getCategoryId(),
											  product.getProductPrice(),
											  product.getProductCurrency(),
											  categoryBO.getCategoryById(product.getCategoryId()).getCategoryName(),
											  categoryBO.getCategoryById(product.getCategoryId()).getTaxPercentage()
											  );
			ProductCategory category = categoryBO.getCategoryById(product.getCategoryId());
			dto.setTotalAmount(product.accept(visitor, category));
			cartBillDTOList.add(dto);
		}
		double totalPayableAmount=0.0;
		for(CartBillDTO cartDTO : cartBillDTOList)
		{
			totalPayableAmount+=cartDTO.getTotalAmount();
		}
		model.addAttribute("totalPayableAmount", totalPayableAmount);
		model.addAttribute("productCurrency",cartBillDTOList.get(0).getProductCurrency());
		return cartBillDTOList;
	}

}
