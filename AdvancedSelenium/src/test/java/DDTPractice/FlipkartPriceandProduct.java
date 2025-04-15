package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartPriceandProduct {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String LINK = prop.getProperty("link");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(LINK);
		
		driver.findElement(By.name("q")).sendKeys("bluetooth");
		driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();
		
		List<WebElement> productName = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		
		System.out.println(productName.size());
		
		List<WebElement> price = driver.findElements(By.className("Nx9bqj"));
		System.out.println(price.size());
		
		for(int i=0; i<productName.size(); i++) {
			
			System.out.println(productName.get(i).getAttribute("title")+ " "+ price.get(i).getText());
		}
	}

}
