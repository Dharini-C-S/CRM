package Products;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductTest {

	public static void main(String[] args) throws IOException {
		// Fetching common data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		
		//Launching browser
		WebDriver driver= null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		
		//Login
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Creating Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		
		//Fetching data from excel
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String productName = wb.getSheet("Product").getRow(1).getCell(2).getStringCellValue();
		String category = wb.getSheet("Product").getRow(1).getCell(3).getStringCellValue();
		String quantity = wb.getSheet("Product").getRow(1).getCell(4).getStringCellValue();
		String price = wb.getSheet("Product").getRow(1).getCell(5).getStringCellValue();
		String vendor = wb.getSheet("Product").getRow(1).getCell(6).getStringCellValue();
		
		//Passing the values to create account
		
		driver.findElement(By.name("productName")).sendKeys(productName);
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		driver.findElement(By.name("price")).sendKeys(price);
		WebElement cat = driver.findElement(By.name("productCategory"));
		Select select = new Select(cat);
		select.selectByValue(category);
		WebElement ven = driver.findElement(By.name("vendorId"));
		Select sel = new Select(ven);
		sel.selectByVisibleText(vendor);
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		//Verification
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		if(msg.getText().contains(productName)) {
			System.out.println(msg.getText());
		}
		else {
			System.out.println("Product not added successfully");
		}
		
		//Logout
		WebElement userIcon = driver.findElement(By.className("user-icon"));
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		driver.quit();
		
	}

}
