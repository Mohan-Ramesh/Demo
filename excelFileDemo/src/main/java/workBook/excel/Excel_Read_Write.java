package workBook.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

public class Excel_Read_Write {
	FileInputStream inputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int numberOfRows, numberOfCells;
	String home = System.getProperty("user.dir");
	String filePath = home + File.separator + "sample2.xlsx";
	Scanner scanner = new Scanner(System.in);

	@Test
	public void write() throws IOException {

		File file = new File(filePath);
		inputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.createSheet("sheet3");

		System.out.println("Enter the number of Rows");
		numberOfRows = scanner.nextInt();
		System.out.println("Enter the number of cell");
		numberOfCells = scanner.nextInt();
		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
			row = sheet.createRow(rowIndex);

			for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
				cell = row.createCell(cellIndex);
				if (cellIndex == 0) {
					System.out.println("Enter the name");
					cell.setCellValue(scanner.next());
				} else {
					System.out.println("Enter the marks");
					cell.setCellValue(scanner.next());
				}
			}
		}
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		outputStream.close();
	}

	@AfterTest
	public void read() throws IOException {

		inputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("sheet3");

		for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
			row = sheet.getRow(rowIndex);

			for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
				cell = row.getCell(cellIndex);

				String text = cell.getStringCellValue();
				System.out.print(text + " ");
			}
			System.out.println();
		}

	}

}