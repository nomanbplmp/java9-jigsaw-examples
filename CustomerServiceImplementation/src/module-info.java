/**
 *  Module customer serivce 
 */
/**
 * @author Noman
 *
 */
module CustomerServiceModule {
	requires transitive customerServiceApi;
	exports  com.nk.customer.service;
	exports com.nk.tools.finder;
	provides com.nk.customer.service.api.CustomerService with com.nk.customer.service.CustomerServiceDemo;
}