<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="glms.dto.*" %>
     <%@page import="glms.bl.*" %>
      <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
  if(session.getAttribute("message")!=null)
   {
   	out.println((String)session.getAttribute("message"));
   	session.removeAttribute("message");
	}
 %>
  <%
  ArrayList<LoanDTO> loans = LoanBL.getLoans();
  if(loans!=null && loans.size()>0)
   {
%>
<table border="1">
<tr>
    <td>ACCOUNT NUMBER</td>
    <td>LOAN AMOUNT</td>
    <td>ISSUE DATE</td>
    <td>NET GOLD WEIGHT</td>
    <td>INTEREST RATE</td>
    <td>INSTALLMENTS</td>
    <td>DESCRIPTION</td>
    <td>DELETE</td>
</tr>
<%
for(LoanDTO loan : loans)
{
 %>
<tr>
    <td><%=loan.getAccount_no()%>&nbsp;</td>
    <td><%=loan.getLoan_amount()%>&nbsp;</td>
    <td><%=loan.getDate()%>&nbsp;</td>
    <td><%=loan.getNet_gold_wt()%>&nbsp;</td>
    <td><%=loan.getInterest_rate()%>&nbsp;</td>
    <td><%=loan.getInstallments()%>&nbsp;</td>
    <td><%=loan.getDescription()%>&nbsp;</td>
    <td><a href="deleteLoandetails.jsp?account_no=<%=loan.getAccount_no() %>" onclick="return confirm('Are You Sure To Delete!!!')">DELETE</a></td>
</tr>
<%
  	}
}
	else
	{
		 %>
         <tr>
         <td colspan="7">No Customer Details Found!!!!!!</td>
         </tr>
<%
	}
%>
	

	
</table>						
</body>
</html>