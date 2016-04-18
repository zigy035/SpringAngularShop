package com.spring.angular.shop.dao;

import java.util.List;

import com.spring.angular.shop.model.CartItem;

public interface CartDAO {
	
	List<CartItem> getCart(String cartId);

	CartItem getItem(String itemId);

	void updateItem(CartItem item);

	void deleteItem(CartItem item);

	CartItem getCartItem(String cartId, String productId);

	void addCartItem(CartItem item);
}
