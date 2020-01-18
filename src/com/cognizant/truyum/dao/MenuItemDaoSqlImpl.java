package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	@Override
	public List<MenuItem> getMenuItemListAdmin() throws SQLException {

		List<MenuItem> menuItemList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();

		try {
			String sql = "select * from menu_item ";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				MenuItem menu = new MenuItem();
				menu.setId(rs.getLong(1));
				menu.setName(rs.getString(2));
				menu.setPrice(rs.getFloat(3));
				menu.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				menu.setCategory(rs.getString(5));
				menu.setDateOfLaunch(rs.getDate(6));
				menu.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				menuItemList.add(menu);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws SQLException {

		List<MenuItem> menuItemList = new ArrayList<>();

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from menu_item where me_active=? and me_date_of_launch =? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Yes");
			stmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MenuItem menu = new MenuItem();
				menu.setId(rs.getLong(1));
				menu.setName(rs.getString(2));
				menu.setPrice(rs.getFloat(3));
				menu.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				menu.setCategory(rs.getString(5));
				menu.setDateOfLaunch(rs.getDate(6));
				menu.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				menuItemList.add(menu);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) throws SQLException {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "update menu_item set me_name =?,me_price=?,me_active=?,me_date_of_launch=?, me_category=?,me_free_delivery=? where me_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, menuItem.getName());
			stmt.setFloat(2, menuItem.getPrice());
			stmt.setString(3, menuItem.isActive() ? "yes" : "No");
			stmt.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			stmt.setString(5, menuItem.getCategory());
			stmt.setString(6, menuItem.isFreeDelivery() ? "yes" : "No");
			stmt.setLong(7, menuItem.getId());

			int result = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws SQLException {
		MenuItem menu = new MenuItem();

		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "select * from menu_item where me_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, menuItemId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				menu.setId(rs.getInt(1));
				menu.setName(rs.getString(2));
				menu.setPrice(rs.getFloat(3));
				menu.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				menu.setCategory(rs.getString(5));
				menu.setDateOfLaunch(rs.getDate(6));
				menu.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return menu;

	}

}
