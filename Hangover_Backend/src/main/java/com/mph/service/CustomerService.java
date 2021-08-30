package com.mph.service;

import java.util.List;

import com.mph.entity.Customer;

/**
 * @author VAMSI
 *
 */
public interface CustomerService {

	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer validateCustomer(Customer customer);
	public List<Customer> updateCustomer(Customer customer);
	public List<Customer> deleteCustomer(int cid);
	public Customer getCustomerById(int cid);
	public Customer login(String email, String password);
}