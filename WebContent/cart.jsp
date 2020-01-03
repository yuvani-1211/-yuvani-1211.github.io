<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span class="tru">truYum</span> 
	<img src="./images/truyum-logo-light.png "> 
	<a href="ShowCart" class="ref"> Cart </a> <a href="ShowMenuItemListCustomer" class="ref1">Menu</a>
	</header>
	<div>

		<h1>Cart</h1>
		<br>
		<br>
		<h3 class="middle">${mes}</h3>
		<table>

			<tr>
				<th class="left">Name</th>
				<th class="freedeli">Free Delivery</th>
				<th class="right">Price</th>
				<th class="center">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="cart">
				<tr>
					<td class="left"><c:out value="${cart.name}"></c:out></td>
					<td class="freedeli"><c:out
							value="${cart.freeDelivery?'Yes':'No'}"></c:out></td>
					<td class="right"><c:out value="Rs .${cart.price}"></c:out></td>
					<td class="delete"><a href="RemoveCart?menuItemId=${cart.id}"
						class="black">Delete</a></td>

				</tr>
			</c:forEach>
			<table>
				<tr>
					<td></td>
					<th class="right">Total:</th>
					<th class="left">Rs .${total}</th>
				</tr>
			</table>
		</table>
	</div>
	<footer>
	<h3 class="black">Copyright &copy 2019</h3>
	</footer>
</body>
</html>
