package restassuredTest2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DummyJsonGetProduct1 {
	public class DummyJsonGet extends TestBase{
		
		@BeforeTest
		public void setData() throws JsonProcessingException
		
		{
			configReader();
			RestAssured.baseURI = prop.getProperty("dummy_base_uri");
			RestAssured.basePath =prop.getProperty("dummy_base_path");

		}
		
		@Test
		public void checkStatusCode()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.statusCode(200)
			.log().all();
		}
		
		@Test
		public void checkTitle()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", equalTo("Essence Mascara Lash Princess"));
				
		}
		
		@Test
		public void checkTitlecontainString()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", containsString("Essence"));
				
		}
		
		@Test
		public void checkTitleStartsWith()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", startsWith("E"));
				
		}
		
		@Test
		public void checkTitleEndsWith()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", endsWith("s"));
				
		}
		
		@Test
		public void checkCategoryIgnoreCase()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("category", equalToIgnoringCase("beauty"));
				
		}
		@Test
		public void checkDesc()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("description", contains("Essence"));
				
		}
		
		@Test
		public void checkPrice()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("price", comparesEqualTo(9.99F));
				
		}
		
		@Test
		public void CheckDiscountPercentage()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("discountPercentage", comparesEqualTo(10.48F));
				
		}
		
		@Test
		public void CheckRating()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("rating", comparesEqualTo(2.56F));
				
		}
		
		@Test
		public void CheckStock()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("stock", comparesEqualTo(99));
				
		}
		
		@Test
		public void CheckBrand()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("brand", equalTo("Essence"));
				
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
			System.out.println("title is "+title);
		
	}
	}
}


//https://dummyjson.com/