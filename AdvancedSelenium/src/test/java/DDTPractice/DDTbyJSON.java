package DDTPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DDTbyJSON {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("./src/test/resources/JsonVtigerData.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		String BROWSER = data.get("browser").asText();
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
