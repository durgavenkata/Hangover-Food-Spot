package com.mph.controller;

import java.util.List;

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

import com.mph.entity.Orders;
import com.mph.service.OrdersService;

/**
 * @author HEMRAJU
 *
 */
@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/orders")
public class OrdersRestController {
		
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/Allorders")
	public  Orders setorders(@RequestBody Orders orders){
		ordersService.addOrders(orders);
		return orders;

	}
	
	@DeleteMapping("/deleteorders/{id}")
	public  ResponseEntity<List<Orders>> deleteOrders(@PathVariable("id") int ordersid){
		List<Orders> ordersList = ordersService.deleteOrders(ordersid);
		System.out.println("From Rest all orders : " + ordersList);
		
		if(ordersList.isEmpty())
		{
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(ordersList,HttpStatus.OK);
	}
	
	@PutMapping("/updateorders")
	public  ResponseEntity<List<Orders>> updateorders(@RequestBody Orders orders){
		List<Orders> ordersList = ordersService.updateOrders(orders);
		System.out.println("From Rest Orders: " + ordersList);
		
		if(ordersList.isEmpty())
		{
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(ordersList,HttpStatus.OK);
	}
	
	@GetMapping("/searchorders/{cid}")
	public  ResponseEntity<Orders> searchorders(@PathVariable("cid") int ordersid){
		Orders ordersById = ordersService.getOrdersById(ordersid);
		System.out.println("From Rest Orders: " + ordersById);
		
		if(ordersById == null)
		{
			return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Orders>(ordersById,HttpStatus.OK);
	}
}