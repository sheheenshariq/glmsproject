package glms.dl;
import glms.dto.*;
import java.sql.*;
import java.util.*;

public class CustomerDL 
{
	public static int addCustomer(CustomerDTO customer)
	{
		   int result=0;
		   String query;
		   PreparedStatement ps=null;
		   Connection con;
		   String newstr=null;
		   String last_customer_id,new_customer_id;
		   LoginDTO login=null;
		  
		   try
		   {
			   con=DBHelper.getConnection();
			   last_customer_id=getLastcustomer_id();
			   
				if(last_customer_id!=null)
				{
				      new_customer_id=Helper.Generate(last_customer_id);
				}
				
				else
				{
					  new_customer_id="AC10001";
				}
				System.out.print("***NEW acnt no"+new_customer_id);
				
				   query="INSERT INTO CUSTOMER(CUSTOMER_NAME,GENDER,ADDRESS,AADHAR,CONTACT_NUMBER,ACCOUNT_NUMBER) VALUES(?,?,?,?,?,?)";			
				   ps=con.prepareStatement(query);
				   ps.setString(1,customer.getCustomer_name());
				   ps.setString(2,customer.getGender());
				   ps.setString(3,customer.getAddress());
				   ps.setString(4,customer.getAadhar());
				   ps.setString(5,customer.getContact_no());
				   ps.setString(6,new_customer_id);
				   
			      System.out.print("***"+new_customer_id);
			      
			      login=new LoginDTO();
	          	  login.setUsername(customer.getCustomer_name());
	          	  login.setPassword(customer.getAadhar());
	          	  login.setAccountNumber(new_customer_id);
	          	  result=LoginDL.addLogin(login);
			   
             result= ps.executeUpdate();
	       }
		   catch(Exception e)
		   {
			   System.out.println("**Error**CustomerDL:addCustomer " +e.getMessage());
		   }
		 return result;
	   }
	
	
       public static  int updateCustomer(CustomerDTO customer)
	   {
		   int result=0;
		   String query;
		   PreparedStatement ps=null;
		   Connection con;
		   
		   try
		   {
			   con=DBHelper.getConnection();
			   query = "UPDATE CUSTOMER SET CUSTOMER_NAME=?,GENDER=?,ADDRESS=?,CONTACT_NUMBER=?  WHERE ACCOUNT_NUMBER=?";
			   ps=con.prepareStatement(query);
			   ps.setString(1,customer.getCustomer_name());
			   ps.setString(2,customer.getGender());
			   ps.setString(3,customer.getAddress());
			   ps.setString(4,customer.getContact_no());
			   ps.setString(5,customer.getAccount_no());
			   
			   result= ps.executeUpdate();
			  
		   }
		   catch(Exception e)
		   {
			   System.out.println("**Error**CustomerDL:updateCustomer " +e.getMessage());
		   }
		   
		 return result;
	   }
	 
	 
	 public static int deleteCustomer(String account_no)
	 {
			int result=0;
			String query;
			PreparedStatement ps=null;
			Connection con;
			
			try
			{	
			    con=DBHelper.getConnection();
				query = "DELETE FROM CUSTOMER WHERE ACCOUNT_NUMBER=?";
				ps=con.prepareStatement(query);
				ps.setString(1,account_no);
				result = ps.executeUpdate();
				ps.close();
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("**error**:customerDL:deletecustomer"+e.getMessage());
			}
		   return result;
	 }
	 
	   public static CustomerDTO getCustomer(String account_no)
	   {
		   Connection con=null;
		   Statement statement=null;
		   ResultSet resultSet=null;
		   CustomerDTO customer=null;
		   String sql="";
		   try
		   {
			   sql="SELECT * FROM CUSTOMER WHERE ACCOUNT_NUMBER='" +account_no+"'"; 
			   con=DBHelper.getConnection();
			   statement =con.createStatement();
			   resultSet=statement.executeQuery(sql);
			   while(resultSet.next())
			   {
				   customer=new CustomerDTO(); 
				   
				   customer.setCustomer_name(resultSet.getString("CUSTOMER_NAME"));
				   customer.setGender(resultSet.getString("GENDER"));
				   customer.setAddress(resultSet.getString("ADDRESS"));
				   customer.setAadhar(resultSet.getString("AADHAR"));
				   customer.setContact_no(resultSet.getString("CONTACT_NUMBER"));
				   customer.setAccount_no(resultSet.getString("ACCOUNT_NUMBER"));
				}
		   }
		   catch(Exception e)
		   {
			   System.out.println("**Error**CustomerDL:getCustomer " +e.getMessage());
		   }
		 return   customer;
	   }
	
	public  static String getLastcustomer_id()
	{
		CustomerDTO customer=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String customer_id=null;
		
		try
		{
			String sql="SELECT ACCOUNT_NUMBER FROM CUSTOMER ORDER BY ACCOUNT_NUMBER DESC";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			
			if(resultSet.next())	
			{
				customer_id=resultSet.getString("ACCOUNT_NUMBER");
				System.out.print("***get last"+customer_id);
		    }
			resultSet.close();
			statement.close();
			con.close();
		 }
		catch(Exception e)
		{
			System.out.println("**error**:customerDL:getLastcustomer_id()"+e.getMessage());
		}
	  return customer_id;
	}
	
	public static ArrayList<CustomerDTO> getCustomers()
	{
		   ArrayList<CustomerDTO> customers=null;
		   Connection con=null;
		   Statement statement=null;
		   ResultSet resultSet=null;
		   CustomerDTO customer=null;
		   
		   try
		   {  
			   con=DBHelper.getConnection();
			   customers= new ArrayList<CustomerDTO>();
			   String sql="SELECT * FROM CUSTOMER";
			   statement =con.createStatement();
			   resultSet=statement.executeQuery(sql);
			   
			   while(resultSet.next())
			   {
				     customer=new CustomerDTO(); 
				     customer.setCustomer_name(resultSet.getString("CUSTOMER_NAME"));
				     customer.setGender(resultSet.getString("GENDER"));
				     customer.setAddress(resultSet.getString("ADDRESS"));
				     customer.setAadhar(resultSet.getString("AADHAR"));
				     customer.setContact_no(resultSet.getString("CONTACT_NUMBER"));
				     customer.setAccount_no(resultSet.getString("ACCOUNT_NUMBER"));
				     customers.add(customer);
			   }
			   resultSet.close();
			   statement.close();
			   con.close();
		   }
		   catch(Exception e)
		   {
			   System.out.println("**Error**CustomerDL:getCustomers" +e.getMessage());
		   }
		   
		  return customers;
	 }
}