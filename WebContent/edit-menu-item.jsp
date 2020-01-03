<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Menu Item</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span class="tru">truYum</span> <img
		src="./images/truyum-logo-light.png "> <a
		href="ShowMenuItemListAdmin" class="ref"> Menu </a> </header>
	<div>
		<form name="myform" onsubmit="return validform()"
			action="EditMenuItem?menuItemId=${menuItem.id}" method="post">

			<h1>Menu Items</h1>
			<br>
			<br>
			<table>
				<tr>
					<td>Name</td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" name="name" id="name"
						class="size" value="${menuItem.name}"></td>
				</tr>
				<tr>
					<td>Price (Rs.)</td>
					<td>Active</td>
					<td>Date of Launch</td>
					<td>Category</td>
				</tr>
				<tr>




				</tr>
				<tr>
					<td><input type="text" name="price" id="price" class="right"
						value="${menuItem.price}"></td>
					<td><input type="radio" id="yes" name="rd"
						value="${menuItem.active}" checked="${menuItem.active}"><label for="yes">Yes</label>
						<input type="radio" id="no" name="rd"><label for="no">No</label>
					</td>
					<td><input type="text" name="tetdate" id="date"
						value="<fmt:formatDate pattern="dd/MM/yyyy"  value="${menuItem.dateOfLaunch}"/>">
					</td>

					<td><select type="text" name="category">
							<option value="${menuItem.category}">${menuItem.category}</option>
							<option>Starters</option>
							<option>Main Course</option>
							<option>Dessert</option>
							<option>Drinks</option>
					</select></td>
				</tr>
				<tr colspan="2">
					<td><input type="checkbox" name="check" id="check"
						value="${menuItem.freeDelivery}" checked>Free Delivery</td>
				</tr>
				<tr colspan="2">
					<td><input type="submit" value="Save" class="button" /></td>
				</tr>

			</table>
		</form>
	</div>
	<footer>
	<h3 class="black">Copyright &copy 2019</h3>
	</footer>
	<script src="./js/script.js"></script>
</body>
</html>
