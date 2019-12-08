function validate1()
            {
               var GoldWt = document.getElementById("txtnet_gold_wt").value;
               var InterestRate = document.getElementById("txtinterest_rate").value;
               var Installments = document.getElementById("txtinstallments").value;
               var Description = document.getElementById("txtdescription").value;
                var AccountNo = document.getElementById("txtaccount_no").value;
				var Alphapattern=new RegExp("^[a-zA-Z]");
				var Numberpattern=new RegExp("^[7-9]{1}[0-9]{8}");
				var Npattern=new RegExp("^[0-9]{1-12}");
				var Userpattern=new RegExp("[A-Z]{2,5}");
				var NumberCheck=new RegExp("^\d{2}$");
				var GoldCheck=new RegExp("^\d{3}$");
				
				var flag=0;
		
				
				  if(!Alphapattern.test(Description))
	                {
	                    document.getElementById("id1").innerHTML="Name field accepts Alphabets only";
	                    document.getElementById("id1").style.color="Red";
	                    if(Description==="")
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
                
              
                
               
                if(!Userpattern.test(AccountNo))
                {
                    document.getElementById("id4").innerHTML="Username field accepts Alphabets and Numbers only";
                    document.getElementById("id4").style.color="Red";
  					               
                if(AccountNo==="")
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
                
                if(!GoldChecks.test(GoldWt))
                {
                    document.getElementById("id5").innerHTML="Gold weight field accepts  Numbers only";
                    document.getElementById("id5").style.color="Red";
  					               
                if(GoldWt==="")
                {
                    document.getElementById("id5").innerHTML="Don't leave Username field empty";
                    document.getElementById("id5").style.color="Red";
                    flag=1;

                }                  
                flag=1;

                }
                else
                {
                    document.getElementById("id5").innerHTML="";
                }
                

                
                if(!NumberCheck.test(InterestRate))
                {
                    document.getElementById("id6").innerHTML="Username field accepts  Numbers only";
                    document.getElementById("id6").style.color="Red";
  					               
                if(InterestRate==="")
                {
                    document.getElementById("id6").innerHTML="Don't leave Username field empty";
                    document.getElementById("id6").style.color="Red";
                    flag=1;

                }                  
                flag=1;

                }
                else
                {
                    document.getElementById("id6").innerHTML="";
                }
                
                
                if(!NumberCheck.test(Installments))
                {
                    document.getElementById("id7").innerHTML="Username field accepts  Numbers only";
                    document.getElementById("id7").style.color="Red";
  					               
                if(Installments==="")
                {
                    document.getElementById("id7").innerHTML="Don't leave Username field empty";
                    document.getElementById("id7").style.color="Red";
                    flag=1;

                }                  
                flag=1;

                }
                else
                {
                    document.getElementById("id7").innerHTML="";
                }
                
                
				  
               if(flag==1)
            	  return false
            	  else
            		  return true
            }
