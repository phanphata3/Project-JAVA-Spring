<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Product</title>
</head>
<body>
	
	<center>
		<h1>${message }</h1>
		<h2>This is info of product(s)</h2>
		
		<table border="1">
			<tr>
				<center>
				<td class="heading"> <h4> ID </h4> </td>
				</center>
				
				<center>
				<td class="heading"> <h4> Name </h4> </td>
				</center>
				
				<center>
				<td class="heading"> <h4> Info </h4> </td>
				</center>
				
				<center>
				<td class="heading"> <h4> Price </h4> </td>
				</center>
			</tr>
	
		
		<c:forEach var="myProduct" items="${listProduct}" >
		<tr>
			<td>${myProduct.id }</td>
			<td>${myProduct.name }</td>
			<td>${myProduct.info }</td>
			<td>${myProduct.price }</td>
		</tr>
		
		</c:forEach>
		</table>
		
		</br></br>
		
		
		
		<a href="${page }">${info }</a>
	</center>
</body>
</html>