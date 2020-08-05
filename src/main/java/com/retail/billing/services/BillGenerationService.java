package com.retail.billing.services;

import java.util.List;

import com.retail.billing.domain.Item;
import com.retail.billing.domain.Customer;

public interface BillGenerationService {

	double getPayableAmount(Customer customer, List<Item> items);

}
