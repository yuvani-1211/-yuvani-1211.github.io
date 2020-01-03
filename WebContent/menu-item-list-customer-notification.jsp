<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>(Add to Cart success)</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span class="tru">truYum</span> <img
		src="./images/truyum-logo-light.png "> <a href="ShowCart"
		class="ref"> Cart </a> <a href="menu-item-list-customer.html"
		class="ref1">Menu</a> </header>
	<div>

		<h1>Menu Items</h1>
		<h3 class="middle">${mes}</h3>
		<table>

			<tr>
				<th class="left">Name</th>
				<th class="center">Free Delivery</th>
				<th class="right">Price</th>
				<th class="center">category</th>
				<th class="center">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="left"><c:out value="${menu.name}"></c:out></td>
					<td class="center"><c:out
							value="${menu.freeDelivery?'Yes' :'No'}"></c:out></td>
					<td class="right"><c:out value="Rs. ${menu.price}"></c:out></td>
					<td class="center"><c:out value="${menu.category}"></c:out></td>
					<td class="center"><a href="AddToCart?menuItemId=${menu.id}"
						class="black">Add to Cart</a></td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<footer>
	<h3 class="black">Copyright@2019</h3>
	</footer>
</body>
</html>
