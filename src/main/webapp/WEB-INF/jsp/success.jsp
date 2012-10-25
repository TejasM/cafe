<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title><c:out value="Success" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	${message}
	<br>
	<a href="<c:url value="order"/>">Create Order</a>
	<a href="<c:url value="orderItem"/>">Create Order Item</a>
	<a href="<c:url value="status"/>">Check Status of Orders</a>
	
</body>