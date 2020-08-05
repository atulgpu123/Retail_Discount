package com.retail.billing.domain;

import com.retail.billing.model.Product;

import lombok.Data;

@Data
public class Item {

	private Product product;

	private int quantity;

	private double totalCost;

	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalCost = product.getPrice() * quantity;
	}
}
