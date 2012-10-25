<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title><c:out value="Create Order Item" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<form:form commandName="orderItem" id="orderItem">>
		<table>
			<tbody>
				<tr>
					<td><form:label path="type">Type:</form:label></td>
					<td><form:select path="type" items="${types}"></form:select>
				</tr>
				<tr>
					<td><form:label path="iced">Iced:</form:label></td>
					<td><form:checkbox path="iced"></form:checkbox>
				</tr>
				<tr>
					<td><form:label path="shots">Shots:</form:label></td>
					<td><form:input path="shots"></form:input>
				</tr>
			</tbody>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="Add Order Item"  /></td>
			</tr>
		</table>
	</form:form>
	<a href="<c:url value="order"/>">Create Order</a>
	<a href="<c:url value="orderItem"/>">Create Order Item</a>
	<a href="<c:url value="status"/>">Check Status of Orders</a>
</body>