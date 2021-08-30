package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.MenuDao;
import com.mph.entity.Menu;
/**
 * @author VAMSI
 *
 */
@Transactional
@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuDao menuDao;
	
	@Override
	public void addmenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.addMenu(menu);
	}

	@Override
	public List<Menu> deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(menuId);
	}

	@Override
	public Menu getMenuById(int menuId) {
		// TODO Auto-generated method stub
		return menuDao.getMenuById( menuId);
	}

	@Override
	public List<Menu> updatemenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.updatemenu(menu);
	}

}