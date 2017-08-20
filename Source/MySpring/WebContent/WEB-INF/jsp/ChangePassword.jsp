<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
		
		<form:form method="post" action="changePassword.html">
	
		<table>
			<tr>
				<td><form:label path="password">Old password</form:label></td>
				<td><form:password path="password" placeholder="   Input old password"/></td> 
			</tr>
			<tr>
				<td><form:label path="password1">New password</form:label></td>
				<td><form:password path="password1" placeholder="   Input new password"/></td>
			</tr>
			
			<tr>
				<td><form:label path="password2">Re-input new password</form:label></td>
				<td><form:password path="password2" placeholder="   Re-input new passord"/></td>
			</tr>
			
			<tr>
			<tr>
			
			</tr>
			<td></td>
				<td colspan="3">
					<input type="submit" value="Change"/>
				</td>
			</tr>
		</table>	
			
		</form:form>
		</br></br>
		<a href="${page} ">${info }</a>
	</center>
	


</body>
</html>