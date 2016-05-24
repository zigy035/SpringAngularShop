package com.spring.angular.shop.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.dao.TaxDAO;
import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Cart;
import com.spring.angular.shop.model.CartItem;
import com.spring.angular.shop.model.Tax;
import com.spring.angular.shop.service.CartService;

public class CartServiceImpl implements CartService {
	
	private CartDAO cartDAO;
	private AddressDAO addressDAO;
	private TaxDAO taxDAO;
	
	@Override
	public CartItem addProductToCart(String productId, String customerId) {
		
		// Get cart or create if it doesn't exist
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
			return cartDAO.getCartItem(cart.getId(), productId);
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

	/*@Override
	public List<CartItem> getCartItems(String customerId) {
		
	}*/

	@Override
	public CartDTO getCartData(String customerId) {
		
		Cart cart = cartDAO.getCart(customerId);
		
		List<CartItem> items = cartDAO.getCartItems(cart.getId());
		if (items.isEmpty()) {
			return null;
		}
		
		double subtotal = 0.0d;
		for (CartItem item : items) {
			item.setTotal(item.getProductPrice().doubleValue() * item.getQuantity().intValue());
			subtotal += item.getTotal();
		}
		subtotal = roundDecimalValue(subtotal);

		double deliveryCost = 0.0d;
		Address shippingAddress = addressDAO.getShippingAddress(customerId);
		if (shippingAddress == null) {
			deliveryCost = 20.0;
		} else {
			String regionCode = shippingAddress.getRegionIso();
			Tax tax = taxDAO.getTax(regionCode);
			if (tax == null) {
				deliveryCost = 20.0;
			} else {
				deliveryCost = roundDecimalValue(subtotal * tax.getPercent()/100);
			}
		}
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setItems(items);
		cartDTO.setSubtotal(subtotal);
		cartDTO.setDeliveryCost(deliveryCost);
		cartDTO.setTotal(subtotal + deliveryCost);
		cartDTO.setDeliveryType(cart.getDeliveryTypeCode());
		cartDTO.setPaymentMethod(cart.getPaymentMethodCode());
		
		return cartDTO;
	}
	
	@Override
	public CartDTO getCheckoutCartData(String customerId, String deliveryType) {
		
		CartDTO cartDTO = getCartData(customerId);
		if ("NEXT_DAY".equals(deliveryType)) {
			cartDTO.setDeliveryCost(cartDTO.getDeliveryCost() + 15.0);
			cartDTO.setTotal(cartDTO.getSubtotal() + cartDTO.getDeliveryCost());
		}
		
		return cartDTO;
	}
	
	private double roundDecimalValue(double subtotal) {
		BigDecimal decimal = new BigDecimal(subtotal);
		decimal.setScale(2, RoundingMode.HALF_UP);
		return decimal.doubleValue();
	}

	// Inject DAOs
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public void setTaxDAO(TaxDAO taxDAO) {
		this.taxDAO = taxDAO;
	}

}
