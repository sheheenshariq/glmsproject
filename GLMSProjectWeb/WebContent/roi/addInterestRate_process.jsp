<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="glms.*,glms.bl.*,glms.dto.*,glms.dl.* "%>
<%!
	int interest_rate_change;
	String roi_date;
	InterestRateDTO roi = null;
	int r=0;
%>
<%
	try
	{
		interest_rate_change = Integer.parseInt(request.getParameter("ROI"));
		roi_date = request.getParameter("ROI_DATE");
        roi = new InterestRateDTO();
        roi.setInterest_rate_change(interest_rate_change);
        roi.setRoi_date(roi_date);
	     r = InterestRateBL.addROI(roi);
	
		if(r>0)
		{
			session.setAttribute("message","Interest details added successfully");
		}
		else
		{
			session.setAttribute("message","Please try again later");
		}
	response.sendRedirect("ChangeROI.jsp");
	}

	catch(Exception e)
	{
		System.out.println("**Error**: Interest: InterestRateAddProcess  "+e.getMessage());
		session.setAttribute("message", "Please enter  options!!!");
		response.sendRedirect("UpdateROI.jsp");
	}
%>