package com.spring.angular.shop.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.shop.dao.ProductDAO;
import com.spring.angular.shop.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO; 
	
	@RequestMapping("/layout")
    public String getCartContentPage() {
        return "layout/product";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> loadAllProducts() {
		
		List<Product> products = productDAO.getProducts();
        if (CollectionUtils.isEmpty(products)) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
