package glms.bl;
import glms.dl.*;
import glms.dto.InterestRateDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InterestRateBL
{
	public static int addROI(InterestRateDTO roi)
	{
		int result=0;
		
		try
		{
			
			result =InterestRateDL.addROI(roi);
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:InterestRateBL:addROI"+e.getMessage());
		}
		return result;
	}
	
	public static ArrayList<InterestRateDTO> getInterest_rate_change()
	{
		ArrayList<InterestRateDTO> InterestRate=null;
		
		try
		{
			
			InterestRate=InterestRateDL.getInterest_rate_change();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:InterestRateBL:getInterest_rate_change"+e.getMessage());
		}
		return InterestRate;
	}
	
	public static int getrates()
	{
		int gr=0;
		
		try
		{
				gr=InterestRateDL.getrates();	
		}
		catch(Exception e)
		{
			System.out.println("**error**:InterestRateBL:getRates"+e.getMessage());
		}
		return gr;
	}
	
}
