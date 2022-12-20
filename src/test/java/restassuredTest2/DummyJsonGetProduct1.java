package restassuredTest2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;

public class DummyJsonGetProduct1 {
	public class DummyJsonGet {
		
		@BeforeTest
		public void setData() throws JsonProcessingException
		
		{
			RestAssured.baseURI = "https://dummyjson.com/";
			RestAssured.basePath ="products/1";
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
				.body("title", equalTo("iPhone 9"));
				
		}
		
		@Test
		public void checkTitlecontainString()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", containsString("iPhone 9"));
				
		}
		
		@Test
		public void checkTitleStartsWith()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", startsWith("i"));
				
		}
		
		@Test
		public void checkTitleEndsWith()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("title", endsWith("9"));
				
		}
		
		@Test
		public void checkCategoryIgnoreCase()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("category", equalToIgnoringCase("SmartPhones"));
				
		}
		@Test
		public void checkDesc()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("description", equalTo("An apple mobile which is nothing like apple"));
				
		}
		
		@Test
		public void checkPrice()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("price", comparesEqualTo(549));
				
		}
		
		@Test
		public void CheckDiscountPercentage()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("discountPercentage", comparesEqualTo(12.96F));
				
		}
		
		@Test
		public void CheckRating()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("rating", comparesEqualTo(4.69F));
				
		}
		
		@Test
		public void CheckStock()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("stock", comparesEqualTo(94));
				
		}
		
		@Test
		public void CheckBrand()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body("brand", equalTo("Apple"));
				
		}
		
		/*@Test
		public void CheckTitleKey()
		{
			given()
			.contentType("application/json")
			.when()
				.get()
			.then()
				.body(hasKey("title"));
				
		}*/
		
	}
}


//https://dummyjson.com/