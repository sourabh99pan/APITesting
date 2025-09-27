package restassuredTest2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Http_201_created extends TestBase{
	
	String myData ="";
	@BeforeTest
	public void setData() throws IOException, ParseException
	
	{
		configReader();
		
		RestAssured.baseURI = prop.getProperty("base_uri_1");
		RestAssured.basePath =prop.getProperty("base_path_1");
		
		JSONParser jsonParser = new JSONParser();
		String path = System.getProperty("user.dir")+"/src/test/resources/data.json";
		
		ObjectMapper objMap = new ObjectMapper();
		
		Gorest Gorest = objMap.readValue(new File(path), Gorest.class);
			
		String myData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(Gorest);
		this.myData=myData;
	}
	
	@Test
	public void check201Code()
	{
		String token = prop.getProperty("access_token");
		given()
		.header("Authorization", "Bearer " +token)
		.contentType("application/json")
		.body(myData)
		.when()
			.post()
		.then()
			.statusCode(201)
		.log().all();
	}
	
	@Test
	public void check422Code()
	{
		String token = "37e722e200d2b1c65596bc9295780b6edb58bf2ad2c82341a5cb6b7f4b89fdfc";
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
