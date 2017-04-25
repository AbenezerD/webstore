<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<img  style="float:left" alt="product_image" src="${product.image}" height="200px" width="200px">
	<p><strong>${product.name}</strong></p>
	<p><em>${product.price}</em></p>
	<textarea rows="5" cols="100" disabled="disabled">${product.description}</textarea>
	<p style="clear:left">5 left in store</p>
	</div>
	
	<a href="ProductController.do?action=addToCart&productId=<c:out value="${product.productId}"/>">Add To Cart</a>
</body>
</html>