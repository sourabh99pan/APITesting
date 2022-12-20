package restassuredTest2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import restassuredTests.ClientDetails;
import restassuredTests.Life1;
import restassuredTests.Payload;
import restassuredTests.PlanDetails;

public class DemoPayload {

	public static void main(String[] args) throws JsonProcessingException {
		
		Gorest Gorest = new Gorest(7865,"Sourabh Pandya","sourabh7@mail.com","male","active");
		
		ObjectMapper objMap = new ObjectMapper();
		
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
		
		System.out.println(myData);
				
	}
}
