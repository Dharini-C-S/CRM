package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileInputStream fis = new FileInputStream("C:\\Users\\dhari\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\Data.properties");
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL =prop.getProperty("url");
//		String usrn =prop.getProperty("username");
//		String pwd =prop.getProperty("password");
//		System.out.println(browser);
//		System.out.println(url);
//		System.out.println(usrn);
	//	System.out.println(pwd);
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome")){
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.get(URL);
		
	}

}
