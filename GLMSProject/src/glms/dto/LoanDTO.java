package glms.dto;

public class LoanDTO 
{
String account_no,date,description;
int loan_amount,net_gold_wt,installments,interest_rate;
public String getAccount_no()
{
	return account_no;
}
public void setAccount_no(String account_no)
{
	this.account_no = account_no;
}
public String getDate()
{
	return date;
}
public void setDate(String date)
{
	this.date = date;
}
public String getDescription() 
{
	return description;
}
public void setDescription(String description)
{
	this.description = description;
}
public int getLoan_amount()
{
	return loan_amount;
}
public void setLoan_amount(int loan_amount)
{
	this.loan_amount = loan_amount;
}
public int getNet_gold_wt()
{
	return net_gold_wt;
}
public void setNet_gold_wt(int net_gold_wt)
{
	this.net_gold_wt = net_gold_wt;
}
public int getInstallments()
{
	return installments;
}
public void setInstallments(int installments)
{
	this.installments = installments;
}
public int getInterest_rate()
{
	return interest_rate;
}
public void setInterest_rate(int interest_rate)
{
	this.interest_rate = interest_rate;
}

}
