package glms.bl;
import java.util.*;
import glms.dl.*;
import glms.dto.*;

public class PaymentBL {

	public static int addPayment(PaymentDTO payment)
	{
		int result=0;
		String s="",EmiDate="";
		int new_paymentNo=0,paymentNo=0,Payment=0;
		double Emi_amount=0,Balance_amnt=0;
		 double net_loan=0;
		try
		{
			
			    s=payment.getAccountNo();
			    System.out.println("acnt no in add payment bl"+s);
			    
			    paymentNo=payment.getPaymentRemaining();
			    System.out.println("pay no in add payment bl"+paymentNo);
			    Payment=EmiDL.getPaymentNumber(s);
			    
                System.out.println("payNoin payment bl:"+paymentNo);
			    new_paymentNo=paymentNo - Payment ;
                System.out.println("New payNo in payment bl:"+new_paymentNo);

                Emi_amount=EmiDL.getEmiAmount(s);
                System.out.println("emi amount in payment bl"+Emi_amount);
                
                 EmiDate=EmiDL.getEmiDate(s);
                 System.out.println("emi DATE in payment bl"+EmiDate);
                
                  
                 net_loan=Emi_amount *  paymentNo;
                 System.out.println("netloan payment bl:"+net_loan);
              
                 Balance_amnt=net_loan -Emi_amount;
                 System.out.println("balance amnt payment bl:"+Balance_amnt);
              
                         
                       payment.setAccountNo(s);
                       payment.setEmiAmount(Emi_amount);
                       payment.setEmiDate(EmiDate);
                       payment.setPaymentRemaining(new_paymentNo);
                       payment.setRepaymentAmount(Balance_amnt);
                       
			            if(new_paymentNo< 0)
			            {
			            	System.out.println("close emi acnt");
			            	payment.setStatus("closed");
			            	
			            }
			            else
			            {
			            	payment.setStatus("open");
			            }
		
		             result = PaymentDL.addPayment(payment);
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:PaymentBL:addpayment"+e.getMessage());
		}
	  return result;
	}
	
	 
	public static PaymentDTO getPayment(String accountNo)
	{
		PaymentDTO payment = null;

		try
		{
		    payment =PaymentDL.getPayment(accountNo);
        }
		catch(Exception e)
		{
			System.out.println("**error**:paymentBL:getPayment"+e.getMessage());
		}
	  return payment;
	}
}
