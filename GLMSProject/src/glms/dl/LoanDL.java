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
		//String newstr=null;
		try
		{
			con=DBHelper.getConnection();
			query = "INSERT INTO LOAN_DETAILS(ACCOUNT_NUMBER,LOAN_AMOUNT,ISSUE_DATE,NET_GOLD_WT,INTEREST_RATE,INSTALLMENTS,DESCRIPTION) VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
		    ps.setString(1, loan.getAccount_no());
			ps.setInt(2,loan.getLoan_amount());
			ps.setString(3, loan.getDate());
			ps.setInt(4, loan.getNet_gold_wt());
			ps.setInt(5, loan.getInterest_rate());
			ps.setInt(6, loan.getInstallments());
		    ps.setString(7, loan.getDescription());
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:LoanDL:addLoan"+e.getMessage());
		}
		return result;
	}
	public static int deleteLoan(String account_no)
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
			ps.setString(1, account_no);
			result = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			//result=-1;
			System.out.println("**error**:LoanDL:deleteLoan"+e.getMessage());
		}
		return result;
	}
	public static LoanDTO getLoan(String account_no)
	{
		LoanDTO loan=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try
		{
			String sql="SELECT * FROM LOAN_DETAILS WHERE ACCOUNT_NO="+account_no;
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())	
			{
				loan=new LoanDTO();
				loan.setAccount_no(resultSet.getString("ACCOUNT_NUMBER"));
				loan.setLoan_amount(resultSet.getInt("LOAN_AMOUNT"));
				loan.setDate(resultSet.getString("ISSUE_DATE"));
				loan.setNet_gold_wt(resultSet.getInt("NET_GOLD_WT"));
				loan.setInterest_rate(resultSet.getInt("INTEREST_RATE"));
				loan.setInstallments(resultSet.getInt("INSTALLMENTS"));
				loan.setDescription(resultSet.getString("DESCRIPTION"));
			}
			resultSet.close();
			statement.close();
			con.close();
			//return customer;
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
				loan.setAccount_no(resultSet.getString("ACCOUNT_NUMBER"));
				loan.setLoan_amount(resultSet.getInt("LOAN_AMOUNT"));
				loan.setDate(resultSet.getString("ISSUE_DATE"));
				loan.setNet_gold_wt(resultSet.getInt("NET_GOLD_WT"));
				loan.setInterest_rate(resultSet.getInt("INTEREST_RATE"));
				loan.setInstallments(resultSet.getInt("INSTALLMENTS"));
				loan.setDescription(resultSet.getString("DESCRIPTION"));
				loans.add(loan);
			}
			resultSet.close();
			statement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:LoanrDL:getLoan"+e.getMessage());
		}
		return loans;
	}
}
