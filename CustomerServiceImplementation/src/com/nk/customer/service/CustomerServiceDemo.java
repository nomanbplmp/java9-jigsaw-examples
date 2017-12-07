package com.nk.customer.service;

import java.util.Arrays;
import java.util.List;

import com.nk.customer.service.api.CustomerService;

public class CustomerServiceDemo implements CustomerService {
public String getName(Long id) {
	return "DummyCustomer";
}

public List<String> getPendingItems(Long Id) {
	return Arrays.asList("item1","item2","item3");
}

}
