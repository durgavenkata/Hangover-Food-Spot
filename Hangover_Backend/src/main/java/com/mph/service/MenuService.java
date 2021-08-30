package com.mph.service;

import java.util.List;

import com.mph.entity.Menu;

/**
 * @author VAMSI
 *
 */
public interface MenuService {
	public void addmenu(Menu menu);
	public List<Menu> deleteMenu(int menuId);
	public Menu getMenuById(int menuId);
	public List<Menu> updatemenu(Menu menu);
}
