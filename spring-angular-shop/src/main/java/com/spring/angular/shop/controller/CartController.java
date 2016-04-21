package com.spring.angular.shop.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.model.CartItem;

@RestController
@RequestMapping("/cart")
public class CartController {

	private static final String CURRENT_CART_ID = "CART1";
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CartItem>> loadCartData() {
		
		List<CartItem> cartData = cartDAO.getCart(CURRENT_CART_ID);
        if (CollectionUtils.isEmpty(cartData)) {
            return new ResponseEntity<List<CartItem>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CartItem>>(cartData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
    public ResponseEntity<CartItem> addItem(@PathVariable("productId") String productId) {
		
		CartItem cartItem = cartDAO.getCartItem(CURRENT_CART_ID, productId);
		if (cartItem == null) {
			CartItem newCartItem = new CartItem();
			newCartItem.setCartId(CURRENT_CART_ID);
			newCartItem.setProductId(productId);
			newCartItem.setQuantity(1);
			cartDAO.addCartItem(newCartItem);
			return new ResponseEntity<CartItem>(newCartItem, HttpStatus.CREATED);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
			cartDAO.updateItem(cartItem);
			return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/update/{itemId}/{quantity}", method = RequestMethod.PUT)
    public ResponseEntity<CartItem> updateItem(@PathVariable("itemId") String itemId, 
    		@PathVariable("quantity") Integer quantity) {
        System.out.println("Updating item " + itemId);
         
        CartItem item = cartDAO.getItem(itemId);
         
        if (item == null) {
            System.out.println("Item with id " + itemId + " not found");
            return new ResponseEntity<CartItem>(HttpStatus.NOT_FOUND);
        }
 
        item.setQuantity(quantity);
        cartDAO.updateItem(item);
        
        return new ResponseEntity<CartItem>(item, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/delete/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity<CartItem> deleteItem(@PathVariable("itemId") String itemId) {
        System.out.println("Deleting item " + itemId);
         
        CartItem item = cartDAO.getItem(itemId);
         
        if (item == null) {
            System.out.println("Item with id " + itemId + " not found");
            return new ResponseEntity<CartItem>(HttpStatus.NOT_FOUND);
        }
 
        cartDAO.deleteItem(item);
        
        return new ResponseEntity<CartItem>(item, HttpStatus.OK);
    }
	
}
