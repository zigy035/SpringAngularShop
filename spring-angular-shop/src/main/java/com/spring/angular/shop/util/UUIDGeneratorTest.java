package com.spring.angular.shop.util;

import java.util.UUID;

public class UUIDGeneratorTest {
	
	public static final String STR = "region.%s.%s";
	
	public static void main(String[] args) {
//		System.out.println("Uid: " + UUID.randomUUID().toString().replace("-", ""));
		String result = String.format(STR, "ca", "al");
		System.out.println(result);
	}
}
