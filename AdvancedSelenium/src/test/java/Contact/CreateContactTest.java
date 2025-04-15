package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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
//import org.openqa.selenium.support.ui.Select;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		Properties prop= new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String usr = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		String url = prop.getProperty("url");
		
		//Fetching test script data
		FileInputStream fisE = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		String campaign = wb.getSheet("DDT").getRow(3).getCell(2).getStringCellValue();
		String organization = wb.getSheet("DDT").getRow(3).getCell(4).getStringCellValue();
		String title= wb.getSheet("DDT").getRow(3).getCell(5).getStringCellValue();
		String contactName =wb.getSheet("DDT").getRow(3).getCell(6).getStringCellValue();
		String mobile =wb.getSheet("DDT").getRow(3).getCell(7).getStringCellValue();
		//Launching Browser
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if( browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else if ( browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(usr);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Create Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("organizationName")).sendKeys(organization);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.name("contactName")).sendKeys(contactName);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		
		//Selecting the campaign
		//Handling the window
		Set<String> window = driver.getWindowHandles();
		for(String win : window) {
			driver.switchTo().window(win);
			String actualUrl = driver.getCurrentUrl();
			
			if(actualUrl.contains("selectCampaign")) {
				break;
			}
		}
			
		WebElement list = driver.findElement(By.id("search-criteria"));
		Select select = new Select(list);
		select.selectByIndex(1);
		driver.findElement(By.id("search-input")).sendKeys(campaign);
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		
		for(String win : window) {
			driver.switchTo().window(win);
			String actualUrl = driver.getCurrentUrl();
			
			if(actualUrl.contains("create-contact")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		//Verification
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
		if(msg.getText().contains("Added")) {
			System.out.println(msg.getText());
		}
		else {
			System.out.println("Verification failed");
		}
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		//Logout
		WebElement user_icon = driver.findElement(By.className("user-icon"));
		Actions action = new Actions(driver);
		action.moveToElement(user_icon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		driver.quit();
				

	}

}
