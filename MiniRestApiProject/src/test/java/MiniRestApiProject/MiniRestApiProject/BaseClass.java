package MiniRestApiProject.MiniRestApiProject;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification httpRequest;
	Response httpResponse;

	String game_ID = "2";
	

	Logger logger;

	@BeforeClass
	void setUp() {

		RestAssured.baseURI = "http://localhost:8080/app/videogames";

		httpRequest = RestAssured.given();

		logger = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);

	}

}
