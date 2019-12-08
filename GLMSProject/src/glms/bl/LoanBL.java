package glms.bl;

import glms.dl.*;
import glms.dto.LoanDTO;

import java.util.ArrayList;

public class LoanBL
{
	public static int addLoan(LoanDTO loan)
	{
		int result=0;
		
		try
		{
			
			result = LoanDL.addLoan(loan);
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:LoanBL:addLoan"+e.getMessage());
		}
		return result;
	}
	public static int deleteLoan(String account_no)
	{
		int result=0;
		try
		{	
			
			result = LoanDL.deleteLoan(account_no);
			
		}
		catch(Exception e)
		{
			//result=-1;
			System.out.println("**error**:LoanBL:deleteLoan"+e.getMessage());
		}
		return result;
	}
	public static LoanDTO getLoan(String account_no)
	{
		LoanDTO loan=null;
		
		
		try
		{
			loan=LoanDL.getLoan(account_no);
			//return details;
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanBL:getLoan"+e.getMessage());
		}
		return loan;
	}
	public static ArrayList<LoanDTO> getLoans()
	{
		ArrayList<LoanDTO> loans=null;
		
		try
		{
			
			loans=LoanDL.getLoans();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanBL:getLoans"+e.getMessage());
		}
		return loans;
	}

}
