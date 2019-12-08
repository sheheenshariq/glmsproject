<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="glms.dto.*,glms.dl.*,glms.dl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout process</title>
</head>
<body>
<%
	
	session.removeAttribute("user_name");
	session.removeAttribute("password");
	session.removeAttribute("session");
	session.removeAttribute("message");
    session.removeAttribute("ACCOUNT_NUMBER");
	response.sendRedirect("Login.jsp");

%>
</body>
</html>