package DDTPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneGreaterThan60k {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Iphone");
		driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		
		for(WebElement p : price) {
			
			String filteredPrice = (p.getText()).replaceAll("[^0-9]", "");
			Integer priceInt = Integer.valueOf(filteredPrice);
			if(priceInt>60000) {
				String productName = driver.findElement(By.xpath("//div[text()='"+p.getText()+"']/ancestor::div[@class='yKfJKb row']//div[@class='KzDlHZ']")).getText();
				System.out.println(productName +" = "+p.getText());
				
			}
		
			}
		
		driver.quit();
		
		}
	}

