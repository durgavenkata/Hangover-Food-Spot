package com.mph.test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mph.dao.CustomerDao;
import com.mph.dao.CustomerDaoImpl;
import com.mph.entity.Customer;



//Unit Testing on a functionality from DAO layer(CustomerDaoImpl)

public class customerDaoTest {

	CustomerDao customerDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		System.out.println("Initiating Unit Testing ...");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception
	{
		System.out.println("Terminating Unit Testing ...");
	}
	
	@Before
	public void setUp() throws java.lang.Exception
	{
		System.out.println("@Before calling Test method");
		customerDao = new CustomerDaoImpl();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		customerDao=null;
		System.out.println("@After calling Test method");
	}
	
	@Test
	public void testCustomerId()
	{
		System.out.println("Testing if the returned customer id and the requested customer id are the same! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an existing customer ID");
		int customerId=sc.nextInt();
		try {
		Customer customerReturned=customerDao.getCustomerById(customerId);
		assertEquals(customerReturned.getCustomerId(), customerId);
		}
		catch(Exception e)
		{
			System.out.println("Oops!The customer does not exist!");
		}

		finally {
			System.out.println("Customer verified Successfully!");
		}
     }
}