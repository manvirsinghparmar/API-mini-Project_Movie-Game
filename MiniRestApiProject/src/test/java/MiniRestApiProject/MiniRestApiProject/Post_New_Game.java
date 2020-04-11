package MiniRestApiProject.MiniRestApiProject;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import junit.framework.Assert;

public class Post_New_Game extends BaseClass {
	
	

	@BeforeClass
	void postGame() throws InterruptedException {
		
		logger.info("TEST CASE 2........................Post New Game Started .........................");

		JSONObject requestObject=new JSONObject();
		
		requestObject.put("id","67");
		requestObject.put("name","Matrix");
		requestObject.put("releaseDate","2020-04-10");
		requestObject.put("reviewScore","100");
		requestObject.put("category","Driving");
		requestObject.put("rating","Universal");
		
		httpRequest.header("content-type", "application/json;charset=UTF-8");

		httpRequest.body(requestObject.toJSONString());
		
		httpResponse = httpRequest.request(Method.POST,"");
		
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
		
		Assert.assertTrue(responseBody.contains("Record Added Successfully"));
	
	}
	
	@AfterClass
	void tearDown() {
		
		logger.info("Test Case Post New Game finished");
	}
}
