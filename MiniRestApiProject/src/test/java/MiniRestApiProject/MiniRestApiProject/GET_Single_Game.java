package MiniRestApiProject.MiniRestApiProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import junit.framework.Assert;

public class GET_Single_Game extends BaseClass {

	@BeforeClass
	void getAllGames() {

		logger.info("TEST CASE 4...Get a single game ");

		httpResponse = httpRequest.request(Method.GET, "/2");

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

		Assert.assertTrue(responseBody.contains(game_ID));
		
		logger.info("@@@@@@@@" +responseBody);
	}

	@AfterClass
	void tearDown() {

		logger.info("Test Case Get Single Game finished");
	}

}
