package jSonHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTOXLFILE {

	Scanner scan = new Scanner(System.in);
	  String jSonFile;
	  String fileName,userWorkingDirectory;  
	  JSONObject oJsonObject = new JSONObject();
	void writer() throws IOException {		
	  
	 JSONObject oJsonObject = new JSONObject();
	 
		
		oJsonObject.put("EmployeeID", "2050");
		oJsonObject.put("EmployeeName", "Mohan krishna");
		oJsonObject.put("EmployeeRole","Trainee");

		
	      userWorkingDirectory = System.getProperty("user.dir");
	      System.out.println("Name Your File:");
	      fileName = scan.nextLine();
		     jSonFile = userWorkingDirectory + File.separator + fileName ;
		
		File jFile = new File(jSonFile);
		jFile.createNewFile();
		FileWriter file = new FileWriter(jFile);
		file.write(oJsonObject.toJSONString());
		file.close();
		System.out.println("File written successfully...");
		
  }
	
	void xlWriter() throws IOException, ParseException {	

		JSONParser oJsonParser = new JSONParser();		
        
        FileReader reader = new FileReader(jSonFile);       
          
            Object obj = oJsonParser.parse(reader);
         oJsonObject = (JSONObject) obj;
         Set <String> key =oJsonObject.keySet();
        
         TreeMap <String,String> map = new TreeMap();
         
         for(String jkey : key) {
        	 
        	 map.put(jkey,(String) oJsonObject.get(jkey) );
         }
        
         System.out.println("enter the sheet name ");
         fileName = scan.nextLine();
	    String xlFile = userWorkingDirectory + File.separator + fileName ;
	
         File xlfile = new File(xlFile);
        
         
         FileInputStream fileInputStream = new FileInputStream(xlfile);
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
	        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet9");
         
	        int row = 0; 
	        XSSFRow nRow;
	        for (String index1: key) {
	            nRow = xssfSheet.createRow(row++);
	            String objArray[] = { index1,map.get(index1)};

	            int cell = 0;

	            for (String temp: objArray) {
	                XSSFCell xssfCell = nRow.createCell(cell++);
	                xssfCell.setCellValue(temp);
	            }

	        }
	        FileOutputStream fileOutputStream = new FileOutputStream(xlfile);
	        xssfWorkbook.write(fileOutputStream);
	        fileOutputStream.close();
	        System.out.println("XLsheet was writed Successfully");
		
	}
	

}
