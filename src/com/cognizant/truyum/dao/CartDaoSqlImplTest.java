package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException, SQLException {
		// TODO Auto-generated method stub

		testGetAllCartItems();
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1l);
		System.out.println("cart Items ");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}

	}

	public static void testAddCartItem() throws CartEmptyException, SQLException {
		CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1l);
		cartDao.addCartItem(1, 2l);
		cartDao.addCartItem(1, 3l);
		System.out.println("user added a card item");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}

	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1l);
		System.out.println("user remove a card item");
		for (MenuItem menuItem : menuItemListCustomer) {
			cartDao.removeCartItem(1, 2l);
			System.out.println(menuItem);
		}

	}
}
