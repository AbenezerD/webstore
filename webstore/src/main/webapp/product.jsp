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
<jsp:include page="page_header.jsp" />
	<form action="ProductController.do" method="post">
		<fieldset>
			<p>
				<label for="productId">Product ID</label> <input type="text"
					name="productId" value="<c:out value="${cProduct.productId}" />"
					placeholder="Product ID[will be generated if not provided]" />
			</p>
			<p>
				<label for="name">Name</label> <input type="text"
					name="name" value="<c:out value="${cProduct.name}" />"
					placeholder="Name" />
			</p>
			<p>
				<label for="price">Price</label> <input type="text"
					name="price" value="<c:out value="${cProduct.price}" />"
					placeholder="Price" />
			</p>
			<p>
				<label for="description">Description</label> <input type="text"
					name="description" value="<c:out value="${cProduct.description}" />"
					placeholder="Description" />
			</p>
			<p>
				<label for="image">Image</label> <input type="text"
					name="image" value="<c:out value="${cProduct.image}" />"
					placeholder="Image" />
			</p>
			<p>
				<label for="quantity">Quantity</label> <input type="text"
					name="quantity" value="<c:out value="${cProduct.quantity}" />"
					placeholder="Quantity" />
			</p>
			<input type="hidden" name="action" value="${action}"/>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
	
<jsp:include page="page_footer.jsp" />
</body>
</html>