package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatainExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet("WriteData").createRow(1).createCell(1).setCellValue("SELENIUM");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
		System.out.println("Data written in Excel successfully");
		
	}

}
