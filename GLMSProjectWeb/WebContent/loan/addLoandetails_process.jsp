<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="glms.bl.*"%>
<%@ page import="glms.dl.*"%>
<%@ page import="glms.dto.*"%>
 <%!
    
 String accountNo,issueDate,description;
 int netGoldwt,tenure,interestRate;
 LoanDTO loan=null;
 int result=0;
 %>
    <% 
    try
    {
		accountNo=request.getParameter("txtaccount_no");
		//loan_amount=Integer.parseInt(request.getParameter("txtloan_amount"));
		netGoldwt=Integer.parseInt(request.getParameter("txtnet_gold_wt"));
	    interestRate=Integer.parseInt(request.getParameter("sltLoanrate"));
		description=request.getParameter("txtdescription");
		tenure=Integer.parseInt(request.getParameter("txttenure"));
		issueDate=request.getParameter("txtdate");
		
			loan=new LoanDTO();
			
			loan.setAccountNo(accountNo);
			loan.setIssueDate(issueDate);
			loan.setNetGoldwt(netGoldwt);
			loan.setInterestRate(interestRate);
			loan.settenure(tenure);
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
          response.sendRedirect("LoanTable.jsp");

   }
    
	catch(Exception e)
	{
			System.out.println("**error**:loan:addLoandetails_process.jsp"+e.getMessage());
			session.setAttribute("message","please enter a valid deatils");
			response.sendRedirect("LoanTable.jsp");
	}
%>