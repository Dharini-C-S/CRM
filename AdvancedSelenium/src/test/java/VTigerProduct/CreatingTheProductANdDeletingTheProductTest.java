package VTigerProduct;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreatingProductForm;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerProductsPage;

public class CreatingTheProductANdDeletingTheProductTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void creatingTheProductANdDeletingTheProductTest() throws EncryptedDocumentException, IOException, InterruptedException {

//				File_Utility fileUtility = new File_Utility();
////				String BROWSER =fileUtility.getDataFromPropertiesFile("browser");
//				String URL =fileUtility.getDataFromPropertiesFile("url");
//				String USERNAME =fileUtility.getDataFromPropertiesFile("username");
//				String PASSWORD =fileUtility.getDataFromPropertiesFile("password");
				
//				WebDriver driver = null;
//				
//				if(BROWSER.contains("chrome"))
//				{
//					driver = new ChromeDriver();
//				}
//				else if(BROWSER.contains("firefox")) {
//					driver = new FirefoxDriver();
//				}
//				else if (BROWSER.contains("edge"))
//				{
//					driver= new EdgeDriver();
//				}
//				else {
//					driver = new ChromeDriver();
//				}
				
				WebDriver_Utility webUtility = new WebDriver_Utility();
				
				webUtility.maximizeBrowser(driver);
				webUtility.waitElementsToLoad(driver);
				
//				driver.get(URL);
				
//				//Login
//				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
//				
				
				//Logging in with the help of getter method
				
//				VtigerLoginPage login = new VtigerLoginPage(driver);
//				
//				login.getUsernameTextField().sendKeys(USERNAME);
//				login.getPasswordTextField().sendKeys(PASSWORD);
//				login .getLoginButton().click();

				
				//business logics to login
//				login.loginToVTigerApplication(USERNAME, PASSWORD);
				
				//Generating random number to avoid duplicate products
				
				Java_Utility javaUtility = new Java_Utility();
				int ranNum = javaUtility.getRandomNumber();
//				
				// Accessing data from file utility
				Excel_Utility excelUtility = new Excel_Utility();
				
				String productName=excelUtility.getDataFromExcel("VtigerProduct", 1, 0)+ranNum;
				
				//driver.findElement(By.linkText("Products")).click();
				VtigerHomepage homePage = new VtigerHomepage(driver);
				homePage.clickProductsLink(driver);
				
//				driver.findElement(By.cssSelector("img[alt=\"Create Product...\"]")).click();
				VtigerProductsPage products = new VtigerProductsPage(driver);
				products.clickCreateProductIcon(driver);
				
//				driver.findElement(By.name("productname")).sendKeys(productName);
//				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				CreatingProductForm productForm = new CreatingProductForm(driver);
				productForm.createProduct(productName);
				productForm.clickSaveButton(driver);
				
				
				//Verification
//				String confirmationMsg = driver.findElement(By.id("dtlview_Product Name")).getText();
				String actProductName=	productForm.verifyCreationOfProduct(driver, productName);
			
				Assert.assertEquals(productName, actProductName, "Product "+productName+" is not created");
				System.out.println("Product "+productName+" is created successfully");
				
				//Deleting the product
//				driver.findElement(By.linkText("Products")).click();
//				
//				WebElement search = driver.findElement(By.id("bas_searchfield"));
//				
//				Select select = new Select(search);
//				select.selectByValue("productname");
//				
//				driver.findElement(By.name("search_text")).sendKeys(productName);
//				
//				driver.findElement(By.name("submit")).click();
//				
			//	driver.findElement(By.xpath("//a[text()='"+productName+"' and @title='Products']/../..//input[@name='selected_id']")).click();
//				
//				driver.findElement(By.xpath("//input[@value='Delete']")).click();
//				products.deleteTheProduct(productName, driver);
//				
//				webUtility.switchingDriverControlToAlertandAccept(driver);
				
				//Checking if product is deleted or not
//				driver.findElement(By.linkText("Products")).click();
				homePage.clickProductsLink(driver);
//				Thread.sleep(3000);
				products.searchForProduct(driver, productName);
//				Thread.sleep(3000);
				products.dynamicXpathToClickCheckBox(driver, productName);
//				Thread.sleep(3000);
				products.deleteTheProduct(driver);
//				Thread.sleep(3000);
				webUtility.switchingDriverControlToAlertandAccept(driver);
				homePage.clickProductsLink(driver);
//				List<WebElement> products = driver.findElements(By.xpath("//a[@title='Products']"));
//				List<WebElement> listOfProducts = products.getProductList();
//				
//				boolean productFound =false ;
//				
//				for(int i=0; i<listOfProducts.size();i++)
//				{
//					if((listOfProducts.get(i).getText()).contains(productName))
//					{
//						 System.out.println("Product is not deleted");
//					        productFound = true;  // Product found, no need to check further
//					        break; 
//					}
//					
//				}
//				
//				if(!productFound)
//				{
//					System.out.println("Product " + productName + " deleted successfully");
//				}
				
				products.verifyDeletionOfProduct(driver, productName);
				//Logout
				
//				homePage.LogoutOfApplication(driver);
				
				
				
	}
				
				
				
	}
	

				

	


