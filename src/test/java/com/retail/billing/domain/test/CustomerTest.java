package com.retail.billing.domain.test;

import org.junit.Test;

import com.retail.billing.base.test.BillingDataBuilder;
import com.retail.billing.domain.Customer;

import junit.framework.Assert;

public class CustomerTest {

	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Customer customer = BillingDataBuilder.getCustomerMoreThanTwoYearOldRegDate();
		Assert.assertTrue(customer.isApplicableForLoyalityDiscount());
	}

	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingDataBuilder.getAffiliateCustomer();
		Assert.assertFalse(customer.isApplicableForLoyalityDiscount());
	}

	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Customer customer = BillingDataBuilder.getCustomerLessThanTwoYearOldRegDate();
		Assert.assertFalse(customer.isApplicableForLoyalityDiscount());
	}
}
