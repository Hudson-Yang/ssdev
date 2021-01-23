package com.doubles.devlog.tutorial.vo;

public class ProductVO {
	
	private String name;
	private int price;
	
	public ProductVO(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "productVO{name='"+name+'\''+", price="+price+'}'; // ProductVO{name='name', price=price};
	}
	
}
