package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url =prop.getProperty("url");
		String usrn =prop.getProperty("username");
		String pwd =prop.getProperty("password");
		
		//Generating random number for campaign name
		Random ran = new Random();
		int num = ran.nextInt(1000);
		
		//Excel
		FileInputStream fisE = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		String campaignName = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue()+num;
		String target = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		
		// Launching browser
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(usrn);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// TODO Auto-generated method stub
		
		//Create Campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		driver.findElement(By.name("targetSize")).sendKeys(target);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//	//WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//WebElement msg = driver.findElement(By.className("Toastify__toast-body"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		//String msg = driver.findElement(By.xpath("//div[ends-with(text(),'Successfully Added')]")).getText();
		
		 System.out.println(msg.getText());
		WebElement userIcon = driver.findElement(By.className("user-icon"));
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		driver.quit();

	}

}
