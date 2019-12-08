package glms.bl;
import glms.dl.*;
import glms.dto.*;
import java.lang.*;
import java.util.ArrayList;
public class EmiBL
{
	public static int addEmi(EmiDTO emi)
	{
		int result=0;
		String accountNo="",ac="";
		double amount=0;
		String s="";
		float rate=0,r=0;
		int tenure=0,t=0;
		double emiAmount=0;
		
		try
		{
			
		    s=emi.getAccountNo();
			     System.out.println("acnt no in add emi bl"+s);
			     
		    amount=LoanDL.getLoanAmount(s); 
                 System.out.println("loanamount in emi bl:"+amount);
                 
            rate=LoanDL.getInterestRate(s);            
                 System.out.println("rate in emi bl:"+ rate);
                 
            tenure=LoanDL.getTenure(s);            
                 System.out.println("tenure in emi bl:"+ tenure);
             
             r = rate /(12*  100); // one month interest 
                    System.out.println("R in emi bl:"+ r);
                    
     		 t = tenure * 12; // one month period 
     		        System.out.println("T in emi bl:"+ t);
     		        
             double st=(double)Math.pow(1 + r, t);
                    System.out.println("st in emi bl:"+ st);
                    
             emiAmount = (amount * r * st) 	/ (st - 1); 
     	            System.out.println("***emi amount is"+emiAmount); 
     	            
             emi.setAccountNo(s);
                     System.out.println("***ACnt no"+s); 
                     
     		 emi.setEmiAmount(emiAmount);
     		 
     	  result = EmiDL.addEmi(emi);
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:EmiBL:addEMI"+e.getMessage());
		}
		return result;
	}
	
	
	public static EmiDTO getEmi(String account_no)
	{
		EmiDTO emi=null;
	    String ac=account_no;
	    
		try
		{
			emi=EmiDL.getEmi(account_no);
		}
		
		catch(Exception e)
		{
			System.out.println("**error**:EmiBL:getEmi"+e.getMessage());
		}
		return emi;
	}
	
	
	public static ArrayList<EmiDTO> getEmis()
	{
		ArrayList<EmiDTO> emis=null;
		
		try
		{
			
			emis=EmiDL.getEmis();
		}
		
		catch(Exception e)
		{
			System.out.println("**error**:EmiBL:getEMIS"+e.getMessage());
		}
	  return emis;
	}
	
}
