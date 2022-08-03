package workBook.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	 Scanner scanner = new Scanner(System.in);

	
	 ArrayList fileReader(String studentOne,String studentTwo,String studentThree) {
		
	String line;
		
		FileReader file1,file2,file3;
		ArrayList list= new ArrayList();
		
		try {
			
			file1 = new FileReader(studentOne);
			BufferedReader br = new BufferedReader(file1);

			while ((line = br.readLine()) != null) {
				
				String words[] = line.split(" ");
				System.out.println(Arrays.toString(words));
				list.add(Arrays.toString(words));
				 
				
			}
			br.close();
			file2 = new FileReader(studentTwo);
			BufferedReader br2 = new BufferedReader(file2);

			while ((line = br2.readLine()) != null) {
				
				String words[] = line.split(" ");
				System.out.println(Arrays.toString(words));
				list.add(Arrays.toString(words));
							
			}
			br2.close();
			
			file3 = new FileReader(studentThree);
			BufferedReader br3 = new BufferedReader(file3);

			while ((line = br3.readLine()) != null) {
				
				String words[] = line.split(" ");
				System.out.println(Arrays.toString(words));
				list.add(Arrays.toString(words));
				
			}
			br3.close();
			System.out.println(list);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	
	
	void writeToXlsxFile() throws IOException {
		
		
		  String fileName;   
	       
	      

	        String userWorkingDirectory = System.getProperty("user.dir");
	        
	        System.out.println("Name Your File1:");
	        fileName = scanner.nextLine();
	        String studentOne = userWorkingDirectory + File.separator + fileName ;
	        
	        System.out.println("Name Your File2:");
	        fileName = scanner.nextLine();
	        String studentTwo = userWorkingDirectory + File.separator + fileName ;
	        
	        System.out.println("Name Your File3:");
	        fileName = scanner.nextLine();
	        String studentThree = userWorkingDirectory + File.separator + fileName ;
	        
	        ArrayList list= new ArrayList(fileReader(studentOne,studentTwo,studentThree));

	        System.out.println("Enter Your workbook Name:");
	       fileName = scanner.nextLine();
	       String bookname = userWorkingDirectory + File.separator + fileName ;
	        File file = new File(bookname);

	        FileInputStream fileInputStream = new FileInputStream(file);
	        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
	        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet7");

	        TreeMap<Integer,Object[]> map = new TreeMap<Integer,Object[]>();
	    int index=1;
	    map.put(index,  new Object[] {"ROLL NUMBER", "NAME", "TOTAL MARKS","RESULT"});
			for(Object temp : list) {
				
				String worde=temp.toString();
				String words[]=worde.split(",");
				
				 map.put(++index,  new Object[] {words[0],words[1],words[2],words[3]});
			}
			        Set<Integer> key = map.keySet();
			        int row = 0; //Null pointer Exception
			        XSSFRow nRow;
			        for (int index1: key) {
			            nRow = xssfSheet.createRow(row++);
			            Object[] objArray = map.get(index1);

			            int cell = 0;

			            for (Object obj: objArray) {
			                XSSFCell xssfCell = nRow.createCell(cell++);
			                xssfCell.setCellValue((String)obj);
			            }

			        }
			        FileOutputStream fileOutputStream = new FileOutputStream(bookname);
			        xssfWorkbook.write(fileOutputStream);
			        fileOutputStream.close();
			        System.out.println("XLsheet was writed Successfully");
	        	
	        
	        
	        
	        
	        
	        
		
	}

}
