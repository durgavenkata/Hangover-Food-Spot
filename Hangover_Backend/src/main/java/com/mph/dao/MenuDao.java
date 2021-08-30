package com.mph.dao;

import java.util.List;

import com.mph.entity.Menu;

/**
 * @author DHEERAJ
 *
 */
public interface MenuDao {
	public void addMenu(Menu menu);

	public List<Menu> deleteMenu(int menuId);
	public Menu getMenuById(int menuId);

	public List<Menu> updatemenu(Menu menu);
}