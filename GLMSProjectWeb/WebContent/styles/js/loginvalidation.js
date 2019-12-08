function validate()
{
	var flag=false;
	var a =	document.getElementById("username");
	var b =	document.getElementById("password");
	if(a.value=="admin"&&b.value=="1234")
		{
			flag=true;
		}
	else if(a.value==null||b.value==null)
		
		{
			alert("Wrong Username or Password");
			flag=false;
		}
	return flag;


}