<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="glms.bl.*"%>
<%@ page import="glms.dl.*"%>
<%@ page import="glms.dto.*"%>
 <%!
    
 String accountNo;
 String Emidate;
 int PaymentNo=0;
   
    EmiDTO emi=null;
    int result=0;
 %>
    <% 
    try
    {
        accountNo=request.getParameter("txtAccountNumber");
		Emidate=request.getParameter("EMIdate");
		PaymentNo=Integer.parseInt(request.getParameter("paymentNo"));
		        System.out.println("****acnt in process"+ accountNo);
		emi=new EmiDTO();
		emi.setAccountNo(accountNo);
		emi.setEmiDate(Emidate);
		emi.setPaymentNo(PaymentNo);

	   result=EmiBL.addEmi(emi);
	if(result>0)
	{
		session.setAttribute("message","calculate emi details  successfully");
	}
	else
	{
		session.setAttribute("message","please try again");
	}
	response.sendRedirect("EmiTable.jsp");
	
	}
    
	catch(Exception e)
	{
	System.out.println("**error**:emi:addemidetails_process.jsp"+e.getMessage());
	session.setAttribute("message","please enter a valid deatils");
	response.sendRedirect("EmiTable.jsp");
	}
%>