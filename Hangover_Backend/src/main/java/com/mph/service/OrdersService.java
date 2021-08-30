package com.mph.service;

import java.util.List;

import com.mph.entity.Orders;

/**
 * @author VAMSI
 *
 */
public interface OrdersService {
	public void addOrders(Orders orders);
	public List<Orders> deleteOrders(int ordersId);
	public Orders getOrdersById(int ordersId);
	public List<Orders> updateOrders(Orders orders);
}