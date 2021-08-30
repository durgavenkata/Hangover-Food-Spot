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

import com.mph.entity.Menu;

import com.mph.service.MenuService;


/**
 * @author HEMRAJU
 *
 */
@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/menu")
public class MenuRestController {
	
	@Autowired
	MenuService menuService;
	
	@PostMapping("/Menu")
	public  Menu setMenu(@RequestBody Menu menu){
		menuService.addmenu(menu);
		return menu;

	}
	
	@DeleteMapping("/deleteMenu/{id}")
	public  ResponseEntity<List<Menu>> deleteMenu(@PathVariable("id") int menuid){
		List<Menu> menuList = menuService.deleteMenu(menuid);
		System.out.println("From Rest all menus : " + menuList);
		
		if(menuList.isEmpty())
		{
			return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Menu>>(menuList,HttpStatus.OK);
	}
	
	@PutMapping("/updatemenu")
	public  ResponseEntity<List<Menu>> updatemenu(@RequestBody Menu menu){
		List<Menu> menuList = menuService.updatemenu(menu);
		System.out.println("From Rest allmenus: " + menuList);
		
		if(menuList.isEmpty())
		{
			return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Menu>>(menuList,HttpStatus.OK);
	}
	
	@GetMapping("/searchMenu/{cid}")
	public  ResponseEntity<Menu> searchmenu(@PathVariable("cid") int menuid){
		Menu menuById = menuService.getMenuById(menuid);
		System.out.println("From Rest allmenus: " + menuById);
		
		if(menuById == null)
		{
			return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Menu>(menuById,HttpStatus.OK);
	}
}