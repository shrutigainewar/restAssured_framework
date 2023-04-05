package Common_Methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class patch_Common_Method_API {
	
	public static int response_StatusCode_Extractor(String baseURI, String resource, String reqbody)
	{
		RestAssured.baseURI=baseURI;
		int res_StatusCode=given().header("Content-Type", "application/json").body(reqbody).when().patch(resource).then().extract().statusCode();
		return res_StatusCode;
	}
	
	public static String responseBody_Extractor(String baseURI, String resource, String reqbody)
	{
		RestAssured.baseURI=baseURI;
		String responseBody=given().header("Content-Type", "application/json").body(reqbody).when().patch(resource).then().extract().response().asString();
		return responseBody;
	}

}
