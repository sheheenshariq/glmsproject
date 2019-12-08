package glms.dto;

public class InterestRateDTO 
{
	int interest_rate_change;
	String roi_date;

	public String getRoi_date() {
		return roi_date;
	}
    public void setRoi_date(String roi_date) {
		this.roi_date = roi_date;
	}

	public int getInterest_rate_change() {
		return interest_rate_change;
	}
    public void setInterest_rate_change(int interest_rate_change) {
		this.interest_rate_change = interest_rate_change;
	}

}
