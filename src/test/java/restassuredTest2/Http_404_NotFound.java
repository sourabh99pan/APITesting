package restassuredTest2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Http_404_NotFound {
	
	String myData ="";
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		RestAssured.basePath ="users/5770";

	}
	
	@Test
	public void check404Code()
	{
		String token = "f0967927985c2e003a29751372dda291ce9eb580818866b687526ba1322cbeab";
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
