package glms.bl;
import glms.dto.*;
import glms.dl.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class CustomerBL
{
	public static int addCustomer(CustomerDTO customer)
	{
	    int result=0;
	   
	    try
		{  
		       result=CustomerDL.addCustomer(customer);             
		}
		catch(Exception e)
		{
			System.out.println("**Error**CustomerBL:addCustomer"+e.getMessage());
		}
	   return result;
	 }
	
	 public static int updateCustomer(CustomerDTO customer)
	 {
	   int result=0;
	                                   
		try
		{  
			result=CustomerDL.updateCustomer(customer);
		}
		catch(Exception e)
		{
		       System.out.println("**Error**CustomerBL:updateCustomer"+e.getMessage());
		}
	   return result;
	 }
	
	 public static int deleteCustomer(String account_no)
	 {
		int result=0;
		
		try
		{	
			result = CustomerDL.deleteCustomer(account_no);
			
		}
		catch(Exception e)
		{
			
			System.out.println("**error**:customerBL:deletecustomer"+e.getMessage());
		}
		return result;
	 }

	 public static CustomerDTO getCustomer(String account_no)
	 {
	   CustomerDTO customer = null;

		try
		{
		customer =CustomerDL.getCustomer(account_no);
	
		}

		catch(Exception e)
		{
		System.out.println("**error** CustomerBL:getCustomer()"+e.getMessage());
		}
	   return customer;
	 }
	
     public static ArrayList<CustomerDTO> getCustomers()
	 {
	    ArrayList<CustomerDTO> customers = null;

		try
		{
		   customers =CustomerDL.getCustomers();
	    }

		catch(Exception e)
		{
		    System.out.println("**error** CustomerBL:getCustomers()"+e.getMessage());
		}
	    return customers;
	 }
     
 }