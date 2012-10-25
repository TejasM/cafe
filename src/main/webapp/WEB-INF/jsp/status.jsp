<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title><c:out value="Order Status" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<c:out value="Delivered:" />
	<br>
	<table>
		<c:forEach var="delivery" items="${delivered}">
			<tr>
				<td>${delivery}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<c:out value="Working On:" />
	<br>
	<table>
		<c:forEach var="order" items="${ordersInWorks}">
			<tr>
				<td>${order}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value="order"/>">Create Order</a>
	<a href="<c:url value="orderItem"/>">Create Order Item</a>
	<a href="<c:url value="status"/>">Check Status of Orders</a>

</body>