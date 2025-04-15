package VTigerProduct;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreatingProductForm;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerProductsPage;

public class CreateProductTest extends BaseClass{

	@Test(groups = {"SmokeTest","IntegrationTest"})
	public void createProductTest() throws IOException {
		
		WebDriver_Utility webUtility = new WebDriver_Utility();
		
		webUtility.maximizeBrowser(driver);
		webUtility.waitElementsToLoad(driver);
		
		VtigerHomepage homePage = new VtigerHomepage(driver);
		homePage.clickProductsLink(driver);

		VtigerProductsPage product = new VtigerProductsPage(driver);
		product.clickCreateProductIcon(driver);
		
		Java_Utility javaUtility = new Java_Utility();
		int ranNum = javaUtility.getRandomNumber();
		
		Excel_Utility excelUtility = new Excel_Utility();
		String productName=excelUtility.getDataFromExcel("VtigerProduct", 0, 0)+ranNum;
	
		CreatingProductForm createProductForm = new CreatingProductForm(driver);
		createProductForm.createProduct(productName);
		createProductForm.clickSaveButton(driver);
		
		//Verification
		String actProductName = createProductForm.verifyCreationOfProduct(driver, productName);
		
		Assert.assertEquals(productName, actProductName, "Product "+productName+" is not created");
		System.out.println("Product "+productName+" is created successfully.");
		
	}

}
