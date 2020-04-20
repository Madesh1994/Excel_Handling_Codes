package ClassWorkMaven.HandlingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {

	@SuppressWarnings("deprecation")
	private static void excelHandingmethod(String filepath, String workBookName, String sheetname) throws IOException {
		// TODO Auto-generated method stub

		// create object for a file
		File login = new File(filepath + workBookName);
		System.out.println(login);

		// Creating an object of FileInputStream
		FileInputStream fileInput = new FileInputStream(login);
		Workbook readBook = null;

		// Creating an object for XSSFworkbook class
		readBook = new XSSFWorkbook(fileInput);

		// Creating an object for Sheet;
		Sheet sheet1 = readBook.getSheet(sheetname);

		// Identifing the total number of rows
		int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		
		System.out.println("Total Number of Rows in sheet " + rowCount);
		
		for (int i =1; i<rowCount+1;i++)
		{
			Row row =  sheet1.getRow(i);
			
			for (int j=0; j<row.getLastCellNum();j++)
			{
				//reading cell value
				Cell cellvalue = sheet1.getRow(i).getCell(j);
				cellvalue.setCellType(CellType.STRING);
				String value = cellvalue.getStringCellValue();
				
				System.out.println(value);
			}
				
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelHandling objREH = new ExcelHandling();

		String Filepath = "C:\\Users\\elcot\\Downloads\\";

		System.out.println("\n************Excel Handing ************");
		objREH.excelHandingmethod(Filepath, "LoginDetails.xlsx", "Sheet1");

	
	}

}
