package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.getData;

public class put_Request_Repository {
	
	public static String baseURI()
	{
		String baseURI="https://reqres.in";
		return baseURI;
	}
	
	public static String resource()
	{
		String resource="api/users/2";
		return resource;
	}
	
	public static String put_Request_TC1() throws IOException
	{
		ArrayList <String> data = getData.getDataExcel("Put_Data", "TC1");
		String Name = data.get(2);
		String Job = data.get(3);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return requestBody;
	}

}
