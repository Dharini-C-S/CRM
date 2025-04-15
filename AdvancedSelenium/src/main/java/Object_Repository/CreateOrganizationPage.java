package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateOrganizationPage {
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTextField;
	
	@FindBy(id ="email1")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//INPUT[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationName;
	
	/**
	 * This method enters the details of Organization
	 * @param driver
	 * @param organizationName
	 * @param phone
	 * @param email
	 */
	public void enterOrganizationDetails(WebDriver driver, String organizationName, String phone ,String email) {
		
		organizationNameTextField.sendKeys(organizationName);
		phoneNumberTextField.sendKeys(phone);
		emailTextField.sendKeys(email);
		
	}
	/**
	 * This method clicks the save button
	 * @param driver
	 */
	public void saveButton(WebDriver driver) {
		saveButton.click();
	}
	
	/**
	 * This method is to verify the creation of Organization
	 */
	public String verificationOfOrganization(WebDriver driver, String orgName) {
		String verOrgName = organizationName.getText();
		

		Assert.assertEquals(verOrgName, orgName,"Organization has not been added....FAILED!!!");
		System.out.println("Organization "+orgName+" has been added successfully");
//		if(verOrgName.contains(orgName)) {
//			System.out.println("Organization "+orgName+" has been added successfully");
//		}
//		else
//		{
//			System.out.println("Organization has not been added....FAILED!!!");
//		}
		return verOrgName;
	}
}
