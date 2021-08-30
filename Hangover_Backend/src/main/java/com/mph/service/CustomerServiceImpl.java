package com.mph.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;

/**
 * @author VAMSI
 *
 */
@Transactional
@Service

public class CustomerServiceImpl implements CustomerService {
  
	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	public void addCustomer(Customer customer) {
		
		customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer validateCustomer(Customer customer) {
		
		return customerDao.validateCustomer(customer);
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> deleteCustomer(int customerid) {
		
		return customerDao.deleteCustomer(customerid);
	}

	@Override
	public Customer getCustomerById(int customerid) {
		
		return customerDao.getCustomerById(customerid);
	}
	
	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		return customerDao.login(email, password);
	}
}

