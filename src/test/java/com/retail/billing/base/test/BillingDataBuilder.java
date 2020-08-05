package com.retail.billing.base.test;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.retail.billing.domain.Item;
import com.retail.billing.domain.Customer;
import com.retail.billing.enums.CustType;
import com.retail.billing.model.Product;

public class BillingDataBuilder {
	
	private static final int CUSTOMER_LOYALTY_PERIOD_YRS = 2;
	
	public static Product getDiscountProduct() {
		Product product = new Product();
		product.setName("ProductA");
		product.setDiscountApplicable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setName("PRoductB");
		product.setDiscountApplicable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		Customer customer = new Customer(CustType.AFFILIATE, "customer1", "ABC Affiliate", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(CustType.EMPLOYEE, "customer2", "John", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getCustomerMoreThanTwoYearOldRegDate() {
		Customer customer = new Customer(CustType.CUSTOMER, "customer1", "atul", new DateTime().minusYears(CUSTOMER_LOYALTY_PERIOD_YRS).minusDays(1));
		return customer;
	}
	
	public static Customer getCustomerLessThanTwoYearOldRegDate() {
		Customer customer = new Customer(CustType.CUSTOMER, "customer2", "kalyan", new DateTime().minusYears(CUSTOMER_LOYALTY_PERIOD_YRS).plusDays(1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
