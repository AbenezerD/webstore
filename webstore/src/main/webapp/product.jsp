<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
  
<title>Add New Product</title>
</head>
<body>
	<form action="ProductController.do" method="post">
		<fieldset>
			<div>
				<label for="productId">Contact ID</label> <input type="text"
					name="productId" value="<c:out value="${product.productId}" />"
					readonly="readonly" placeholder="Product ID[will be generated if not provided]" />
			</div>
			<div>
				<label for="name">Name</label> <input type="text"
					name="name" value="<c:out value="${product.name}" />"
					placeholder="Name" />
			</div>
			<div>
				<label for="price">Phone</label> <input type="text"
					name="price" value="<c:out value="${product.price}" />"
					placeholder="Price" />
			</div>

			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
</body>
</html>