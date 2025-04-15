package DDTPractice;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcel {

	public static void main(String[] args) throws Throwable {
		//Accessing the excel
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		//navigating the sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		//Accessing the row
		Row row = sheet.createRow(3);
	
		//Accessing the cell
		Cell cell = row.createCell(0);
		
		//Passing the value to insert
		cell.setCellValue("Inserted Data");
		
		//Accessing
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
		wb.write(fos);
		
		
		wb.close();
		
		

	}

}
