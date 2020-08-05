package com.retail.billing.model;

import lombok.Data;

@Data
public class Product {

	private String name;

	private boolean isDiscountApplicable;

	private double price;
}
