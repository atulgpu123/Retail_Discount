package com.retail.billing.enums;

public enum CustType {
	
	AFFILIATE(10),
	EMPLOYEE(30), 
	CUSTOMER(5);
	
	private double discount;
	
	CustType(double discount) {
		this.setDiscount(discount);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	


}
