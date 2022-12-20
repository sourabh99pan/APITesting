package restassuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class Plan903 {
	
	String myData="";
	
	@BeforeTest
	public void postData() throws JsonProcessingException
	{
		
		Life1 life = new Life1("50","F","N");
		PlanDetails plan = new PlanDetails("903","12000","012","SINGLE");
		ClientDetails client = new ClientDetails(life);
		
		Payload p =new Payload("BL_API","w^%L2SkpMri0dbyHyy2L",plan,client);
		
		ObjectMapper objMap = new ObjectMapper();
		
		myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		
		RestAssured.baseURI = "https://illustrations.faithlifefinancial.ca/";
		RestAssured.basePath ="api/FirstYearPremium";
		
		
	}
	
	@Test
	public void TC06()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("firstYearModalPremium", equalTo(318.8F));
			
			
	}
	
	@Test
	public void TC07()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("minADOAmount", equalTo(60.0F));
					
	}
	
	@Test
	public void TC08()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("maxADOAmount", equalTo(361.2F));
					
	}
	
	@Test
	public void TC09()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumAnnual", equalTo(318.8F));
					
	}
	
	@Test
	public void TC10()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumMonthly", equalTo(28.69F));
					
	}
}
