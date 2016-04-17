package com.spring.angular.shop.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.model.CartItem;

public class CartDAOImpl extends SqlSessionDaoSupport implements CartDAO {

	@Override
	public List<CartItem> getCart(String cartId) {
		return getSqlSession().selectList("getCart", cartId);
	}

	@Override
	public CartItem getItem(String itemId) {
		return getSqlSession().selectOne("getItem", itemId);
	}

	@Override
	public void updateItem(CartItem item) {
		getSqlSession().update("updateItem", item);
	}

	@Override
	public void deleteItem(CartItem item) {
		getSqlSession().delete("deleteItem", item);
	}

}
