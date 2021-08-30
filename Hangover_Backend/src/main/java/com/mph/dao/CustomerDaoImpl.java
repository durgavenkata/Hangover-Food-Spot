package com.mph.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;

/**
 * @author DHEERAJ
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public void addCustomer(Customer customer) {
		
		getSession().saveOrUpdate(customer);
		System.out.println("Customer added Successfully :)");
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		Query query = getSession().createQuery("from Customer customer");
		@SuppressWarnings("unchecked")
		List<Customer> userList = query.list();
		return userList;
	}

	@Override
	public Customer validateCustomer(Customer customer) {
		
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("email", customer.getEmail()));
		c.add(Restrictions.eq("password", customer.getPassword()));
		Customer uniqueCustomer = (Customer)c.uniqueResult();
		System.out.println("Customer Retrieved : " + uniqueCustomer);
		return uniqueCustomer;
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		
		Query query = getSession().createQuery("update Customer customer set name=:name,phone=:phone where customerId =:eno");
		query.setParameter("name", customer.getName());
		query.setParameter("phoneNumber", customer.getPhoneNumber());
		query.setParameter("eno",customer.getCustomerId());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		return getAllCustomer();
	}

	@Override
	public List<Customer> deleteCustomer(int cid) {

		Query query = getSession().createQuery("delete from Customer customer where customerId=:cid");
		query.setParameter("cid", cid);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllCustomer();
		
	}
	

	@Override
	public Customer getCustomerById(int cid) {

		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("customerId", cid));
		Customer customer = (Customer)c.uniqueResult();
		System.out.println("Customer Found : " + customer);
		return customer;
	}
	
	@Override
	public Customer login(String email, String password) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Customer where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		Customer up = (Customer) query.uniqueResult();
		System.out.println("From login.." + up);
		return up;
	}
}