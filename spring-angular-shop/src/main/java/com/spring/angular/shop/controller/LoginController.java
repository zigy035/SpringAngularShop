package com.spring.angular.shop.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController
{
	private static final Logger LOG = Logger.getLogger(LoginController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(Model model)
	{
		LOG.debug("Show login page");

		return "login";
	}
	
	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public String getLoginFailurePage(Model model)
	{
		LOG.debug("Show error page");
		
		model.addAttribute("error", "true");
		
		return "login";
	}
	
}
