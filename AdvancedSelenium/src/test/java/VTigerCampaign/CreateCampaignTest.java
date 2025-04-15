package VTigerCampaign;


import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateCampaignForm;
import Object_Repository.VtigerCampaignPage;
import Object_Repository.VtigerHomepage;

public class CreateCampaignTest extends BaseClass{

	@Test
	public void createCampaignTest() throws IOException {

		WebDriver_Utility webUtility = new WebDriver_Utility();
		
		webUtility.maximizeBrowser(driver);
		webUtility.waitElementsToLoad(driver);
	
		//Creating Campaign
		VtigerHomepage homepage = new VtigerHomepage(driver);
		homepage.CampaignPage(driver);
		
		VtigerCampaignPage campaign = new VtigerCampaignPage(driver);
		campaign.clickCreateCampaignLookup(driver);

		Java_Utility jUtility = new Java_Utility();
		int ranNum = jUtility.getRandomNumber();
		
		Excel_Utility excelUtility = new Excel_Utility();
		
		String campaignName=excelUtility.getDataFromExcel("VtigerProduct", 1, 1)+ranNum;
				
		CreateCampaignForm createCampaignForm = new CreateCampaignForm(driver);
		createCampaignForm.createCampaign(driver, campaignName);
		createCampaignForm.saveButton(driver);
		
		//Verification
		createCampaignForm.verificationOfCampaignCreation(driver, campaignName);
	

	}

}
