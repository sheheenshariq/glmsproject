
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="glms.bl.*"%>
<%@ page import="glms.dl.*"%>
<%@ page import="glms.dto.*"%>
 <%!
    
 String accountNo;
 int paymentNo=0;
 PaymentDTO payment=null;
 int result=0;
    %>
    <%
    try
    {

	 accountNo=request.getParameter("sltaccountNo");
	 session.setAttribute("ACCOUNT_NUMBER", accountNo);
	 paymentNo=Integer.parseInt(request.getParameter("PaymentNo"));
	 payment=new PaymentDTO();
	 payment.setAccountNo(accountNo);
	 payment.setPaymentRemaining(paymentNo);
	 System.out.println("**acnt no in payment  process"+ accountNo);
	
	 result=PaymentBL.addPayment(payment);
	
	      
		if(result>0)
		{
			session.setAttribute("message","payment details added successfully");
		}
		
		else
		{
			session.setAttribute("message","please try again");
		}
	   response.sendRedirect("paymentform.jsp");
		
	}
    
	catch(Exception e)
	{
	System.out.println("**error**:loan:addPaymentdetails_process.jsp"+e.getMessage());
	session.setAttribute("message","please enter a valid deatils");
	response.sendRedirect("paymentform.jsp");
	}
%>