package com.spring.angular.shop.util;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class ShaPasswordEncoderTest {
	
	public static void main(String[] args) {
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		String encodedPwd = passwordEncoder.encodePassword("test", null);
		System.out.println(encodedPwd);
	}
}
