package com.mph.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;


import com.mph.controller.CustomerRestController;
import com.mph.entity.Customer;



public class RestController {
	
	CustomerRestController customerController;
	
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
		customerController = new CustomerRestController();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		customerController=null;
		System.out.println("@After calling Test method");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCustomerId()
	{
		System.out.println("Testing if the returned customer id and the requested customer id are the same! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("What is the ID of the customer you want to Delete?");
		int customerId=sc.nextInt();
		try {
		ResponseEntity<List<Customer>> customerDeleted=customerController.deleteCustomer(customerId);
		try{
			assertEquals("redirect:/getcust",customerDeleted);
			ResponseEntity<Customer> customer = customerController.searchCustomer(customerId);
			if(((List<Customer>) customer).isEmpty())
				System.out.println("Customer was deleted successfully!");
			}
		catch(Exception exc){
			System.out.println("Oops!The customer could not be deleted!");
		}
		}
		catch(Exception e)
		{
			System.out.println("Oops!The customer does not exist!");
		}

		finally {
			System.out.println("Customer deletion verified Successfully!");
		}
     }

}