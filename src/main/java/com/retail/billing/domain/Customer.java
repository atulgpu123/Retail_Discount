package com.retail.billing.domain;

import java.util.Objects;

import org.joda.time.DateTime;

import com.retail.billing.enums.CustType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;

	private CustType custType;

	private String custId;

	private String custName;

	private DateTime regDate;

	public boolean isApplicableForLoyalityDiscount() {
		DateTime dateToCompare = DateTime.now().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS);
		return Objects.nonNull(regDate) && regDate.isBefore(dateToCompare) && (CustType.CUSTOMER == custType);
	}
}
