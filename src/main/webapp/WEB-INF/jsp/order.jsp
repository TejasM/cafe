<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title><c:out value="Create Order" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<c:out value="Create Order:" />
	<br>
	<form:form commandName="order" id="order">>
		<table>
			<tbody>
				<tr>
					<td><form:label path="orderItems">Order Items:</form:label></td>
					<td><form:select path="orderItems" items="${orderItems}"></form:select>
				</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="Submit Order" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="<c:url value="order"/>">Create Order</a>
	<a href="<c:url value="orderItem"/>">Create Order Item</a>
	<a href="<c:url value="status"/>">Check Status of Orders</a>
	
</body>