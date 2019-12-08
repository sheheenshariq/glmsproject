package glms.dto;

public class LoanDTO 
{
	String accountNo,issueDate,description;
	double loanAmount;
	int netGoldwt,tenure,interestRate;
	
    public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getNetGoldwt() {
		return netGoldwt;
	}
	public void setNetGoldwt(int netGoldwt) {
		this.netGoldwt = netGoldwt;
	}
	
	public int gettenure() {
		return tenure;
	}
	public void settenure(int tenure) {
		this.tenure = tenure;
	}
	
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
}
