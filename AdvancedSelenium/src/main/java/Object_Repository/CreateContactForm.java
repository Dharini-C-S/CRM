package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic_Utility.WebDriver_Utility;

public class CreateContactForm {
	public CreateContactForm(WebDriver driver) {
		PageFactory.initElements(driver, this );

	}
	
	@FindBy(name = "salutationtype")
	private WebElement salutation;
	
	@FindBy(name ="firstname")
	private WebElement firstname;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "mouseArea_First Name")
	private WebElement verifyFirstName;
	
	@FindBy(xpath = "//input[@name='account_name']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement addOrganizationIcon;
	
	@FindBy(id = "search_txt")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	
	
	/**
	 * This method will create contact by entering salutation , firstname and lastname
	 * @param driver
	 * @param sal
	 * @param firstName
	 * @param lastName
	 */
	public void createContact(WebDriver driver, String sal, String firstName, String lastName) {
		
		WebDriver_Utility wUtility = new WebDriver_Utility();
		wUtility.selectingDropDown(salutation, sal);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		
	}
	
	public void createContactWithOrganization(WebDriver driver, String orgName) {
		addOrganizationIcon.click();
		
		WebDriver_Utility webUtility = new WebDriver_Utility();
		webUtility.switchingDriverContol(driver, "Popup");
		
		searchTextField.sendKeys(orgName);
		searchButton.click();
		
		webUtility.dynamicXpath(driver, orgName);
		
		webUtility.switchingDriverContol(driver, "Contacts");
	}
	
	/**
	 * This method will click save button
	 * @param driver
	 */
	public void clickSaveButton(WebDriver driver) {
		saveButton.click();
	}

	/**
	 * This method verify the creation of contact
	 * @param driver
	 * @param firstName
	 */
	public void verifyCreationOfContact(WebDriver driver, String firstName) {
		String verFirstName = verifyFirstName.getText();
		
		Assert.assertEquals(firstName, verFirstName,"Contact has not been created....FAILED!!!");
		System.out.println("Contact has been created successfully");
//		if(verFirstName.contains(firstName)) {
//			System.out.println("Contact has been created successfully");
//		}
//		else
//		{
//			System.out.println("Contact has not been created....FAILED!!!");
//		}
		
	}
}

