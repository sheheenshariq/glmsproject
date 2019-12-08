package glms.dto;



public class CustomerDTO
{
	 int aadhar,contact_no,status;
	    String cust_name,gender,address;
	    		//static String str;
		public int getAadhar()
		{
			return aadhar;
		}
		public void setAadhar(int aadhar) 
		{
			this.aadhar = aadhar;
		}
		public int getContact_no() 
		{
			return contact_no;
		}
		public void setContact_no(int contact_no)
		{
			this.contact_no = contact_no;
		}
		
		public String getCust_name()
		{
			return cust_name;
		}
		public void setCust_name(String cust_name)
		{
			this.cust_name = cust_name;
		}
		public String getGender()
		{
			return gender;
		}
		public void setGender(String gender) 
		{
			this.gender = gender;
		}
		public String getAddress()
		{
			return address;
		}
		public void setAddress(String address)
		{
			this.address = address;
		}
		 public  String generate(String current_id) {
				
			 String prefix,newstr;
				int isuffix;
			
		
		
				prefix=current_id.substring(0,3);
				isuffix=Integer.parseInt(current_id.substring(3));
				isuffix++;
				newstr=prefix+isuffix;
				
				return newstr;
			}


}
