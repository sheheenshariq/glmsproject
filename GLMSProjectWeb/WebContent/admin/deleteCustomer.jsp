<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="glms.bl.*,glms.dto.*,glms.dl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	String account_no="";
	int result=0;
%>
<%
	account_no=request.getParameter("ACCOUNT_NUMBER");
	result=CustomerBL.deleteCustomer(account_no);
	if(result>0)
	 {
	 	session.setAttribute("message", "customer details deleted successfully!");
	 	
	 }
	 else
	 {
	   	session.setAttribute("message", "Please try again later!");
	 }
	response.sendRedirect("customer_reg_view.jsp");
%>

</body>
</html>