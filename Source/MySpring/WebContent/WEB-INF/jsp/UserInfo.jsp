<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information</title>
<h2>${message }</h2>

</head>
<body>

	<h2>Infomation of ${username }</h2>
	<form:form>

	<table>

	<tr>
		<td>Name</td>
		<td>:</td>
		<td></td>
		<td>${name }</td> 
	</tr>
	<tr>
		<td>Address</td>
		<td>:</td>
		<td></td>
		<td>${address }</td> 
	</tr>
	<tr>
		<td>Email</td>
		<td>:</td>
		<td></td>
		<td>${email }</td> 
	</tr>
	<tr>
		<td>Phone</td>
		<td>:</td>
		<td></td>
		<td>${phone }</td> 
	</tr>
</table>	
	
</form:form>
	</br></br>
	
<a href="${change }">${changeinfo }</a></br>
<a href="${page }">${info }</a>
</body>
</html>