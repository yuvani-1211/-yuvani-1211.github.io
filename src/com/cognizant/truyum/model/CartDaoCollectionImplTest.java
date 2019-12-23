package com.cognizant.truyum.model;

import java.util.List;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
		testAddCartItem();
		testRemoveCartItem();
	}
	
	public static void testGetAllCartItems()
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	public static void testAddCartItem() throws CartEmptyException
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2l);
		cartDao.addCartItem(1, 5l);
		cartDao.addCartItem(2, 1l);
		cartDao.addCartItem(2, 3l);
		List<MenuItem> menuItemListCustomer=cartDao.getAllCartItems(1l);
		System.out.println("user added a cart item");
		for(MenuItem menuItem : menuItemListCustomer)
		{
			System.out.println(menuItem);
		}
	}
	
	public static void testRemoveCartItem()
	{
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,2l);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
