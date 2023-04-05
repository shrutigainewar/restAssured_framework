package Common_Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Common_Method_Utilities {
	
	public static void EvidenceFileCreator(String fileName, String request, String response) throws IOException
	{
		File newtextfile=new File("C:\\Users\\kbwad\\Desktop\\MSSQUARE_NOTES\\Rest_Assured\\restAssured_Evidence\\" + fileName + ".txt");
		
		if(newtextfile.createNewFile())
		{
		FileWriter datawriter=new FileWriter(newtextfile);
		datawriter.write("Request Body is:\n" +request+ "\n\n");
		datawriter.write("Response Body is:\n" +response);
		datawriter.close();
		System.out.println("Request and Response body saved in: " +newtextfile.getName());
		}
		else
		{
			System.out.println(newtextfile.getName()+ " Already exists please take backup of it.");
		}
    }
}	
