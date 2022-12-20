package restassuredTest2;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;

public class Error404 {
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		RestAssured.baseURI = "https://dummyjson.com/";
		RestAssured.basePath ="product";
	}
	
	@Test
	public void check404Code()
	{
		given()
		.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(404)
		.log().all();
	}
	
	@Test
	public void checkOutput()
	{
		String output=given()
		.contentType("application/json")
		.when()
			.get()
		.then()
		.extract().response().asString();
		Assert.assertEquals(output.contains("not found!"), true);
	}
}
