package glms.dl;
import glms.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
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
		try
		{
			con=DBHelper.getConnection();
			last_customer_id=getLastcustomer_id();
			if(last_customer_id!=null)
			{
			new_customer_id=customer.generate(last_customer_id);
			}
			else
			{
				new_customer_id="CUS101";
			}
			System.out.print("***"+new_customer_id);
			query = "INSERT INTO CUSTOMER(CUSTOMER_ID,CUST_NAME,GENDER,ADDRESS,AADHAR,CONTACT_NO,ACCOUNT_NO) VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
		    ps.setString(1, new_customer_id);
			ps.setString(2,customer.getCust_name());
			ps.setString(3, customer.getGender());
			ps.setString(4, customer.getAddress());
			ps.setInt(5, customer.getAadhar());
			ps.setInt(6, customer.getContact_no());
		    ps.setString(7, "1");
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:customerDL:addcustomer"+e.getMessage());
		}
		return result;
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
			String sql="SELECT CUSTOMER_ID FROM CUSTOMER ORDER BY CUSTOMER_ID DESC";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			if(resultSet.next())	
			{
				customer_id=resultSet.getString("customer_id");
				
				
			}
			resultSet.close();
			statement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			//result=-1;
			System.out.println("**error**:customerDL:getLastcustomer_id()"+e.getMessage());
		}
		return customer_id;
	}
	public static int updateCustomer(CustomerDTO customer)
	{
		
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			con=DBHelper.getConnection();
			query = "UPDATE CUSTOMER SET CUST_NAME=?,GENDER=?,ADDRESS=?,CONTACT_NO=? WHERE AADHAR=?";
			ps=con.prepareStatement(query);
			
			ps.setString(1,customer.getCust_name());
			ps.setString(2, customer.getGender());
			ps.setString(3, customer.getAddress());
			
			ps.setInt(4, customer.getContact_no());
			ps.setInt(5, customer.getAadhar());
			result=ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:customerDL:updateCustomer"+e.getMessage());
		}
		return result;
	}
	public static int deleteCustomer(int aadhar)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{	
			
			con=DBHelper.getConnection();
			query = "DELETE FROM CUSTOMER WHERE AADHAR=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, aadhar);
			result = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			//result=-1;
			System.out.println("**error**:customerDL:deletecustomer"+e.getMessage());
		}
		return result;
	}
	public static CustomerDTO getcustomer(int aadhar)
	{
		CustomerDTO customer=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try
		{
			String sql="SELECT * FROM CUSTOMER WHERE AADHAR="+aadhar;
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())	
			{
				customer=new CustomerDTO();
				//customer.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				customer.setCust_name(resultSet.getString("CUST_NAME"));
				customer.setGender(resultSet.getString("GENDER"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customer.setAadhar(resultSet.getInt("AADHAR"));
				customer.setContact_no(resultSet.getInt("CONTACT_NO"));
				
			}
			resultSet.close();
			statement.close();
			con.close();
			//return customer;
		}
		catch(Exception e)
		{
			System.out.println("**error**:customerDL:getcustomer"+e.getMessage());
		}
		return customer;
	}
	public static ArrayList<CustomerDTO> getcustomers()
	{
		ArrayList<CustomerDTO> customers=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		CustomerDTO customer=null;
		try
		{
			customers=new ArrayList<CustomerDTO>();
			String sql="SELECT * FROM CUSTOMER";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
				
			{
				customer=new CustomerDTO();
				//customer.setCustomer_id(resultSet.getInt("CUSTOMER_ID"));
				customer.setCust_name(resultSet.getString("CUST_NAME"));
				customer.setGender(resultSet.getString("GENDER"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customer.setAadhar(resultSet.getInt("AADHAR"));
				customer.setContact_no(resultSet.getInt("CONTACT_NO"));
				customers.add(customer);
			}
			resultSet.close();
			statement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:customerDL:getcustomers"+e.getMessage());
		}
		return customers;
	}
}
