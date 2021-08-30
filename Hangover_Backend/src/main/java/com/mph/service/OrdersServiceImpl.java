package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.OrdersDao;
import com.mph.entity.Orders;
/**
 * @author VAMSI
 *
 */
@Transactional
@Service
public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	OrdersDao ordersDao;
	
	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		ordersDao.addOrders(orders);
	}

	@Override
	public List<Orders> deleteOrders(int ordersId) {
		// TODO Auto-generated method stub
		return ordersDao.deleteOrders(ordersId);
	}

	@Override
	public Orders getOrdersById(int ordersId) {
		// TODO Auto-generated method stub
		return ordersDao.getOrdersById(ordersId);
	}

	@Override
	public List<Orders> updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrders(orders);
	}
}