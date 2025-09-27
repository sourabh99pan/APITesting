package restassuredTest2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Http_400_Bad_Request {
	
	String myData ="";
	@BeforeTest
	public void setData() throws IOException
	
	{
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		RestAssured.basePath ="users";
		JSONParser jsonParser = new JSONParser();
		String path = System.getProperty("user.dir")+"/src/test/resources/data.json";

		ObjectMapper objMap = new ObjectMapper();
		
		Gorest Gorest = objMap.readValue(new File(path), Gorest.class);
		
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
		this.myData=myData;
	}
	
	@Test
	public void check400Code()
	{
		String token = "f0967927985c2e003a29751372dda291ce9eb580818866b687526ba1322cbeab";
		given()
		.header("Authorization", "bearer " +token)
		.contentType("application/json")
		.body(myData)
		.when()
			.post()
		.then()
			.statusCode(400)
		.log().all();
	}

}


