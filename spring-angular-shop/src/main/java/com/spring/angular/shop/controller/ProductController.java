package com.spring.angular.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.angular.shop.dao.ProductDAO;
import com.spring.angular.shop.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadAllProducts(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> loadProducts() {
        return productDAO.getProducts();
	}
	
}
