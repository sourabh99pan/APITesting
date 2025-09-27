package restassuredTest2;

import org.mozilla.javascript.tools.shell.Environment;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenAPI_Http_201_created extends OpenAPIBase{
	
	String myData ="";
	@BeforeTest
	public void setData() throws JsonProcessingException
	
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		RestAssured.basePath ="users";
		//Gorest Gorest = new Gorest(78066,"Sourabh","sourabh117@mail.com","male","active");
		
		ObjectMapper objMap = new ObjectMapper();
		
		//String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
		this.myData=myData;
		configReader();
	}
	
	@Test
	public void check201Created()
	
	{
		String token = "37e722e200d2b1c65596bc9295780b6edb58bf2ad2c82341a5cb6b7f4b89fdfc";
		RestAssured.requestSpecification = new RequestSpecBuilder().addFilter(new OpenApiValidationFilter(prop.getProperty("ymlfile")))
				.addHeader("Authorization", "Bearer"+token).addFilter(new RequestLoggingFilter()).build();
		
						RestAssured.given()
						.contentType("application/json")
						.body(myData)
						.when()
							.post()
						.then()
							.statusCode(201).log().all();
							
						
	}
	
	

}
