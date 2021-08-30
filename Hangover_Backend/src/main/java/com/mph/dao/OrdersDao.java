package com.mph.dao;

import java.util.List;

import com.mph.entity.Orders;

/**
 * @author DHEERAJ
 *
 */
public interface OrdersDao {
	public void addOrders(Orders orders);
	public List<Orders> deleteOrders(int ordersId);
	public Orders getOrdersById(int ordersId);
	public List<Orders> updateOrders(Orders orders);
}