package VTigerOrganization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.VtigerHomepage;
import Object_Repository.VtigerOrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws IOException {

			WebDriver_Utility webUtility = new WebDriver_Utility();
				
				webUtility.maximizeBrowser(driver);
				webUtility.waitElementsToLoad(driver);

				//Create organization
				VtigerHomepage homePage = new VtigerHomepage(driver);
				homePage.OrganizationPage(driver);

				VtigerOrganizationPage organization = new VtigerOrganizationPage(driver);
				organization.createOrganization(driver);
				
				
				Java_Utility jUtility = new Java_Utility();
				int ranNum = jUtility.getRandomNumber();
				
				//Accessing data from excel
				
				Excel_Utility excelUtility = new Excel_Utility();
				
				String orgName=excelUtility.getDataFromExcel("VtigerProduct", 1, 3)+ranNum;
				String Phone=excelUtility.getDataFromExcelUsingDataFormatter("VtigerProduct", 2, 3);
				String email=excelUtility.getDataFromExcel("VtigerProduct", 3, 3);
				
				CreateOrganizationPage createOrganization = new CreateOrganizationPage(driver);
				createOrganization.enterOrganizationDetails(driver, orgName, Phone, email);
				createOrganization.saveButton(driver);
				
				//Verification
				String verOrgName = createOrganization.verificationOfOrganization(driver, orgName);
				Assert.assertEquals(orgName, verOrgName,"Organization has not been added....FAILED!!!" );
				System.out.println("Organization "+orgName+" has been added successfully");
			
	}
}
