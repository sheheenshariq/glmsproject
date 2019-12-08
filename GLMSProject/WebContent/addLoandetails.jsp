<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addLoandetails_process.jsp">
<table>
<tr>
    <td>ACCOUNT NUMBER</td>
    <td>
       <input type="text" name="txtaccount_no" id="txtaccount_no">
    </td>
</tr>
<tr>
    <td>LOAN AMOUNT</td>
     <td>
       <input type="text" name="txtloan_amount" id="txtloan_amount">
    </td>
</tr>
<tr>
    <td>ISSUE DATE</td>
     <td>
       <input type="text" name="txtdate" id="txtdate">
    </td>
</tr>
<tr>
    <td>NET GOLD WEIGHT</td>
     <td>
       <input type="text" name="txtnet_gold_wt" id="txtnet_gold_wt">
    </td>
</tr>
<tr>
    <td>INTEREST RATE</td>
     <td>
       <input type="text" name="txtinterest_rate" id="txtinterest_rate">
    </td>
</tr>
<tr>
    <td>INSTALLMENTS</td>
     <td>
       <input type="text" name="txtinstallments" id="txtinstallments">
    </td>
</tr>
<tr>
    <td>DESCRIPTION</td>
     <td>
       <input type="text" name="txtdescription" id="txtdescription">
    </td>
</tr>
<tr>
    <td></td>
     <td>
       <input type="submit" name="submit" id="submit" value="ADD">
    </td>
</tr>
</table>
</form>
</body>
</html>