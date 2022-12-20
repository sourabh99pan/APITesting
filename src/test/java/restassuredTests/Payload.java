package restassuredTests;

public class Payload {
	
	String userkey;
	String secret;
	PlanDetails planDetails;
	ClientDetails clientDetails;
	
	public Payload(String userkey,String secret,PlanDetails planDetails,ClientDetails clientDetails)
	{
		this.userkey=userkey;
		this.secret=secret;
		this.planDetails=planDetails;
		this.clientDetails=clientDetails;
		
	}
	
	public String getUserkey() {
		return userkey;
	}

	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public PlanDetails getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(PlanDetails planDetails) {
		this.planDetails = planDetails;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

}
