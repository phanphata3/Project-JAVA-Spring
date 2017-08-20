<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
		<h2> ${error } </h2>
	

		</br></br>
	   

      <form:form method="post" action="loginUser.html">
	
		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" placeholder="   Input Username"/></td> 
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" placeholder="   Input password"/></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="checkbox" value="yes" name="_spring_security_remember_me"/> Remember me </td><br/><br/>
			</tr>
			 
			<td></td>
				<td colspan="3">
					<input type="submit" value="Login"/>
				</td>
			</tr>
		</table>
		
			
		</form:form> 
     	
		</br></br>
		<a href="index.html">Back</a> 
	
	</center>
	


</body>
</html>