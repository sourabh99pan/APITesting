package restassuredTests;

public class PlanDetails {
	
	String plancode;
	String faceAmount;
	String paymentFrequencyID;
	String policyTypeID;
	
	public PlanDetails(String plancode, String faceAmount, String paymentFrequencyID, String policyTypeID)
	{
		this.plancode = plancode;
		this.faceAmount = faceAmount;
		this.paymentFrequencyID = paymentFrequencyID;
		this.policyTypeID = policyTypeID;
		
	}
	
	public String getPlancode() {
		return plancode;
	}
	public void setPlancode(String plancode) {
		this.plancode = plancode;
	}
	public String getFaceAmount() {
		return faceAmount;
	}
	public void setFaceAmount(String faceAmount) {
		this.faceAmount = faceAmount;
	}
	public String getPaymentFrequencyID() {
		return paymentFrequencyID;
	}
	public void setPaymentFrequencyID(String paymentFrequencyID) {
		this.paymentFrequencyID = paymentFrequencyID;
	}
	public String getPolicyTypeID() {
		return policyTypeID;
	}
	public void setPolicyTypeID(String policyTypeID) {
		this.policyTypeID = policyTypeID;
	}


}
