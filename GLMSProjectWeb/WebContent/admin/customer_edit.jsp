<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="glms.dto.*,glms.bl.*,glms.dl.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Update Form</title>
</head>
<%
if(session.getAttribute("user_name")==null)
{

   response.sendRedirect("../styles/Login.jsp");
}

%>
   
<body>
<table width="100%" height="688" border="0">
  <tbody>
    <tr>
      <td height="684" align="center" valign="top"><table width="100%" border="0">
        <tbody>
          <tr>
            <td height="138" align="center" valign="middle" bgcolor="#0000FF"><h1 style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif; font-size: xx-large;">Customer Information System</h1></td>
          </tr>
          <tr>
            <td height="530" align="center" valign="top"><table width="100%" border="0">
              <tbody>
                <tr>
                  <td height="33" align="center" valign="middle"></td>
                </tr>
                <tr>
                <td height="33" align="center" valign="middle" style="font-family: Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif; font-weight: bold; font-size: large;">Update form</td>
                </tr>
                <tr>
                
                 <!-- Logout Modal-->
		   <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		      <div class="modal-content">
		        <div class="modal-header">
		          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
		            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
		              <span aria-hidden="true">×</span>
		            </button>
		           </div>
		          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
		         <div class="modal-footer">
		            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
		               <a class="btn btn-primary" href="../styles/Login.jsp">Logout</a>
		       </div>
		     </div>
		   </div>
		 </div>
		 
                   <%!
                   
                   String customer_name,gender,address,account_no,contact_no,aadhar;
                   String ecustomer_name,egender,eaddress,eaccount_no,econtact_no,eaadhar;
                   boolean ErrorFlag=false;
                   boolean sErrorFlag=false;
                   String message="";
                 
                   CustomerDTO customer=null;
                   int result=0;
                   %>
                   <%
                   if(request.getParameter("submit")!=null)
                   {
                	   message="";
                	   ErrorFlag=false;
                	   sErrorFlag=false;
                	   customer_name="";gender="";address="";account_no="";contact_no="";aadhar="";
                       ecustomer_name="";egender="";eaddress="";eaccount_no="";econtact_no="";eaadhar="";
                	   
                	   try
                	    {
                		    customer_name=request.getParameter("txtcustomer_name");
               		    	gender=request.getParameter("txtgender");
               		    	address=request.getParameter("txtaddress");
               		    	aadhar=request.getParameter("txtaadhar");
               		    	contact_no=request.getParameter("txtcontact_no");
               		    	account_no=request.getParameter("txtaccount_no");
               		    	
               		    	if(!sErrorFlag)
               		    	{
                		   
                		         customer = new CustomerDTO();
                		         customer.setCustomer_name(customer_name);
             			         customer.setGender(gender);
             			         customer.setAddress(address);
             			         customer.setAadhar(aadhar);
                                 customer.setContact_no(contact_no);
                                 customer.setAccount_no(account_no);
                		  
                		     if(!ErrorFlag)
                		     {
                		    	 result= CustomerBL.updateCustomer(customer);
                 			    if(result>0)
                 			    {
                 			    	session.setAttribute("message", "customer details updated successfully!");
                 			    }
                 			    else
                 			    {
                 			      	session.setAttribute("message", "Please try again later!");
                 			    }
                 		      response.sendRedirect("customer_reg_view.jsp");
                 		    }
               		      }
                                               		    
                	    }
                	    
                	   catch(Exception e)
               	  		{
               				System.out.println("**Error** Student: customer_edit.jsp "+e.getMessage());
               				message = "error " +  e.getMessage();
               	   		}
                  }
                  else
                   {
                	   message="";
                	   ErrorFlag=false;
                	   sErrorFlag=false;
                	   
                	   account_no=request.getParameter("ACCOUNT_NUMBER");
                	   customer=CustomerBL.getCustomer(account_no);
                	   if(customer!=null)
                	   {
                	   customer_name=customer.getCustomer_name();
                	   gender=customer.getGender();
                	   address=customer.getAddress();
                	   aadhar=""+customer.getAadhar();
                	   contact_no=""+customer.getContact_no();
                	   account_no=customer.getAccount_no();
                	  
                	   }
                	   else
                	   {
                		   customer_name="";gender="";address="";account_no="";contact_no="";aadhar="";
                           ecustomer_name="";egender="";eaddress="";eaccount_no="";econtact_no="";eaadhar="";
                	   }
                   }
                   
                   %>
                   
                  <td height="33" align="center" valign="middle" style="color: #F70509">
                  <%=message %>
                  
                  </td>
                </tr>
                <tr>
                  <td height="33" align="center" valign="middle">
					  <form  method="post" onsubmit="return validate();" >
					    <table width="100%" border="0">
					      <tbody>
					        <tr>
					          <td width="11%" height="30">&nbsp;</td>
					          <td width="11%">&nbsp;</td>
					          <td width="11%">&nbsp;</td>
					          <td width="17%" align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Customer name</td>
					          <td width="1%">&nbsp;</td>
					          <td width="16%" align="left" valign="middle">
					            <input type="text" name="txtcustomer_name" value='<%=customer_name%>' ></td>
					          <td width="26%" align="left" valign="middle" style="color: #F70509" >
					          
					          </td>
					          <td width="2%">&nbsp;</td>
					          <td width="2%">&nbsp;</td>
					          </tr>
					         <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Gender</td>
					          <td>&nbsp;</td>
					          
					          <!--  <td align="left" valign="middle"><input type="text" name="txtgender" value='<%=gender%>'></td>  -->
					          <td align="left" valign="middle" style="color: #F70509">
					            <select  name="txtgender">
							    <option value="0"  selected disabled >Select</option>
								<option  value="Male" >Male</option>
								<option value="Female" >Female</option>
							</select>
					          </td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr>
					        <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Address</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle"><input type="text" name="txtaddress" value='<%=address%>' ></td>
					          <td align="left" valign="middle" style="color: #F70509">
					             
					          </td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr>
					        <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Aadhar</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle"><input type="text" name="txtaadhar" value='<%=aadhar%>' readonly="true" ></td>
					          <td align="left" valign="middle" style="color: #F70509">
					            
					          </td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr>
					        <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Contact Number</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle"><input type="text" name="txtcontact_no"  value='<%=contact_no%>'></td>
					          <td align="left" valign="middle" style="color: #F70509">
					           
					          </td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr> 
					          
					           <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">Account number</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle"><input type="text" name="txtaccount_no"  value='<%=account_no%>' readonly="true"></td>
					          <td align="left" valign="middle" style="color: #F70509">
					           
					          </td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr> 
					        <tr>
					          <td height="30">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">&nbsp;</td>
					          <td>&nbsp;</td>
					          <td align="left" valign="middle"><input type="submit" name="submit" id="submit" value="Update"></td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          <td>&nbsp;</td>
					          </tr>
					        </tbody>
					      </table>
						  
						  
                      </form></td>
                </tr>
                
                
                
              
                <tr>
                  <td height="33" align="center" valign="middle">&nbsp;</td>
                </tr>
              </tbody>
            </table></td>
          </tr>
          <tr>
            <td align="center" valign="top"><table width="100%" border="0">
              <tbody>
                <tr>
                  <td align="center" valign="middle" bgcolor="#000000">&nbsp;</td>
                </tr>
                <tr>
                  <td align="center" valign="middle" bgcolor="#E7BF09"></td>
                </tr>
              </tbody>
            </table></td>
          </tr>
        </tbody>
      </table></td>
    </tr>
  </tbody>
</table>
</body>
</html>
