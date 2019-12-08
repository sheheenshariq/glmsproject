<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,glms.bl.*,glms.dto.*,glms.dl.*,java.text.SimpleDateFormat,java.text.DateFormat" %>
<%!
	 String contact_no,aadhar,Password;
	 String account_no,customer_name,gender,address,Username,AccountNumber;
	 String date;  	
     CustomerDTO customer=null;
     LoginDTO login=null;
     int result=0;
     String ac=null;
%>
 <%
 
 
  try
  {
	  customer_name=request.getParameter("txtcustomer_name");
	  gender=request.getParameter("txtgender");
	  address=request.getParameter("txtaddress");
	  aadhar=request.getParameter("txtaadhar");
	  contact_no=request.getParameter("txtcontact_no");
	  System.out.println("********account no"+ac);
	  
	   
	                                           //response.sendRedirect("CustomerHome.jsp");
	       
              customer=new CustomerDTO();
			  customer.setCustomer_name(customer_name);
			  customer.setGender(gender);
			  customer.setAddress(address);
			  customer.setAadhar(aadhar);
              customer.setContact_no(contact_no);
              System.out.println("********set to db acnt no is "+ac);
              
              result=CustomerBL.addCustomer(customer);
		        
				  if(result >0)
				  {
					  session.setAttribute("message", "Customer added successfully!!!");
                  }
				  else
				  {
					  session.setAttribute("message", "Please try again");
				  }
				  response.sendRedirect("customer_reg_view.jsp");
  }
  catch(Exception e)
  {
	   result=-1;
	   System.out.println("**Error**customer_add_process.jsp :addCustomer " +e.getMessage());
	   //session.setAttribute("message", "Server Busy, Please Try Again,Later");  //server validation
	   response.sendRedirect("CustomerDetails.jsp");
  }
 %>
  
  
  
  
  
  
  