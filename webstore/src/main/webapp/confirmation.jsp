<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div>
		<fieldset>
			<legend>Confirmation: </legend>
			<blockquote>You have successfully finished the Purchasing process, and bellow
			listed products will arrive on time to this shipping address...<br> 
			 Thank you! for choosing us.</blockquote>
			
			<p>Customer: ${customer.name}</p>
			<p>Shipping Address: ${address.shipping}</p>
			<p>Billing Address: ${address.billing}</p>
			
		</fieldset>
	</div>
	<table border=1 width="400px">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.products}" var="product">
				<tr>
					<td><c:out value="${product.productId}" /></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ConfirmationController">Go To Home</a> || <a href="logout">Log out</a>
</body>
</html>