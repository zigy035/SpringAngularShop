package com.spring.angular.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.model.Cart;
import com.spring.angular.shop.model.CartItem;
import com.spring.angular.shop.service.CartService;

public class CartServiceImpl implements CartService {
	
	private CartDAO cartDAO;
	
	@Override
	public CartItem addProductToCart(String productId, String customerId) {
		
		Cart cart = cartDAO.getCart(customerId);
		if (cart == null) {
			cartDAO.createCart(customerId);
			cart = cartDAO.getCart(customerId);
		}
		
		CartItem cartItem = cartDAO.getCartItem(cart.getId(), productId);
		if (cartItem == null) {
			CartItem newCartItem = new CartItem();
			newCartItem.setCartId(cart.getId());
			newCartItem.setProductId(productId);
			newCartItem.setQuantity(1);
			cartDAO.addItem(newCartItem);
			return newCartItem;
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartDAO.updateItem(cartItem);
			return cartItem;
		}
	}

	@Override
	public CartItem updateCartItem(String itemId, Integer quantity) {
		CartItem item = cartDAO.getItem(itemId);
        
        if (item == null) {
            return null;
        }
 
        item.setQuantity(quantity);
        cartDAO.updateItem(item);
		return item;
	}

	@Override
	public CartItem deleteCartItem(String itemId) {
		CartItem item = cartDAO.getItem(itemId);
        
        if (item == null) {
            return null;
        }
 
        cartDAO.deleteItem(item);
		return item;
	}

	@Override
	public List<CartItem> getCartItems(String customerId) {
		Cart cart = cartDAO.getCart(customerId);
		if (cart == null) {
			return new ArrayList<CartItem>();
		}
		return cartDAO.getCartItems(cart.getId());
	}

	// Inject DAO
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

}
