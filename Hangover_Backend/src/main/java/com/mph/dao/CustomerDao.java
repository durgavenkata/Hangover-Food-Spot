package com.mph.dao;

import java.util.List;

import com.mph.entity.Customer;

/**
 * @author DHEERAJ
 *
 */
public interface CustomerDao {

	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer validateCustomer(Customer customer);
	public List<Customer> updateCustomer(Customer customer);
	public List<Customer> deleteCustomer(int cid);
	public Customer getCustomerById(int cid);
	public Customer login(String email,String password);
}