package VTigerContact;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateContactForm;
import Object_Repository.VtigerContact;
import Object_Repository.VtigerHomepage;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test
	public  void createContactWithOrganizationTest() throws IOException {

		WebDriver_Utility webUtility = new WebDriver_Utility();
		
		webUtility.maximizeBrowser(driver);
		webUtility.waitElementsToLoad(driver);
		
		//Create Contact
		VtigerHomepage homePage = new VtigerHomepage(driver);
		homePage.clickContactLink(driver);
		
		VtigerContact contact = new VtigerContact(driver);
		contact.clickCreateContactIcon(driver);
		
		
		Excel_Utility excelUtility = new Excel_Utility();
		
		String sal=excelUtility.getDataFromExcel("VtigerProduct", 1, 5);
		String firstName=excelUtility.getDataFromExcel("VtigerProduct", 2, 5);
		String lastName=excelUtility.getDataFromExcel("VtigerProduct", 3, 5);
		String orgName=excelUtility.getDataFromExcel("VtigerProduct", 4, 5);

		CreateContactForm createContactForm = new CreateContactForm(driver);
		createContactForm.createContact(driver, sal, firstName, lastName);
	
		createContactForm.createContactWithOrganization(driver, orgName);
		//Saving the contact
		
		createContactForm.clickSaveButton(driver);
		
		//Verification
		createContactForm.verifyCreationOfContact(driver, firstName);
		
	}

}
