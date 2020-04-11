package MiniRestApiProject.MiniRestApiProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import junit.framework.Assert;

public class Delete_Game extends BaseClass {
	
	
	
	
	@BeforeClass
	void getAllGames() {
		
		logger.info("TEST CASE 3...Delete a game ");

		httpResponse = httpRequest.request(Method.DELETE, "/15");

	}

	@Test
	void getStatusCode() {

		int statusCode = httpResponse.getStatusCode();

		Assert.assertEquals(200, statusCode);

		System.out.println("Status Code: " + statusCode);
	}

	@Test
	void responseBody() {

		String responseBody = httpResponse.getBody().asString();

		System.out.println("@@@@@@@@@@" + responseBody);
		
		Assert.assertTrue(responseBody.contains("Record Deleted Successfully"));
	}

	@AfterClass
	void tearDown() {
 
		logger.info("Test Case DELETE finished");
	}

}
