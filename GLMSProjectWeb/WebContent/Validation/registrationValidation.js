function validate()
            {
                var CustomerName = document.getElementById("txtcustomer_name").value;
                var Address = document.getElementById("txtaddress").value;
                var Aadhar = document.getElementById("txtaadhar").value;
                var ContactNo = document.getElementById("txtcontact_no").value;
                var AccountNo = document.getElementById("txtaccount_no").value;
				var Alphapattern=new RegExp("^[a-zA-Z]");
				var Numberpattern=new RegExp("^[7-9]{1}[0-9]{8}");
				var Userpattern=new RegExp("[A-Z]{2,5}");
				
				var flag=0;
		
				
				  if(!Alphapattern.test(CustomerName))
	                {
	                    document.getElementById("id1").innerHTML="Name field accepts Alphabets only";
	                    document.getElementById("id1").style.color="Red";
	                    if(CustomerName==="")
		                    {
		                        document.getElementById("id1").innerHTML="Don't leave name field empty";
		                        document.getElementById("id1").style.color="Red";
 								flag=1;
		                    }
	                    flag=1;

	                }			
                else
                {
                    document.getElementById("id1").innerHTML="";
                }
                
                if(Address==="")
                {
                    document.getElementById("id2").innerHTML="Don't leave Address field empty";
                    document.getElementById("id2").style.color="Red";
                    flag=1;

                }
                else
                {
                    document.getElementById("id2").innerHTML="";
                }
                
                if(!Numberpattern.test(ContactNo))
                {
                    document.getElementById("id3").innerHTML="Enter a valid  mobile number";
                    document.getElementById("id3").style.color="Red";
                    
                if(ContactNo==="")
                {
                    document.getElementById("id3").innerHTML="Don't leave Phone field empty";
                    document.getElementById("id3").style.color="Red";
                    flag=1;

                }
                flag=1;

                }
                else
                {
                    document.getElementById("id3").innerHTML="";
                }
                if(!Userpattern.test(AccountNo))
                {
                    document.getElementById("id4").innerHTML="Username field accepts Alphabets and Numbers only";
                    document.getElementById("id4").style.color="Red";
  					               
                if(Username==="")
                {
                    document.getElementById("id4").innerHTML="Don't leave Username field empty";
                    document.getElementById("id4").style.color="Red";
                    flag=1;

                }                  
                flag=1;

                }
                else
                {
                    document.getElementById("id4").innerHTML="";
                }
                

				  
               if(flag==1)
            	  return false;
            	  else
            		  return true;
            }