package com.spring.angular.shop.util;

import java.util.UUID;

public class UUIDGeneratorTest {
	
	public static void main(String[] args) {
		System.out.println("Uid: " + UUID.randomUUID().toString().replace("-", ""));
	}
}
