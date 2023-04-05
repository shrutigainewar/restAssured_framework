package Test_Class;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Methods.Common_Method_API;
import Common_Methods.Common_Method_Utilities;
import Request_Repository.post_Request_Repository;
import io.restassured.path.json.JsonPath;

public class post_TC1 {
	@Test
	
	public static void orchestrator() throws IOException
	{
		String responseBody="";
		int res_StatusCode=0;
		String baseURI=post_Request_Repository.baseURI();
		String resource=post_Request_Repository.resource();
		String requestBody=post_Request_Repository.post_Request_TC1();
		
		for(int i=0; i<5; i++)
		{
			res_StatusCode=Common_Method_API.responseStatusCode_extractor(baseURI, resource, requestBody);
			if(res_StatusCode==201)
			{
				responseBody=Common_Method_API.responseBody_extractor(baseURI, resource, requestBody);
				responseBodyValidator(responseBody);
				
				break;
			}
			else
			{
				System.out.println("Correct status code is not found in iteration " +i);
			}
		}
		Common_Method_Utilities.EvidenceFileCreator("post_TC1", requestBody, responseBody);
		Assert.assertEquals(res_StatusCode, 201);
		
	}

	private static void responseBodyValidator(String responseBody) {
		// TODO Auto-generated method stub
		
		//Create json path object to extract response body parameters
		JsonPath obj=new JsonPath(responseBody);
		
		//extract responsebody parameters
		String res_name=obj.getString("name");
		String res_job=obj.getString("job");
		String res_id=obj.getString("id");
		String res_createdAt=obj.getString("createdAt");
		
		String date=res_createdAt.substring(0, 10);
		String currentdate=LocalDate.now().toString();
		
		/*//print results
		System.out.println("Name: " +res_name);
		System.out.println("Job: " +res_job);
		System.out.println("Id: " +res_id);
		System.out.println("CreatedAt: " +res_createdAt);
		System.out.println("Actual Date: " +date+ "\nCurrent Date: " +currentdate);*/
		
		//validate responsebody parameters
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotNull(res_id, "Not Null");
		Assert.assertEquals(date, currentdate);
			
	}

}
