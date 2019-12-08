<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="glms.bl.*,glms.dl.*,glms.dto.*" %>
 <%!
    
 String account_no,date,description;
 int loan_amount,net_gold_wt,installments,interest_rate;
   
    LoanDTO loan=null;
    int result=0;
    %>
    <% 
    try
    {


account_no=request.getParameter("txtaccount_no");
loan_amount=Integer.parseInt(request.getParameter("txtloan_amount"));
net_gold_wt=Integer.parseInt(request.getParameter("txtnet_gold_wt"));
date=request.getParameter("txtdate");
interest_rate=Integer.parseInt(request.getParameter("txtinterest_rate"));
description=request.getParameter("txtdescription");
installments=Integer.parseInt(request.getParameter("txtinstallments"));

loan=new LoanDTO();
loan.setAccount_no(account_no);
loan.setLoan_amount(loan_amount);
loan.setDate(date);
loan.setNet_gold_wt(net_gold_wt);
loan.setInterest_rate(interest_rate);
loan.setInstallments(installments);
loan.setDescription(description);
result=LoanBL.addLoan(loan);
if(result>0)
{
	session.setAttribute("message","Loan details added successfully");
}
else
{
	session.setAttribute("message","please try again");
}
response.sendRedirect("viewLoandetails.jsp");

}
    
catch(Exception e)
{
System.out.println("**error**:loan:addLoandetails_process.jsp"+e.getMessage());
session.setAttribute("message","please enter a valid deatils");
response.sendRedirect("viewLoandetails.jsp");
}
%>-
