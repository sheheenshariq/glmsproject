<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Date,glms.bl.*,glms.dl.*,glms.dto.*,java.text.DateFormat,java.text.SimpleDateFormat" %>
 <%!
    
 int aadhar,contact_no;
 String  cust_name,gender,address;
    //bookBL bl=null;
    CustomerDTO customer=null;
    int result=0;
    %>
    <% 
    try
    {


//customer_id=Integer.parseInt(request.getParameter("txtcustomer_id"));
aadhar=Integer.parseInt(request.getParameter("txtaadhar"));
contact_no=Integer.parseInt(request.getParameter("txtcontact_no"));
cust_name=request.getParameter("txtcust_name");
gender=request.getParameter("txtgender");
address=request.getParameter("txtaddress");

customer=new CustomerDTO();
//customer.setCustomer_id(customer_id);
customer.setCust_name(cust_name);
customer.setGender(gender);
customer.setAddress(address);
customer.setAadhar(aadhar);
customer.setContact_no(contact_no);

result=CustomerBL.addCustomer(customer);
if(result>0)
{
	session.setAttribute("message","Customer details added successfully");
}
else
{
	session.setAttribute("message","please try again");
}
response.sendRedirect("viewCustomer.jsp");

}
    
catch(Exception e)
{
System.out.println("**error**:customer:addCustomer_process.jsp"+e.getMessage());
session.setAttribute("message","please enter a valid mark");
response.sendRedirect("viewCustomer.jsp");
}
%>