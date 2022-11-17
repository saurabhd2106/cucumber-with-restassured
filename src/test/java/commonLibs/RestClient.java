package commonLibs;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class RestClient {
	
	public static Response sendGetRequest(String endpointUrl) {

		return given().when().get(endpointUrl);

	}

	public static Response sendGetRequest(String endpointUrl, Header header) {

		return given().header(header).when().get(endpointUrl);

	}

	public static Response sendPostRequest(String endpointUrl, Object payload) {

		return given().contentType(ContentType.JSON).when().body(payload).post(endpointUrl);

	}

	public static Response sendPostRequest(String endpointUrl, Object payload, Header header) {

		return given().header(header).contentType(ContentType.JSON).when().body(payload).post(endpointUrl);

	}

	public static Response sendPutRequest(String endpointUrl, Object payload) {

		return given().contentType(ContentType.JSON).when().body(payload).put(endpointUrl);

	}

	public static Response sendPutRequest(String endpointUrl, Object payload, Header header) {

		return given().header(header).contentType(ContentType.JSON).when().body(payload).put(endpointUrl);

	}

	public static Response sendDeleteRequest(String endpointUrl) {

		return given().when().delete(endpointUrl);

	}

	public static Response sendDeleteRequest(String endpointUrl, Header header) {

		return given().header(header).when().delete(endpointUrl);

	}


}
