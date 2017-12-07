package com.nk.customer.service.api;

import java.util.List;

public interface CustomerService {
	public String getName(Long id);
	public List<String> getPendingItems(Long Id) ;
}
