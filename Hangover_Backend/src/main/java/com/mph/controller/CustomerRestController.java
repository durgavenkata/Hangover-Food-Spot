package com.mph.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Customer;
import com.mph.service.CustomerService;


/**
 * @author HEMRAJU
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger(CustomerRestController.class);
	@GetMapping("/allcustomer")
	public ResponseEntity<List<Customer>> allcustomer() {
		
		logger.info("GETTING REQUEST FROM local host TO SHOW THE LIST OF EMPLOYEES");
		System.out.println(logger.getName()+ "  " + logger.getLevel());

PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		
		
		System.out.println("Log4 j configuration is SUCCESSFUL");
		
		List<Customer> emplist = customerService.getAllCustomer();
		System.out.println("From Rest allemp : " + emplist);
		
		if(emplist.isEmpty()) {
			
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(emplist,HttpStatus.OK);		
		
	}
	@GetMapping("/allCustomer")
public  ResponseEntity<List<Customer>> allCustomer(){
	List<Customer> customerList = customerService.getAllCustomer();
	System.out.println("From Rest allemp: " + customerList);
	
	if(customerList.isEmpty())
	{
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
}
	
	
	@PostMapping("/addCustomer")
public  Customer addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
	return customer;

}
	
	
	@DeleteMapping("/deleteCustomer/{cid}")
public  ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("cid") int customerid){
	List<Customer> customerList = customerService.deleteCustomer(customerid);
	System.out.println("From Rest allemp: " + customerList);
	
	if(customerList.isEmpty())
	{
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
}
	
	
	@PutMapping("/updateCustomer")
public  ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer){
	List<Customer> customerList = customerService.updateCustomer(customer);
	System.out.println("From Rest allemp: " + customerList);
	
	if(customerList.isEmpty())
	{
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
}
	@GetMapping("/searchCustomer/{cid}")
	public  ResponseEntity<Customer> searchCustomer(@PathVariable("cid") int customerid){
		Customer customerById = customerService.getCustomerById(customerid);
		System.out.println("From Rest allemp: " + customerById);
		
		if(customerById == null)
		{
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(customerById,HttpStatus.OK);
	}
	@PostMapping("/validateCustomer")
	public Customer loginUser(@RequestBody Customer customer) throws Exception {
		String tempEmailId = customer.getEmail();
		String tempPassword = customer.getPassword();
		Customer customerObj = null;
		if (tempEmailId != null && tempPassword != null) {
			customerObj = customerService.login(tempEmailId, tempPassword);
		}
		if (customerObj == null) {
			throw new Exception("Bad credetianls,User not found");
		}
		return customerObj;

	}
}