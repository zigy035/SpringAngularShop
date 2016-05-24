package com.spring.angular.shop.service;

import java.util.List;

import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.model.CartItem;

public interface CartService {
	
	CartItem addProductToCart(String productId, String customerId);
	
	CartItem updateCartItem(String itemId, Integer quantity);

	CartItem deleteCartItem(String itemId);
	
//	List<CartItem> getCartItems(String customerId);
	
	CartDTO getCartData(String customerId);
	
	CartDTO getCheckoutCartData(String customerId, String deliveryType);
}
