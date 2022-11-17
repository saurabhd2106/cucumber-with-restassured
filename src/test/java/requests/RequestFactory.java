package requests;

import commonLibs.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

	public static Response loginToApplication(String endpointUrl, Object requestPayload) {

		return RestClient.sendPostRequest(endpointUrl, requestPayload);

	}

	public static Response loginToApplication(String endpointUrl, String username, String password) {

		return RestClient.sendPostRequest(endpointUrl, "");

	}

}
