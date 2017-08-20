
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>
	<a href="Help.html"> Help </a>|
	<a href="UserInfo.html"> Info </a>|
	<a href="${page}"> List of Products </a>|
	<c:url value="/Logout.html" var="logoutUrl"></c:url>  
    <a href="${logoutUrl }">Logout</a> 
	
	</br></br>
	<h2> This is main page </h2>
	</br></br>
	<h3>Welcome back ${user }</h3>
</body>
</html>

