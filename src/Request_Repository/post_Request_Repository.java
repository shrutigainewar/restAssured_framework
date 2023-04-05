package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.getData;

public class post_Request_Repository {
	
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String resource() {
		String resource="api/users";
		return resource;
	}
	public static String post_Request_TC1() throws IOException
	{
		ArrayList <String> data = getData.getDataExcel("Post_Data", "TC1");
		String Name = data.get(2);
		String Job = data.get(3);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
	}
	
	/*public static String post_Request_TC2() {
		String requestBody="{\r\n"
				+ "    \"name\": \"morph\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return requestBody;
	}*/

}
