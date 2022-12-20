package restassuredTest2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Http_201_created {
	
	String myData ="";
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		RestAssured.basePath ="users";
		Gorest Gorest = new Gorest(7865,"Sourabh Pandya","sourabh987@mail.com","male","active");
		
		ObjectMapper objMap = new ObjectMapper();
		
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
	}
	
	@Test
	public void check422Code()
	{
		String token = "f0967927985c2e003a29751372dda291ce9eb580818866b687526ba1322cbeab";
		given()
		.header("Authorization", "Bearer " +token)
		.contentType("application/json")
		.body(myData)
		.when()
			.post()
		.then()
			.statusCode(422)
		.log().all();
	}

}
