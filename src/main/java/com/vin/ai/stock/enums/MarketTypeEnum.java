package com.vin.ai.stock.enums;

public enum MarketTypeEnum {

	PRIMARY_MARKET("一级市场"),
	SECONDARY_MARKET("二级市场"),
	THIRD_MARKET("三级市场"),
	FOURTH_MARKET("四级市场"),
	STREET_MARKET("场外市场"),
	THE_SECOND_BOARD("二板市场");

	private String name;

	private MarketTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
