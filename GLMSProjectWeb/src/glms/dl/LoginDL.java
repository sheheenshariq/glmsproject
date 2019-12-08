package glms.dl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import glms.dto.*;

public class LoginDL {
	
	public static int addLogin(LoginDTO login)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			con=DBHelper.getConnection();
			query="INSERT INTO USER_GOLD(USERNAME,PASSWORD,ACCOUNT_NUMBER)VALUES(?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1,login.getUsername());
			ps.setString(2,login.getPassword());
			ps.setString(3,login.getAccountNumber());
			result =ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			result=-1;;
			System.out.println("**error** LoginDL:addLogin"+e.getMessage());
		}
		return result;
	}
	
	public static LoginDTO getLogin(String account_no)
	{
		   Connection con=null;
		   Statement statement=null;
		   ResultSet resultSet=null;
		   LoginDTO login=null;
		   String sql="";
		   try
		   {
			   sql="SELECT * FROM USER_GOLD WHERE ACCOUNT_NUMBER='" +account_no+"'"; 
			   con=DBHelper.getConnection();
			   statement =con.createStatement();
			   resultSet=statement.executeQuery(sql);
			   while(resultSet.next())
			   {
				   login=new LoginDTO(); 
				   login.setUsername(resultSet.getString("USERNAME"));
				   login.setPassword(resultSet.getString("PASSWORD"));
			   }
		   }
		   catch(Exception e)
		   {
			   System.out.println("**Error**LoginDL:getLogin " +e.getMessage());
		   }
		return login;
	}
	
	public static LoginDTO checkLogin(LoginDTO login)
	{
		Connection con=null;
		ResultSet resultSet=null;
		LoginDTO  login1=null;
		PreparedStatement ps;
		Statement statement=null;
		String sql="";
		
		try
		{   
			sql="SELECT * FROM USER_GOLD WHERE USERNAME =? AND PASSWORD=?";
			con=DBHelper.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,login.getUsername());
			ps.setString(2,login.getPassword());
			resultSet=ps.executeQuery();
			
			if(resultSet.next())
			{
				login1=new LoginDTO();
				login1.setUsername(resultSet.getString("USERNAME"));
				login1.setPassword(resultSet.getString("PASSWORD"));
				login1.setAccountNumber(resultSet.getString("ACCOUNT_NUMBER"));

			}
			
		}
		catch(Exception e)
		{
			System.out.println("**error** LoginDL:checkLogin"+e.getMessage());
		}
		return login1;
	}

}
