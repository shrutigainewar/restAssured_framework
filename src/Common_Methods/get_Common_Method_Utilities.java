package Common_Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class get_Common_Method_Utilities {
	
	public static void EvidenceFileCreator(String fileName, String response) throws IOException
	{
		File newtxtfile=new File("C:\\Users\\kbwad\\Desktop\\MSSQUARE_NOTES\\Rest_Assured\\restAssured_Evidence\\" +fileName+ ".txt");
		
		if(newtxtfile.createNewFile())
		{
			FileWriter datawriter=new FileWriter(newtxtfile);
			datawriter.write("Response body is: " +response);
			datawriter.close();
			System.out.println("\n\nRequest and Response Body file is created." +newtxtfile.getName());
		}
		else
		{
			System.out.println(newtxtfile.getName()+ "\n\nFile already exists, take backup of it.");
		}
	}

}
