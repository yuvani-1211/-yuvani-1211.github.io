package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private double total;
	private List<MenuItem> menuItemList;
	public List<MenuItem> getMenuItem;

	public Cart() {
		super();
		menuItemList =new ArrayList<>();
		total=0.0;
		// TODO Auto-generated constructor stub
	}
	public Cart(double total, List<MenuItem> menuItemList) {
		super();
		this.total = total;
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	
	
		
	
}
