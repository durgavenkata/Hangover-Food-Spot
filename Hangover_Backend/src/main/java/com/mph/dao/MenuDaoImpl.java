package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.entity.Menu;


/**
 * @author DHEERAJ
 *
 */
@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(menu);
		System.out.println("Menu added Successfully in DB !!!");
		
	}

	@Override
	public List<Menu> deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("delete from menu where menuId=:menuId");
		query.setParameter("menuId", menuId);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return deleteMenu(noofrows);
	}

	@Override
	public Menu getMenuById(int menuId) {

		Criteria c = getSession().createCriteria (Menu.class); 
		c.add(Restrictions.eq("MenuId",menuId)); 
		Menu m= (Menu)c.uniqueResult(); 
		System.out.println("Menu Retrieved" + m);
		return m;
	}

	@Override
	public List<Menu> updatemenu(Menu menu) {
		Query query = getSession().createQuery("update Menu menu set menuId=:menuId,menuName=:menuName");
		query.setParameter("menuId", menu.getMenuId());
		query.setParameter("menuName",menu.getMenuName());
		
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		return getAllMenu();
		
	}

	private List<Menu> getAllMenu() {
		// TODO Auto-generated method stub

		Query query = getSession().createQuery("from Menu menu");
		@SuppressWarnings("unchecked")
		List<Menu> menuList = query.list();
		return menuList;
	}

}