package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class CryptoCurrency {
	
	// base url globally declared
	String url = "https://crypto-wallet-server.mock.beeceptor.com";
	
	@Test (priority = 0)
	public void registerUser() {
		
		JSONObject js = new JSONObject();
		js.put("username", "user123");
		js.put("password", "securepassword");
		js.put("email", "user@example.com");
		
		given().contentType("Application/JSON").body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/register")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 1)
	public void LoginUser() {
		
		RestAssured.baseURI = url;
		
		given().when().get("/api/v1/balance").then().statusCode(200).log().all();
	}
	
	@Test(priority = 2)
	public void RetrieveTrans() {
		
		RestAssured.baseURI = url;
		
		given().when().get("/api/v1/balance").then().statusCode(200).log().all();
	}
	
	@Test(priority = 3)
	public void ListOfTransaction() {
		
		RestAssured.baseURI = url;
		
		given().when().get("/api/v1/transactions").then().statusCode(200).log().all();
	}
	
	@Test (priority = 4)
	public void transferETH() {
		
		JSONObject js = new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", "5.0");
		js.put("currency", "ETH");
		
		given().contentType("Application/JSON").body(js.toJSONString()).when().post("/api/v1/transactions")
		.then().statusCode(200).log().all();
	}
	
	@Test (priority = 5)
	public void calculateETH() {
		
		JSONObject js = new JSONObject();
		js.put("amount", "2.5");
		js.put("currency", "BTC");
		js.put("recipient_address", "0x1234567890ABCDEF");
		
		given().contentType("Application/JSON").body(js.toJSONString()).when().post("/api/v1/transaction_fee")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 6)
	public void currencyRates() {
		
		RestAssured.baseURI = url;
		
		given().when().get("/api/v1/exchange_rates").then().statusCode(200).log().all();
	}

}
