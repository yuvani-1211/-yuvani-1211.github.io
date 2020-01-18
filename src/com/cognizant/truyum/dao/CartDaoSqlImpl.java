package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public void addCartItem(long userId, long menuItemId) throws SQLException {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "insert into cart (ct_us_id,ct_pr_id)values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			int res = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> cartItemList = new ArrayList<>();
		Cart cart = new Cart();
		String sql = "SELECT me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery FROM menu_item inner join cart on ct_pr_id=me_id where ct_us_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem();
				m.setName(rs.getString(1));
				m.setPrice(rs.getFloat(2));
				m.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
				m.setDateOfLaunch(rs.getDate(4));
				m.setCategory(rs.getString(5));
				m.setFreeDelivery(rs.getString(6).equalsIgnoreCase("Yes"));
				cart.getMenuItemList().add(m);
			}

			String query = "SELECT sum(me_price) as TotalPrice\r\n" + "FROM menu_item\r\n" + "inner join cart \r\n"
					+ "on ct_pr_id=me_id\r\n" + "where cart.ct_us_id=?;";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setLong(1, 1);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cart.getMenuItemList();

	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "DELETE FROM cart" + "WHERE ct_us_id=? AND ct_pr_id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);

			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}

}
