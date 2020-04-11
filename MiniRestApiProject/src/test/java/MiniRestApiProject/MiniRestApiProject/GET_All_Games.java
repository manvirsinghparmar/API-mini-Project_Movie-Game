package MiniRestApiProject.MiniRestApiProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import junit.framework.Assert;

public class GET_All_Games extends BaseClass {

	@BeforeClass
	void getAllGames() {
		
		logger.info("TEST CASE 1...Get All Game Started ");

		httpResponse = httpRequest.request(Method.GET, "");

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
	}

	@AfterClass
	void tearDown() {

		logger.info("Test Case Get All Games finished");
	}
}
