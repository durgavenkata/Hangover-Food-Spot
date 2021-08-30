package com.mph.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

/**
 * @author GURU
 *
 */
@Entity
public class Menu{
@Id
private int menuId;
private String menuName;
private float menuPrice;
private String menuImg;


public Menu() {
	super();
	// TODO Auto-generated constructor stub
}

public Menu(int menuId, String menuName, float menuPrice, String menuImg, Orders orders) {
	super();
	this.menuId = menuId;
	this.menuName = menuName;
	this.menuPrice = menuPrice;
	this.menuImg = menuImg;
}

public int getMenuId() {
	return menuId;
}

public void setMenuId(int menuId) {
	this.menuId = menuId;
}

public String getMenuName() {
	return menuName;
}

public void setMenuName(String menuName) {
	this.menuName = menuName;
}

public float getMenuPrice() {
	return menuPrice;
}

public void setMenuPrice(float menuPrice) {
	this.menuPrice = menuPrice;
}

public String getMenuImg() {
	return menuImg;
}

public void setMenuImg(String menuImg) {
	this.menuImg = menuImg;
}

@Override
public String toString() {
	return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuImg=" + menuImg
			+ "]";
}

public Menu uniqueResult() {
	// TODO Auto-generated method stub
	return null;
}


}