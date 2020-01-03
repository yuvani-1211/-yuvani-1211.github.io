package com.cognizant.truyum.dao;


import java.util.List;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testGetAllCartItems();
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
	}
	
	public static void testGetAllCartItems() throws CartEmptyException
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer=cartDao.getAllCartItems(1l);
		System.out.println("cart Items ");
		for(MenuItem menuItem : menuItemListCustomer)
		{
			System.out.println(menuItem);
		}
		
		}
	public static void testAddCartItem() throws CartEmptyException
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer=cartDao.getAllCartItems(1l);
		cartDao.addCartItem(1, 2l);
		cartDao.addCartItem(1, 3l);
		System.out.println("user added a card item");
		for(MenuItem menuItem : menuItemListCustomer)
		{
			System.out.println(menuItem);
		}
	}
	
	public static void testRemoveCartItem() throws CartEmptyException
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer=cartDao.getAllCartItems(1l);
		System.out.println("user remove a card item");
		for(MenuItem menuItem : menuItemListCustomer)
		{
			cartDao.removeCartItem(1,2l);
			System.out.println(menuItem);
		}
	
		
		
	}
	
}
