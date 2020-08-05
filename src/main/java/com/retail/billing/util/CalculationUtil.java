package com.retail.billing.util;

public class CalculationUtil {

	private static final int DISCOUNT_PER_HUNDRED = 5;

	public CalculationUtil() throws Exception {
		throw new Exception();

	}

	public static double getDiscountForTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}

	public static double getDiscountedPrice(Boolean isDiscountApplicable, double totalCost, double percentage) {
		if (isDiscountApplicable && percentage != 0) {
			return (totalCost - totalCost * percentage / 100);
		}
		return totalCost;
	}

}
