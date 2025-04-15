package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertAllTheLinksToExcel {

	public static void main(String[] args) throws IOException {
		//Fetching common data
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String Link = prop.getProperty("link");
		
		//Launching the browser
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(Link);
		//Fetching all the links present in the website
		List<WebElement> links = driver.findElements(By.xpath("//a"));
	
		//Accessing the excel and writing the data in  the excel
		FileInputStream excel = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(excel);
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		//Row row = sheet.createRow(1);
		
		
		int i=1;
		
		for(WebElement l : links)
		{	
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(2);
			cell.setCellValue(l.getAttribute("href")); //we are getting the value for the href attribute
			i++;
		}
		System.out.println("Inserted data successfully");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptData.xlsx");
		wb.write(fos);
		
		//Fetching the data from excel and printing it in the console
		
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		
		for(int j=1; j<=lastRow; j++) {
			Row row = sheet.getRow(j);
			Cell cell = row.getCell(2);
			String value = cell.getStringCellValue();
			System.out.println(value);
		}
		
		wb.close();
		
		
		
	}
}
