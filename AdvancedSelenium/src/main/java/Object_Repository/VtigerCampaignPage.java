package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCampaignPage {

	public VtigerCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[alt='Create Campaign...']")
	private WebElement createCampaignLookup;

	public WebElement getCreateCampaignLookup() {
		return createCampaignLookup;
	}
	/**
	 * This method clicks on create campaign lookup image
	 * @param driver
	 */
	public void clickCreateCampaignLookup(WebDriver driver) {
		createCampaignLookup.click();
	}
}
