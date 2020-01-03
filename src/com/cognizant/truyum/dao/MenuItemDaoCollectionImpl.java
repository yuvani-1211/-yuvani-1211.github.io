package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;
	private MenuItem menuItem;

	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwich", 99.0f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(
					new MenuItem(3, "Pizza", 149.0f, true, DateUtil.convertToDate("21/08/2018"), "Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.0f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.0f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> custList = new ArrayList<>();
		Date d = new Date();
		for (MenuItem x : menuItemList) {
			if (x.isActive() && x.getDateOfLaunch().before(d)) {
				custList.add(x);
			}

		}
		return custList;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		MenuItem menuId = getMenuItem(menuItem.getId());
		menuId.setName(menuItem.getName());
		menuId.setPrice(menuItem.getPrice());
		menuId.setActive(true);
		menuId.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuId.setCategory(menuItem.getCategory());
		menuId.setFreeDelivery(true);

	}

	@Override
	public MenuItem getMenuItem(long menuItemId)
	{
		MenuItem menuItem = null;
		for (MenuItem x : menuItemList) {
			if (x.getId() == menuItemId) {
				menuItem = x;
				break;
			}
		}
		return menuItem;
	}

}