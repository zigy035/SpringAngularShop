package com.spring.angular.shop.model;

public class DeliveryType {
	
	private String code;
	private String name;
	private Double cost;
//	private String formattedCost;
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormattedCost() {
		return "$" + cost;
	}
	/*public void setFormattedCost(String formattedCost) {
		this.formattedCost = formattedCost;
	}*/
	
	
}
