package restassuredTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadDemo {

	public static void main(String[] args) throws JsonProcessingException {
		
		Life1 life = new Life1("10","F","N");
		PlanDetails plan = new PlanDetails("904","12000","012","SINGLE");
		ClientDetails client = new ClientDetails(life);
		
		Payload p =new Payload("BL_API","w^%L2SkpMri0dbyHyy2L",plan,client);
		
		ObjectMapper objMap = new ObjectMapper();
		
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		
		System.out.println(myData);
				
	}

}
