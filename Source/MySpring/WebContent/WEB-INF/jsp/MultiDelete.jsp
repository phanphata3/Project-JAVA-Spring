<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multi delete Product</title>
</head>
<body>
	
	<center>
		<h1>${message }</h1>
		<h2>This is list of ID product(s)</h2>
		
		<form:form method="post" action="multiDelete.html">
			<table>
				<c:forEach var="myProduct" items="${listProduct}">
					<tr >
						${myProduct.id },
					</tr>
				</c:forEach>
			
				<tr>
					<td><form:label path="del">Choose</form:label></td>
					<td></td>
					<td><form:input path="del" /></td> 
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td colspan="3">
						<input type="submit" value="Delete"/>
					</td>
				</tr>
			</table>
		</form:form>
		</br></br>
		<a href="${page }">${info }</a>
	</center>
</body>
</html>