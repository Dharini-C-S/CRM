package testng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidee {

	//Executing same test scripts multiple times by providing different set of data
	
	@Test(dataProvider = "getLoc")
	public void bookTickets(String src, String dest, String noOfPass) {
		
		System.out.println("Book tickets from "+src+" to "+dest);
		System.out.println("Number of passengers: "+noOfPass);
	}
	
//	@DataProvider
//	public Object[][] getLoc(){
//		
//		Object[][] obj = new Object[3][3];
//		
//		obj[0][0]="Bangalore";
//		obj[0][1]="Mangalore";
//		obj[0][2]=60;
//		
//		obj[1][0]="Coorg";
//		obj[1][1]="Wayand";
//		obj[1][2]=25;
//		
//		obj[2][0]="Ooty";
//		obj[2][1]="Goa";
//		obj[2][2]=30;
//		
//		return obj;
//		
//	}
	
	//Fetching data from excel
	@DataProvider
	public Object[][] getLoc() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		 Sheet st = wb.getSheet("DataProvider");
		
		int lastRow = st.getLastRowNum()+1;
		 int lastCell = st.getRow(0).getLastCellNum()+1;
		 System.out.println(lastRow);
		System.out.println(lastCell);
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++) {
				obj[i][j]=st.getRow(i).getCell(j).getStringCellValue();			
				}
		}
//		 obj[0][0]= wb.getSheet("DataProvider").getRow(0).getCell(0).getStringCellValue();
//		 obj[0][1]= wb.getSheet("DataProvider").getRow(0).getCell(1).getStringCellValue();
//		 obj[0][2]= wb.getSheet("DataProvider").getRow(0).getCell(2).getStringCellValue();
//		 
//		 obj[1][0]= wb.getSheet("DataProvider").getRow(1).getCell(0).getStringCellValue();
//		 obj[1][1]= wb.getSheet("DataProvider").getRow(1).getCell(1).getStringCellValue();
//		 obj[1][2]= wb.getSheet("DataProvider").getRow(1).getCell(2).getStringCellValue();
//		 
//		 obj[2][0]= wb.getSheet("DataProvider").getRow(2).getCell(0).getStringCellValue();
//		 obj[2][1]= wb.getSheet("DataProvider").getRow(2).getCell(1).getStringCellValue();
//		 obj[2][2]= wb.getSheet("DataProvider").getRow(2).getCell(2).getStringCellValue();
		 
		return obj;
		
	}
}
