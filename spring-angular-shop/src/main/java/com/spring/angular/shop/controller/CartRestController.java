package com.spring.angular.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.model.CartItem;
import com.spring.angular.shop.service.CartService;

@RestController
@RequestMapping("/cart-rest")
public class CartRestController extends AbstractController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public CartDTO loadCartData() {
		
		if (getAuthUser() == null) {
			return null;
		}
		return cartService.getCartData(getAuthUser().getId());
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
	@ResponseBody
	public CartItem addItem(@PathVariable("productId") String productId) {
		
		if (getAuthUser() == null) {
			return null;
		}
		CartItem cartItem = cartService.addProductToCart(productId, getAuthUser().getId());
		return cartItem;
	}
	
	@RequestMapping(value = "/update/{itemId}/{quantity}", method = RequestMethod.GET)
	@ResponseBody
	public CartItem updateItem(@PathVariable("itemId") String itemId, 
    		@PathVariable("quantity") Integer quantity) {
		
        CartItem cartItem = cartService.updateCartItem(itemId, quantity);
        return cartItem;
    }
	
	@RequestMapping(value = "/delete/{itemId}", method = RequestMethod.GET)
	@ResponseBody
	public CartItem deleteItem(@PathVariable("itemId") String itemId) {
        
		CartItem item = cartService.deleteCartItem(itemId);
        return item;
    }
	
}
