package com.cognizant.truyum.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet({ "/RemoveCartServlet", "/RemoveCart" })
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			long menuItemId = Long.parseLong(request.getParameter("menuItemId"));
			CartDao cartDao = new CartDaoCollectionImpl();
			cartDao.removeCartItem(1, menuItemId);
			request.setAttribute("mes", "Item removed to Cart Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCart");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mes", "No items in cart. Use 'Add to Cart' option in");
			RequestDispatcher rd = request.getRequestDispatcher("cart-empty.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
