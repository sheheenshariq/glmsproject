package glms.dto;

public class PaymentDTO {

	String accountNo;
	double EmiAmount;
	String EmiDate;
	int paymentRemaining;
	double repaymentAmount;
	String status;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public double getEmiAmount() {
		return EmiAmount;
	}
	public void setEmiAmount(double emiAmount) {
		EmiAmount = emiAmount;
	}
	
	public String getEmiDate() {
		return EmiDate;
	}
	public void setEmiDate(String emiDate) {
		EmiDate = emiDate;
	}
	
	public int getPaymentRemaining() {
		return paymentRemaining;
	}
	public void setPaymentRemaining(int paymentRemaining) {
		this.paymentRemaining = paymentRemaining;
	}
	
	public double getRepaymentAmount() {
		return repaymentAmount;
	}
	public void setRepaymentAmount(double repaymentAmount) {
		this.repaymentAmount = repaymentAmount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
