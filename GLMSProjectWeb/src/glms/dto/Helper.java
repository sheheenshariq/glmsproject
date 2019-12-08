package glms.dto;

public class Helper
{
    public  static String Generate(String current_id)
	{
                String prefix,newstr;
				int isuffix;
			
	            prefix=current_id.substring(0,2);
				isuffix=Integer.parseInt(current_id.substring(2));
				isuffix++;
				newstr=prefix+isuffix;
				return newstr;
    }
}