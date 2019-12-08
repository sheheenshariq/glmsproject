package glms.dl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import glms.dto.*;

public class PaymentDL {
        public static int addPayment(PaymentDTO payment)
		{
			int result=0;
			String query;
			PreparedStatement ps=null;
			Connection con;
			try
			{
				con=DBHelper.getConnection();
				query ="INSERT INTO PAYMENT_INFO(ACCOUNT_NUMBER,EMI_AMOUNT,EMI_DATE,PAYMENT_REMAINING,REPAYMENT_AMOUNT,STATUS) VALUES(?,?,?,?,?,?)";
				ps=con.prepareStatement(query);
			    ps.setString(1, payment.getAccountNo());
				ps.setDouble(2,payment.getEmiAmount());
				ps.setString(3, payment.getEmiDate());
				ps.setInt(4,payment.getPaymentRemaining());
				ps.setDouble(5, payment.getRepaymentAmount());
				ps.setString(6, payment.getStatus());
				//ps.setDouble(7, payment.getTotal_amount());

				  result = ps.executeUpdate();
			}
			catch(Exception e)
			{
				result=-1;
				System.out.println("**error**:paymentDL:addpayment"+e.getMessage());
			}
		  return result;
		}
		
		public static PaymentDTO getPayment(String accountNo)
		{
			PaymentDTO payment=null;
			Connection con=null;
			Statement statement=null;
			ResultSet resultset=null;
			String sql="";
			try
			{
				sql="SELECT * FROM PAYMENT_INFO WHERE ACCOUNT_NUMBER='"+accountNo+"'";
				con=DBHelper.getConnection();
				statement=con.createStatement();
				resultset=statement.executeQuery(sql);
					while(resultset.next())	
					{
						payment=new PaymentDTO();
						payment.setAccountNo(resultset.getString("ACCOUNT_NUMBER"));
					    payment.setEmiAmount(resultset.getDouble("EMI_AMOUNT"));
						payment.setEmiDate(resultset.getString("EMI_DATE"));
						payment.setPaymentRemaining(resultset.getInt("PAYMENT_REMAINING"));
						payment.setRepaymentAmount(resultset.getDouble("REPAYMENT_AMOUNT"));
						payment.setStatus(resultset.getString("STATUS"));
						//payment.setTotal_amount(resultset.getDouble("TOTAL_AMOUNT"));

						
					}
				
			}
			catch(Exception e)
			{
				System.out.println("**error**:paymentDL:getpayment"+e.getMessage());
			}
			return payment;
		}
		
		
		public static ArrayList<PaymentDTO> getPayments()
		{
			ArrayList<PaymentDTO> payments=null;
			Connection con=null;
			Statement statement=null;
			ResultSet resultSet=null;
			PaymentDTO payment=null;
			try
			{
				payments=new ArrayList<PaymentDTO>();
				String sql="SELECT * FROM PAYMENT_INFO";
				con=DBHelper.getConnection();
				statement=con.createStatement();
				resultSet=statement.executeQuery(sql);
					while(resultSet.next())
					{
						payment=new PaymentDTO();
						payment.setAccountNo(resultSet.getString("ACCOUNT_NUMBER"));
						payment.setEmiAmount(resultSet.getDouble("EMI_AMOUNT"));
						payment.setEmiDate(resultSet.getString("EMI_DATE"));
						payment.setPaymentRemaining(resultSet.getInt("PAYMENT_REMAINING"));
						payment.setRepaymentAmount(resultSet.getDouble("REPAYMENT_AMOUNT"));
						payment.setStatus(resultSet.getString("STATUS"));
						payments.add(payment);
					}
					resultSet.close();
					statement.close();
					con.close();
			}
			catch(Exception e)
			{
				System.out.println("**error**:paymentDL:getpayments"+e.getMessage());
			}
		 return payments;
		}
}
