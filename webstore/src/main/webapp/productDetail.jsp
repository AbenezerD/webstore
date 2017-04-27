<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>product detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/styleMain.css">

</head>
<body>
	<jsp:include page="page_header.jsp" />
		<div class="mainContainer">
		
			<div>
				<img style="float: left" alt="product_image" src="${product.image}" height="200px" width="200px">
				<p><strong>${product.name}</strong></p>
				<p><em>${product.price}</em>
				</p><textarea rows="5" cols="100" disabled="disabled">${product.description}</textarea>
				<p style="clear: left"><c:out value = "${product.quantity}"></c:out> left in store</p>
			</div>
		
	<a href="Home?action=addToCart&productId=<c:out value="${product.productId}"/>">Add To Cart</a>
	|| <a href="home.jsp">back to list of products</a>
		</div>
	<jsp:include page="page_footer.jsp" />
</body>
</html>