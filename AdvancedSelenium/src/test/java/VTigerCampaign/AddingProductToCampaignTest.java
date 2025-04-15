package VTigerCampaign;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateCampaignForm;
import Object_Repository.VtigerCampaignPage;
import Object_Repository.VtigerHomepage;

public class AddingProductToCampaignTest extends BaseClass {
	
	@Test
	public void addingProductToCampaignTest() throws EncryptedDocumentException, IOException {
	
				WebDriver_Utility webUtility = new WebDriver_Utility();
				
				webUtility.maximizeBrowser(driver);
				webUtility.waitElementsToLoad(driver);
			
				//More Links
				VtigerHomepage homepage = new VtigerHomepage(driver);
				homepage.CampaignPage(driver);
				
				//Creating campaign
				VtigerCampaignPage  campaign = new VtigerCampaignPage(driver);
				campaign.clickCreateCampaignLookup(driver);
				
				Excel_Utility excelUtility = new Excel_Utility();
				Java_Utility jUtility = new Java_Utility();
				int ranNum = jUtility.getRandomNumber();
				
				String campaignName=excelUtility.getDataFromExcel("VtigerProduct", 3, 1)+ranNum;
				String productName=excelUtility.getDataFromExcel("VtigerProduct", 1, 0);
			
				CreateCampaignForm createCampaignForm = new CreateCampaignForm(driver);
				createCampaignForm.createCampaignWithProduct(driver, campaignName, productName);
				createCampaignForm.saveButton(driver);

				//Verification
				createCampaignForm.verificationOfCampaignCreation(driver, campaignName);
				
	}
}
