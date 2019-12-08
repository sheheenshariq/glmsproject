package glms.dl;
import glms.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmiDL
{
	public static int addEmi(EmiDTO emi)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			con=DBHelper.getConnection();
			query ="INSERT INTO EMI(ACCOUNT_NUMBER,EMI_AMOUNT,EMI_DATE,PAYMENT_NUMBER,STATUS) VALUES(?,?,?,?,?)";
			ps=con.prepareStatement(query);
		    ps.setString(1, emi.getAccountNo());
			ps.setDouble(2,emi.getEmiAmount());
			ps.setString(3, emi.getEmiDate());
			ps.setInt(4, emi.getPaymentNo());
			ps.setString(5, "OPEN");
          result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:addEmi"+e.getMessage());
		}
	  return result;
	}
	
	public static EmiDTO getEmi(String accountNo)
	{
		EmiDTO emi=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultset=null;
		
		try
		{
			String sql="SELECT * FROM EMI WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultset=statement.executeQuery(sql);
				if(resultset.next())	
				{
					emi=new EmiDTO();
					emi.setAccountNo(resultset.getString("ACCOUNT_NUMBER"));
					emi.setEmiAmount(resultset.getInt("EMI_AMOUNT"));
					emi.setEmiDate(resultset.getString("EMI_DATE"));
					emi.setPaymentNo(resultset.getInt("PAYMENT_NUMBER"));
				}
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:getEmi"+e.getMessage());
		}
	   return emi;
	}

	public static ArrayList<EmiDTO> getEmis()
	{
		ArrayList<EmiDTO> emis=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		EmiDTO emi=null;
		
		try
		{
			emis=new ArrayList<EmiDTO>();
			String sql="SELECT * FROM EMI";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			
				while(resultSet.next())
			    {
					emi=new EmiDTO();
					emi.setAccountNo(resultSet.getString("ACCOUNT_NUMBER"));
					emi.setEmiAmount(resultSet.getDouble("EMI_AMOUNT"));
					emi.setEmiDate(resultSet.getString("EMI_DATE"));
					emi.setPaymentNo(resultSet.getInt("PAYMENT_NUMBER"));
					emis.add(emi);
				}
				resultSet.close();
				statement.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:getEmis"+e.getMessage());
		}
	  return emis;
	}
	
	public static int getPaymentNumber(String accountNo)
	{
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		int  pay=0;
		
		try
		{
	        String sql="SELECT PAYMENT_NUMBER FROM EMI WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			    while(resultSet.next())
			    {
					pay=resultSet.getInt("PAYMENT_NUMBER");
				    System.out.println("***PAY IN LOAN DL*"+pay);
				}
				resultSet.close();
				statement.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:getPaymentNumber"+e.getMessage());
		}
	  return pay;
	}
	
	public static double getEmiAmount(String accountNo)
	{
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		double   Emi=0;
		
		try
		{
			String sql="SELECT EMI_AMOUNT FROM EMI WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
				while(resultSet.next())
			    {
					Emi=resultSet.getDouble("EMI_AMOUNT");
				    System.out.println("***EMI IN EMI DL*"+Emi);
				}
				resultSet.close();
				statement.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:getEmiAmount"+e.getMessage());
		}
	  return Emi;
	}
	
	public static String getEmiDate(String accountNo)
	{
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String EmiDate="";
		
		try
		{
			String sql="SELECT EMI_DATE FROM EMI WHERE ACCOUNT_NUMBER='"+accountNo+"'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
				while(resultSet.next())
			    {
					EmiDate=resultSet.getString("EMI_DATE");
				    System.out.println("***EMI IN EMI DL*"+EmiDate);
				}
				resultSet.close();
				statement.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:EmiDL:getEmiDate"+e.getMessage());
		}
	  return EmiDate;
    }
}
