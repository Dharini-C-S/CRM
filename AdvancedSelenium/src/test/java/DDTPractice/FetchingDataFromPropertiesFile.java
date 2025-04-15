package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UNAME = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("EDGE")) {
			driver= new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
