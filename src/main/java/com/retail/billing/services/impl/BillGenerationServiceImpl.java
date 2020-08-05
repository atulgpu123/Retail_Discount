package com.retail.billing.services.impl;

import java.util.List;

import com.retail.billing.domain.Item;
import com.retail.billing.domain.Customer;
import com.retail.billing.enums.CustType;
import com.retail.billing.services.BillGenerationService;
import com.retail.billing.util.CalculationUtil;

public class BillGenerationServiceImpl implements BillGenerationService {

	@Override
	public double getPayableAmount(Customer customer, List<Item> items) {
		double discountPercentage = getDiscountPrecent(customer);
		double totalDiscountedPrice = items.stream().mapToDouble(data -> CalculationUtil
				.getDiscountedPrice(data.getProduct().isDiscountApplicable(), data.getTotalCost(), discountPercentage))
				.sum();
		return Math.round(totalDiscountedPrice - CalculationUtil.getDiscountForTotalAmount(totalDiscountedPrice));
	}

	private double getDiscountPrecent(Customer customer) {
		if (customer.getCustType() == CustType.AFFILIATE || customer.getCustType() == CustType.EMPLOYEE
				|| customer.isApplicableForLoyalityDiscount()) {
			return customer.getCustType().getDiscount();
		}
		return 0;
	}

}
