<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change info product</title>
</head>
<body>

	<h2>${ message}</h2>
	</br></br>

	<form:form method="post" action="changeProduct.html">

	<table>
	<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:label path="id" >${id }</form:label></td>
		
	</tr>
	<tr>
		<td><form:label path="name">Name</form:label></td>
		<td><form:input path="name" placeholder="   ${name }"></form:input></td>
		</td></td>
	<td><p class="help-block">( ${name } )</p></td>
	</tr>
	
	
	<tr>
		<td><form:label path="info">Info</form:label></td>
		<td><form:input path="info" placeholder="   ${info }"></form:input></td>
		</td></td>
	<td><p class="help-block">( ${info } )</p></td>
	</tr>
	
	
	<tr>
		<td><form:label path="price">Price</form:label></td>
		<td><form:input path="price" type="number" size="10" placeholder="   ${price }"></form:input></td>
		</td></td>
	<td><p class="help-block">( ${price } )</p></td>
	</tr>
	
	
	<tr></tr>
	<tr></tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Change Product"/>
		</td>
	</tr>
</table>	
	</br></br>
	<a href="AdminList.html"> Back to list</a>
</form:form>
</body>
</html>