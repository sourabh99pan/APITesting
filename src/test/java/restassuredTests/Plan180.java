package restassuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class Plan180 {
	
	String myData="";
	
	@BeforeTest
	public void postData() throws JsonProcessingException
	{
		
		Life1 life = new Life1("50","M","S");
		PlanDetails plan = new PlanDetails("180","1200","012","SINGLE");
		ClientDetails client = new ClientDetails(life);
		
		Payload p =new Payload("BL_API","w^%L2SkpMri0dbyHyy2L",plan,client);
		
		ObjectMapper objMap = new ObjectMapper();
		
		myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		
		RestAssured.baseURI = "https://illustrations.faithlifefinancial.ca/";
		RestAssured.basePath ="api/FirstYearPremium";
		
		
	}
	
	@Test
	public void TC11()
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
			.body("firstYearModalPremium", equalTo(50.0F));
			
			
	}
	
	@Test
	public void TC12()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("minADOAmount", equalTo(0.0F));
					
	}
	
	@Test
	public void TC13()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("maxADOAmount", equalTo(0.0F));
					
	}
	
	@Test
	public void TC14()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumAnnual", equalTo(50.0F));
					
	}
	
	@Test
	public void TC15()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumMonthly", equalTo(0.0F));
					
	}
}
