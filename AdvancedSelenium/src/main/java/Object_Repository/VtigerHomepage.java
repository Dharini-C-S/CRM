package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class VtigerHomepage {
	 public VtigerHomepage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(linkText = "Products")
	 private WebElement productsLink;
	 
	 @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	 private WebElement profileIcon;
	 
	 @FindBy(linkText = "Sign Out")
	 private WebElement signOutLink;
	 
	 @FindBy(linkText = "More")
	 private WebElement moreLink;
	 
	 @FindBy(linkText = "Campaigns")
	 private WebElement campaignsLink;
	 
	 @FindBy(linkText = "Organizations")
	 private WebElement organizationLink;
	 
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	/**
	 * This method is logs out of the application
	 * @param driver
	 */
	public void LogoutOfApplication (WebDriver driver) {
		WebElement icon = profileIcon;
		WebDriver_Utility webUtility = new WebDriver_Utility();
		webUtility.moveToElementMouseAction(driver, icon);
		signOutLink.click();
	
	}
	 
	/**
	 * This method is to navigate to campaign page
	 * @param driver
	 */
	public void CampaignPage(WebDriver driver) {
	
		WebDriver_Utility webUtility = new WebDriver_Utility();
		webUtility .moveToElementMouseAction(driver, moreLink);
		campaignsLink.click();
		
		
	}
	/**
	 * This method will navigate to organization page
	 * @param driver
	 */
	public void OrganizationPage(WebDriver driver) {
		organizationLink.click();
	}
	
	/**
	 * This method will navigate to contacts page
	 * @param driver
	 */
	public void clickContactLink(WebDriver driver) {
		contactsLink.click();
	}
	/**
	 * This method will click products link
	 * @param driver
	 */
	public void clickProductsLink(WebDriver driver) {
		productsLink.click();
	}


	
}
