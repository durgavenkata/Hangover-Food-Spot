package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Orders;

/**
 * @author DHEERAJ
 *
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		
		getSession().saveOrUpdate(orders);
		System.out.println(" added Successfully :)");
		
	}
	
	@Override
	public List<Orders> deleteOrders(int ordersId) {
		Query query = getSession().createQuery("delete from OrdersDetails orders where ordersId=:ordersId");
		query.setParameter("ordersId", ordersId);
		int no_ofRows = query.executeUpdate();
		if(no_ofRows >0)
		{
			System.out.println("Deleted " + no_ofRows + " rows");
		}
		return getAllOrders();
		
		
	}
	

	@Override
	public Orders getOrdersById(int ordersId) {
		Criteria c = getSession().createCriteria(Orders.class);
		c.add(Restrictions.eq("ordersId",ordersId));
		Orders b = (Orders)c.uniqueResult();
		System.out.println("Orders Found : " +b);
		return b;
	}

	@Override
	public List<Orders> updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("update Orders orders set ordersId=:ordersId,menuId=:menuId,menuName=:menuName,menuPrice=:menuPrice,quantity=:quantity,address=:address where ordersId=:ordersId");
		query.setParameter("ordersId", orders.getOrdersId());
		query.setParameter("menuId",orders.getMenuId());
		query.setParameter("menuName",orders.getMenuName());
		query.setParameter("menuPrice", orders.getMenuPrice());
		query.setParameter("quantity",orders.getQuantity());
		query.setParameter("address",orders.getaddress());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		return getAllOrders();
	}

	private List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Booking booking");
		@SuppressWarnings("unchecked")
		List<Orders> orderslist = query.list();
		return orderslist;
	}

}