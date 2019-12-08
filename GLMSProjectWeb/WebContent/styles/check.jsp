<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="glms.dto.*,glms.dl.*,glms.bl.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login check page</title>
</head>
<body>
	<%!LoginDTO user1 = null;
	LoginDTO user2 = null;
	String username;
	String password;
	String message = "	";
	String accountNumber = "";%>
	<%
		if (request.getParameter("login") != null)
		{
			username = request.getParameter("username");
			password = request.getParameter("password");
			user1 = new LoginDTO();
			user1.setUsername(username);
			user1.setPassword(password);
			user2 = new LoginDTO();
			user2 = LoginBL.checkLogin(user1);
			//accountNumber = user2.getAccountNumber();

			    if (user2 != null)
			    {
				session.setAttribute("user_name", user2.getUsername());
				session.setAttribute("password", user2.getPassword());
			    }
			    else
			    {
			    	out.println("Wrong id or password");
			    }
			    
			    
			    
				if (user2!=null && user2.getUsername().equals("admin")  ) 
				{
					out.println("Hello admin");
					response.sendRedirect("Home.jsp");
				} 
				else 
				{
					accountNumber=user2.getAccountNumber();
					out.println("Succesfully Logged in");
					session.setAttribute("session", "True");
					session.setAttribute("message", "Welcome" + request.getParameter("user_name"));
					session.setAttribute("ACCOUNT_NUMBER", accountNumber);
					response.sendRedirect("CustomerHome.jsp");
				}

			}

			
		
	%>
</body>
</html>