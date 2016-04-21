package com.spring.angular.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.angular.shop.model.CartItem;

public interface CartDAO {
	
	@Select("SELECT ci.id, ci.cart_id, p.id AS product_id, p.name AS product_name, p.price AS product_price, ci.quantity " + 
			"FROM cart_item AS ci " + 
			"JOIN product AS p ON ci.product_id = p.id " +
			"WHERE ci.cart_id = #{cartId}")
	List<CartItem> getCart(String cartId);

	@Select("SELECT ci.id, ci.cart_id, ci.quantity " +
			"FROM cart_item AS ci " + 
			"WHERE ci.id = #{itemId}")
	CartItem getItem(String itemId);

	@Select("SELECT ci.id, ci.cart_id, ci.quantity" +
			"FROM cart_item AS ci " + 
			"WHERE ci.product_id = #{productId} AND ci.cart_id = #{cartId}")
	CartItem getCartItem(String cartId, String productId);
	
	@Insert("INSERT INTO cart_item VALUES (#{id}, #{cartId}, #{productId}, #{quantity})")
	void addCartItem(CartItem item);
	
	@Update("UPDATE cart_item SET quantity = #{quantity} WHERE id = #{id}")
	void updateItem(CartItem item);

	@Delete("DELETE FROM cart_item WHERE id = #{id}")
	void deleteItem(CartItem item);

}
