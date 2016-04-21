package com.spring.angular.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spring.angular.shop.model.Product;

public interface ProductDAO {
	
	@Select("SELECT p.id, p.name, p.description, p.price FROM product AS p")
	List<Product> getProducts();
}
