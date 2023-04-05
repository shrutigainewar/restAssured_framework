package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.getData;

public class patch_Request_Repository {
	
	public static String baseURI()
	{
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String resource()
	{
		String resource="api/users/2";
		return resource;
	}
	public static String patch_TC1() throws IOException
	{
		ArrayList <String> data = getData.getDataExcel("Patch_Data", "TC1");
		String Name = data.get(2);
		String Job = data.get(3);
		
		String reqbody="{\r\n"
				+ "    \"name\": \""+Name+"\",\r\n"
				+ "    \"job\": \""+Job+"\"\r\n"
				+ "}";
		return reqbody;
	}

}
