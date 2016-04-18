package com.spring.angular.shop.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.ProductDAO;
import com.spring.angular.shop.model.Product;

public class ProductDAOImpl extends SqlSessionDaoSupport implements ProductDAO {

	@Override
	public List<Product> getProducts() {
		return getSqlSession().selectList("getProducts");
	}
	
}
