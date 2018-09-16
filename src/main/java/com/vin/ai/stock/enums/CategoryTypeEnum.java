package com.vin.ai.stock.enums;

public class CategoryTypeEnum {


	private String name;

	private CategoryTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
