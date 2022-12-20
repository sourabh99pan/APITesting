package restassuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class Plan904 {
	
	String myData="";
	
	@BeforeTest
	public void postData() throws JsonProcessingException
	{
		
		Life1 life = new Life1("50","F","N");
		PlanDetails plan = new PlanDetails("904","12000","012","SINGLE");
		ClientDetails client = new ClientDetails(life);
		
		Payload p =new Payload("BL_API","w^%L2SkpMri0dbyHyy2L",plan,client);
		
		ObjectMapper objMap = new ObjectMapper();
		
		myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		
		RestAssured.baseURI = "https://illustrations.faithlifefinancial.ca/";
		RestAssured.basePath ="api/FirstYearPremium";
		
		
	}
	
	@Test
	public void TC01()
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
			.body("firstYearModalPremium", equalTo(444.8F));
			
			
	}
	
	@Test
	public void TC02()
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
	public void TC03()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("maxADOAmount", equalTo(265.2F));
					
	}
	
	@Test
	public void TC04()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumAnnual", equalTo(444.8F));
					
	}
	
	@Test
	public void TC05()
	{
		given()
			.contentType("application/json")
			.body(myData)
		.when()
			.post()
		.then()
			.statusCode(200)
		.and()
			.body("firstYearPremiumMonthly", equalTo(40.03F));
					
	}
}
