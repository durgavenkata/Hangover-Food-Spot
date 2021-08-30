package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author GURU
 *
 */
@Entity
public class Orders {
	@Id
	private int ordersId;
	private int menuId;
	private String menuName;
	private float menuPrice;
	private int quantity;
	private String address;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int ordersId, int menuId, String menuName, float menuPrice, int quantity, String address) {
		super();
		this.ordersId = ordersId;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.quantity = quantity;
		this.address = address;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", menuId=" + menuId + ", menuName=" + menuName + ", menuPrice="
				+ menuPrice + ", quantity=" + quantity + ", address=" + address + "]";
	}
	public Orders uniqueResult() {
		// TODO Auto-generated method stub
		return null;
	}

}