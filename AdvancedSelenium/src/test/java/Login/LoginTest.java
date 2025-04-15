package Login;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url =prop.getProperty("url");
		String usrn =prop.getProperty("username");
		String pwd =prop.getProperty("password");
		
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
		//Verification
		WebElement heading = driver.findElement(By.xpath("//b[text()='Campaigns']"));
		if(heading.isDisplayed()) {
			System.out.println("Verified: Logged in successfully");
		}else {
			System.out.println("Login unsuccessful");
		}
		//Logging out
		Actions action= new Actions(driver);
		WebElement userIcon = driver.findElement(By.className("user-icon"));
		action.moveToElement(userIcon).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
		driver.quit();
	}
}
