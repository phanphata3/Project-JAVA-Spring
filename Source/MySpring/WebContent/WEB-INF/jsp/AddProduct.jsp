<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add product</title>
</head>
<body>

	<h2>${ message}</h2>
	</br></br>

	<form:form method="post" action="addProduct.html">

	<table>
	<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:input path="id" placeholder="   Input Id here" /></td> 
	</tr>
	<tr>
		<td><form:label path="name">Name</form:label></td>
		<td><form:input path="name" placeholder="   Input name here"/></td>
	</tr>
	<tr>
		<td><form:label path="info">Info</form:label></td>
		<td><form:input path="info" placeholder="   Input info here"/></td>
	</tr>
	<tr>
		<td><form:label path="price">Price</form:label></td>
		<td><form:input path="price" type="number" size="10" placeholder="   Input number only"/></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Product"/>
		</td>
	</tr>
</table>	
	</br></br>
	<a href="AdminList.html"> Back to list</a>
</form:form>
</body>
</html>