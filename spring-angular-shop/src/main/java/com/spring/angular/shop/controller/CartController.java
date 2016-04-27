package com.spring.angular.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController extends AbstractController {
		
	@RequestMapping(method = RequestMethod.GET)
	public String loadAllProducts(Model model) {
		return "cart";
	}
	
}
