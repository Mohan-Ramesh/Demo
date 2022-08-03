package exe18522;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TopperFinder {
	Scanner scan = new Scanner(System.in);
	  String jSonFile;
	  String fileName,userWorkingDirectory;
	  int records;
	  
	void jsonWriter() throws IOException {
		
		JSONArray studentDetails = new JSONArray();
		System.out.println("Enter num of Records");
		records = scan.nextInt();
		scan.nextLine();
		JSONObject jobject[] = new JSONObject[records]  ;
		for (int index = 0 ;index<records ; index++) {
			
			jobject[index] = new JSONObject();
			
			System.out.println("Enter the ROLL NUM :");
			jobject[index].put("ROLL NUM ", scan.nextLine());
			
			System.out.println("Enter the NAME :");
			jobject[index].put("NAME ", scan.nextLine());
			
			System.out.println("Enter the MARKS :");
			jobject[index].put("MARKS", scan.nextInt());
			scan.nextLine();
			
			System.out.println("Enter the RESULT :");
			jobject[index].put("RESULT", scan.nextLine());
			
			studentDetails.add(jobject[index]);
			
			
		}
		
		 userWorkingDirectory = System.getProperty("user.dir");
	      System.out.println("Name Your File:");
	      fileName = scan.nextLine();
		     jSonFile = userWorkingDirectory + File.separator + fileName ;
		
		File jFile = new File(jSonFile);
		jFile.createNewFile();
		FileWriter file = new FileWriter(jFile);
		file.write(studentDetails.toJSONString());
		 file.flush();
		file.close();
		System.out.println("File written successfully...");
	
		
	}
	
	void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		 JSONParser jsonParser = new JSONParser();
		 FileReader reader = new FileReader(jSonFile);
	        
	         
	            Object obj = jsonParser.parse(reader);

	            JSONArray studentList = (JSONArray) obj;
	        
	            JSONObject empobject[] = new JSONObject[records] ;
	      	            
	          
	           for (int objectNameChanger = 0;objectNameChanger<studentList.size();objectNameChanger++ ) {
	        	   
	        	   empobject[objectNameChanger]  = (JSONObject) studentList.get(objectNameChanger);
	        	   
	           }
	           
	            JSONObject max = empobject[0];
	          
	            for(int objindex = 0;objindex<studentList.size();objindex++) {
	            	if((Long)max.get("MARKS")<(Long)empobject[objindex].get("MARKS")){
	            		
	            		max = empobject[objindex];
	            		
	            	}
	            	
	            	
	            }
	            System.out.println(max.get("NAME "));
            	  
	}
	
	
	
	
	
	
	
	
}