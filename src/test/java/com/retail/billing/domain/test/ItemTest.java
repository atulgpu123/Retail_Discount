package com.retail.billing.domain.test;

import org.junit.Assert;
import org.junit.Test;

import com.retail.billing.base.test.BillingDataBuilder;
import com.retail.billing.domain.Item;
import com.retail.billing.model.Product;
import com.retail.billing.util.CalculationUtil;

public class ItemTest {

	@Test
	public void shouldGetnoDiscountforNonDiscountableProduct() {
		Product product = BillingDataBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96,
				CalculationUtil.getDiscountedPrice(item.getProduct().isDiscountApplicable(), item.getTotalCost(), 5),
				0);
	}

	@Test
	public void shouldGetDiscountForDiscountableProduct() {
		Product product = BillingDataBuilder.getDiscountProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(220.36,
				CalculationUtil.getDiscountedPrice(item.getProduct().isDiscountApplicable(), item.getTotalCost(), 5),
				0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroprecentage() {
		Product product = BillingDataBuilder.getDiscountProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(220.3,
				CalculationUtil.getDiscountedPrice(item.getProduct().isDiscountApplicable(), item.getTotalCost(), 5),
				0.1);
	}

}
