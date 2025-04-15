package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFileTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		Row row1 = sheet.getRow(0);
		Row row2 = sheet.getRow(1);
		Row row3 = sheet.getRow(2);
		
		Cell cell1 = row1.getCell(0);
		Cell cell2 = row2.getCell(0);
		Cell cell3 = row3.getCell(0);
		
		
		String val1 = cell1.getStringCellValue();
		String val2 =cell2.getStringCellValue();
		
		
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cell3);
		
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(exceldata);
		
	}

}
