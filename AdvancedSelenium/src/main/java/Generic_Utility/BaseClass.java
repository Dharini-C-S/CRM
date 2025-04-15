package Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {
	public WebDriver driver;
	@BeforeSuite(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void beforeSuite() {
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void beforeTest() {
		System.out.println("Parallel Execution or reading external resources");
	}
//	pullOne
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void beforeClass() throws IOException {
		File_Utility fileUtility = new File_Utility();
		String BROWSER =fileUtility.getDataFromPropertiesFile("browser");
		
		
		if(BROWSER.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.contains("edge"))
		{
			driver= new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void beforeMethod() throws IOException {
		File_Utility fileUtility = new File_Utility();
		String URL =fileUtility.getDataFromPropertiesFile("url");
		String USERNAME =fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD =fileUtility.getDataFromPropertiesFile("password");
		
		driver.get(URL);
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVTigerApplication(USERNAME, PASSWORD);
		
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void afterMethod() {
		System.out.println("Logout from application");
		VtigerHomepage homePage = new VtigerHomepage(driver);
		homePage.LogoutOfApplication(driver);
	}
	
	@AfterClass(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void afterClass() {
		driver.quit();
		System.out.println("Close browser");
	}
	
	@AfterTest(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void afterTest() {
		System.out.println("Stop Parallel Execution or  close reading external resources");
	}
	
	@AfterSuite(groups = {"SmokeTest","IntegrationTest","RegressionTest"})
	public void afterSuite() {
		System.out.println("Close database connection");
	}


	
	}
