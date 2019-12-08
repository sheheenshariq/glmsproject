package glms.bl;
import java.util.ArrayList;
import java.sql.Date;

import glms.dl.*;
import glms.dto.*;
public class CustomerBL 
{
	public static int addCustomer(CustomerDTO customer)
	{
		int result=0;
		try
		{
			
			result = CustomerDL.addCustomer(customer);
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:CustomerBL:addcustomer"+e.getMessage());
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
			result=-1;
			System.out.println("**error**:customerBL:updatecustomer"+e.getMessage());
		}
		return result;
	}
	public static int deleteCustomer(int customer_id)
	{
		int result=0;
		
		try
		{	
			result = CustomerDL.deleteCustomer(customer_id);
			
		}
		catch(Exception e)
		{
			//result=-1;
			System.out.println("**error**:customerBL:deletecustomer"+e.getMessage());
		}
		return result;
	}
	public static CustomerDTO getcustomer(int customer_id)
	{
		CustomerDTO customer=null;
		try
		{
			customer=CustomerDL.getcustomer(customer_id);
		}
		catch(Exception e)
		{
			System.out.println("**error**:customerBL:getcustomer"+e.getMessage());
		}
		return customer;
	}
	public static ArrayList<CustomerDTO> getcustomers()
	{
		ArrayList<CustomerDTO> customers=null;
		try
		{
			
			customers=CustomerDL.getcustomers();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:customerDL:getcustomers"+e.getMessage());
		}
		return customers;
	}
}
