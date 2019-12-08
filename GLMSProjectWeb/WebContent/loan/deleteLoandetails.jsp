<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="glms.bl.*,glms.dto.*,glms.bl.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	String accountNo="";
	int result=0;
%>
<%
		accountNo=request.getParameter("accountNo");
		result=LoanBL.deleteLoan(accountNo);
			if(result>0)
			 {
			 	session.setAttribute("message", "Loan details deleted successfully!");
			 	
			 }
			 else
			 {
			   	session.setAttribute("message", "");
	         }
       response.sendRedirect("LoanTable.jsp");
%>
</body>
</html>