<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu Item List Admin</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span class="tru">truYum</span> <img
		src="./images/truyum-logo-light.png "> <a
		href="ShowMenuItemListAdmin" class="ref"> Menu </a> </header>
	<div>

		<h1>Menu Items</h1>
		<br>
		<br>
		<table>

			<tr>
				<th class="left">Name</th>
				<th class="right">Price</th>
				<th class="center">Active</th>
				<th>Date of Lunch</th>
				<th>category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>

					<td class="left"><c:out value="${menu.name}"></c:out></td>
					<td class="right"><c:out value="Rs.${menu.price}"></c:out></td>
					<td class="center"><c:out value="${menu.active? 'Yes' : 'No'}"></c:out></td>
					<td class="center"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menu.dateOfLaunch}" /></td>
					<td class="center"><c:out value="${menu.category}"></c:out></td>
					<td class="center"><c:out
							value="${menu.freeDelivery? 'Yes' : 'No'}"></c:out></td>
					<td class="center"><a
						href="ShowEditMenuItem?menuItemId=${menu.id}" class="black">Edit</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<footer>
	<h3 class="black">Copyright &copy 2019</h3>
	</footer>
</body>
</html>