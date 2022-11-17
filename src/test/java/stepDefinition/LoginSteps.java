package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utils.ConfigLoader;

import static requests.RequestFactory.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conduitApp.LoginPojo;
import conduitApp.User;

public class LoginSteps {

	Response response;

	ValidatableResponse vResponse;

	String baseUrl;
	
	ConfigLoader configLoader;
	
	@Before
	public void preSetup() {
		configLoader = ConfigLoader.getInstance();
	}

	@Given("Saurabh is a writer and has an account on conduit application")
	public void setup() {
		
		

		// 1. Create a request
		// 2. Send the request
		// 3. Receive the response
		// 4. Validate the response

		baseUrl = String.format("http://%s:%s", configLoader.getHostname(), configLoader.getPortNumber());

	}

	@When("Saurabh enters the credential as {string} and {string}")
	public void loginToApplicationStep(String userEmail, String userPassword) {

		String loginEndpointUrl = baseUrl + "/api/users/login";

		// String payload = "{\r\n \"user\": {\r\n \"email\": \"saurabh@fake.com\",\r\n
		// \"password\": \"fake\"\r\n }\r\n}";

		Map<String, Object> payloadAsMap = new HashMap<String, Object>();

		Map<String, String> user = new HashMap<String, String>();

		user.put("email", userEmail);

		user.put("password", userPassword);

		payloadAsMap.put("user", user);

		// Prepare test data as POJO class

		LoginPojo payloadAsPojo = new LoginPojo();

		User userFromPojo = new User();

		userFromPojo.setEmail(userEmail);

		userFromPojo.setPassword(userPassword);

		payloadAsPojo.setUser(userFromPojo);

		response = loginToApplication(loginEndpointUrl, payloadAsPojo);

		response.prettyPrint();

	}

	@When("Saurabh enters the credential as")
	public void loginToApplicationAsList(DataTable dataTable) {
		
		String loginEndpointUrl = baseUrl + "/api/users/login";

		List<String> credentials = dataTable.asList();

		String userEmail = credentials.get(0);

		String userPassword = credentials.get(1);

		LoginPojo payloadAsPojo = new LoginPojo();

		User userFromPojo = new User();

		userFromPojo.setEmail(userEmail);

		userFromPojo.setPassword(userPassword);

		payloadAsPojo.setUser(userFromPojo);

		response = loginToApplication(loginEndpointUrl, payloadAsPojo);

		response.prettyPrint();

	}
	
	@When("Saurabh enters the credential as map")
	public void loginToApplicationAsMap(DataTable dataTable) {
		
		String loginEndpointUrl = baseUrl + "/api/users/login";

		Map<String, String> credentials = dataTable.asMap();

		String userEmail = credentials.get("email");

		String userPassword = credentials.get("password");

		LoginPojo payloadAsPojo = new LoginPojo();

		User userFromPojo = new User();

		userFromPojo.setEmail(userEmail);

		userFromPojo.setPassword(userPassword);

		payloadAsPojo.setUser(userFromPojo);

		response = loginToApplication(loginEndpointUrl, payloadAsPojo);

		response.prettyPrint();

	}
	
	@When("Saurabh enters the credential as vertical map")
	public void loginToApplicationAsVerticalMap(DataTable dataTable) {
		
		String loginEndpointUrl = baseUrl + "/api/users/login";

		Map<String, String> credentials = dataTable.transpose().asMap();

		String userEmail = credentials.get("email");

		String userPassword = credentials.get("password");

		LoginPojo payloadAsPojo = new LoginPojo();

		User userFromPojo = new User();

		userFromPojo.setEmail(userEmail);

		userFromPojo.setPassword(userPassword);

		payloadAsPojo.setUser(userFromPojo);

		response = loginToApplication(loginEndpointUrl, payloadAsPojo);

		response.prettyPrint();

	}

	@Then("Saurabh gets access to the application")
	public void verifyLogin() {

		vResponse = response.then();

		vResponse.statusCode(200);

		vResponse.statusLine("HTTP/1.1 200 OK");

		// More validation

		// Response value validations
	}

}
