package glms.dl;
import glms.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoanDL
{
	public static int addLoan(LoanDTO loan)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "INSERT INTO LOAN_DETAILS(ACCOUNT_NUMBER,LOAN_AMOUNT,ISSUE_DATE,NET_GOLD_WT,INTEREST_RATE,TENURE,DESCRIPTION) VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
		    ps.setString(1, loan.getAccountNo());
			ps.setDouble(2,loan.getLoanAmount());
			ps.setString(3, loan.getIssueDate());
			ps.setInt(4, loan.getNetGoldwt());
			ps.setInt(5, loan.getInterestRate());
			ps.setInt(6, loan.gettenure());
		    ps.setString(7, loan.getDescription());
		    
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:addLoan"+e.getMessage());
		}
	  return result;
	}
	
	public static int deleteLoan(String accountNo)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{	
			con=DBHelper.getConnection();
			query = "DELETE FROM LOAN_DETAILS WHERE ACCOUNT_NUMBER=?";
			ps=con.prepareStatement(query);
			ps.setString(1, accountNo);
			result = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:deleteLoan"+e.getMessage());
		}
	  return result;
	}
	
	public static LoanDTO getLoan(String accountNo)
	{
		LoanDTO loan=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultset=null;
		try
		{
			String sql="SELECT * FROM LOAN_DETAILS WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultset=statement.executeQuery(sql);
				if(resultset.next())	
				{
					loan=new LoanDTO();
					loan.setAccountNo(resultset.getString("ACCOUNT_NUMBER"));
					loan.setLoanAmount(resultset.getInt("LOAN_AMOUNT"));
					loan.setIssueDate(resultset.getString("ISSUE_DATE"));
					loan.setNetGoldwt(resultset.getInt("NET_GOLD_WT"));
					loan.settenure(resultset.getInt("TENURE"));
					loan.setInterestRate(resultset.getInt("INTEREST_RATE"));
					loan.setDescription(resultset.getString("DESCRIPTION"));
				}
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:getLoan"+e.getMessage());
		}
	  return loan;
	}
	
	public static ArrayList<LoanDTO> getLoans()
	{
		ArrayList<LoanDTO> loans=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		LoanDTO loan=null;
		try
		{
			loans=new ArrayList<LoanDTO>();
			String sql="SELECT * FROM LOAN_DETAILS";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			
				while(resultSet.next())
			    {
					loan=new LoanDTO();
					loan.setAccountNo(resultSet.getString("ACCOUNT_NUMBER"));
					loan.setLoanAmount(resultSet.getInt("LOAN_AMOUNT"));
					loan.setIssueDate(resultSet.getString("ISSUE_DATE"));
					loan.setNetGoldwt(resultSet.getInt("NET_GOLD_WT"));
					loan.setInterestRate(resultSet.getInt("INTEREST_RATE"));
					loan.settenure(resultSet.getInt("TENURE"));
					loan.setDescription(resultSet.getString("DESCRIPTION"));
					loans.add(loan);
				}
				resultSet.close();
				statement.close();
				con.close();
				
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:getLoans"+e.getMessage());
		}
	  return loans;
	}
	
	public static double getLoanAmount(String accountNo)
	{
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		double loanAmount=0;
		try
		{
			String sql="SELECT LOAN_AMOUNT FROM LOAN_DETAILS WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			
				while(resultSet.next())
			    {
			      loanAmount=resultSet.getDouble("LOAN_AMOUNT");
				  System.out.println("***Loan amount*"+loanAmount);
				}
				resultSet.close();
				statement.close();
				con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:getloanamount"+e.getMessage());
		}
	  return loanAmount;
	}
	
    public static int getInterestRate(String accountNo)
	{
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		int  interestRate=0;
		
		try
		{
			String sql="SELECT INTEREST_RATE FROM LOAN_DETAILS WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
				while(resultSet.next())
			    {
					interestRate=resultSet.getInt("INTEREST_RATE");
				    System.out.println("***RATE IN LOAN DL*"+interestRate);
				}
				resultSet.close();
				statement.close();
				con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:getInterestRate"+e.getMessage());
		}
		return interestRate;
	}
	
	
	public static int getTenure(String accountNo)
	{
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		int  tenure=0;
		try
		{
			String sql="SELECT TENURE FROM LOAN_DETAILS WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
		    {
				tenure=resultSet.getInt("TENURE");
			    System.out.println("***tenure LOAN DL*"+tenure);
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanDL:getTenure"+e.getMessage());
		}
	 return tenure;
	}
}
