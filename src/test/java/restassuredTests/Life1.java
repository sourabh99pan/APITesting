package restassuredTests;

public class Life1 {

	String age;
	String genderID;
	String smokingClassID;
	
	public Life1(String age, String genderID, String smokingClassID)
	{
		this.age = age;
		this.genderID = genderID;
		this.smokingClassID = smokingClassID;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGenderID() {
		return genderID;
	}
	public void setGenderID(String genderID) {
		this.genderID = genderID;
	}
	public String getSmokingClassID() {
		return smokingClassID;
	}
	public void setSmokingClassID(String smokingClassID) {
		this.smokingClassID = smokingClassID;
	}

	
}
