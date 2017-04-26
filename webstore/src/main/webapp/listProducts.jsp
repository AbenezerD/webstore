<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Contacts</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="script.js"></script>
 
</head>
<body>
<h2>A&E Shopping App.</h2>
Welcome ${userName} <a href="logout">LogOut</a> 
<center><p><a href="">About</a> || <a href="Cart" >Cart</a></p></center>
	<div id="listProducts">
	</div>
	<%-- <c:forEach items="${products}" var="product">
	<div>
	<a style="float:left" href="ProductController.do?action=detail&productId=${product.productId}"><img alt="product_image" src="${product.image}" height="100px" width="100px"></a>
	<p><strong>${product.name}</strong></p>
	<p><em>${product.price}</em></p>
	<p style="clear:left">5 left in store</p>
	</div>
	</c:forEach> --%>
	<pre>
	</pre>
	<h3>List Of Products Added to the Cart</h3>
	<table  border=1 width="400px">
			<c:forEach items="${cart.products}" var="product">
				<tr>
					<td><c:out value="${product.productId}" /></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.price}" /></td>
 					
				</tr>
			</c:forEach>
	</table>
	<p>
		<!-- <a href="ProductController.do?action=insert">Add Contact</a> -->
	</p>
</body>
</html>
	<pre>
	</pre>
	<p>
		<!-- <a href="ProductController.do?action=insert">Add Contact</a> -->
	</p>
</body>
</html>