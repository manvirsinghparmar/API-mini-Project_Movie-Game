package MiniRestApiProject.MiniRestApiProject;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import junit.framework.Assert;

public class Update_a_Game extends BaseClass {
	
	@BeforeClass
	void postGame() throws InterruptedException {
		
		logger.info("TEST CASE 5...Update a Game Started ");

		JSONObject requestObject=new JSONObject();
		
		requestObject.put("id","2");
		requestObject.put("name","Shaminder");
		requestObject.put("releaseDate","2020-04-10");
		requestObject.put("reviewScore","100");
		requestObject.put("category","Driving");
		requestObject.put("rating","Universal");
		
		httpRequest.header("content-type", "application/json;charset=UTF-8");

		httpRequest.body(requestObject.toJSONString());
		
		httpResponse = httpRequest.request(Method.PUT,"/"+ game_ID);
		
		Thread.sleep(5000);
		
		
		

	}

	@SuppressWarnings("deprecation")
	@Test
	void getStatusCode() {

		int statusCode = httpResponse.getStatusCode();

		Assert.assertEquals(200, statusCode);

		System.out.println("Status Code: " + statusCode);
	}

	@Test
	void getResponseBody() {

		String responseBody = httpResponse.getBody().asString();
		
		logger.info("!!!!!!!!Response Body: " + responseBody);
		
		Assert.assertTrue(responseBody.contains("Shaminder"));
	
	}
	
	@AfterClass
	void tearDown() {
		
		logger.info("Test Case Update Game Finished finished");
	}

}
