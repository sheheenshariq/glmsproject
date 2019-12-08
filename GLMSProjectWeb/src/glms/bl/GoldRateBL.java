package glms.bl;
import java.util.ArrayList;
import glms.dl.*;
import glms.dto.GoldRateDTO;
import glms.dto.InterestRateDTO;
import glms.dto.LoanDTO;

public class GoldRateBL
{
	public static int addGold_Rate(GoldRateDTO goldrate)
	{
		int result=0; 
		
		try
		{
		   result = GoldRateDL.addGold_Rate(goldrate);
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:GoldRateBL:addgoldrate"+e.getMessage());
		}
		return result;
	}
	
	public static ArrayList<GoldRateDTO> getGold_Rate( )
	{
		ArrayList<GoldRateDTO> gold_rate=null;
		
		try
		{
		   gold_rate=GoldRateDL.getGold_Rate();
		}
		catch(Exception e)
		{
			System.out.println("**error**:GoldRateBL:getGold_Rate"+e.getMessage());
		}
		return  gold_rate;
	}
	
	public static int getRates()
	{
		int gr=0;
		
		try
		{
				gr=GoldRateDL.getRates();	
		}
		catch(Exception e)
		{
			System.out.println("**error**:GoldRateBL:getRates"+e.getMessage());
		}
		return gr;
	}
	
}



