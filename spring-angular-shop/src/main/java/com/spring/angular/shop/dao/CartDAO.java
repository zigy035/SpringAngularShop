package com.spring.angular.shop.dao;

import java.util.List;

import com.spring.angular.shop.model.Cart;
import com.spring.angular.shop.model.CartItem;

public interface CartDAO {
	
	List<CartItem> getCartItems(String cartId);

	CartItem getItem(String itemId);

	void updateItem(CartItem item);

	void deleteItem(CartItem item);

	CartItem getCartItem(String cartId, String productId);

	void addItem(CartItem item);

	Cart getCart(String customerId);

	void createCart(String customerId);
}
