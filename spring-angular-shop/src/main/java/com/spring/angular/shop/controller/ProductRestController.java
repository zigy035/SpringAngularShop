package com.spring.angular.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.angular.shop.dao.ProductDAO;
import com.spring.angular.shop.model.Product;

@Controller
@RequestMapping("/product-rest")
public class ProductRestController {
	
	@Autowired
	private ProductDAO productDAO; 
		
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Product> loadProducts() {
		
		List<Product> products = productDAO.getProducts();
        if (CollectionUtils.isEmpty(products)) {
            return new ArrayList<Product>();
        }
        return products;
	}
	
}
