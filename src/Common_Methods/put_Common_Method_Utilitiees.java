package Common_Methods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class put_Common_Method_Utilitiees {
	
	public static void EvidenceFileCreator(String filename, String Request, String Response) throws IOException
	{
		File newtxtfile= new File("C:\\Users\\kbwad\\Desktop\\MSSQUARE_NOTES\\Rest_Assured\\restAssured_Evidence\\" +filename+ ".txt");
		
		if(newtxtfile.createNewFile())
		{
			FileWriter datawriter= new FileWriter(newtxtfile);
			datawriter.write("Request Body is: " +Request+ "\n\n");
			datawriter.write("Response Body is: " +Response);
			datawriter.close();
			System.out.println("Request and Response body saved in: " +newtxtfile.getName());
		}
		else
		{
			System.out.println(newtxtfile.getName()+ "File already exist, take backup of it.");
		}
	}
}
