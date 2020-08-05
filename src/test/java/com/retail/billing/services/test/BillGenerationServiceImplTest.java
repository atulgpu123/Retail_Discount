package com.retail.billing.services.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.retail.billing.base.test.BillingDataBuilder;
import com.retail.billing.domain.Item;
import com.retail.billing.domain.Customer;
import com.retail.billing.services.BillGenerationService;
import com.retail.billing.services.impl.BillGenerationServiceImpl;

public class BillGenerationServiceImplTest {
	
	private BillGenerationService billGenerationService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billGenerationService = new BillGenerationServiceImpl();
		items = BillingDataBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillForDiscountEligibleCustomer() {
		Customer customer = BillingDataBuilder.getCustomerMoreThanTwoYearOldRegDate();
		Assert.assertEquals(761, billGenerationService.getPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForNonEligibleCustomer() {
		Customer customer = BillingDataBuilder.getCustomerLessThanTwoYearOldRegDate();
		Assert.assertEquals(790, billGenerationService.getPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = BillingDataBuilder.getAffiliateCustomer();
		Assert.assertEquals(737, billGenerationService.getPayableAmount(affiliateCustomer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Customer employeeCustomer = BillingDataBuilder.getEmployeeCustomer();
		Assert.assertEquals(626, billGenerationService.getPayableAmount(employeeCustomer, items), 0);
	}
}
