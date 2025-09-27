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

public class Http_401_Error extends TestBase{
	
	String myData ="";
	@BeforeTest
	public void setData() throws IOException
	
	{
		configReader();
		
		RestAssured.baseURI = prop.getProperty("base_uri_1");
		RestAssured.basePath =prop.getProperty("base_path_1");
		JSONParser jsonParser = new JSONParser();
		String path = System.getProperty("user.dir")+"/src/test/resources/data.json";

		ObjectMapper objMap = new ObjectMapper();
		
		Gorest Gorest = objMap.readValue(new File(path), Gorest.class);
		
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
	}
	
	@Test
	public void check401Code()
	{
		String token = "f0967927985c2e003a29751372dda291ce9eb580818866b687526ba1322cbeab";
		given()
		.header("Authorization", "bearer " +token)
		.contentType("application/json")
		.body(myData)
		.when()
			.post()
		.then()
			.statusCode(401)
		.log().all();
	}

}
