package glms.bl;

import glms.dl.*;
import glms.dto.*;
import glms.dl.GoldRateDL;
import java.util.ArrayList;

public class LoanBL {
	public static int addLoan(LoanDTO loan)
	{
		int result=0;
		float r=0;
		
		try
		{
			int wt = loan.getNetGoldwt();
			       System.out.println("TEST1:"+wt);
			       
			int rates=GoldRateDL.getRates();  
                   System.out.println("TEST2:"+rates);
			
			String date=loan.getIssueDate();
			       System.out.println("TEST3:"+date);
			int rate=loan.getInterestRate();
			       System.out.println("TEST4:"+rate);
			       
			loan.setLoanAmount(0.6*loan.getNetGoldwt()*rates);
			      //System.out.println("----"+rates.getGold_Rate());
			
			result = LoanDL.addLoan(loan);
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:LoanBL:addLoan"+e.getMessage());
		}
		return result;
	}
	
	public static int deleteLoan(String accountNo)
	{
		int result=0;
		try
		{	
			result = LoanDL.deleteLoan(accountNo);
			
		}
		catch(Exception e)
		{
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
	
	public static double getLoanAmount(String accountNo)
	{
		double loanAmount=0;
		//ArrayList<GoldRateDTO> rates=null;
		
		try
		{
			//	rate=new InterestRateDTO();
				loanAmount=LoanDL.getLoanAmount(accountNo);	
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanBl:getLoanAmount"+e.getMessage());
		}
		return loanAmount;
	}
	
	
	
	public static int  getInterestRate(String accountNo)
	{
		int interestRate=0;
		//ArrayList<GoldRateDTO> rates=null;
		
		try
		{
			//	rate=new InterestRateDTO();
				interestRate=LoanDL.getInterestRate(accountNo);	
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanBl:getInterestRate"+e.getMessage());
		}
		return interestRate;
	}
	
	
	public static int  getTenure(String accountNo)
	{
		int tenure=0;
		
		try
		{
				tenure=LoanDL.getTenure(accountNo);	
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanBl:getTenure"+e.getMessage());
		}
		return tenure;
	}
	
}
