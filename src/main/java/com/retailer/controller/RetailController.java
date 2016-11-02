package com.retailer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.retailer.dto.CartBillDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.retailer.business.ProductBO;
import com.retailer.entity.ProductEntity;
import com.retailer.util.StoreUtil;

@Controller
@SessionAttributes("myCart")
@RequestMapping("/")
public class RetailController {
	
	@Autowired
	private StoreUtil storeUtil;
	@Autowired
	private ProductBO productBO;
	
	@ModelAttribute("myCart")
	public Map<ProductEntity, Integer> populateMyCart() 
	{
	    return new HashMap<ProductEntity,Integer>();
	}
	
	@RequestMapping(value="/catalog", method= {RequestMethod.GET })
	public String renderProductsOnStore(HttpServletRequest request, Model model,
			@ModelAttribute("myCart") Map<ProductEntity,Integer> myCart)
	{
		if(!model.containsAttribute("myCart"))
		{
			model.addAttribute("myCart", new HashMap<ProductEntity,Integer>());
		}
		else
			model.addAttribute("cartSize", myCart.size());
		return storeUtil.dispatchCatalog(model, null);
	}
	
	@RequestMapping(value="/productdetail/{productid}", method= {RequestMethod.GET })
	public String renderProductDetailPage(HttpServletRequest request, Model model,
			@PathVariable(value="productid") String productId,
			@ModelAttribute("myCart") Map<ProductEntity,Integer> myCart)
	{
		if(!model.containsAttribute("myCart"))
		{
			model.addAttribute("myCart", new HashMap<ProductEntity,Integer>());
		}
		return storeUtil.renderProductDetailPage(model, productId, null);
	}
	
	@RequestMapping(value="/add/to/cart", method= {RequestMethod.POST })
	public String addToCart(HttpServletRequest request, Model model,
			@RequestParam(value="productId") String productId,
			@RequestParam(value="quantity") String quantity,
			@RequestParam(value="d", required = false) String d,
			@ModelAttribute("myCart") Map<ProductEntity,Integer> myCart)
	{
		ProductEntity product = productBO.getProductById(productId);
		product.setQuantity(Integer.parseInt(quantity));
		
		if(myCart.containsKey(product))
			myCart.put(product, myCart.get(product)+Integer.parseInt(quantity));
		else
		    myCart.put(product, Integer.parseInt(quantity));
		
		if(StringUtils.isNotBlank(d))
		     return "redirect:/productdetail/" + productId; 
		return "redirect:/catalog"; 
	}
	
	@RequestMapping(value="/generate/bill", method = {RequestMethod.POST })
	public String generateBillForPayment(HttpServletRequest request, Model model,
			@ModelAttribute("myCart") Map<ProductEntity,Integer> myCart)
	{
		if(myCart.isEmpty())
		{
			model.addAttribute("cartEmpty", true);
		}
		else
		{
		   List<CartBillDTO> cartBillList = storeUtil.generateBill(myCart, model);
		   model.addAttribute("cartBillList", cartBillList);
		   
		}
		return "/retail/Bill";
	}
}
