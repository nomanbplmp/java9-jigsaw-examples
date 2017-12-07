package com.nk.customer.rest.api;

import java.util.List;
import java.util.ServiceLoader;

import com.nk.customer.service.CustomerServiceDemo;
import com.nk.customer.service.api.CustomerService;
import com.nk.tools.finder.ToolFinder;
/**
 * 
 * @author Noman
 *
 */
public class CustomerHelper {
	CustomerService loader = ServiceLoader.load(CustomerService.class).findFirst().get();
	CustomerService hardCoupling = new CustomerServiceDemo();
	ToolFinder finder = new ToolFinder();
	public String getName(Long Id) {
		//	return loader.findFirst().get().getName(Id);
	    return hardCoupling.getName(Id);	
	}

	public List<String> displayToolsName() {
		return finder.showAllTools();
	}
	
	
	public static void main(String[] args) {
		CustomerHelper controller = new CustomerHelper();
		System.out.println(controller.getName(1l));
		controller.displayToolsName().stream().forEach(System.out::println);
	}
}
