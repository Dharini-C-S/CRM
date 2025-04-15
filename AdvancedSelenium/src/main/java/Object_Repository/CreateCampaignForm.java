package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class CreateCampaignForm {

	public CreateCampaignForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//INPUT[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id ="mouseArea_Campaign Name")
	private WebElement verCampaignName;
	
	@FindBy(css="img[src='themes/softed/images/select.gif']")
	private WebElement addProductIcon;
	
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getVerCampaignName() {
		return verCampaignName;
	}
	
	public WebElement getAddProductIcon() {
		return addProductIcon;
	}

	/**
	 * This method is used to create a campaign
	 * @param driver
	 * @param campaignName
	 */
	public void createCampaign(WebDriver driver, String campaignName) {
		campaignNameTextField.sendKeys(campaignName);
//		saveButton.click();
	}
	
	/**
	 * This method is used to create campaign with product
	 * @param driver
	 * @param campaignName
	 * @param productName
	 */
	public void createCampaignWithProduct(WebDriver driver, String campaignName, String productName) {
		campaignNameTextField.sendKeys(campaignName);
		addProductIcon.click();
		
		WebDriver_Utility webUtility = new WebDriver_Utility();
		webUtility.switchingDriverContol(driver, "Popup");
		
		driver.findElement(By.linkText(""+productName+"")).click();
		webUtility.switchingDriverContol(driver, "Campaigns");
		
//		saveButton.click();
	}
	
	
	/**
	 * This method is used to verify if campaign is created or not.
	 * @param driver
	 */
	public void verificationOfCampaignCreation(WebDriver driver, String campaignName) {
		String campaignNameAfterCreation = verCampaignName.getText();
		
		if(campaignNameAfterCreation.contains(campaignName)) {
			System.out.println("Campaign "+campaignName+" has been added successfully");
		}
		else
		{
			System.out.println("Campaign has not been added....FAILED!!!");
		}
	}
	
	/**
	 * This method clicks on save button
	 * @param driver
	 */
	public void saveButton(WebDriver driver) {
		saveButton.click();
	}
	

	
}
