package restassuredTest2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Http_404_NotFound extends TestBase{
	
	String myData ="";
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		
		configReader();
		
		RestAssured.baseURI = prop.getProperty("base_uri_1");
		RestAssured.basePath =prop.getProperty("base_path_2");

	}
	
	@Test
	public void check404Code()
	{
		String token = prop.getProperty("access_token");
		given()
		.header("Authorization", "bearer " +token)
		.contentType("application/json")
		.when()
			.delete()
		.then()
			.statusCode(404)
		.log().all();
	}

}
