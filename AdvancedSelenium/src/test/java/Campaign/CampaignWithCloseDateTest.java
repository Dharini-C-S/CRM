package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CampaignWithCloseDateTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		Properties prop= new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String usr = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		String url = prop.getProperty("url");
		
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat simDate = new SimpleDateFormat("dd-MM-yyyy");
		String today = simDate.format(date);
		System.out.println(today);
		
		//To use future date
		Calendar cal = simDate.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 15);
		String closeDate = simDate.format(cal.getTime());
		System.out.println(closeDate);
		
		//To use previous dates
		cal.add(Calendar.DAY_OF_MONTH, -10);
		String past = simDate.format(cal.getTime());
		System.out.println(past);
		
		//Generating random number for campaign name
		Random ran = new Random();
		int num = ran.nextInt(1000);
		
		
		//Test script data
		
		FileInputStream fisE = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		String campaignName = wb.getSheet("DDT").getRow(2).getCell(2).getStringCellValue()+num;
		 String target = wb.getSheet("DDT").getRow(2).getCell(3).getStringCellValue();
		
		
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
		
		//Campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		driver.findElement(By.name("targetSize")).sendKeys(target);
		driver.findElement(By.name("expectedCloseDate")).sendKeys(closeDate);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verification
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
		//WebElement msg = driver.findElement(By.className("Toastify__toast-body"));
		System.out.println(msg.getText());
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		//Thread.sleep(10000);
		
		
		//Logout
		WebElement user_icon = driver.findElement(By.className("user-icon"));
		Actions action = new Actions(driver);
		action.moveToElement(user_icon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		driver.quit();
		

	}

}
