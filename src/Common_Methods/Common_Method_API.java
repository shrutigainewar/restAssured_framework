package Common_Methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Common_Method_API {
	
	public static int responseStatusCode_extractor(String baseURI, String resource, String req_body)
	{
		RestAssured.baseURI=baseURI;
		int response_Statuscode=given().header("Content-Type", "application/json").body(req_body).when().post(resource)
				.then().extract().statusCode();
		return response_Statuscode;
	}
	public static String responseBody_extractor(String baseURI, String resource, String req_body)
	{
		RestAssured.baseURI=baseURI;
		String response_body=given().header("Content-Type", "application/json").body(req_body).when().post(resource)
				.then().extract().response().asString();
		return response_body;
	}

}