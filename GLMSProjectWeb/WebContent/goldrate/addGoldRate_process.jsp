<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="glms.bl.*,glms.dl.*,glms.dto.*" %>
 <%!
 int goldrate;
 String date;
 GoldRateDTO gold_rate=null;
 int result=0;
 %>
    <% 
    try
    {
        goldrate=Integer.parseInt(request.getParameter("txtgold_rate"));
		System.out.println("goldrate********"+goldrate);
		date=request.getParameter("txtdate");
		System.out.println("date********"+date);
		
        gold_rate=new GoldRateDTO();
		gold_rate.setGold_rate(goldrate);
		gold_rate.setDate(date);

        result=GoldRateBL.addGold_Rate(gold_rate);

			if(result>0)
			{
				session.setAttribute("message","Gold rate details added successfully");
			}
			else
			{
				session.setAttribute("message","please try again");
			}
        response.sendRedirect("ChangeGoldRate.jsp");

      }
    
	catch(Exception e)
	{
		System.out.println("**error**:loan:addGoldRate_process.jsp"+e.getMessage());
		session.setAttribute("message","please enter a valid details");
		response.sendRedirect("ChangeGoldRate.jsp");
	}
%>