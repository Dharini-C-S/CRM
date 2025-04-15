package Generic_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {


	public String getDataFromExcel(String sheetName, int rowNum, int cellNum ) throws EncryptedDocumentException, IOException
	{
		/**
		 * This method used to fetch the data from excel
		 * @author Dharini C S
		 */
		File file = new File("./src/test/resources/TestScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(file);
		
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
	}

	public String getDataFromExcelUsingDataFormatter(String sheetName, int rowNum, int cellNum ) throws EncryptedDocumentException, IOException {

		/**
		 * With the help of DataFormatter, data will be converted into String
		 * @author Dharini C S
		 */
		File file = new File("./src/test/resources/TestScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(file);
		
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		
		
		return data;
		
	}
}
