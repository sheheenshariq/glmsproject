<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" import="glms.dl.*,glms.bl.*,glms.dto.*,java.util.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>View All customer</title>
</head>

<body>
<table width="100%" height="688" border="0" background="img.jpg">
  <tbody>
    <tr>
      <td height="684" align="center" valign="top"><table width="100%" border="0">
        <tbody>
          <tr>
            <td height="138" align="center" valign="middle" bgcolor="#808080"><h1 style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif; font-size: xx-large;color:#FFFFFF">CUSTOMER DETAILS</h1></td>
          </tr>
          <tr>
            <td height="530" align="center" valign="top"><table width="100%" border="0">
              <tbody>
              <tr>
                  <td height="33" align="left" valign="middle" style="color: #F70509">
                  <!--  
                  		if(session.getAttribute("user_name")!=null)
                  		{
                  			out.println("	Hello	"+(String)session.getAttribute("user_name"));
                  			
                  		}
                  		/*else
                  		{
                  			response.sendRedirect("../authentication/login.jsp");
                  		}*/
                  		
                  -->
                 </td>
                </tr>
                <tr>
                  <td height="33" align="center" valign="middle">
                  </td>
                </tr>
                <tr>
                  <td height="33" align="center" valign="middle" style="font-family: Cambria, 'Hoefler Text', 'Liberation Serif', Times, 'Times New Roman', serif; font-weight: bold; font-size: large;">CUSTOMER DETAILS</td>
                </tr>
                <tr>
                  <td height="33" align="center" valign="middle" style="color: #F70509">
                  <% 
                  		if(session.getAttribute("message")!=null)
                  		{
                  			out.println((String)session.getAttribute("message"));
                  			session.removeAttribute("message");
                  		}
                  %>
                 </td>
                </tr>
                <tr>
                  <td height="33" align="center" valign="middle">
					  <form id="form1" name="form1" method="post">
					  <%
					  ArrayList<CustomerDTO> customers = CustomerBL.getcustomers();
					  	if(customers!=null && customers.size()>0)
						{
	

					  %>
					    <table width="80%" border="1" align="center" bordercolor="#808080" border>
					      <tbody style="">
					        <tr>
					          
					          <td width="16%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">CUSTOMER NAME</span></td>
					          <td width="12%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">GENDER</span></td>
					          <td width="12%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">ADDRESS</span></td>
					          <td width="11%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">AADHAR</span></td>
					          <td width="20%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">CONTACT NO</span></td>
					          <td width="20%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">UPDATE</span></td>
					          <td width="18%" align="center" valign="middle" bgcolor="#E7BF09"><span style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif">DELETE</span></td>
					          </tr>
					          <%
					          	for(CustomerDTO customer : customers)
					          	{
					          %>
					        <tr>
					          <td height="30"><%= customer.getCust_name() %>&nbsp;</td>
					          <td><%=customer.getGender()%>&nbsp;</td>
					          <td align="left" valign="middle" style="font-family: 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans', 'DejaVu Sans', Verdana, sans-serif"><%=customer.getAddress() %></td>
					          <td><%= customer.getAadhar() %>&nbsp;</td>
					          <td align="left" valign="middle"><%= customer.getContact_no() %>&nbsp;</td>
					          <td align="left" valign="middle"><a href="editCustomer.jsp?aadhar=<%= customer.getAadhar()%>">Update</a>&nbsp;</td>
					          <td align="left" valign="middle"><a href="deleteCustomer.jsp?aadhar=<%= customer.getAadhar()%>" onclick="return confirm('Are you sure?')">Delete</a>&nbsp;</td>
					          
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
                  <td align="center" valign="middle" bgcolor="#C0C0C0"></td>
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
