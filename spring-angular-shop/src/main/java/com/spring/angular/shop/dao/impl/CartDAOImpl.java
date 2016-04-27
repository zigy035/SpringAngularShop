package com.spring.angular.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.model.Cart;
import com.spring.angular.shop.model.CartItem;

public class CartDAOImpl extends SqlSessionDaoSupport implements CartDAO {

	@Override
	public List<CartItem> getCartItems(String cartId) {
		return getSqlSession().selectList("getCartItems", cartId);
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

	@Override
	public CartItem getCartItem(String cartId, String productId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cartId", cartId);
		params.put("productId", productId);
		return getSqlSession().selectOne("getCartItem", params);
	}

	@Override
	public void addItem(CartItem item) {
		getSqlSession().insert("addItem", item);
	}

	@Override
	public Cart getCart(String customerId) {
		return getSqlSession().selectOne("getCart", customerId);
	}

	@Override
	public void createCart(String customerId) {
		getSqlSession().insert("createCart", new Cart(customerId));
	}

}
