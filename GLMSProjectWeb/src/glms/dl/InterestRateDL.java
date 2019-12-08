package glms.dl;
import glms.dto.InterestRateDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InterestRateDL
{
    public static int addROI(InterestRateDTO rate)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;

		try
		{
            con=DBHelper.getConnection();
			query = "INSERT INTO RATE_OF_INTEREST(ROI,ROI_DATE) VALUES(?,?)";
			ps=con.prepareStatement(query);
			ps.setInt(1, rate.getInterest_rate_change());
			ps.setString(2, rate.getRoi_date());
			
		    result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("**error**:InterestRateDL:addROI"+e.getMessage());
		}
	  return result;
	}
	
	public static ArrayList<InterestRateDTO> getInterest_rate_change()
	{
		ArrayList<InterestRateDTO> rateofinterest=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		InterestRateDTO roi=null;
		try
		{
			rateofinterest=new ArrayList<InterestRateDTO>();
			String sql="SELECT * FROM RATE_OF_INTEREST";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			
			while(resultSet.next())
		    {
				roi=new InterestRateDTO();
		        roi.setInterest_rate_change(resultSet.getInt("ROI"));
				roi.setRoi_date(resultSet.getString("ROI_DATE"));
			    rateofinterest.add(roi);
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:InterestRateDL:getInterest_rate_change"+e.getMessage());
		}
	  return rateofinterest;
	}
	
	public static int getrates()
	{
		int rates=0;
		Connection con=null;
		Statement statement=null;
		ResultSet resultset=null;
		
		try
		{
			
			String sql="SELECT ROI FROM RATE_OF_INTEREST ORDER BY ROI DESC";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultset=statement.executeQuery(sql);
			
			while(resultset.next())
			{
		       
			   rates=resultset.getInt("ROI");
			  
			}
			resultset.close();
			statement.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("**error**:InterestRateDL:getrates"+e.getMessage());
		}
		return rates;
	}
}
