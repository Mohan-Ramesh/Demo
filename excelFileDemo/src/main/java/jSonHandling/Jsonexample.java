package jSonHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Jsonexample {
	
	int records;
	 String jSonFile;
	  String fileName,userWorkingDirectory;
	Scanner scan = new Scanner(System.in);
	
	 void writeJson() throws IOException {
		System.out.println("Enter th records");
		records = scan.nextInt();
		scan.nextLine();
		JSONObject []oJSONObject = new JSONObject[records];
		 userWorkingDirectory = System.getProperty("user.dir");
	      System.out.println("Name Your File:");
	      fileName = scan.nextLine();
		     jSonFile = userWorkingDirectory + File.separator + fileName ;
		
		File jFile = new File(jSonFile);
		jFile.createNewFile();
		FileWriter file = new FileWriter(jFile);
	
		
for (int index = 0 ;index<records ; index++) {
			
	oJSONObject[index] = new JSONObject();
			
			System.out.println("Enter the ROLL NUM :");
			oJSONObject[index].put("ROLL NUM ", scan.nextLine());
			
			System.out.println("Enter the NAME :");
			oJSONObject[index].put("NAME ", scan.nextLine());
			
			System.out.println("Enter the MARKS :");
			oJSONObject[index].put("MARKS", scan.nextInt());
			scan.nextLine();
			
			System.out.println("Enter the RESULT :");
			oJSONObject[index].put("RESULT", scan.nextLine());
			
			file.write(oJSONObject[index].toJSONString());
			 file.flush();
			
			
		}

file.close();
System.out.println("File written successfully...");

	}
	
	
}
