<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<script type="text/javascript"
	src="/cafe/resources/js/jquery/jquery-1.8.2.min.js" />
<script type="text/javascript">
	var jq = jQuery.noConflict();
</script>
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
	<form:form commandName="order" id="order" onsubmit="return false;">
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
				<td><input type="submit" value="Submit Order"
					onclick="submitOrder()" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<span id="success"></span>
	<br>
	<a href="<c:url value="order"/>">Create Order</a>
	<a href="<c:url value="orderItem"/>">Create Order Item</a>
	<script type="text/javascript">
		document.write(document.attributes.getNamedItem("orderItems"));
	</script>

	<script type="text/javascript">
		function submitOrder() {
			jq(function() {
				// Call a URL and pass two arguments
				// Also pass a call back function
				// See http://api.jquery.com/jQuery.post/
				// See http://api.jquery.com/jQuery.ajax/
				// You might find a warning in Firefox: Warning: Unexpected token in attribute selector: '!' 
				// See http://bugs.jquery.com/ticket/7535
				jq.post("/cafe-web/order", jq('#order').serialize(), function(
						data) {
					// data contains the result
					// Assign result to the sum id
					jq("#success").replaceWith(
							'<span id="success">' + data + '</span>');
					jq("#table").load("/cafe/status");
				});
			});
		}
	</script>

</body>