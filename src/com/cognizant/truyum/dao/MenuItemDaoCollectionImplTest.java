package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("AdminMenuItemList");
			testGetMenuItemListAdmin();
			System.out.println("CustomerMenuItemList");
			testGetMenuItemListCustomer();
			testModifyMenuItem();
			System.out.println("AdminMenuItemList");
			testGetMenuItemListAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem = new MenuItem(1, "Maggie", 35.0f, true, DateUtil.convertToDate("11/02/1999"), "Main Course",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);

	}

}
