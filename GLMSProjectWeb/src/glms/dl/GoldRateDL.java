package glms.dl;
import glms.dto.GoldRateDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class GoldRateDL {
	public static int addGold_Rate(GoldRateDTO rate)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "INSERT INTO TBL_GOLD_RATE(GOLD_RATE,UPDATED_DATE) VALUES(?,?)";
			ps=con.prepareStatement(query);
		    ps.setInt(1, rate.getGold_rate());
		    ps.setString(2, rate.getDate());
		
			
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**error**:GoldRateDL:addGoldRate"+e.getMessage());
		}
		return result;
	}

	public static ArrayList<GoldRateDTO> getGold_Rate()
	{
		ArrayList<GoldRateDTO> gold_rate=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		GoldRateDTO gr=null;
		try
		{
			gold_rate=new ArrayList<GoldRateDTO>();
			String sql="SELECT * FROM TBL_GOLD_RATE";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
				
			{
				gr=new GoldRateDTO();
			
				
				gr.setGold_rate(resultSet.getInt("GOLD_RATE"));
				gr.setDate(resultSet.getString("UPDATED_DATE"));
				gold_rate.add(gr);
			}
			resultSet.close();
			statement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:GoldRateDL:getGold_Rate"+e.getMessage());
		}
		return gold_rate;
	}

	public static int getRates()
	{
		
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		int gr=0;
		try
		{
			//rates=new ArrayList<GoldRateDTO>();

			String sql="SELECT GOLD_RATE FROM TBL_GOLD_RATE ORDER BY GOLD_RATE  ";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
				
			{
				
			     gr=resultSet.getInt("GOLD_RATE");
			   
			}
			resultSet.close();
			statement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**error**:GoldRateDL:getRates"+e.getMessage());
		}
		//System.out.println(rates);
		return gr;
	}
}
