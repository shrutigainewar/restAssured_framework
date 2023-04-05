package Test_Class;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Methods.put_Common_Method_API;
import Common_Methods.put_Common_Method_Utilitiees;
import Request_Repository.put_Request_Repository;
import io.restassured.path.json.JsonPath;

public class put_TC1 {
	@Test
	
	public static void orchestrator() throws IOException
	{
		String responseBody="";
		int responseStatusCode=0;
		String baseURI=put_Request_Repository.baseURI();
		String resource=put_Request_Repository.resource();
		String requestBody=put_Request_Repository.put_Request_TC1();
		
		for(int i=0; i<5; i++)
		{
			responseStatusCode=put_Common_Method_API.responseStatusCode_Extractor(baseURI, resource, requestBody);
					
			if(responseStatusCode==200)
			{
				responseBody=put_Common_Method_API.responsebody_Extractor(baseURI, resource, requestBody);
				responseBodyValidator(responseBody);
				break;
			}
			else
			{
				System.out.println("Correct status Code is not found in iteration " +i); 
			}
		}
		put_Common_Method_Utilitiees.EvidenceFileCreator("put_TC1", requestBody, responseBody);
	}

	private static void responseBodyValidator(String responseBody)
	{
		// TODO Auto-generated method stub
		
		//Create json path object to extract response body parameters
		JsonPath obj=new JsonPath(responseBody);
		
		//extract response body parameters
		String res_name=obj.getString("name");
		String res_job=obj.getString("job");
		String res_updatedAt=obj.getString("updatedAt");
		
		//date slipt
		String date=res_updatedAt.substring(0, 10);
		String currentdate=LocalDate.now().toString();
		
		//Print result
		/*System.out.println("Name: " +res_name+ "\nJob: " +res_job+ "\nUpdatedAt: " +res_updatedAt);
		System.out.println("Actual Date: " +date+ "\nCurrent Date: " +currentdate);*/
		
		//validate response body parameters
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");
		Assert.assertEquals(date, currentdate);
	}

}
