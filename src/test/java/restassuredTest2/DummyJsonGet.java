package restassuredTest2;

import static io.restassured.RestAssured.given;

import org.hamcrest.collection.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DummyJsonGet {
	
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		RestAssured.baseURI = "https://dummyjson.com/";
		RestAssured.basePath ="products";
	}
	
	@Test
	public void checkStatusCode()
	{
		given()
		.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(200);
			
	}
	
	@Test
	public void checkwithResponse()
	{
		Response response =given()
		.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(200).extract().response(); 
		//System.out.println("Response is: " +response);
		JsonPath extractor = response.jsonPath();
		String title =extractor.get("title");
		
			
	}
	
	@Test
	public void checkTitle()
	{
		given()
		.contentType("application/json")
		.when()
			.get()
		.then()
			.body("products.title", hasItems("iPhone 9","Samsung Universe 9","OPPOF19"))
			.log().all();
	}
	
	/*@Test
	public void CheckTitleKey()
	{
		given()
		.contentType("application/json")
		.when()
			.get()
		.then()
			.body("products",hasKey("title"));
			
	}*/

}
