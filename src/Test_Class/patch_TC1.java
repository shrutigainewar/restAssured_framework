package Test_Class;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Methods.patch_Common_Method_API;
import Common_Methods.patch_Common_Method_Utilities;
import Request_Repository.patch_Request_Repository;
import io.restassured.path.json.JsonPath;

public class patch_TC1 {
	@Test
	
	public static void orchestrator() throws IOException
	{
		int res_StatusCode=0;
		String responseBody="";
		String baseURI=patch_Request_Repository.baseURI();
		String resource=patch_Request_Repository.resource();
		String requestbody=patch_Request_Repository.patch_TC1();
		
		for(int i=0; i<5; i++)
		{
			res_StatusCode=patch_Common_Method_API.response_StatusCode_Extractor(baseURI, resource, requestbody);
			if(res_StatusCode==200)
			{
				responseBody=patch_Common_Method_API.responseBody_Extractor(baseURI, resource, requestbody);
				responseBodyValiadtor(responseBody);
				break;
			}
			else
			{
				System.out.println("Correct Status Code is not found. " +i);
			}
		}
		patch_Common_Method_Utilities.EvidenceFileCreator("patch_TC1", requestbody, responseBody);
		Assert.assertEquals(res_StatusCode, 200);
	}

	private static void responseBodyValiadtor(String responseBody) {
		// TODO Auto-generated method stub
		
		//Create json Path object to extract responsebody parameters
		JsonPath obj=new JsonPath(responseBody);
		
		//Extract responsebody parameters
		String res_name=obj.getString("name");
		String res_job=obj.getString("job");
		String res_updatedAt=obj.getString("updatedAt");
		
		String date=res_updatedAt.substring(0, 10);
		String currentdate=LocalDate.now().toString();
		
		//print result
		/*System.out.println("Name: " +res_name+ "\nJob: " +res_job+ "\nupdatedAt: " +res_updatedAt);
		System.out.println("Actual Date: " +date+ "\nCurrenty Date: " +currentdate);*/
		
		//validate responsebody parameters
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");
		Assert.assertEquals(date, currentdate);
	}

}
