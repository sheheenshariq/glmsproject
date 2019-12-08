package glms.bl;
import glms.dl.*;
import glms.dto.*;
import java.util.*;
import java.sql.*;
public class LoginBL {

	public static int addLogin(LoginDTO login)
	{
		int result=0;
		
		try
		{
		   result=LoginDL.addLogin(login);
		}
		catch(Exception e)
		{
			System.out.println("**error** LoginBL:addLogin"+e.getMessage());
		}
		return result;
	}
	
	public static LoginDTO getLogin(String account_no)
	{
		   
		   LoginDTO login=null;
		  
		   try
		   {
			    login=LoginDL.getLogin(account_no); 
		   }
		   catch(Exception e)
		   {
			   System.out.println("**Error**LoginBL:getLogin " +e.getMessage());
		   }
		   
		return login;
	 }

	   public static LoginDTO checkLogin(LoginDTO login1)
	   {
           LoginDTO login2=new LoginDTO();
   		    int result=0;
			try
			{

				login2 = LoginDL.checkLogin(login1);
	        }
			catch(Exception e)
			{
				System.out.println("**error** Loginbl:validateLogin"+e.getMessage());
			}
		  return login2;
			
	   }
}
